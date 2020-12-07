package Views;
import Controllers.ControllerRegister;

import javax.swing.*;
import java.awt.*;

public class ViewFormRegister extends JFrame {
    public JButton btnSave;
    public JTextField tbIdentification, tbFirstName, tbLastName, tbUserName;
    public JPasswordField tbUserPassword;
    public ViewFormRegister() {
        initComponents();
        new ControllerRegister(this);
    }

    private void initComponents() {

    }
}
