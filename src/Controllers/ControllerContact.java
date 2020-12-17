package Controllers;
import DAO.ContactDaoImplement;
import Interfaces.IDataModel;
import Models.Contact;
import Models.User;
import Views.ViewContact;
import java.util.List;

public class ControllerContact {
    private final ViewContact viewContact = new ViewContact();
    public ControllerContact() {}

    public void recordModelData(Contact contact) {
        IDataModel<Contact> contactDao = new ContactDaoImplement();
        contactDao.recordModelData(contact);
    }

    public void deleteModelData(Contact contact) {
        IDataModel<Contact> contactDao = new ContactDaoImplement();
        contactDao.deleteModelData(contact);
    }

    public void updateModelData(Contact contact) {
        IDataModel<Contact> contactDao = new ContactDaoImplement();
        contactDao.updateModelData(contact);
    }

    public void viewContacts(User currentUser) {
        IDataModel<Contact> contactDao = new ContactDaoImplement();
        List<Contact> listContact = ((ContactDaoImplement) contactDao).getListModelData(currentUser);
        viewContact.renderViewContact(listContact);
    }
}
