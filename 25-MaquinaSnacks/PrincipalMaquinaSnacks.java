import maquina_snacks.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PrincipalMaquinaSnacks {
    private static final Logger LOGGER = Logger.getLogger(PrincipalMaquinaSnacks.class.getName());

    public static void maquinaSnacks() {
        /*var salir = false;
        var consola = new Scanner(System.in);
        List<Snack> productos = new ArrayList<>();
        System.out.println("***Maquina Snacks ***");
        Snacks.mostrarSnacks();
        while (!salir) {
            try {
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, consola, productos);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Ocurrio un error... {0}", e.getMessage());
            } finally {
                System.out.println();
            }
        }*/
        try (Scanner consola = new Scanner(System.in)) {
            boolean salir = false;
            List<Snack> productos = new ArrayList<>();
            System.out.println("***Maquina Snacks ***");
            Snacks.mostrarSnacks();
            while (!salir) {
                try {
                    int opcion = mostrarMenu(consola);
                    salir = ejecutarOpcion(opcion, consola, productos);
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Ocurrió un error... {0}", e.getMessage());
                } finally {
                    System.out.println();
                }
            }
        }
    }
    private static int mostrarMenu(Scanner consola){
        int opcion = -1;
        while (opcion == -1) {
            try {
                System.out.print("""
                    Menu:
                    1. Comprar Snack
                    2. Mostrar Ticket
                    3. Agregar Nuevo Snack
                    4. Salir
                    Elija una opción: 
                    """);
                opcion = Integer.parseInt(consola.nextLine());
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Entrada inválida. Debe ser un número... {0}", e.getMessage());
            }
        }
        return opcion;
    }
    private static boolean ejecutarOpcion(int opcion, Scanner consola, List<Snack> productos){
        var salir = false;
        switch (opcion) {
            case 1 -> comprarSnack(consola, productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa pronto!");
                salir = true;
            }
            default -> {
                System.out.println("Opción invalida: " + opcion);
            }
        }
        return salir;
    }
    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.print("Cuál snack desea (id)?: ");
        try {
            int idSnack = Integer.parseInt(consola.nextLine());
            boolean snackEncontrado = false;
            for (Snack snack : Snacks.getSnacks()) {
                if (idSnack == snack.getIdSnack()) {
                    productos.add(snack);
                    System.out.println("Snack agregado: " + snack);
                    snackEncontrado = true;
                    break;
                }
            }
            if (!snackEncontrado) {
                System.out.println("Id de snack no encontrado: " + idSnack);
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Entrada inválida. Debe ingresar un número... {0}", e.getMessage());
        }
    }
    
    private static void mostrarTicket(List<Snack> productos){
        //var ticket = "***Ticket***";
        StringBuilder ticket = new StringBuilder("***Ticket***\n");
        var total = 0.0;
        for(var producto : productos){
            //ticket += "\n\t-" + producto.getNombre() + " - $" + producto.getPrecio();
            ticket.append(String.format("\t- %s - $%.2f%n", producto.getNombre(), producto.getPrecio()));
            total += producto.getPrecio();
        }
        //ticket += "\n\t Total -> $" + total;
        ticket.append(String.format("\tTotal -> $%.2f", total));
        System.out.println(ticket);
    }
    private static void agregarSnack(Scanner consola) {
        System.out.print("Nombre del Snack: ");
        String nombre = consola.nextLine();
        
        double precio = -1;
        while (precio < 0) {
            System.out.print("Precio del Snack: ");
            try {
                precio = Double.parseDouble(consola.nextLine());
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Entrada inválida. Ingrese un número válido... {0}", e.getMessage());
            }
        }
    
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Snack agregado");
        Snacks.mostrarSnacks();
    }
    public static void main(String[] args) {
        maquinaSnacks();
    }
}