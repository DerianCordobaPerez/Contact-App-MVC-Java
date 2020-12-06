package DAO;
import Connection.ConnectionDatabase;
import Interfaces.IDataModel;
import Models.User;
import Views.Components.Error;
import java.sql.*;

public class UserDaoImplement implements IDataModel<User> {
    private Statement statementQuery = null;
    private Connection connection = null;
    private String sqlQuery = "";

    @Override
    public boolean recordModelData(User user) {
        boolean correctBehavior = false;
        sqlQuery = "insert into Users values (" + user.getId() + ", '" + user.getIdentification() + "', '" + user.getFirstName() + "', '"
                + user.getLastName() + "', '" + user.getUserName() + "')";
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred when entering a new user");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public boolean updateModelData(User user) {
        boolean correctBehavior = false;
        sqlQuery = "update Users set Identification = '" + user.getIdentification() + "', firstName = '" + user.getFirstName() + "', lastName = '"
                + user.getLastName() + "', userName = '" + user.getUserName() + "' where Id = " + user.getId();
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to update user data");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public boolean deleteModelData(User user) {
        boolean correctBehavior = false;
        sqlQuery = "delete from Users where id = " + user.getId();
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to delete user data");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public User getModelData(User user) {
        sqlQuery = "select * from Users where id = " + user.getId();
        ResultSet resultQuery;
        User newUser = null;
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            resultQuery = statementQuery.executeQuery(sqlQuery);
            while(resultQuery.next()) {
                newUser = new User();
                newUser.setId(resultQuery.getInt(1));
                newUser.setIdentification(resultQuery.getString(2));
                newUser.setFirstName(resultQuery.getString(3));
                newUser.setLastName(resultQuery.getString(4));
                newUser.setUserName(resultQuery.getString(5));
            }
            statementQuery.close();
            resultQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to get user");
            exception.printStackTrace();
        }
        return newUser;
    }

    @Override
    public int getTotalClass() {
        int totalQuantity = -1;
        ResultSet resultQuery;
        sqlQuery = "select count(id) as All from Users";
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            resultQuery = statementQuery.executeQuery(sqlQuery);
            if(resultQuery.next())
                totalQuantity = (resultQuery.getInt("All")) + 1;
            statementQuery.close();
            resultQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to get the total number of users");
            exception.printStackTrace();
        }
        return totalQuantity;
    }
}
