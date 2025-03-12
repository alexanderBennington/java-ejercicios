package clases;

public class Aritmetica {
    public static int dividir(int numero1, int numero2){
        if (numero2 == 0) {
            throw new RuntimeException ("División entre 0");
        }
        return numero1 / numero2;
    }
}