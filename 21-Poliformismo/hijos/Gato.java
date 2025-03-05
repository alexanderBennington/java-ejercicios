package hijos;
import Padre.Animal;

public class Gato extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("Puedo maullar");
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