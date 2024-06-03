# Proyecto - Aplicación de consola "Libreta de direcciones"

## Resumen
En este proyecto se desarrolla un programa simple que emula un directorio de contactos, o llamado de otra forma, "libreta de direcciones".
Este programa permite que los usuarios, mediante la introducción de datos por consola, puedan agregar datos desde 0, cargar desde un archivo de texto plano, buscar y encontrar registros, eliminarlos y mostrar todos los registros actuales.
Este proyecto se desarrolló completamente en inglés, a pesar de no ser mi lengua nativa, para hacer énfasis en la codificación en lenguaje universal, sin embargo, este archivo y la Wiki serán elaborados completamente en español.

## Abstract
In this project we'll develop a simple program that emules a contact directory, also known as "Address Book".
This program, from console inputs, allows the users to add new data, load from a plain text file, search and find entries, delete it and show all the current entries.
This project was developed fully in english, even if it isn't my native language, to emphasize on the universal-language coding, nevertheless, this file and the wiki will be made fully in spanish.

## Estructura del proyecto
El proyecto está organizado en 3 distintos paquetes y 7 clases, incluyendo 3 de prueba

### Package `address`
En este paquete se encuentran las clases: 
- **`Menu`**: Despliega un menú con distintas opciones para el usuario y realiza un chequeo menor de los datos, para cersiorarse de que su introducción es correcta.
- **`AddressBookApplication`**: Clase que se encarga de ejecutar todo el programa y presenta la interfaz al usuario.

### Package `address.data`
En este paquete se encuentran las clases:
- **`AddressEntry`**: Plantilla inicial que dicta los datos necesarios para un registro del AddressBook.
- **`AddressBook`**: Se encarga de manejar el ArrayList que contiene las entradas principales del directorio y contiene los métodos esenciales para la ejecución.

### Package `tests`
En este paquete se encuentran las clases encargadas de realizar las pruebas unitarias con JUnit Jupiter
- **`AddressEntryTest`**: Prueba los getters, setters y toString de la clase para cersiorarse de proporcionar y obtener los datos correctos.
- **`AddressBookTest`**: Se encarga de probar los métodos orientados a la manipulación de los datos dentro del ArrayList que conforman el directorio de contactos.
- **`MenuTest`**: Comprueba los métodos para evitar duplicados en el directorio.

## Operaciones
Este programa tiene las siguientes operaciones disponibles para el usuario:
1. **Añadir contacto**: Mediante el ingreso de datos por la terminal, crea un registro para el directorio y lo añade a este, dándole la opción al usuario de exportarlo a un archivo de texto plano.
2. **Cargar desde archivo**: Permite al usuario añadir al directorio un registro desde un archivo de texto plano.
3. **Buscar registros con similitudes**: Al ingresar la parte de un apellido, le muestra al usuario las coincidencias que pudiera encontrar con ese fragmento del apellido de cada contacto.
4. **Eliminar un registro**: Al buscar un apellido específico, se puede eliminar por completo del directorio.
5. **Mostrar todos los registros**: Permite al usuario visualizar todos los registros actuales del directorio.

## Javadoc

