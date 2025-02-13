import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float saldo = 1000.00f;
        int opcion;
        do{
            System.out.println("""
                                *** Cajero Automatico ***
                                Operaciones:
                                1. Consultar saldo.
                                2. Retirar.
                                3. Depositar
                                4. Salir
                                """);
            System.out.println("Elija una opción: ");          
            opcion = Integer.parseInt((scan.nextLine()));
            switch(opcion){
                case 1 -> System.out.printf("Tu saldo es de $%.2f\n\n", saldo);
                case 2 -> {
                    System.out.print("Cantidad que desea retirar: $");
                    float cantidadRetirar = Float.parseFloat(scan.nextLine());
                    saldo -= cantidadRetirar;
                    System.out.printf("\nTu saldo actual es de $%.2f\n\n", saldo);
                }
                case 3 -> {
                    System.out.print("Cantidad que desea depositar: $");
                    float cantidadRetirar = Float.parseFloat(scan.nextLine());
                    saldo += cantidadRetirar;
                    System.out.printf("\nTu saldo actual es de $%.2f\n\n", saldo);
                }
                case 4 -> System.out.println("¡Gracias, vuela pronto!");
                default -> System.out.println("Favor de seleccionar una opción dentro del rango 1-4\n");
            };
        } while(opcion != 4);
        scan.close();
    }
}