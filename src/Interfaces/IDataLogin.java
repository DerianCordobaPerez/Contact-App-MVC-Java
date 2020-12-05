package Interfaces;
import Models.User;

public interface IDataLogin {
    User verifyUserLogin(String userName, String userPassword);
}
