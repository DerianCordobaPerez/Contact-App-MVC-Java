package Views;
import Controllers.ControllerLogin;
import Models.User;
import Views.Components.Error;
import Views.Components.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

/**
 * user view class
 * @author derian_cordoba
 * */
public class ViewUser extends JFrame {
    public JButton btnViewAllContacts;
    /**
     * method commissioned to render and initialize the jframe window methods
     * @param user user to render
     * */
    public void renderViewUser(User user) {
        this.setTitle("Welcome " + user.getFirstName());
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        SwingUtilities.invokeLater(() -> initComponents(user));
    }

    /**
     * method where we assign our main jpanel necessary methods for its visualization
     * @param user user to render
     * */
    private void initComponents(User user) {
        JPanel mainPanel = mainPanelConfiguration(), centerPanel = new JPanel(), userPanel = userPanelConfiguration(user), menuPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createTitledBorder("User in Session -> " + user.getUserName()));
        centerPanel.add(userPanel);
        new Menu().generateMenu(this);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        this.setContentPane(mainPanel);
    }

    /**
     * method where we will paint the information of the logged in user
     * @param user user to render
     * */
    private JPanel userPanelConfiguration(User user) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),  null));

        JLabel lbContactPicture = new JLabel(),
                lbUserName = new JLabel("UserName: " + user.getUserName());
        ImageIcon userPicture = null;
        try {
            userPicture = new ImageIcon(new ImageIcon(getClass().getResource("../Public/UsersPictures/"
                    + "UserName:" + user.getUserName() + "_" + "Id:" + user.getId() + ".jpg"))
                    .getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        } catch(NullPointerException exception) {
            new Error().generatedError("Error finding find photo of user " + user.getUserName());
        }
        lbContactPicture.setIcon(userPicture);
        btnViewAllContacts = new JButton("View All Contacts");
        Arrays.asList(lbContactPicture, lbUserName, btnViewAllContacts).forEach(mainPanel::add);
        return mainPanel;
    }

    /**
     * generalized configuration for main JPanel
     * */
    private JPanel mainPanelConfiguration() {
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        return contentPane;
    }

}