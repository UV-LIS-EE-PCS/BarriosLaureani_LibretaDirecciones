package address.data;

import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;

/**
 * Representa un libro de direcciones que contiene varias entradas de direcciones.
 */
public class AddressBook {

    // Instanciación del ArrayList con las entradas de directorio
    private ArrayList<AddressEntry> addressEntries = new ArrayList<>();
    private static AddressBook instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private AddressBook() {}

    /**
     * Obtiene la instancia única de AddressBook.
     * 
     * @return La instancia única de AddressBook.
     */
    public static AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    /**
     * Obtiene todas las entradas de dirección.
     * 
     * @return Una lista de todas las entradas de dirección.
     */
    public ArrayList<AddressEntry> getEntries() {
        return addressEntries;
    }

    /**
     * Añade una nueva entrada de dirección al ArrayList de estas.
     * 
     * @param fName Nombre de pila.
     * @param lName Apellido.
     * @param street Calle.
     * @param city Ciudad.
     * @param state Estado.
     * @param zipCode Código postal.
     * @param email Dirección de correo electrónico.
     * @param phoneNumber Número de teléfono.
     */
    public void add(String fName, String lName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        AddressEntry tempEntry = new AddressEntry();
        tempEntry.setFirstName(fName);
        tempEntry.setLastName(lName);
        tempEntry.setStreet(street);
        tempEntry.setCity(city);
        tempEntry.setState(state);
        tempEntry.setZipCode(zipCode);
        tempEntry.setEmail(email);
        tempEntry.setPhoneNumber(phoneNumber);
        addressEntries.add(tempEntry);
    }

    /**
     * Almacena una entrada de dirección en un archivo .txt.
     * 
     * @param tempEntry La entrada de dirección a almacenar.
     */
    public void saveToFile(AddressEntry tempEntry) {
        try (FileWriter saveEntry = new FileWriter(tempEntry.getLastName() + "_" + tempEntry.getFirstName() + ".txt")) {
            saveEntry.write(tempEntry.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee un archivo .txt y añade su contenido al ArrayList de entradas de dirección.
     * 
     * @param filename El nombre del archivo a leer.
     */
    public void readFromFile(String filename) {
        try (BufferedReader loadEntry = new BufferedReader(new FileReader(filename))) {    
            String[] addressElements = new String[8];
            int index = 0;
            String line;
            while ((line = loadEntry.readLine()) != null) {
                addressElements[index] = line.trim();
                index++;
                if (index == 8) {
                    add(addressElements[0], addressElements[1], addressElements[2], addressElements[3], addressElements[4], Integer.parseInt(addressElements[5]), addressElements[6], addressElements[7]);
                    index = 0;
                }
            }
            System.out.println("File " + filename + " loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca una entrada específica utilizando el inicio del apellido de la persona.
     * 
     * @param startOfLastName El inicio del apellido a buscar.
     */
    public void find(String startOfLastName) {
        ArrayList<AddressEntry> coincidences = new ArrayList<>();
        for (AddressEntry tempEntry : addressEntries) {
            if (tempEntry.getLastName().toLowerCase().contains(startOfLastName.toLowerCase())) {
                coincidences.add(tempEntry);
            }
        }
        if (coincidences.isEmpty()) {
            System.out.println("There are no contacts with that last name.");
        } else {
            for (int i = 0; i < coincidences.size(); i++) {
                System.out.println("Coincidence number " + (i + 1));
                System.out.println(coincidences.get(i).toString());
            }
        }
    }

    /**
     * Busca y muestra una entrada específica utilizando el apellido de la persona.
     * 
     * @param lastName El apellido de la entrada a buscar.
     */
    public void seek(String lastName) {
        boolean found = false;
        for (AddressEntry tempEntry : addressEntries) {
            if (tempEntry.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("This entry was found: ");
                System.out.println(tempEntry.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("There are no contacts with that last name.");
        }
    }

    /**
     * Elimina una entrada utilizando el apellido de la persona.
     * 
     * @param lastName El apellido de la entrada a eliminar.
     */
    public void remove(String lastName) {
        addressEntries.removeIf(tempEntry -> tempEntry.getLastName().equalsIgnoreCase(lastName));
        System.out.println("This entry was removed successfully.");
    }

    /**
     * Muestra todas las entradas registradas en el ArrayList de directorio.
     */
    public void show() {
        if (addressEntries.isEmpty()) {
            System.out.println("The Address Book is empty. Try by adding a new contact or loading a File.");
        } else {
            Comparator<AddressEntry> lastNameComparing = Comparator.comparing(AddressEntry::getLastName);
            addressEntries.sort(lastNameComparing);
            for (AddressEntry tempEntry : addressEntries) {
                System.out.println(tempEntry.toString() + "\n");
            }
        }
    }
}