package Views;
import Controllers.ControllerLogin;

import javax.swing.*;

public class ViewFormLogin extends JFrame {
    public JButton btnEnter, btnExit;
    public JTextField tbUserName;
    public JPasswordField tbUserPassword;
    private ControllerLogin controllerLogin;
    public ViewFormLogin() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        controllerLogin = new ControllerLogin(this);
    }
}
