package Controllers;
import DAO.ContactDaoImplement;
import Interfaces.IDataModel;
import Models.Contact;
import Views.ViewContact;
import java.util.List;

public class ControllerContact {
    private final ViewContact viewContact = new ViewContact();
    public ControllerContact() {}

    public void recordModelData(Contact contact) {
        IDataModel contactDao = new ContactDaoImplement();
        contactDao.recordModelData(contact);
    }

    public void deleteModelData(Contact contact) {
        IDataModel contactDao = new ContactDaoImplement();
        contactDao.deleteModelData(contact);
    }

    public void updateModelData(Contact contact) {
        IDataModel contactDao = new ContactDaoImplement();
        contactDao.updateModelData(contact);
    }

    public void viewContacts() {
        IDataModel contactDao = new ContactDaoImplement();
        List<Contact> listContact = ((ContactDaoImplement) contactDao).getListModelData();
        viewContact.renderViewContact(listContact);
    }
}
