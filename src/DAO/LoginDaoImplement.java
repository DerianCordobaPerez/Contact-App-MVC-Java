package DAO;
import Interfaces.IDataLogin;
import Models.User;
import Views.Components.Error;
import Connection.ConnectionDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImplement implements IDataLogin {
    private Statement statementQuery = null;
    private Connection connection = null;
    private String sqlQuery = "";
    @Override
    public User verifyUserLogin(String userName, String userPassword) {
        sqlQuery = "select * from Users where username = '" + userName + "' and password = '" + userPassword + "'";
        ResultSet resultQuery;
        User userLoggedIn = null;
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            resultQuery = statementQuery.executeQuery(sqlQuery);
            while(resultQuery.next()) {
                userLoggedIn = new User();
                userLoggedIn.setId(1);
                userLoggedIn.setIdentification(resultQuery.getString(2));
                userLoggedIn.setFirstName(resultQuery.getString(3));
                userLoggedIn.setLastName(resultQuery.getString(4));
                userLoggedIn.setUserName(resultQuery.getString(5));
            }
            statementQuery.close();
            resultQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("The username or password entered are incorrect");
            exception.printStackTrace();
        }
        return userLoggedIn;
    }
}
