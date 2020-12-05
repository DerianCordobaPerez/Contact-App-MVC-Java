package Controllers;
import Interfaces.IDataModel;
import Models.User;
import Views.Components.Error;
import Views.ViewUser;
import DAO.UserDaoImplement;

public class ControllerUser {
    private ViewUser viewUser;
    public ControllerUser() {}

    public void recordModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.recordModelData(user))
            new Error().generatedError("An error occurred while registering the user");
    }

    public void deleteModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.deleteModelData(user))
            new Error().generatedError("An error occurred while deleting user " + user.getUserName());
    }

    public void updateModelDataUser(User user) {
        IDataModel<User> userDao = new UserDaoImplement();
        if(!userDao.updateModelData(user))
            new Error().generatedError("An error occurred while updating user " + user.getUserName());
    }

    public void viewUser(User currentUser) {
        IDataModel<User> userDao = new UserDaoImplement();
        User user;
        if((user = userDao.getModelData(currentUser)) == null) {
            new Error().generatedError("The searched user has not been found in the database");
            return;
        }
        viewUser = new ViewUser(user);
    }
}
