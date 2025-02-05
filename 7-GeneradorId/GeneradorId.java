import java.util.Random;
import java.util.Scanner;

public class GeneradorId {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Ingrese su nombre: ");
        String nombre = scan.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scan.nextLine();
        System.out.print("Ingrese su año de nacimiento: ");
        int ano = scan.nextInt();
        scan.nextLine();
        String year = Integer.toString(ano);
        
        int numeroAleatorio = random.nextInt(10000)+1;
        String numeroAleatorioFormateado = String.format("%04d", numeroAleatorio);
        String id = nombre.substring(0, 2).toUpperCase() + apellido.substring(0, 2).toUpperCase() + year.substring(2, 4) + numeroAleatorioFormateado ;
        
        System.out.println("ID: " + id);
    }
}
