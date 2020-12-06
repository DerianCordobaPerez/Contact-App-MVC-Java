package Views;
import Models.User;
import Views.Components.Error;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ViewUser extends JFrame {

    public void renderViewUser(User user) {
        this.setTitle("Welcome " + user.getFirstName());
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        SwingUtilities.invokeLater(() -> initComponents(user));
    }

    private void initComponents(User user) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));
        JLabel lbContactPicture = new JLabel(),
        lbUserName = new JLabel("UserName: " + user.getUserName());
        
        try {
            ImageIcon userPicture = new ImageIcon(new ImageIcon(getClass().getResource("../Public/UsersPictures/"
                    + "UserName:" + user.getUserName() + "_" + "Id:" + user.getId() + ".png"))
                    .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
            lbContactPicture.setIcon(userPicture);
        } catch(NullPointerException exception) {
            new Error().generatedError("the image of the " + user.getUserName() + " user has not been found");
        }

        Arrays.asList(lbContactPicture, lbUserName).forEach(mainPanel::add);
    }
}