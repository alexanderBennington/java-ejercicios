import claseabstracta.*;
import interfaz.*;
import java.io.Serializable;

public class PruebaAbstracta{
    static void imprimirDatos(String saludo, float numeroFloat, int... numeros){
        System.out.println("Saludo: " + saludo);
        System.out.printf("saludo %.2f \n", numeroFloat);
        for(int numero : numeros){
            System.out.println("Numero: " + numero);
        }
    }
    public static void main(String[] args){
        imprimirDatos("hola", 2.345F, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        FiguraGeometrica figurageometrica = new Rectangulo();
        figurageometrica.dibujar();
        figurageometrica = new Circulo();
        figurageometrica.dibujar();
        Traductor ingles = new Ingles();
        ingles.iniciarTraductor();
        ingles.traducir();
        var persona = new Persona();
        persona.setNombre("Alex");
        persona.setEdad(12);
        System.out.println(persona);

    }
}
class Circulo extends FiguraGeometrica{
    public void dibujar(){
        System.out.println("Dibujar Circulo");
    }
}
class Ingles implements Traductor{
    public void traducir(){
        System.out.println("Traduciendo a ingles...");
    }
}
class Persona implements Serializable{
    private String nombre;
    private int edad;

    Persona(){}

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    @Override
    public String toString(){
        return "Persona{" +
                "nombre='" + this.nombre + '\'' +
                ", edad=" + this.edad +
                "}";
    }
}