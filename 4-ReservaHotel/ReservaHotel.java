public class ReservaHotel{
	public static void main(String[] args){
		String nombreCliente = "Alexander S";
		int diasEstancia = 3;
		final float TARIFA_DIARIA = 120.32F;
		boolean isVistaMar = true;

		System.out.println("Nombre del cliente: " + nombreCliente);
		System.out.println("Días de estancia: " + diasEstancia);
		System.out.println("Tarifa Diaria: " + TARIFA_DIARIA);
		System.out.println("Tiene vista al mar: " + isVistaMar);

		nombreCliente = "Kevin T";
		diasEstancia = 7;
		isVistaMar = false;

		System.out.println("Nombre del cliente: " + nombreCliente);
		System.out.println("Días de estancia: " + diasEstancia);
		System.out.println("Tarifa Diaria: " + TARIFA_DIARIA);
		System.out.println("Tiene vista al mar: " + isVistaMar);
	}
}