package Controllers;
import Interfaces.IDataModel;
import Models.User;
import Views.ViewUser;
import DAO.UserDaoImplement;

public class ControllerUser {
    private final ViewUser viewUser = new ViewUser();
    public ControllerUser() {}

    public void recordModelDataUser(User user) {
        IDataModel userDao = new UserDaoImplement();
        userDao.recordModelData(user);
    }

    public void deleteModelDataUser(User user) {
        IDataModel userDao = new UserDaoImplement();
        userDao.deleteModelData(user);
    }

    public void updateModelDataUser(User user) {
        IDataModel userDao = new UserDaoImplement();
        userDao.updateModelData(user);
    }

    public void viewUser(User currentUser) {
        IDataModel userDao = new UserDaoImplement();
        User user = (User)userDao.getModelData(currentUser);
        viewUser.renderViewUser(user);
    }
}
