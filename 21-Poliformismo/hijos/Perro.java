package hijos;
import Padre.Animal;

public class Perro extends Animal{
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