package Connection;
import Views.Components.Error;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public static Connection ConnectDatabase() {
        Connection connection = null;
        String User = "root", Password = "derian2020";
        String Url = String.format("jdbc:mysql://localhost:3306/Contact_App?user=%s&password=%s", User, Password);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Url);
        } catch (SQLException | ClassNotFoundException exception) {
            new Error().generatedError("An error occurred while trying to connect to the database");
            exception.printStackTrace();
        }
        return connection;
    }
}
