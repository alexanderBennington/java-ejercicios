package interfaz;

public interface Traductor {
    //son public y abstract
    void traducir();
    default void iniciarTraductor(){
        System.out.println("Iniciando traductor...");
    }
}