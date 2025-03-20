package zona_fit.zonafit;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

public class ZonaFit {
    private static final Logger LOGGER = Logger.getLogger(ZonaFit.class.getName());
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp(){
        var salir = false;
        Scanner consola = new Scanner(System.in);
        IClienteDAO clienteDao = new ClienteDAO();
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(consola, opcion, clienteDao);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Error al ejecutar opciones: {0}", e.getMessage());
            }
        }
    }

    private static int mostrarMenu(Scanner consola){
        int opcion = 0;
        while (opcion <= 0) {
            try {
                System.out.print("""
                    ***Zona Fit ***
                    1. Listar Clientes
                    2. Buscar Cliente
                    3. Agregar Cliente
                    4. Modificar Cliente
                    5. Eliminar Cliente
                    6. Salir
                    \nElije una opción:\s
                """);
                opcion = Integer.parseInt(consola.nextLine());
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Entrada inválida. Debe ser un número... {0}", e.getMessage());
            }
        }
        return opcion;
    }

    private static boolean ejecutarOpciones(Scanner consola, int opcion, IClienteDAO clienteDAO){
        //List<Cliente> cliente = new ArrayList<>();
        var salir = false;
        switch (opcion) {
            case 1 -> {
                var cliente = clienteDAO.listarClientes();
                System.out.println("Lista de clientes:");
                cliente.forEach(System.out::println);
                System.out.println();
            }
            case 2 -> {
                System.out.print("Introduzca ID de cliente a buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idCliente);
                clienteDAO.buscarClientePorId(cliente);
                System.out.println();
            }
            case 3 -> {
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Membresia: ");
                var membresia =  Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(nombre, apellido, membresia);
                clienteDAO.agregarCliente(cliente);
                System.out.println();
            }
            case 4 -> {
                System.out.print("Introduzca ID de cliente a modificar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Membresia: ");
                var membresia =  Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idCliente, nombre, apellido, membresia);
                clienteDAO.modificarCliente(cliente);
                System.out.println();
            }
            case 5 -> {
                System.out.print("Introduzca ID de cliente a eliminar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = new Cliente(idCliente);
                clienteDAO.eliminarCliente(cliente);
            }
            case 6 -> {
                System.out.println("Hasta luego!");
                salir = true;
            }
            default -> {
                System.out.println("Opción invalida: " + opcion);
            }
        }
        return salir;
    }
}
