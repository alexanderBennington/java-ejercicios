package colecciones;

import java.util.Map;
import java.util.HashMap;

public class Mapas {
    Map<String, String> mapa;

    public Mapas(){
        System.out.println("Creando mapa...");
        mapa = new HashMap<>();
    }
    public Map<String, String> getDatosMapa(){
        return this.mapa;
    }
    public void setDatoMapa(String clave, String valor){
        this.mapa.put(clave, valor);
    }
    public void removeDatoMapa(String clave){
        this.mapa.remove(clave);
    }
    public void mostrarMapa(){
        this.mapa.entrySet().forEach(System.out::println);
        this.mapa.forEach((clave, valor) -> System.out.println("Llave: " + clave + ", Valor: " + valor));
    }
}