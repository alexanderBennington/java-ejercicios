package manejos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgregarContenidoArchivo {
    private static final Logger LOGGER = Logger.getLogger(AgregarContenidoArchivo.class.getName());

    public static void agregarContenidoArchivo(File archivo){
        boolean anexar = false;
        if(!(anexar = archivo.exists())){
            LOGGER.log(Level.WARNING, "No existe el archivo: {0}", archivo.getAbsolutePath());
            return;
        }
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar))){
            var nuevoContenido = "Nuevo\nContenido\n\tPráctica";
            salida.println(nuevoContenido);
            LOGGER.log(Level.INFO, "Nuevo contenido agregado a {0}", archivo.getAbsolutePath());
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error al escribir en archivo " + archivo.getAbsolutePath(), e);
        }
    }
}
