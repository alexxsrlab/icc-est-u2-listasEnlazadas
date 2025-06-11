package View;

import java.util.Scanner;

import Controllers.ContactManager;
import Models.Contact;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    // Muestra el menú y retorna la opción seleccionada
    public int showMenu() {
        System.out.println("\n--- Menú de Agenda ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Ver todos los contactos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(scanner.nextLine()); // sin try-catch
    }

    // Pide al usuario los datos del contacto
    public Contact getContactInput() {
        System.out.print("Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String phone = scanner.nextLine();
        return new Contact(name, phone);
    }

    // Pide al usuario el nombre para buscar o eliminar
    public String getNameInput(String action) {
        System.out.printf("Ingrese el nombre del contacto a %s: ", action);
        return scanner.nextLine();
    }

    // Muestra un contacto
    public void showContact(Contact contact) {
        System.out.println("Contacto encontrado: " + contact);
    }

    // Muestra un mensaje genérico
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Imprime todos los contactos
    public void printAll(ContactManager manager) {
        System.out.println("\n--- Lista de Contactos ---");
        manager.printList();
    }
}
