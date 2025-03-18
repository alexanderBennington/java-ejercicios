package maquina_snacks;

import java.util.List;
import java.util.ArrayList;

public class Snacks {
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 23.34));
        snacks.add(new Snack("Refresco", 17.45));
        snacks.add(new Snack("Sandwich", 12.32));
    }
    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }
    public static void mostrarSnacks(){
        StringBuilder inventarioSnacks = new StringBuilder("***Snacks en el inventario***\n");
        //var inventarioSnacks = "";
        for(Snack snack : snacks){
            //inventarioSnacks += snack.toString() + "\n";
            inventarioSnacks.append(snack).append("\n");
        }
        //System.out.println("***Snacks en el inventario***");
        System.out.println(inventarioSnacks);
    }
    public static List<Snack> getSnacks(){
        return snacks;
        //return List.copyOf(snacks);
    }
}