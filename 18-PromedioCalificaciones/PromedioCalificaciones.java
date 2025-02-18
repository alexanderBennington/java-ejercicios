import java.util.Scanner;

public class PromedioCalificaciones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numeroCalificaciones;
        int i;
        float[] calificaciones;
        float promedio;
        char continuar;
        boolean siContinuar = true;
        do{
            promedio = 0;
            System.out.print("""
                                *** Promedio de calificaciones ***
                                Número de calificaciones: 
                                """);
            numeroCalificaciones = Integer.parseInt((scan.nextLine()));
            calificaciones = new float[numeroCalificaciones]; 
            for(i = 0; i < numeroCalificaciones; i++){
                System.out.print("\nIngrese la califiacion numero " + (i + 1) + ": ");
                calificaciones[i] = Float.parseFloat(scan.nextLine());
                promedio += calificaciones[i];
            }
            promedio /= numeroCalificaciones;
            System.out.printf("\nEl promedio es de %.2f\n", promedio);
            System.out.println("Quieres calcular otro promedio? s/n: ");
            continuar = scan.next().charAt(0);
            scan.nextLine();
            if(!String.valueOf(continuar).equalsIgnoreCase("s")){
                siContinuar = false;
                System.out.println("Hasta luego!");
            }
        } while(siContinuar);
        scan.close();
    }
}