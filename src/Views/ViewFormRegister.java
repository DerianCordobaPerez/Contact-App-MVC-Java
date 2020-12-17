package Views;
import Controllers.ControllerRegister;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

public class ViewFormRegister extends JFrame {
    public JButton btnSave;
    public JTextField tbIdentification, tbFirstName, tbLastName, tbUserName;
    public JPasswordField tbUserPassword;
    public ViewFormRegister() {
        super("Registration Form");
        initComponents();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        new ControllerRegister(this);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 4));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), null));
        JLabel lbFirstName = new JLabel("FirstName "), lbLastName = new JLabel("LastName"), lbIdentification = new JLabel("No Identification"),
        lbUserName = new JLabel("UserName "), lbUserPassword = new JLabel("Password ");
        btnSave = new JButton("Finish Registration");
        tbFirstName = new JTextField();
        tbLastName = new JTextField();
        tbUserName = new JTextField();
        tbIdentification = new JTextField();
        tbUserPassword = new JPasswordField();
        Arrays.asList(lbFirstName, tbFirstName, lbLastName, tbLastName, lbIdentification, tbIdentification, lbUserName, tbUserName,
                lbUserPassword, tbUserPassword, btnSave).forEach(mainPanel::add);
        this.setContentPane(mainPanel);
    }


}