### `AddressEntry`
```java
package address.data;

/**
 * Representa una entrada de dirección en un directorio.
 */
public class AddressEntry {

    // Variables por las que se compone una entrada de directorio
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;
    private String email;

    /**
     * Constructor vacío para crear una entrada de dirección vacía.
     */
    public AddressEntry() {

    }

    /**
     * Constructor parametrizado para crear una entrada de dirección con los datos proporcionados.
     * 
     * @param firstName Nombre de pila.
     * @param lastName Apellido.
     * @param street Calle.
     * @param city Ciudad.
     * @param state Estado.
     * @param zipCode Código postal.
     * @param email Dirección de correo electrónico.
     * @param phoneNumber Número de teléfono.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Obtiene el nombre de pila.
     * 
     * @return El nombre de pila.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Obtiene el apellido.
     * 
     * @return El apellido.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Obtiene la calle.
     * 
     * @return La calle.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Obtiene la ciudad.
     * 
     * @return La ciudad.
     */
    public String getCity() {
        return city;
    }

    /**
     * Obtiene el estado.
     * 
     * @return El estado.
     */
    public String getState() {
        return state;
    }

    /**
     * Obtiene el código postal.
     * 
     * @return El código postal.
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Obtiene el número de teléfono.
     * 
     * @return El número de teléfono.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Obtiene la dirección de correo electrónico.
     * 
     * @return La dirección de correo electrónico.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el nombre de pila.
     * 
     * @param firstName El nombre de pila.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Establece el apellido.
     * 
     * @param lastName El apellido.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Establece la calle.
     * 
     * @param street La calle.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Establece la ciudad.
     * 
     * @param city La ciudad.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Establece el estado.
     * 
     * @param state El estado.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Establece el código postal.
     * 
     * @param zipCode El código postal.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Establece el número de teléfono.
     * 
     * @param phoneNumber El número de teléfono.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Establece la dirección de correo electrónico.
     * 
     * @param email La dirección de correo electrónico.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna una representación en cadena de la entrada de dirección.
     * 
     * @return Una cadena que contiene todos los campos de la entrada de dirección.
     */
    @Override
    public String toString() {
        return getFirstName() + "\n" + getLastName() + "\n" + getStreet() + "\n" + getCity() + "\n" + getState() + "\n" + getZipCode() + "\n" + getPhoneNumber() + "\n" + getEmail();
    }
}
```

### `AddressBook`
```java
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
```

### `Menu`
```java
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
```
### `AddressBookApplication`
```java
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
```
### AddressEntryTest
```java
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import address.data.AddressEntry;

/**
 * Clase de prueba para la clase AddressEntry.
 */
public class AddressEntryTest {

    /**
     * Prueba el constructor y los getters de la clase AddressEntry.
     */
    @Test
    void testConstructorAndGetters() {
        AddressEntry entry = new AddressEntry("Gary", "Stu", "Calle ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        assertEquals("Gary", entry.getFirstName());
        assertEquals("Stu", entry.getLastName());
        assertEquals("Calle ejemplo", entry.getStreet());
        assertEquals("Cosoleacaque", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(12345, entry.getZipCode());
        assertEquals("gary@example.com", entry.getEmail());
        assertEquals("1234567890", entry.getPhoneNumber());
    }

    /**
     * Prueba los setters de la clase AddressEntry.
     */
    @Test
    void testSetters() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("Mary");
        entry.setLastName("Sue");
        entry.setStreet("Calle ejemplo 2");
        entry.setCity("Orizaba");
        entry.setState("Veracruz");
        entry.setZipCode(54321);
        entry.setEmail("mary@example.com");
        entry.setPhoneNumber("9876543210");
        assertEquals("Mary", entry.getFirstName());
        assertEquals("Sue", entry.getLastName());
        assertEquals("Calle ejemplo 2", entry.getStreet());
        assertEquals("Orizaba", entry.getCity());
        assertEquals("Veracruz", entry.getState());
        assertEquals(54321, entry.getZipCode());
        assertEquals("mary@example.com", entry.getEmail());
        assertEquals("9876543210", entry.getPhoneNumber());
    }

    /**
     * Prueba el método toString de la clase AddressEntry.
     */
    @Test
    void testToString() {
        AddressEntry entry = new AddressEntry("Gary", "Stu", "Calle ejemplo", "Cosoleacaque", "Veracruz", 12345, "gary@example.com", "1234567890");
        String expectedString = "Gary\nStu\nCalle ejemplo\nCosoleacaque\nVeracruz\n12345\n1234567890\ngary@example.com";
        assertEquals(expectedString, entry.toString());
    }
}
```
### AddressBookTest
```java
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
```
### MenuTest
```java
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
```
## Cierre
Este proyecto fue desarrollado para implementar la lógica básica de programación orientada a objetos, aunada a las buenas prácticas de construcción de un sistema. En la Wiki habrá documentación adicional como diagramas UML y ejemplos de la funcionalidad del programa para esclarecer su uso correcto.
