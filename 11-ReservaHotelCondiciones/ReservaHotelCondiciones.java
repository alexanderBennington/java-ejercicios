import java.util.Scanner;

public class ReservaHotelCondiciones {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***Sistema de reservaciones de hotel***");
        System.out.println("Ingrese su nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Dias de estadía: ");
        int diasEstadia = scan.nextInt();
        scan.nextLine();
        System.out.println("Vista al mar? s/n: ");
        char vistaMar = scan.next().charAt(0);
        float costoSinVistaMar = 150.50f;
        float costoVistaMar = 190.50f;
        float total;
        if(String.valueOf(vistaMar).equalsIgnoreCase("s")){
            total = diasEstadia * costoVistaMar;
            System.out.printf("""
                              ---Datos---
                              Nombre Cliente: %s
                              Dias de estadía: %d
                              Vista al mar: %s
                              Precio por dia: $%.2f
                              Total: $%.2f
                              """, nombre, diasEstadia, (String.valueOf(vistaMar).equalsIgnoreCase("s")? "SI" : "NO"), costoVistaMar, total);
        } else{
            total = diasEstadia * costoSinVistaMar;
            System.out.printf("""
                              ---Datos---
                              Nombre Cliente: %s
                              Dias de estadía: %d
                              Vista al mar: %s
                              Precio por dia: $%.2f
                              Total: $%.2f
                              """, nombre, diasEstadia, (String.valueOf(vistaMar).equalsIgnoreCase("s")? "SI" : "NO"), costoSinVistaMar, total);
        }
    }
}
