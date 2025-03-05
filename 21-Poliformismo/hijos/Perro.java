package hijos;
import Padre.Animal;

public class Perro extends Animal{
    public Perro() {
        super("Desconocido", "Desconocida");
    }
    public Perro(String nombre, String raza) {
        super(nombre, raza);
    }
    @Override
    public void hacerSonido(){
        System.out.println("Puedo ladrar");
        super.hacerSonido();
    }
    @Override
    public void dormir(){
        super.dormir();
    }
    @Override
    public void comer(){
        super.comer();
    }
}