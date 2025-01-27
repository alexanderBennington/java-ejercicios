public class DetalleProducto{
	public static void main(String[] args){
		String nombreProducto = "Gansito";
		float $precio = 18.5F;
		int _cantidadDisponible = 15;
		boolean isDisponible = true;

		System.out.println("Nombre del producto: " + nombreProducto);
		System.out.println("Precio: " + $precio);
		System.out.println("Cantidad disponible: " + _cantidadDisponible);
		System.out.println("Esta disponible a venta: " + isDisponible);

		nombreProducto = "Doritos";
		$precio = 10.2F;
		_cantidadDisponible = 0;
		isDisponible = false;

		System.out.println("Nombre del producto: " + nombreProducto);
		System.out.println("Precio: " + $precio);
		System.out.println("Cantidad disponible: " + _cantidadDisponible);
		System.out.println("Esta disponible a venta: " + isDisponible);
	}
}
