package manejos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerTodo {
    private static final Logger LOGGER = Logger.getLogger(LeerTodo.class.getName());

    public static void leerTodo(String nombreArchivo){
        if (!Files.exists(Paths.get(nombreArchivo))) {
            LOGGER.log(Level.WARNING, "El archivo no existe: {0}", nombreArchivo);
            return;
        }
        try {
            List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
            System.out.println("Leyendo archivo...");
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error al leer todo el archivo: ", e);
        }
    }
}
