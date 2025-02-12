import java.util.Scanner;

public class MayorDosNumeros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***Mayor de 2 números***");
        System.out.println("Ingrese un número entero: ");
        int numero1 = Integer.parseInt(scan.nextLine());
        System.out.println("Ingrese otro número entero: ");
        int numero2 = Integer.parseInt(scan.nextLine());
        int mayor = numero1 < numero2 ? numero2 :
                    numero1 > numero2 ? numero1 : 0;
        if(mayor != 0){
            System.out.printf("El numero %d es mayor \n", mayor);
        } else {
            System.out.printf("Ambos números son iguales \n");
        }
        scan.close();
    }
}