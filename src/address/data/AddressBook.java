package address.data;
import java.util.ArrayList;
import java.io.*;
import java.util.Comparator;
public class AddressBook {
    // aún en proceso

    ArrayList<AddressEntry> addressEntries;
    private AddressBook() {
        this.addressEntries= new ArrayList<>();
    }

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

    public void saveToFile(AddressEntry tempEntry) {
        try (FileWriter saveEntry = new FileWriter(tempEntry.getLastName() + "_" + tempEntry.getFirstName() + ".txt")) {
            saveEntry.write(tempEntry.toString());;
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

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

    public void remove(String lastName) {
        addressEntries.removeIf(tempEntry -> tempEntry.getLastName().equalsIgnoreCase(lastName));
    }
    
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