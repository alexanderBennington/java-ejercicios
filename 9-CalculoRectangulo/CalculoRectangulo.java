import java.util.Scanner;

public class CalculoRectangulo{
	public static void main(String[] args){
        	Scanner scan = new Scanner(System.in);
        	System.out.println("""
				***Calculo de área y perímetro de rectangulo***
				Ingrese la base en metros: 
				""");
		float base = scan.nextFloat();
		System.out.println("Ingrese la altura en metros: ");
		float altura = scan.nextFloat();
		System.out.println("El área es de " + (base * altura));
		System.out.println("El perímetro es de " + ((base + altura))*2);
		scan.close();
	}
}