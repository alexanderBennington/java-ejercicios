package servicio;

import java.util.List;
import dominio.Snack;
import java.util.ArrayList;

public class ServicioSnacksLista implements IServicioSnacks {
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 23.34));
        snacks.add(new Snack("Refresco", 17.45));
        snacks.add(new Snack("Sandwich", 12.32));
    }
    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }
    public void mostrarSnacks(){
        StringBuilder inventarioSnacks = new StringBuilder("***Snacks en el inventario***\n");
        for(Snack snack : snacks){
            inventarioSnacks.append(snack).append("\n");
        }
        System.out.println(inventarioSnacks);
    }
    public List<Snack> obtenerSnack(){
        return snacks;
    }
}