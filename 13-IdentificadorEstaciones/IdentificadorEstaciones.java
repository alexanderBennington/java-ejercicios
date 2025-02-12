import java.util.Scanner;

public class IdentificadorEstaciones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***Identificador de estaciones del año***");
        System.out.println("Ingrese un mes 1-12: ");
        int mes = Integer.parseInt(scan.nextLine());
        String estacion = mes == 1 || mes == 2 || mes == 12 ? "Invierno" :
                            mes > 2 && mes < 6 ? "Primavera" :
                            mes > 5 && mes < 9 ? "Verano" : 
                            mes > 8 && mes < 12 ? "Otoño" : "Estación desconocida";
        System.out.print("Estacion del mes " + mes + ": " + estacion);
        scan.close();
    }
}