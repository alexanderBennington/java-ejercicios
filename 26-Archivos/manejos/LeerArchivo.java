package manejos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class LeerArchivo {
    private static final Logger LOGGER = Logger.getLogger(LeerArchivo.class.getName());


    public static void leerArchivo(File archivo){
        if (!archivo.exists()) {
            LOGGER.log(Level.WARNING, "El archivo no existe: {0}", archivo.getAbsolutePath());
            return;
        }
        try (BufferedReader entrada = new BufferedReader(new FileReader(archivo))){
            System.out.println("Leyendo archivo...");
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Error al leer el archivo: {0}", e);
            e.printStackTrace();
        }
    }
}
