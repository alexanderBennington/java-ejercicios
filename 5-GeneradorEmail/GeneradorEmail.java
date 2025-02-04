public class GeneradorEmail{
	public static void main(String[] args){
		String nombre = "Kevin Alexander Sánchez Torres";
		String escuela = "Escuela Superior de Cómputo";
		String dominio = "com.mx";
		
		String nombreNormalizado = nombre.toLowerCase().replace(" ", ".");
		String escuelaNormalizado = escuela.toLowerCase().replace(" ", "");
		String dominioNormalizado = "@" + escuelaNormalizado + "." + dominio;
		String email = nombreNormalizado.concat(dominioNormalizado);

		System.out.println("*** Generador de Email ***");
		System.out.println("Nombre usuario: " + nombre);
		System.out.println("Nombre usuario normalizado: " + nombreNormalizado);
		System.out.println("Nombre escuela: " + escuela);
		System.out.println("Extension de dominio: " + "." + dominio);
		System.out.println("Dominio de email normalizado: " + dominioNormalizado);
		System.out.println("Email final generado: " + email); 				

	}
}
