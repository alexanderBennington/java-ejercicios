import java.util.Scanner;

public class SumaDiagonalMatriz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] numero = new int[3][3];
        char IngresarNumeros;
        char Continuar;
        int i;
        int j;
        int suma;
        boolean siContinuar = true;
        do{
            suma = 0;
            System.out.print("""
                            ***Suma diagonal de matriz***
                            ¿Quiere ingresar sus propios numeros s/n?: 
                            """);
            IngresarNumeros = scan.next().charAt(0);
            scan.nextLine();
            System.out.print("\n");
            if(String.valueOf(IngresarNumeros).equalsIgnoreCase("s")){
                for(i = 0; i < 3; i++){
                    for(j = 0; j < 3; j++){
                        System.out.print("Ingrese valor de la posición [" + i + "][" + j + "]: ");
                        numero[i][j] = Integer.parseInt(scan.nextLine());
                    }
                }
                System.out.println("\nEsta es tu matriz: ");
                for(i = 0; i < 3; i++){
                    for(j = 0; j < 3; j++){
                        System.out.print(numero[i][j] + "\t");
                        if(i == j){
                            suma += numero[i][j];
                        }                    
                    }
                    System.out.print("\n");
                }
                System.out.println("La suma de la diagona es de: " + suma);
            } else {
                numero[0][0] = 100; numero[0][1] = 200; numero[0][2] = 300;
                numero[1][0] = 400; numero[1][1] = 500; numero[1][2] = 600;
                numero[2][0] = 700; numero[2][1] = 800; numero[2][2] = 900;
                System.out.println("Esta es tu matriz: ");
                for(i = 0; i < 3; i++){
                    for(j = 0; j < 3; j++){
                        System.out.print(numero[i][j] + "\t");
                        if(i == j){
                            suma += numero[i][j];
                        }  
                    }
                    System.out.print("\n");
                }
                System.out.println("La suma de la diagona es de: " + suma);
            }
            System.out.print("\nDesea hacer otro calculo s/n?: ");
            Continuar = scan.next().charAt(0);
            scan.nextLine();
            if(!String.valueOf(Continuar).equalsIgnoreCase("s")){
                siContinuar = false;
                System.out.print("\nAdios!");
            }
            System.out.print("\n");
        } while(siContinuar);
        scan.close();
    }
}