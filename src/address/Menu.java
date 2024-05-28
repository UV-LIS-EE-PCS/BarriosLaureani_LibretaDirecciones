package address;
import address.data.*;
public class Menu {
    private AddressBook menuBook;
    public Menu(AddressBook menuBook) {
        this.menuBook = menuBook;
    }
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

    public boolean contactExists(String firstName, String lastName) {
        for(AddressEntry tempEntry : menuBook.getEntries()) {
            if (tempEntry.getFirstName().equalsIgnoreCase(firstName) && tempEntry.getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }
    
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