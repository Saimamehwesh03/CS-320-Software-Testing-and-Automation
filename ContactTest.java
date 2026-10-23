package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        assertEquals("1001", contact.getContactId());
        assertEquals("Saima", contact.getFirstName());
        assertEquals("Syeda", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Riyadh", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "Saima", "Syeda", "1234567890", "Riyadh")
        );
    }

    @Test
    void testContactIdCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "Saima", "Syeda", "1234567890", "Riyadh")
        );
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", null, "Syeda", "1234567890", "Riyadh")
        );
    }

    @Test
    void testFirstNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "12345678901", "Syeda", "1234567890", "Riyadh")
        );
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", null, "1234567890", "Riyadh")
        );
    }

    @Test
    void testLastNameCannotBeLongerThan10Characters() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", "12345678901", "1234567890", "Riyadh")
        );
    }

    @Test
    void testPhoneMustBe10Digits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", "Syeda", "123456789", "Riyadh")
        );

        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", "Syeda", "12345678901", "Riyadh")
        );
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", "Syeda", null, "Riyadh")
        );
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1001", "Saima", "Syeda", "1234567890", null)
        );
    }

    @Test
    void testAddressCannotBeLongerThan30Characters() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(
                    "1001",
                    "Saima",
                    "Syeda",
                    "1234567890",
                    "1234567890123456789012345678901"
            )
        );
    }

    @Test
    void testContactIdCannotBeUpdated() {
        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        assertEquals("1001", contact.getContactId());
    }

    @Test
    void testContactFieldsCanBeUpdated() {
        Contact contact = new Contact(
                "1001",
                "Saima",
                "Syeda",
                "1234567890",
                "Riyadh"
        );

        contact.setFirstName("Sara");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("Jeddah");

        assertEquals("Sara", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("Jeddah", contact.getAddress());
    }
}
