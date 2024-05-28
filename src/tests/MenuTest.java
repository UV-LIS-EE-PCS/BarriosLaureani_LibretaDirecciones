package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import address.data.*;
import address.Menu;

public class MenuTest {
    private AddressBook menuBook;
    private Menu menu;

    @BeforeEach
    void setUp() {
        menuBook = AddressBook.getInstance();
        menu = new Menu(menuBook);
    }

    @Test
    void testAddCheck() {
        menu.addCheck("Jane", "Smith", "456 Oak St", "Othertown", "CA", 54321, "jane@example.com", "9876543210");
        assertTrue(menu.contactExists("Jane", "Smith"), "Contact should have been added");
    }

    @Test
    void testContactExists() {
        menuBook.add("Gary", "Stu", "Calle Ejemplo", "Cosolea", "Veracruz", 12345, "gary@example.com", "1234567890");
        assertTrue(menu.contactExists("Gary", "Stu"), "Contact should exist");
        assertFalse(menu.contactExists("Mary", "Sue"), "Contact should not exist");
    }
}
