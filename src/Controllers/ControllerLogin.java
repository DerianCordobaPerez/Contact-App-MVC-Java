package Controllers;
import DAO.LoginDaoImplement;
import Interfaces.IDataLogin;
import Views.Components.Error;
import Views.ViewFormLogin;
import Views.ViewUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLogin implements ActionListener {
    private final ViewFormLogin viewFormLogin;

    public void eventsGenerated() {
        viewFormLogin.btnEnter.addActionListener(this);
        viewFormLogin.btnExit.addActionListener(this);
    }

    public ControllerLogin(ViewFormLogin viewFormLogin) {
        this.viewFormLogin = viewFormLogin;
        eventsGenerated();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object event = actionEvent.getSource();
        if(event.equals(viewFormLogin.btnEnter)) {
            String userPassword = new String(viewFormLogin.tbUserPassword.getPassword()), userName = viewFormLogin.tbUserName.getText();
            if(userName.isEmpty() || userPassword.isEmpty())
                new Error().generatedError("All login fields are required");
            else {
                IDataLogin loginDao = new LoginDaoImplement();
                Models.User userLoggedIn;
                if((userLoggedIn = loginDao.verifyUserLogin(userName, userPassword)) != null) {
                    viewFormLogin.dispose();
                    new ViewUser().renderViewUser(userLoggedIn);
                } else
                    new Error().generatedError("The username or password is incorrect, please enter your data again");
            }
        }

        if(event.equals(viewFormLogin.btnExit)) {
            if(JOptionPane.showConfirmDialog(null, "are you sure you want to leave",
                    "Are you sure", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
}
