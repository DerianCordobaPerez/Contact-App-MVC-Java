package Controllers;
import Interfaces.IDataModel;
import Models.User;
import Views.Components.Error;
import Views.Components.Success;
import Views.ViewUser;
import DAO.UserDaoImplement;

public class ControllerUser {
    private ViewUser viewUser = new ViewUser();
    public ControllerUser() {}

    public void recordModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.recordModelData(user))
            new Error().generatedError("An error occurred while registering the user");
        else
            new Success().generatedSuccess("User has been successfully registered");
    }

    public void deleteModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.deleteModelData(user))
            new Error().generatedError("An error occurred while deleting user " + user.getUserName());
        else
            new Success().generatedSuccess("User has been successfully removed");
    }

    public void updateModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.updateModelData(user))
            new Error().generatedError("An error occurred while updating user " + user.getUserName());
        else
            new Success().generatedSuccess("The user has been updated successfully");
    }

    public void viewUser(User currentUser) {
        IDataModel<User> userDao = new UserDaoImplement();
        User user;
        if((user = userDao.getModelData(currentUser)) == null)
            new Error().generatedError("The searched user has not been found in the database");
        else {
            new Success().generatedSuccess("Successful Login");
            viewUser.renderViewUser(user);
        }
    }

    public int getAmount() {
        IDataModel<User> userDao = new UserDaoImplement();
        return userDao.getTotalClass();
    }
}
