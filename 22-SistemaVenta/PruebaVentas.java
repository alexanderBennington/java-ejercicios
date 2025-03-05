import ventas.Producto;
import ventas.Orden;

public class PruebaVentas {
    public static void main(String[] args) {
        System.out.println("*** Sistema de ventas ***");
        var producto1 = new Producto("Blusa", 345.45);
        System.out.println(producto1);
        var producto2 = new Producto("Zapatos", 756.34);
        System.out.println(producto2);
    }
}