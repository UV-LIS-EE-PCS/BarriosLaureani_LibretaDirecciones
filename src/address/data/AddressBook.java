package address.data;
import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;
public class AddressBook {

    // Instanciación del Arraylist con las entradas de directorio
    private static AddressBook instance = null;
    ArrayList<AddressEntry> addressEntries;
    private AddressBook() {
        this.addressEntries= new ArrayList<>();
    }

    public static AddressBook getInstance() {
        if (instance == null) {
            instance = new AddressBook();
        }
        return instance;
    }

    // Método para añadir entradas de directorio al Arraylist de estos objetos
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

    // Método que permite almacenar una entrada de directorio en forma de archivo .txt o bloc de notas
    public void saveToFile(AddressEntry tempEntry) {
        try (FileWriter saveEntry = new FileWriter(tempEntry.getLastName() + "_" + tempEntry.getFirstName() + ".txt")) {
            saveEntry.write(tempEntry.toString());;
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    // Método que permite la lectura de un archivo .txt para ser añadido al Arraylist compuesto de entradas de directorio
    public void readFromFile(String filename) {
        try (BufferedReader loadEntry = new BufferedReader(new FileReader(filename))) {    
            String[] addressElements = new String[8];
            int index = 0;
            String line;
            while ((line = loadEntry.readLine()) != null) {
                String[] parts = line.split("\n");
                addressElements[index] = parts[0];
                index++;
            }
            add(addressElements[0], addressElements[1], addressElements[2], addressElements[3], addressElements[4], Integer.parseInt(addressElements[5]), addressElements[6], addressElements[7]);
            System.out.println("File " + filename + " loaded succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para buscar una entrada específica mediante el inicio del apellido de la persona a buscar
    public void find(String startOfLastName) {
        ArrayList<AddressEntry> coincidences = new ArrayList<>();
        for(int i = 0; i < addressEntries.size(); i++) {
            AddressEntry tempEntry;
            tempEntry = addressEntries.get(i);
            if (tempEntry.getLastName().contains(startOfLastName)) {
                coincidences.add(tempEntry);
            }
        }
        if (coincidences.isEmpty()) {
            System.out.println("There are no contacts with that last name.");
        } else {
            for(int i = 0; i < coincidences.size(); i++) {
                System.out.println("Coincidence number " + i+1);
                System.out.println(coincidences.get(i).toString());
            }
        }
    }

    // Método que permite remover una entrada mediante el apellido de la persona
    public void remove(String lastName) {
        addressEntries.removeIf(tempEntry -> tempEntry.getLastName().equalsIgnoreCase(lastName));
    }

    // Mostrar todas las entradas registradas en el Arraylist de directorio
    public void show() {
        if (addressEntries.isEmpty()) {
            System.out.println("The Address Book is empty. Try by adding a new contact or loading a File.");
        } else {
            Comparator <AddressEntry> lastNameComparing = Comparator.comparing(AddressEntry::getLastName);
            addressEntries.sort(lastNameComparing);
            for (AddressEntry tempEntry : addressEntries) {
                System.out.println(tempEntry.toString() + "\n");
            }
        }
    }
}