import Models.Contact;
import Views.ViewContact;

import java.util.ArrayList;
import java.util.List;

public class ContactApp {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        contact.setId(1);
        contact.setName("Derian");
        contact.setOperator("Tigo");
        contact.setPhone("77781905");
        contacts.add(contact);

        contact1.setId(2);
        contact1.setName("Ricardo");
        contact1.setOperator("Claro");
        contact1.setPhone("88774455");
        contacts.add(contact1);

        contact2.setId(3);
        contact2.setName("Ayme");
        contact2.setOperator("Movistar");
        contact2.setPhone("77541169");
        contacts.add(contact2);

        new ViewContact().renderViewContact(contacts);
    }

}
