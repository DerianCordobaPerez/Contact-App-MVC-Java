import Views.ViewFormLogin;
import javax.swing.*;

public class ContactApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewFormLogin();
        });
    }

}
