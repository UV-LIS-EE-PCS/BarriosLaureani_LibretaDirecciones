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
 * Representa una entrada en una libreta de direcciones.
 * Contiene detalles personales como nombre, dirección, número de teléfono y correo electrónico.
 */
public class AddressEntry {

    // Variables que componen una entrada de directorio
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipCode;
    private String phoneNumber;
    private String email;

    /**
     * Constructor por defecto.
     */
    public AddressEntry() {
    }

    /**
     * Constructor parametrizado.
     *
     * @param firstName   Nombre del contacto.
     * @param lastName    Apellido del contacto.
     * @param street      Dirección del contacto.
     * @param city        Ciudad del contacto.
     * @param state       Estado del contacto.
     * @param zipCode     Código postal del contacto.
     * @param phoneNumber Número de teléfono del contacto.
     * @param email       Dirección de correo electrónico del contacto.
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zipCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters y setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Convierte la entrada en una cadena de texto.
     *
     * @return Una cadena de texto con la información de la entrada.
     */
    @Override
    public String toString() {
        return firstName + "\n" + lastName + "\n" + street + "\n" + city + "\n" + state + "\n" + zipCode + "\n" + phoneNumber + "\n" + email;
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
 * Clase que representa una libreta de direcciones que contiene múltiples entradas de direcciones.
 */
public class AddressBook {

    private ArrayList<AddressEntry> addressEntries = new ArrayList<>();
    private static AddressBook instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private AddressBook() {
    }

    /**
     * Obtiene la instancia única de la libreta de direcciones.
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
     * Obtiene todas las entradas de la libreta de direcciones.
     *
     * @return Una lista de todas las entradas de direcciones.
     */
    public ArrayList<AddressEntry> getEntries() {
        return addressEntries;
    }

    /**
     * Añade una nueva entrada a la libreta de direcciones.
     *
     * @param fName      Nombre del contacto.
     * @param lName      Apellido del contacto.
     * @param street     Dirección del contacto.
     * @param city       Ciudad del contacto.
     * @param state      Estado del contacto.
     * @param zipCode    Código postal del contacto.
     * @param email      Dirección de correo electrónico del contacto.
     * @param phoneNumber Número de teléfono del contacto.
     */
    public void add(String fName, String lName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        AddressEntry tempEntry = new AddressEntry(fName, lName, street, city, state, zipCode, phoneNumber, email);
        addressEntries.add(tempEntry);
    }

    /**
     * Guarda una entrada de dirección en un archivo de texto.
     *
     * @param tempEntry La entrada de dirección a guardar.
     */
    public void saveToFile(AddressEntry tempEntry) {
        try (FileWriter saveEntry = new FileWriter(tempEntry.getLastName() + "_" + tempEntry.getFirstName() + ".txt")) {
            saveEntry.write(tempEntry.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee una entrada de dirección desde un archivo de texto y la añade a la libreta de direcciones.
     *
     * @param filename El nombre del archivo desde el cual leer la entrada de dirección.
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
     * Busca entradas en la libreta de direcciones por el comienzo del apellido.
     *
     * @param startOfLastName El inicio del apellido por el cual buscar.
     */
    public ArrayList<AddressEntry> find(String startOfLastName) {
        ArrayList<AddressEntry> coincidences = new ArrayList<>();
        for (AddressEntry tempEntry : addressEntries) {
            if (tempEntry.getLastName().toLowerCase().contains(startOfLastName.toLowerCase())) {
                coincidences.add(tempEntry);
            }
        }
        return coincidences;
    }

    /**
     * Busca una entrada en la libreta de direcciones por el apellido.
     *
     * @param lastName El apellido por el cual buscar.
     */
    public void seek(String lastName) {
        boolean found = false;
        for (AddressEntry tempEntry : addressEntries) {
            if (tempEntry.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Esta entrada fue encontrada: ");
                System.out.println(tempEntry.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No hay contactos con ese apellido. ");
        }
    }

    /**
     * Elimina una entrada de la libreta de direcciones por el apellido.
     *
     * @param lastName El apellido de la entrada a eliminar.
     */
    public void remove(String lastName) {
        boolean found = false;
        for (int i = 0; i < addressEntries.size(); i++) {
            if (addressEntries.get(i).getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Eliminando la siguiente entrada:");
                System.out.println(addressEntries.get(i).toString());
                addressEntries.remove(i);
                found = true;
                i--;  // Ajustar índice después de la eliminación
            }
        }
        if (!found) {
            System.out.println("No se encontraron contactos con ese apellido.");
        }
    }

    /**
     * Imprime todas las entradas de direcciones ordenadas por apellido y nombre.
     */
    public void show() {
        addressEntries.sort(Comparator.comparing(AddressEntry::getLastName).thenComparing(AddressEntry::getFirstName));
        for (AddressEntry tempEntry : addressEntries) {
            System.out.println(tempEntry.toString());
            System.out.println("-----------");
        }
    }
}
```

### `Menu`
```java
package address;

import address.data.*;

/**
 * Clase que representa el menú para interactuar con la libreta de direcciones.
 */
public class Menu {
    private AddressBook menuBook;

    /**
     * Constructor para inicializar el menú con una libreta de direcciones.
     *
     * @param menuBook La libreta de direcciones a ser usada en el menú.
     */
    public Menu(AddressBook menuBook) {
        this.menuBook = menuBook;
    }

    /**
     * Muestra las opciones del menú al usuario.
     */
    public void displayMenu() {
        System.out.println("===============================");
        System.out.println("Elige una opción del menú");
        System.out.println("a) Añadir");
        System.out.println("b) Cargar desde archivo");
        System.out.println("c) Buscar");
        System.out.println("d) Eliminar");
        System.out.println("e) Mostrar todas las entradas");
        System.out.println("f) Salir");
        System.out.println("===============================");
    }

    /**
     * Verifica si un contacto existe en la libreta de direcciones.
     *
     * @param firstName Nombre del contacto.
     * @param lastName  Apellido del contacto.
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
     * Añade una nueva entrada a la libreta de direcciones si no existe previamente.
     *
     * @param firstName   Nombre del contacto.
     * @param lastName    Apellido del contacto.
     * @param street      Dirección del contacto.
     * @param city        Ciudad del contacto.
     * @param state       Estado del contacto.
     * @param zipCode     Código postal del contacto.
     * @param email       Correo electrónico del contacto.
     * @param phoneNumber Número de teléfono del contacto.
     */
    public void addCheck(String firstName, String lastName, String street, String city, String state, int zipCode, String email, String phoneNumber) {
        try {
            if (!contactExists(firstName, lastName)) {
                menuBook.add(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                System.out.println("¡Contacto añadido exitosamente!");
            } else {
                System.out.println("Este contacto ya existe y no se añadirá nuevamente.");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error al añadir el contacto: " + e.getMessage());
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
 * Clase principal para la aplicación de la libreta de direcciones.
 * Permite al usuario interactuar con la libreta de direcciones a través de un menú.
 */
public class AddressBookApplication {
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
                    System.out.println("Ingrese los datos de su contacto");
                    System.out.println("Nombre: ");
                    String firstName = sc.nextLine();
                    System.out.println("Apellido: ");
                    String lastName = sc.nextLine();
                    System.out.println("Calle: ");
                    String street = sc.nextLine();
                    System.out.println("Ciudad: ");
                    String city = sc.nextLine();
                    System.out.println("Estado: ");
                    String state = sc.nextLine();
                    System.out.println("Código Postal: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un Código Postal válido:");
                        sc.next();
                    }
                    int zipCode = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Correo electrónico: ");
                    String email = sc.nextLine();
                    System.out.println("Número de teléfono: ");
                    String phoneNumber = sc.nextLine();
                    
                    if (!start.contactExists(firstName, lastName)) {
                        start.addCheck(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                        AddressEntry tempEntry = new AddressEntry(firstName, lastName, street, city, state, zipCode, email, phoneNumber);
                        boolean saving = true;
                        
                        do {
                            System.out.println("¿Le gustaría guardar esta entrada en un archivo de texto? s/n");
                            char confirmation = sc.next().charAt(0);
                            sc.nextLine();
                            if (confirmation == 's') {
                                addressEntries.saveToFile(tempEntry);
                                System.out.println("Esta entrada está ahora guardada en un archivo .txt.");
                                saving = false;
                            } else if (confirmation == 'n') {
                                System.out.println("Esta entrada no está guardada. Se perderá después de que el programa se detenga.");
                                saving = false;
                            } else {
                                System.out.println("Por favor, elija una opción válida.");
                            }
                        } while (saving); 
                    } else {
                        System.out.println("Este contacto ya existe y no se añadirá nuevamente.");
                    }
                    break;
                case "b":
                    System.out.println("Ingrese el nombre del archivo");
                    String fileName = sc.nextLine();
                    addressEntries.readFromFile(fileName);
                    break;
                case "c":
                    System.out.println("Ingrese un apellido o el inicio de un apellido: ");
                    String startOFLastName = sc.nextLine();
                    addressEntries.find(startOFLastName);
                    break;
                case "d":
                    System.out.println("Ingrese el apellido del contacto que desea eliminar: ");
                    String seekLastName = sc.nextLine();
                    addressEntries.seek(seekLastName);
                    System.out.println("¿Está seguro de que desea eliminar este contacto? s/n");
                    char response = sc.next().charAt(0);
                    sc.nextLine();
                    if (response == 's') {
                        addressEntries.remove(seekLastName);
                    } else if (response == 'n') {
                        System.out.println("Esta entrada permanece en sus contactos.");
                    }
                    break;
                case "e":
                    addressEntries.show();
                    break;
                case "f":
                    System.out.println("¡Adiós!");
                    runProgram = false;
                    return;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
        sc.close();
    }
}
```
## Cierre
Este proyecto fue desarrollado para implementar la lógica básica de programación orientada a objetos, aunada a las buenas prácticas de construcción de un sistema. En la Wiki habrá documentación adicional como diagramas UML y ejemplos de la funcionalidad del programa para esclarecer su uso correcto.
