import ventas.Producto;
import ventas.Orden;

public class PruebaVentas {
    public static void main(String[] args) {
        System.out.println("*** Sistema de ventas ***");
        var producto1 = new Producto("Blusa", 345.45);
        //System.out.println(producto1);
        var producto2 = new Producto("Zapatos", 756.34);
        //System.out.println(producto2);

        var orden1 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        System.out.println(orden1);
        var orden2 = new Orden();
        orden2.agregarProducto(new Producto("Playera", 234.56));
        orden2.agregarProducto(producto2);
        orden2.agregarProducto(producto1);
        System.out.println(orden2);
    }
}