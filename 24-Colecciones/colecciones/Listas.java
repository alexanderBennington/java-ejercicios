package colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Listas {
    List<String> miLista;
    private static final Logger LOGGER = Logger.getLogger(Listas.class.getName());
    
    public Listas(){
        //System.out.println("Creando lista...");
        LOGGER.log(Level.INFO, "Creando lista...");
        this.miLista = new ArrayList<>();
    }
    public void agregarElemento(String datos){
        this.miLista.add(datos);
        LOGGER.log(Level.INFO, "Elemento agregado: {0}", datos);
    }
    public List<String> getMiLista(){
        return this.miLista;
    }
    public void removerElemento(String dato) {
        if (this.miLista.remove(dato)) {
            LOGGER.log(Level.INFO, "Elemento eliminado: {0}", dato);
        } else {
            LOGGER.log(Level.WARNING, "Intento de eliminar un dato inexistente: {0}", dato);
        }
    }
    public void mostrarLista(){
        //this.miLista.forEach(System.out::println);
        //this.miLista.forEach(e -> System.out.println(e));
        this.miLista.forEach(dato -> LOGGER.log(Level.INFO, "Elemento: {0}", dato));
    }
    @Override
    public String toString() {
        return "Lista: " + String.join(", ", miLista);    }
}
