package Views.Components;
import javax.swing.*;
import java.util.Arrays;

public class Menu extends JMenuBar {
    public void generateMenu(JPanel mainPanel) {
        initComponents();
        mainPanel.add(this);
    }

    private void initComponents() {
        JMenu userAction = new JMenu("Account"), contactAction = new JMenu("Contacts");
        JMenuItem itemUserEdit = new JMenuItem("Edit Account"),
        itemUserLogout = new JMenuItem("Logout"),
        itemContactAdd = new JMenuItem("Add Contact"),
        itemContactEdit = new JMenuItem("Edit Contact"),
        itemContactDelete = new JMenuItem("Delete Contact");
        Arrays.asList(itemUserEdit, itemUserLogout).forEach(userAction::add);
        Arrays.asList(itemContactAdd, itemContactEdit, itemContactDelete).forEach(contactAction::add);
        Arrays.asList(userAction, contactAction).forEach(this::add);
        this.setBounds(0, 0 , 500, 25);
    }
}
