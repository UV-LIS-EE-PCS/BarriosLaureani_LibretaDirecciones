package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import address.data.AddressBook;

/**
 * Clase de prueba para la clase AddressBook.
 */
public class AddressBookTest {

    private AddressBook addressBook;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setUp() {
        addressBook = AddressBook.getInstance();
    }

    /**
     * Prueba el método add de la clase AddressBook.
     */
    @Test
    void testAdd() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        assertEquals(1, addressBook.getEntries().size());
    }

    /**
     * Prueba el método find de la clase AddressBook.
     */
    @Test
    void testFind() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        addressBook.add("Mary", "Sue", "Calle Ejemplo 2", "Orizaba", "Veracruz", 54321, "mary@example.com", "9876543210");
        addressBook.find("S");
        assertEquals(2, addressBook.getEntries().size());
    }

    /**
     * Prueba el método getEntries de la clase AddressBook.
     */
    @Test
    void testGetEntries() {
        assertNotNull(addressBook.getEntries());
    }

    /**
     * Prueba el método getInstance de la clase AddressBook.
     */
    @Test
    void testGetInstance() {
        AddressBook instance1 = AddressBook.getInstance();
        AddressBook instance2 = AddressBook.getInstance();
        assertEquals(instance1, instance2);
    }

    /**
     * Prueba el método readFromFile de la clase AddressBook.
     */
    @Test
    void testReadFromFile() {
        addressBook.readFromFile("Barrios_Jorge.txt");
        assertEquals(1, addressBook.getEntries().size());
    }

    /**
     * Prueba el método remove de la clase AddressBook.
     */
    @Test
    void testRemove() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        addressBook.remove("Stu");
        assertEquals(0, addressBook.getEntries().size());
    }

    /**
     * Prueba el método saveToFile de la clase AddressBook.
     */
    @Test
    void testSaveToFile() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        addressBook.add("Mary", "Sue", "Calle Ejemplo 2", "Orizaba", "Veracruz", 54321, "mary@example.com", "9876543210");
        addressBook.show();
        assertEquals(2, addressBook.getEntries().size());
    }

    /**
     * Prueba el método seek de la clase AddressBook.
     */
    @Test
    void testSeek() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        addressBook.seek("Stu");
        assertEquals(1, addressBook.getEntries().size());
    }

    /**
     * Prueba el método show de la clase AddressBook.
     */
    @Test
    void testShow() {
        addressBook.add("Gary", "Stu", "Calle Ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        addressBook.add("Mary", "Sue", "Calle Ejemplo 2", "Orizaba", "Veracruz", 54321, "mary@example.com", "9876543210");
        addressBook.show();
        assertEquals(2, addressBook.getEntries().size());
    }
}