import java.util.Scanner;

public class SistemaAutenticacion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final var USUARIO = "Alexander";
        final var CLAVE = "1234";
        System.out.println("***Sistema de autenticación***");
        System.out.println("Ingresa usuario");
        String usuarios = scan.nextLine().strip();
        System.out.println("Ingresa clave");
        String claves = scan.nextLine().strip();
        var autenticacion = switch(usuarios){
            case USUARIO -> {
                if(CLAVE.equals(claves)){
                    yield "Bienvenido";
                } else {
                    yield "Clave incorrecta";
                }
            }
            default -> {
                if(CLAVE.equals(claves)){
                    yield "Usuario incorrecto";
                } else {
                    yield "Usuario y clave incorrectos";
                }
            }
        };
        System.out.println(autenticacion);
        scan.close();
    }
}