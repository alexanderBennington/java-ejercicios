import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion;
        float numero1;
        float numero2;
        float total;
        do{
            System.out.println("""
                                *** Cajero Automatico ***
                                Operaciones:
                                1. Suma.
                                2. Resta.
                                3. Multiplicacion.
                                4. División.
                                5. Salir.
                                """);
            System.out.print("Elija una opción: ");          
            opcion = Integer.parseInt((scan.nextLine()));
            switch(opcion){
                case 1 -> {
                    System.out.println("\n\n***Suma***");
                    System.out.print("Ingrese un número: ");
                    numero1 = Float.parseFloat((scan.nextLine()));
                    System.out.print("Ingrese otro número: ");
                    numero2 = Float.parseFloat((scan.nextLine()));
                    total = numero1 + numero2;
                    System.out.printf("%.2f + %.2f = %.2f\n\n", numero1, numero2, total);
                }
                case 2 -> {
                    System.out.println("\n\n***Resta***");
                    System.out.print("Ingrese un número: ");
                    numero1 = Float.parseFloat((scan.nextLine()));
                    System.out.print("Ingrese otro número: ");
                    numero2 = Float.parseFloat((scan.nextLine()));
                    total = numero1 - numero2;
                    System.out.printf("%.2f - %.2f = %.2f\n\n", numero1, numero2, total);
                }
                case 3 -> {
                    System.out.println("\n\n***Multiplicación***");
                    System.out.print("Ingrese un número: ");
                    numero1 = Float.parseFloat((scan.nextLine()));
                    System.out.print("Ingrese otro número: ");
                    numero2 = Float.parseFloat((scan.nextLine()));
                    total = numero1 * numero2;
                    System.out.printf("%.2f * %.2f = %.2f\n\n", numero1, numero2, total);
                }
                case 4 -> {
                    System.out.println("\n\n***División***");
                    System.out.print("Ingrese un número: ");
                    numero1 = Float.parseFloat((scan.nextLine()));
                    System.out.print("Ingrese otro número: ");
                    numero2 = Float.parseFloat((scan.nextLine()));
                    if(numero2 != 0f){
                        total = numero1 / numero2;
                        System.out.printf("%.2f / %.2f = %.2f\n\n", numero1, numero2, total);
                    } else {
                        System.out.println("No se puede dividir entre cero, es indefinido\n");
                    }
                }
                case 5 -> System.out.println("¡Gracias, vuela pronto!");
                default -> System.out.println("Favor de seleccionar una opción dentro del rango 1-5\n");
            };
        } while(opcion != 5);
        scan.close();
    }
}