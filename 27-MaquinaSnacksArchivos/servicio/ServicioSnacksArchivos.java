package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import dominio.Snack;

public class ServicioSnacksArchivos implements IServicioSnacks{
    private static final Logger LOGGER = Logger.getLogger(ServicioSnacksArchivos.class.getName());
    private final String NOMBRE_ARCHIVO = "TicketCompra.txt";
    private List<Snack> snacks = new ArrayList<>();

    public ServicioSnacksArchivos(){
        var archivo = new File(NOMBRE_ARCHIVO);
        if(archivo.exists()){
            this.snacks = obtenerSnacks();
            LOGGER.log(Level.INFO, "El archivo ya existe en: {0}", archivo.getAbsolutePath());
        }else{
            try (PrintWriter salida = new PrintWriter(new FileWriter(archivo))){
                LOGGER.log(Level.INFO, "Se ha creado el archivo... {0}", archivo.getAbsolutePath());
                cargarSnacksIniciales();
            } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Ocurrio un error al crear el archivo...", e);
            }
        }
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papas", 23.34));
        this.agregarSnack(new Snack("Refresco", 17.45));
        this.agregarSnack(new Snack("Sandwich", 12.32));
    }

    private List<Snack> obtenerSnacks(){
        List<Snack> snacks = new ArrayList<>();
        try {
            List<String> lineas =Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea : lineas){
                String[] lineaSnack = linea.split(",");
                var idSnack = lineaSnack[0];
                var nombre = lineaSnack[1];
                var precio = Double.parseDouble(lineaSnack[2]);
                Snack snack = new Snack(nombre, precio);
                snacks.add(snack);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro al leer archivo: {0}", e);
        }
        return snacks; 
    }

    @Override
    public void agregarSnack(Snack snack) {
        this.snacks.add(snack);
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        File archivo = new File(NOMBRE_ARCHIVO);
        if(!archivo.exists()){
            LOGGER.log(Level.WARNING, "El archivo no existe: {0}", archivo.getAbsolutePath());
        }
        try (PrintWriter salida = new PrintWriter(new FileWriter(archivo, true))){
            salida.println(snack.escribirSnack());
            LOGGER.log(Level.INFO, "Se ha agregado el " + snack, archivo.getAbsolutePath());
        } catch (IOException e) {
        LOGGER.log(Level.WARNING, "Ocurrio un error al escribir en el archivo...", e);
        }
    }

    @Override
    public void mostrarSnacks() {
        StringBuilder inventarioSnacks = new StringBuilder("***Snacks en el inventario***\n");
        for (var snack : this.snacks){
            inventarioSnacks.append(String.format("%s \n", snack.toString()));
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> obtenerSnack() {
        return snacks;
    }
}