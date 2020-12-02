package Views;
import Models.Contact;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewContact {
    private JFrame mainWindow;
    private Container container;
    private int verticalPosition = 0, horizontalPosition = 0;
    /**
     * @param -> method that will be responsible for rendering the entire contact list
     **/
    public void renderViewContact(List<Contact> contactList) {
        this.mainWindow = new JFrame("All Contacts");
        this.mainWindow.setSize(500, 500);
        this.mainWindow.setVisible(true);
        for(Contact contacts : contactList)
            renderContactInformation(contacts);
    }

    private void renderContactInformation(Contact contact) {
        JLabel  contactName = new JLabel("Name: " + contact.getName()), 
                contactPhone = new JLabel("Number Phone: " + contact.getPhone()), 
                contactOperator = new JLabel("Operator phone: " + contact.getOperator());
        contactName.setBounds(verticalPosition, horizontalPosition, 100, 40);
        verticalPosition += 50;
        
        this.container.add(contactName); this.container.add(contactPhone);
        this.container.add(contactOperator);
    }

    private void renderMainMenu() {

    }
}
