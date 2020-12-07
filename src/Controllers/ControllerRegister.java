package Controllers;
import Configuration.EncryptPassword;
import Models.User;
import Views.ViewFormRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegister implements ActionListener {
    private final ViewFormRegister viewFormRegister;

    public ControllerRegister(ViewFormRegister viewFormRegister) {
        this.viewFormRegister = viewFormRegister;
        enventsGenerated();
    }

    private void enventsGenerated() {
        viewFormRegister.btnSave.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object event = actionEvent.getSource();
        if(event.equals(viewFormRegister.btnSave)) {
            User newUser = newUserAssignament();
            new ControllerUser().recordModelDataUser(newUser);
        }
    }

    private User newUserAssignament() {
        User newUser = new User();
        newUser.setId(new ControllerUser().getAmount());
        newUser.setIdentification(viewFormRegister.tbIdentification.getText());
        newUser.setFirstName(viewFormRegister.tbFirstName.getText());
        newUser.setLastName(viewFormRegister.tbLastName.getText());
        newUser.setUserName(viewFormRegister.tbUserName.getText());
        newUser.setPassword(EncryptPassword.generateSecurePassword(new String(viewFormRegister.tbUserPassword.getPassword()),
                EncryptPassword.getSalt(10)));
        return newUser;
    }
}
