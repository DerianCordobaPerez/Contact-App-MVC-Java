package DAO;
import Interfaces.IDataModel;
import Models.Contact;
import Connection.ConnectionDatabase;
import Models.User;
import Views.Components.Error;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImplement implements IDataModel<Contact> {
    private Statement statementQuery = null;
    private Connection connection = null;
    private String sqlQuery = "";

    @Override
    public boolean recordModelData(Contact contact) {
        boolean correctBehavior = false;
        sqlQuery = "insert into Contacts values(" + contact.getId() + ", '" + contact.getName() + "', '" + contact.getPhone() + "', '"
                + contact.getOperator() + "')";
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred when entering a new contact");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public boolean recordModelData(User user, Contact contact) {
        boolean correctBehavior = false;
        sqlQuery = "insert into Contacts (id, contactName, numberPhone, operator, idUser) values(" + contact.getId() + ", '" + contact.getName() + "', '"
                + contact.getPhone() + "', '" + contact.getOperator() + "', " + user.getId() + ")";
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred when entering a new contact");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public boolean updateModelData(Contact contact) {
        boolean correctBehavior = false;
        sqlQuery = "update Contacts set name = '" + contact.getName() + "', phone = '" + contact.getPhone() + "', operator = '" + contact.getOperator()
                + "' where id = " + contact.getId();
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to update contact data");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public boolean deleteModelData(Contact contact) {
        boolean correctBehavior = false;
        sqlQuery = "delete from Contact where id = " + contact.getId();
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            statementQuery.execute(sqlQuery);
            correctBehavior = true;
            statementQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to delete contact data");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    @Override
    public Contact getModelData(Contact contact) {
        sqlQuery = "select * from contacts where id = " + contact.getId();
        ResultSet resultQuery;
        Contact newContact = null;
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            resultQuery = statementQuery.executeQuery(sqlQuery);
            while(resultQuery.next()) {
                newContact = new Contact();
                newContact.setId(resultQuery.getInt(1));
                newContact.setName(resultQuery.getString(2));
                newContact.setPhone(resultQuery.getString(3));
                newContact.setOperator(resultQuery.getString(4));
            }
            statementQuery.close();
            resultQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to get contact");
            exception.printStackTrace();
        }
        return newContact;
    }

    @Override
    public int getTotalClass() {
        int totalQuantity = -1;
        ResultSet resultQuery;
        sqlQuery = "select count(id) as All from Contacts";
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

    public List<Contact> getListModelData(User user) {
        sqlQuery = "select * from contacts contact inner join users user on user.id = contact.id where user.id = " + user.getId() +
                "group by contact.id order by contact.id desc";
        ResultSet resultQuery;
        List<Contact> listContact = new ArrayList<>();
        try {
            connection = ConnectionDatabase.ConnectDatabase();
            statementQuery = connection.createStatement();
            resultQuery = statementQuery.executeQuery(sqlQuery);
            while(resultQuery.next()) {
                Contact newContact = new Contact();
                newContact.setId(resultQuery.getInt(1));
                newContact.setName(resultQuery.getString(2));
                newContact.setPhone(resultQuery.getString(3));
                newContact.setOperator(resultQuery.getString(4));
                listContact.add(newContact);
            }
            statementQuery.close();
            resultQuery.close();
            connection.close();
        } catch(SQLException exception) {
            new Error().generatedError("An error occurred while trying to get contacts");
            exception.printStackTrace();
        }
        return listContact;
    }
}
