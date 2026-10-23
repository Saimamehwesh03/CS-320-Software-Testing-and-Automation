package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        service.addContact(contact);

        assertDoesNotThrow(() -> service.updateContact(
                "1001",
                "Sara",
                "Syeda",
                "1234567890",
                "Riyadh"
        ));
    }

    @Test
    void testCannotAddDuplicateContactId() {
        ContactService service = new ContactService();

        Contact firstContact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        Contact secondContact = new Contact(
                "1001",
                "Sara",
                "Smith",
                "0987654321",
                "Jeddah"
        );

        service.addContact(firstContact);

        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(secondContact)
        );
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        service.addContact(contact);
        service.deleteContact("1001");

        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(
                    "1001",
                    "Sara",
                    "Syeda",
                    "1234567890",
                    "Riyadh"
            )
        );
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        service.addContact(contact);

        service.updateContact(
                "1001",
                "Sara",
                "Smith",
                "0987654321",
                "Jeddah"
        );

        assertDoesNotThrow(() -> service.updateContact(
                "1001",
                "Sara",
                "Smith",
                "0987654321",
                "Jeddah"
        ));
    }

    @Test
    void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
            service.updateContact(
                    "9999",
                    "Sara",
                    "Smith",
                    "0987654321",
                    "Jeddah"
            )
        );
    }
}
