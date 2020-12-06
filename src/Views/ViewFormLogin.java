package Views;
import Controllers.ControllerLogin;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

/**
 * @author derian_cordoba
 * */

public class ViewFormLogin extends JFrame {
    public JButton btnEnter, btnExit;
    public JTextField tbUserName;
    public JPasswordField tbUserPassword;
    public JLabel lbRegisterUser;

    public ViewFormLogin() {
        initComponents();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(500, 200);
        new ControllerLogin(this);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 5));
        mainPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), null));

        JLabel lbUserName = new JLabel("Enter your Username "),
        lbUserPassword = new JLabel("Enter your Password "),
        lbRestorePassword = new JLabel("Forgot your password?");
        lbRegisterUser = new JLabel("Register Account");
        tbUserName = new JTextField(); tbUserPassword = new JPasswordField();
        btnEnter = new JButton("Enter"); btnExit = new JButton("Exit");

        Arrays.asList(lbUserName, tbUserName, lbUserPassword, tbUserPassword, btnEnter, btnExit).forEach(mainPanel::add);
        Arrays.asList(lbRegisterUser, lbRestorePassword).forEach((components) -> mainPanel.add(components, BorderLayout.PAGE_END));
        this.setContentPane(mainPanel);
    }
}
