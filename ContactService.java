package contactservice;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactId) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException("Contact not found");
    }

    public void updateContact(String contactId, String firstName, String lastName,
                              String phone, String address) {

        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                if (firstName != null) {
                    contact.setFirstName(firstName);
                }

                if (lastName != null) {
                    contact.setLastName(lastName);
                }

                if (phone != null) {
                    contact.setPhone(phone);
                }

                if (address != null) {
                    contact.setAddress(address);
                }

                return;
            }
        }

        throw new IllegalArgumentException("Contact not found");
    }
}
