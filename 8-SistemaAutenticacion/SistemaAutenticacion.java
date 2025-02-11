import java.util.Scanner;

public class SistemaAutenticacion{
	public static void main(String[] args){
		final var USUARIO = "alexander1000";
        	final var CLAVE = "kev123";
        	Scanner scan = new Scanner(System.in);
        	System.out.print("""
                         	*** SISTEMA DE AUTENTICACIÓN ***
                         	Ingrese usuario: 
                         	""");
        	String usuarios = scan.nextLine();
        	System.out.println("Ingrese clave: ");
        	String claves = scan.nextLine();
                boolean comparacionCredenciales = USUARIO.equals(usuarios) && CLAVE.equals(claves) ? true : false; //se agrega ternario como ejemplo pero no es necesario
        	System.out.println("Las credenciales son autenticas?" + comparacionCredenciales);
	}
}