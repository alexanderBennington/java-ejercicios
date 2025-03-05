package ventas;

public class Orden {
    private final int idOrden;
    private Producto[] productos;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS=10;
    private static int contadorOrdenes;

    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }
    public void agregarProducto(Producto producto){
        this.productos[this.contadorProductos++] = producto;
    }

}