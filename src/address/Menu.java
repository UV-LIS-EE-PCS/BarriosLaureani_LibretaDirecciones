package address;

import address.data.*;

/**
 * Representa un menú para interactuar con el libro de direcciones.
 */
public class Menu {

    private AddressBook menuBook;

    /**
     * Constructor que inicializa el menú con un libro de direcciones.
     * 
     * @param menuBook El libro de direcciones a utilizar.
     */
    public Menu(AddressBook menuBook) {
        this.menuBook = menuBook;
    }

    /**
     * Muestra el menú con las opciones disponibles.
     */
    public void displayMenu() {
        System.out.println("===============================");
        System.out.println("Choose an option from the menu");
        System.out.println("a) Add");
        System.out.println("b) Load from file");
        System.out.println("c) Find");
        System.out.println("d) Remove");
        System.out.println("e) Show all entries");
        System.out.println("f) Quit");
        System.out.println("===============================");
    }

    /**
     * Verifica si un contacto existe en el libro de direcciones.
     * 
     * @param firstName El nombre de pila del contacto.
     * @param lastName El apellido del contacto.
     * @return true si el contacto existe, false en caso contrario.
     */
    public boolean contactExists(String firstName, String lastName) {
        for (AddressEntry tempEntry : menuBook.getEntries()) {
            if (tempEntry.getFirstName().equalsIgnoreCase(firstName) && tempEntry.getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Añade un contacto al libro de direcciones después de verificar si ya existe.
     * 
     * @param firstName El nombre de pila del contacto.
     * @param lastName El apellido del contacto.
     * @param street La calle del contacto.
     * @param city La ciudad del contacto.
     * @param state El estado del contacto.
     * @param zipCode El código postal del contacto.
     * @param email La dirección de correo electrónico del contacto.
     * @param phoneNumber El número de teléfono del contacto.
     */
    public void addCheck(String firstName, String lastName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        try {
            if (!contactExists(firstName, lastName)) {
                menuBook.add(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                System.out.println("Contact added successfully!");
            } else {
                System.out.println("This contact already exists and won't be added again.");
            }
        } catch (Exception e) {
            System.out.println("There was an error adding the contact: " + e.getMessage());
        }
    }
}