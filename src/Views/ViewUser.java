package Views;
import Models.User;
import Views.Components.Error;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        JPanel mainPanel = mainPanelConfiguration(), centerPanel = new JPanel(), userPanel = userPanelConfiguration(user);
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createTitledBorder("All Contacts"));
        centerPanel.add(userPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        this.setContentPane(mainPanel);
    }

    private JPanel userPanelConfiguration(User user) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),  null));
        JLabel lbContactPicture = new JLabel(),
                lbUserName = new JLabel("UserName: " + user.getUserName());
        ImageIcon userPicture = null;
        try {
            userPicture = new ImageIcon(new ImageIcon(getClass().getResource("../Public/UsersPictures/"
                    + "UserName:" + user.getUserName() + "_" + "Id:" + user.getId() + ".jpg"))
                    .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        } catch(NullPointerException exception) {
            userPicture = new ImageIcon(new ImageIcon(getClass().getResource("../Public/UsersPictures/Default.png"))
                    .getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        }
        lbContactPicture.setIcon(userPicture);
        Arrays.asList(lbContactPicture, lbUserName).forEach(mainPanel::add);
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