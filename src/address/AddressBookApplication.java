package address;

import address.data.*;
import java.util.Scanner;

/**
 * Clase principal para la aplicación del libro de direcciones.
 */
public class AddressBookApplication {

    /**
     * Método principal que ejecuta la aplicación del libro de direcciones.
     * 
     * @param args Argumentos de línea de comando (no se utilizan).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressEntries = AddressBook.getInstance();
        Menu start = new Menu(addressEntries);
        boolean runProgram = true;

        while (runProgram) {
            start.displayMenu();
            String answer = sc.nextLine();

            switch (answer) {
                case "a":
                    System.out.println("Enter your contact data");
                    System.out.println("First name: ");
                    String firstName = sc.nextLine();
                    System.out.println("Last name: ");
                    String lastName = sc.nextLine();
                    System.out.println("Street: ");
                    String street = sc.nextLine();
                    System.out.println("City: ");
                    String city = sc.nextLine();
                    System.out.println("State: ");
                    String state = sc.nextLine();
                    System.out.println("Zip Code: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid Zip Code:");
                        sc.next();
                    }
                    int zipCode = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();
                    System.out.println("Phone number");
                    String phoneNumber = sc.nextLine();
                    if (!start.contactExists(firstName, lastName)) {
                        start.addCheck(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                        AddressEntry tempEntry = new AddressEntry(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                        boolean saving = true;
                        do {
                            System.out.println("Would you like to save this entry into a text file? y/n");
                            char confirmation = sc.next().charAt(0);
                            sc.nextLine();
                            if (confirmation == 'y') {
                                addressEntries.saveToFile(tempEntry);
                                System.out.println("This entry is now saved on a .txt File. ");
                                saving = false;
                            } else if (confirmation == 'n') {
                                System.out.println("This entry isn't saved. It will lose after the program stops. ");
                                saving = false;
                            } else {
                                System.out.println("Please choose a valid option. ");
                            }
                        } while (saving); 
                    } else {
                        System.out.println("This contact already exists and won't be added again.");
                    }
                    break;
                case "b":
                    System.out.println("Enter the file name");
                    String fileName = sc.nextLine();
                    addressEntries.readFromFile(fileName);
                    break;
                case "c":
                    System.out.println("Enter a last name or the start of a last name: ");
                    String startOfLastName = sc.nextLine();
                    addressEntries.find(startOfLastName);
                    break;
                case "d":
                    System.out.println("Enter the contact last name you want to remove: ");
                    String seekLastName = sc.nextLine();
                    addressEntries.seek(seekLastName);
                    System.out.println("Are you sure you wanna remove this contact? y/n");
                    char response = sc.next().charAt(0);
                    sc.nextLine();
                    if (response == 'y') {
                        addressEntries.remove(seekLastName);
                    } else if (response == 'n') {
                        System.out.println("This entry remains in your contacts. ");
                    }
                    break;
                case "e":
                    addressEntries.show();
                    break;
                case "f":
                    System.out.println("Goodbye!");
                    runProgram = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }
}