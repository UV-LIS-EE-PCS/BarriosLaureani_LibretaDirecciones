package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

public class AddressEntryTest {
    @Test
    void testConstructorAndGetters() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "NY", 12345, "john@example.com", "1234567890");
        assertEquals("John", entry.getFirstName());
        assertEquals("Doe", entry.getLastName());
        assertEquals("123 Main St", entry.getStreet());
        assertEquals("Anytown", entry.getCity());
        assertEquals("NY", entry.getState());
        assertEquals(12345, entry.getZipCode());
        assertEquals("john@example.com", entry.getEmail());
        assertEquals("1234567890", entry.getPhoneNumber());
    }
    @Test
    void testSetters() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("Jane");
        entry.setLastName("Smith");
        entry.setStreet("456 Oak St");
        entry.setCity("Othertown");
        entry.setState("CA");
        entry.setZipCode(54321);
        entry.setEmail("jane@example.com");
        entry.setPhoneNumber("9876543210");
        assertEquals("Jane", entry.getFirstName());
        assertEquals("Smith", entry.getLastName());
        assertEquals("456 Oak St", entry.getStreet());
        assertEquals("Othertown", entry.getCity());
        assertEquals("CA", entry.getState());
        assertEquals(54321, entry.getZipCode());
        assertEquals("jane@example.com", entry.getEmail());
        assertEquals("9876543210", entry.getPhoneNumber());
    }
    @Test
    void testToString() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Main St", "Anytown", "NY", 12345, "john@example.com", "1234567890");
        String expectedString = "John\nDoe\n123 Main St\nAnytown\nNY\n12345\n1234567890\njohn@example.com";
        assertEquals(expectedString, entry.toString());
    }
}
