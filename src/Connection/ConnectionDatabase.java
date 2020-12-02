package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    public static Connection ConnectDatabase() {
        String User = "root", Password = "derian2020";
        String Url = "dbc:mysql://localhost:3306/Contact_App?user=" + User
                + "&password=" + Password;
        Connection connection = null;
        try {
            if ((connection = DriverManager.getConnection(Url)) != null)
                System.out.println("The connection to the database was successful");
        } catch (SQLException exception) {
            System.out.println("An error occurred while trying to connect to the database");
            exception.printStackTrace();
        }
        return connection;
    }
}
