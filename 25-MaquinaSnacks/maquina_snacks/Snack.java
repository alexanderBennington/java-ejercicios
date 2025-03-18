package maquina_snacks;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Snack implements Serializable{
    //private static int contadorSnacks = 0;
    private static final AtomicInteger contadorSnacks = new AtomicInteger(0);
    private final int idSnack;
    private String nombre;
    private double precio;

    public Snack(){
        this.idSnack = Snack.contadorSnacks.incrementAndGet();
    }
    public Snack(String nombre, double precio){
        this();
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public static AtomicInteger getContadorSnacks() {
        return Snack.contadorSnacks;
    }
    public int getIdSnack() {
        return this.idSnack;
    }
    @Override
    public String toString(){
        /*return "Snack{" +
            "idSnack=" + this.idSnack +
            ", nombre='" + this.nombre + '\'' +
            ", precio=" + this.precio +
        '}';*/
        return String.format("Snack{idSnack=%d, nombre='%s', precio=%.2f}", idSnack, nombre, precio);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Snack snack = (Snack) obj;
        return idSnack == snack.idSnack && 
            Double.compare(precio, snack.precio) == 0 && 
            Objects.equals(nombre, snack.nombre);
    }
    @Override
    public int hashCode() {
        return Objects.hash(idSnack, nombre, precio);
    }
}