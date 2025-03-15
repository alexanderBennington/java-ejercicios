//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import colecciones.*;

public class PruebaColecciones {
    static void mostrarListas(){
        Listas lista = new Listas();
        lista.agregarElemento("Lunes");
        lista.agregarElemento("Martes");
        lista.agregarElemento("Miercoles");
        lista.agregarElemento("Jueves");
        //lista.mostrarLista();
        System.out.println(lista);
        /*List<String> miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sabado");
        miLista.add("Domingo");
        miLista.add("Domingo");*/
        /*for(String dia : miLista){
            System.out.println("Dia de la semana: " + dia);
        }*/
        //Función Lambda
        /*miLista.forEach(dia -> {
            System.out.println("Dia: " + dia);
        });*/
        //miLista.forEach(System.out::println);
        List<String> nombres = Arrays.asList("Kevin", "Jose", "Pedro");
        System.out.println("Lista de nombres: ");
        nombres.forEach(System.out::println);
    }
    static void mostrarSets(){
        Sets sets = new Sets(); //No permiten repeticiones 
        sets.setDatoSets("Carlos");
        sets.setDatoSets("Kevin");
        sets.setDatoSets("Jose");
        sets.setDatoSets("Kevin");
        sets.setDatoSets("Pedro");
        sets.setDatoSets("carlos");
        sets.setDatoSets("Ana");
        System.out.println(sets);
        sets.removeDatoSets("Ana");
        System.out.println(sets);
    }
    static void mostrarMapas(){
        Mapas mapa = new Mapas();
        mapa.setDatoMapa("Nombre", "Kevin");
        mapa.setDatoMapa("Apellido", "Sánchez");
        mapa.setDatoMapa("edad", "24");
        mapa.setDatoMapa("x", "33");
        mapa.mostrarMapa();
        mapa.removeDatoMapa("x");
        mapa.mostrarMapa();
    }
    public static void main(String[] args) {
        mostrarListas();
        //mostrarSets();
        //mostrarMapas();
    }
}