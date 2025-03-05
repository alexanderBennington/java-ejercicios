import Padre.Animal;
import hijos.Perro;
import hijos.Gato;

public class Poliformismo{
    static void imprimirSonido(Animal animal){
        animal.hacerSonido();
    }
    public static void main(String[] args){
        var animal = new Animal();
        var perro = new Perro();
        var gato = new Gato();
        perro.hacerSonido();
        gato.dormir();
        perro.comer();
        imprimirSonido(animal);
        imprimirSonido(perro);
        imprimirSonido(gato);
    }
}