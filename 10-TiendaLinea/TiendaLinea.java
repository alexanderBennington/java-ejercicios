import java.util.Scanner;

public class TiendaLinea{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
        	System.out.print("""
                        	***Tienda en linea***
                        	Total de la compra?: 
                        	""");
        	float subtotal = scan.nextFloat();
		scan.nextLine();
        	System.out.print("Eres miembro?(s/n): ");
        	var miembro = scan.nextLine();
        	float descuento = subtotal * 0.1F;
        	if(miembro.equalsIgnoreCase("s")){
            		System.out.println("Se le ha ofrecido en 10% de descuento");
            		System.out.printf("Subtotal: $%.2f \n", subtotal);
			System.out.printf("Descuento: $%.2f \n", descuento);
            		System.out.printf("Total: $%.2f", subtotal - descuento);
        	} else {
			System.out.printf("Subtotal: $%.2f \n", subtotal);
            		System.out.printf("Total: $%.2f", subtotal);
		}
		scan.close();
	}
}