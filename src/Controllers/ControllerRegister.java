package Controllers;
import Interfaces.IDataModel;
import Models.User;
import Views.ViewFormRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegister implements ActionListener {
    private final ViewFormRegister viewFormRegister;

    private void enventsGenerated() {
        viewFormRegister.btnSave.addActionListener(this);
    }

    public ControllerRegister(ViewFormRegister viewFormRegister) {
        this.viewFormRegister = viewFormRegister;
        enventsGenerated();
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
        newUser.setUserName(viewFormRegister.tbUserName.getText());
        newUser.setPassword(new String(viewFormRegister.tbUserPassword.getPassword()));
        return newUser;
    }
}
