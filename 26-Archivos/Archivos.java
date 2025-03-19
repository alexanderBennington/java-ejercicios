import java.io.File;
import manejos.*;

public class Archivos{
    public static void main(String[] args) {
        String nombreArchivo = "miArchivo.txt";
        var archivo = new File(nombreArchivo);
        //CrearArchivo.crearArchivo(archivo);
        LeerArchivo.leerArchivo(archivo);
        AgregarContenidoArchivo.agregarContenidoArchivo(archivo);
        LeerTodo.leerTodo(nombreArchivo);

    }
}
