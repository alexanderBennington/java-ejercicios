import Padre.Animal;
import hijos.Perro;
import hijos.Gato;

public class Poliformismo{
    static void imprimirSonido(Animal animal){
        animal.hacerSonido();
    }
    public static void main(String[] args){
        var animal = new Animal("Puddy", "Bull");
        var perro = new Perro("Billy", "Pit");
        var gato = new Gato("Waybe", "Cat");
        perro.hacerSonido();
        gato.dormir();
        perro.comer();
        imprimirSonido(animal);
        imprimirSonido(perro);
        imprimirSonido(gato);
        System.out.println(animal);
        System.out.println(perro);
        System.out.println(gato);
        System.out.println(Animal.getConteoAnimales());
        System.out.println(gato.getIdAnimal());
        System.out.println(perro.getIdAnimal());
    }
}