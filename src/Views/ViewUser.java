package Views;
import Models.User;
import javax.swing.*;
import java.awt.*;

public class ViewUser extends JFrame {
    public ViewUser(User user) {
        this.setTitle("Welcome " + user.getFirstName());
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        renderViewUser(user);
    }

    public void renderViewUser(User user) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        this.setContentPane(panel);
    }
}