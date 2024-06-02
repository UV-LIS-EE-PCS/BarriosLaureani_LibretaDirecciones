package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

/**
 * Clase de prueba para la clase AddressEntry.
 */
public class AddressEntryTest {

    /**
     * Prueba el constructor y los getters de la clase AddressEntry.
     */
    @Test
    void testConstructorAndGetters() {
        AddressEntry entry = new AddressEntry("Gary", "Stu", "Calle ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        assertEquals("Gary", entry.getFirstName());
        assertEquals("Stu", entry.getLastName());
        assertEquals("Calle ejemplo", entry.getStreet());
        assertEquals("Cosoleacaque", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(12345, entry.getZipCode());
        assertEquals("gary@example.com", entry.getEmail());
        assertEquals("1234567890", entry.getPhoneNumber());
    }

    /**
     * Prueba los setters de la clase AddressEntry.
     */
    @Test
    void testSetters() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("Mary");
        entry.setLastName("Sue");
        entry.setStreet("Calle ejemplo 2");
        entry.setCity("Orizaba");
        entry.setState("Veracruz");
        entry.setZipCode(54321);
        entry.setEmail("mary@example.com");
        entry.setPhoneNumber("9876543210");
        assertEquals("Mary", entry.getFirstName());
        assertEquals("Sue", entry.getLastName());
        assertEquals("Calle ejemplo 2", entry.getStreet());
        assertEquals("Orizaba", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(54321, entry.getZipCode());
        assertEquals("mary@example.com", entry.getEmail());
        assertEquals("9876543210", entry.getPhoneNumber());
    }

    /**
     * Prueba el método toString de la clase AddressEntry.
     */
    @Test
    void testToString() {
        AddressEntry entry = new AddressEntry("Gary", "Stu", "Calle ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        String expectedString = "Gary\nStu\nCalle ejemplo\nCosoleacaque\nVeracruz\n12345\n1234567890\ngary@example.com";
        assertEquals(expectedString, entry.toString());
    }
}