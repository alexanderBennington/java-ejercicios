package alexander.inventario.servicio;

import alexander.inventario.modelo.Producto;
import alexander.inventario.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio{

    private final ProductoRepositorio productoRepositorio;

    @Autowired
    public ProductoServicio(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer idProducto) {
        Producto producto = productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer idProducto) {
        productoRepositorio.deleteById(idProducto);
    }
}
