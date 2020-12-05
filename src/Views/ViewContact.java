package Views;
import Models.Contact;
import Views.Components.Error;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ViewContact {
    private JFrame mainWindow;
    public void renderViewContact(List<Contact> contactList) {
        this.mainWindow = new JFrame("All Contacts");
        this.mainWindow.pack();
        this.mainWindow.setLocationByPlatform(true);
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(this.mainWindow.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(() -> contactLetter(contactList));
    }

    private void contactLetter(List<Contact> contacts) {
        JPanel mainPane = mainPanelConfiguration(), contactPanel = contactPanelConfiguration(contacts), centerPane = new JPanel();
        centerPane.setOpaque(true);
        centerPane.setBackground(Color.WHITE);
        centerPane.setBorder(BorderFactory.createTitledBorder("All Contacts"));
        centerPane.add(contactPanel);
        mainPane.add(centerPane, BorderLayout.CENTER);
        this.mainWindow.setContentPane(mainPane);
    }

    private JPanel contactPanelConfiguration(List<Contact> contacts) {
        JPanel contactPanel = new JPanel();
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

    private JPanel mainPanelConfiguration() {
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(5, 5));
        return contentPane;
    }
}
