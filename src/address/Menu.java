package address;
import address.data.*;
public class Menu {
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

    private AddressEntry createAddressEntry(String firstName, String lastName, String street, String city, String state, int zipCode, String email, String phoneNumber) throws Exception {
        if (firstName.isEmpty() || lastName.isEmpty() || street.isEmpty() || city.isEmpty() || state.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()) {
            throw new Exception("Every field must be completed");
        }
        return new AddressEntry(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
    }

    public void addCheck(String firstName, String lastName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        try {
            AddressBook importedAddressBook = AddressBook.getInstance();
            importedAddressBook.add(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
            System.out.println("Contact added successfully!");
        } catch (Exception e) {
            System.out.println("There was an error adding the contact: " + e.getMessage());
        }
    }
}