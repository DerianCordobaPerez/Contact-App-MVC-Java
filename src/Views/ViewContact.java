package Views;
import Models.Contact;
import Views.Components.Error;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ViewContact {
    private JFrame mainWindow;
    /**
     * Main method which makes the calls to methods necessary for rendering the contact list
     * @param contactList list where contacts sent from controller are stored
     * */
    public void renderViewContact(List<Contact> contactList) {
        this.mainWindow = new JFrame("All Contacts");
        this.mainWindow.pack();
        this.mainWindow.setLocationByPlatform(true);
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(this.mainWindow.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> initComponents(contactList));
    }

    /**
     * Method to fill the main frame of the contact window creating necessary Jpanels
     * @param contacts necessary to send it to a second function
     * */
    private void initComponents(List<Contact> contacts) {
        JPanel mainPane = mainPanelConfiguration(), contactPanel = contactPanelConfiguration(contacts), centerPane = new JPanel();
        centerPane.setOpaque(true);
        centerPane.setBackground(Color.WHITE);
        centerPane.setBorder(BorderFactory.createTitledBorder("All Contacts"));
        centerPane.add(contactPanel);
        mainPane.add(centerPane, BorderLayout.CENTER);
        this.mainWindow.setContentPane(mainPane);
    }

    /**
     * Obtain the contact details to proceed to add them to the Jpanel
     * @param contacts necessary to get contact to contact list
     * */
    private JPanel contactPanelConfiguration(List<Contact> contacts) {
        JPanel contactPanel = new JPanel();
        contactPanel.setLayout(new GridLayout(contacts.size(), 4));
        contactPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),  null));

        for(Contact contact : contacts) {
            JLabel lbContactPicture = new JLabel(),
            lbName = new JLabel("Name: " + contact.getName()),
            lbPhone = new JLabel("Phone: " + contact.getPhone()),
            lbOperator = new JLabel("Operator: " + contact.getOperator());
            JButton editButton = new JButton("Edit Contact"), deleteButton = new JButton("Delete Contact");

            try {
                ImageIcon contactPicture = new ImageIcon(new ImageIcon(getClass().getResource("../Public/ContactsPictures/"
                        + "ContactName:" + contact.getName() + "_" + "Id:" + contact.getId() + ".png")).getImage()
                        .getScaledInstance(20, 20, Image.SCALE_DEFAULT));
                lbContactPicture.setIcon(contactPicture);
            } catch(NullPointerException exception) {
                new Error().generatedError("the image of the " + contact.getName() + " contact has not been found");
            }
            Arrays.asList(lbContactPicture, lbName, lbPhone, lbOperator, editButton, deleteButton).forEach(contactPanel::add);
        }
        return contactPanel;
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
