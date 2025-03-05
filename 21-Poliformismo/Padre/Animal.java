package Padre;

public class Animal{
    private static int conteoAnimales = 0;
    protected int idAnimal;
    protected String nombre;
    protected String raza;

    @Override
    public String toString(){
        return "Id: " + this.idAnimal + " Me llamo " + this.nombre + " y soy de raza " + this.raza;
    }
    public Animal(String nombre, String raza){
        this.nombre = nombre;
        this.raza = raza;
        //Animal.conteoAnimales++;
        //this.idAnimal = Animal.conteoAnimales;
        this.idAnimal = ++Animal.conteoAnimales;
    }
    protected void comer(){
        System.out.println("Como muchas veces al dia");
    }
    protected void dormir(){
        System.out.println("Duermo muchas horas");
    }
    public void hacerSonido(){
        System.out.println("Puedo hacer ruido");
    }
    /*public int getConteoAnimales(){
        return Animal.conteoAnimales;
    }*/
    public static int getConteoAnimales(){
        return Animal.conteoAnimales;
    }
    public int getIdAnimal(){
        return this.idAnimal;
    }
}