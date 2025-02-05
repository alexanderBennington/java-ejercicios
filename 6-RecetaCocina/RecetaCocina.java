import java.util.Scanner;

public class RecetaCocina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***Receta de cocina***\n");
        
        System.out.println("Nombre de la receta: ");
        String nombreReceta = scan.nextLine();
        
        System.out.println("Ingredientes: ");
        String ingredientes = scan.nextLine();
        
        System.out.println("Tiempo de preparación (min): ");
        float tiempo = scan.nextFloat();
        scan.nextLine(); // Consumir el salto de línea pendiente
        
        System.out.println("Es fácil? (true/false): ");
        boolean esFacil = scan.nextBoolean();
        
        System.out.println("\n\nNombre de la receta: " + nombreReceta);
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Tiempo de preparación: " + tiempo + " minutos");
        System.out.println("Es fácil?: " + esFacil);
        
        scan.close(); // Cerrar el Scanner al final del programa
    }
}
