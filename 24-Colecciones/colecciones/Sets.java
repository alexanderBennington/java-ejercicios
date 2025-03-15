package colecciones;

import java.util.Set;
import java.util.TreeSet;


public class Sets {
    Set<String> sets;

    public Sets(){
        System.out.println("Creando set nuevo...");
        sets = new TreeSet<>();
    }
    public Set<String> getSets(){
        return this.sets;
    }
    public void setDatoSets(String dato){
        this.sets.add(dato);
    }
    public void removeDatoSets(String dato){
        this.sets.remove(dato);
    }
    @Override
    public String toString(){
        return "Set: " + String.join(", ", sets);
    }
}
