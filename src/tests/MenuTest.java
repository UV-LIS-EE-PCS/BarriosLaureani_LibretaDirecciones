package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import address.data.*;
import address.Menu;

/**
 * Clase de prueba para la clase Menu.
 */
public class MenuTest {

    private AddressBook menuBook;
    private Menu menu;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    void setUp() {
        menuBook = AddressBook.getInstance();
        menu = new Menu(menuBook);
    }

    /**
     * Prueba el método addCheck de la clase Menu.
     */
    @Test
    void testAddCheck() {
        menu.addCheck("Mary", "Sue", "Calle ejemplo 2", "Orizaba", "Veracruz", 54321, "mary@example.com", "9876543210");
        assertTrue(menu.contactExists("Mary", "Sue"), "El contacto debería haber sido agregado");
    }

    /**
     * Prueba el método contactExists de la clase Menu.
     */
    @Test
    void testContactExists() {
        menuBook.add("Gary", "Stu", "Calle Ejemplo", "Cosolea", "Veracruz", 12345, "gary@example.com", "1234567890");
        assertTrue(menu.contactExists("Gary", "Stu"), "El contacto debería existir");
        assertFalse(menu.contactExists("Mary", "Sue"), "El contacto no debería existir");
    }
}