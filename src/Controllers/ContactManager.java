package Controllers;

import Models.Contact;
import Models.LinkedList;
import Models.Node;

public class ContactManager {
    private LinkedList<Contact> contactos;

    public ContactManager() {
        contactos = new LinkedList<>();
    }

    public void addContact(Contact contacto) {
        contactos.appendToTail(contacto);
    }

    public Contact findContactByName(String nombre) {
        Node<Contact> actual = contactos.getHead();
        while (actual != null) {
            Contact c = actual.getValue();
            if (c.getName().equalsIgnoreCase(nombre)) {
                return c;
            }
            actual = actual.getNext();
        }
        return null;
    }

    public void deleteContactByName(String nombre) {
        Node<Contact> actual = contactos.getHead();
        while (actual != null) {
            if (actual.getValue().getName().equalsIgnoreCase(nombre)) {
                contactos.deleteByValue(actual.getValue());
                return;
            }
            actual = actual.getNext();
        }
    }

    public void printList() {
        contactos.print();
    }
}


