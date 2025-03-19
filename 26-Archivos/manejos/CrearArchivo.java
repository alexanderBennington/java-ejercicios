package manejos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CrearArchivo {
    private static final Logger LOGGER = Logger.getLogger(CrearArchivo.class.getName());

    public static void crearArchivo(File archivo){
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe!");
            } else {
                //var salida = new PrintWriter(new FileWriter(archivo));
                //salida.close();
                try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))) {
                    LOGGER.log(Level.INFO, "Se ha creado el archivo: {0}", archivo.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error al crear el archivo: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }
}