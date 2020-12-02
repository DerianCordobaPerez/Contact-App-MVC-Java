package DAO;
import Interfaces.IDataModel;
import Models.Contact;
import Connection.ConnectionDatabase;
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
            System.out.println("An error occurred when entering a new contact");
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
            System.out.println("An error occurred while trying to update contact data");
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
            System.out.println("An error occurred while trying to update contact data");
            exception.printStackTrace();
        }
        return correctBehavior;
    }

    public List<Contact> getModelData() {
        sqlQuery = "select * from contacts order by id desc";
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
            System.out.println("An error occurred while trying to get contacts");
            exception.printStackTrace();
        }
        return listContact;
    }
}
