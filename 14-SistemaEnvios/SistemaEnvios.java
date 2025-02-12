import java.util.Scanner;

public class SistemaEnvios {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***Sistema de envios***");
        System.out.println("El destino del paquete es (nacional/internacional): ");
        String destino = scan.nextLine();
        System.out.println("Peso del paquete en KG: ");
        float peso = Float.parseFloat(scan.nextLine());
        switch(destino){
            case "nacional": System.out.printf("Costo de envio: $%.2f", peso * 10.0f);
                break;
            case "internacional": System.out.printf("Costo de envio: $%.2f", peso * 20.0f);
                break;
            default: System.out.printf("Destino no registrado");
                break;
        }
        scan.close();
    }
}