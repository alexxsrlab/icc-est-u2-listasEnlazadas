package Controllers;

import Models.Contact;
import View.ConsoleView;

public class MenuController {
    private ContactManager manager;
    private ConsoleView view;

    public MenuController() {
        manager = new ContactManager();
        view = new ConsoleView();
    }

    public void start() {
        int opcion;

        do {
            opcion = view.showMenu();

            switch (opcion) {
                case 1: {
                    Contact nuevoContacto = view.getContactInput();
                    manager.addContact(nuevoContacto);
                    view.showMessage("Contacto agregado.");
                    break;
                }
                case 2: {
                    String nombreBuscar = view.getNameInput("buscar");
                    Contact encontrado = manager.findContactByName(nombreBuscar);
                    if (encontrado != null) {
                        view.showContact(encontrado);
                    } else {
                        view.showMessage("Contacto no encontrado.");
                    }
                    break;
                }
                case 3: {
                    String nombreEliminar = view.getNameInput("eliminar");
                    manager.deleteContactByName(nombreEliminar);
                    view.showMessage("Contacto eliminado si existía.");
                    break;
                }
                case 4: {
                    view.printAll(manager);
                    break;
                }
                case 5: {
                    view.showMessage("Saliendo del programa...");
                    break;
                }
                default: {
                    view.showMessage("Opción inválida. Intente nuevamente.");
                    break;
                }
            }

        } while (opcion != 5);
    }
}
