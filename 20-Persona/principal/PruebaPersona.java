package principal;

import clases.Persona;

public class PruebaPersona{
    public static void main(String[] args){
        var persona1 = new Persona("Kevin", "Alexander");
        persona1.mostrarDatos();
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        persona1.setNombre("Jose");
        persona1.setApellido("Marquez");
        persona1.mostrarDatos();
    }
}