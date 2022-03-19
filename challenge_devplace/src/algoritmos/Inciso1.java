package algoritmos;
import java.util.Scanner;

public class Inciso1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero a verificar \n");

        int numberToCheck = sc.nextInt();
        boolean isPrime = true;

        //sacar la logica del main pasarlo a un metodo diferente. 
        if(numberToCheck == 0||numberToCheck ==1){
            System.out.println("El numero " + numberToCheck  + " no es primo");
            isPrime = false;
        } else {
            for(int i=2; i<=numberToCheck/2; i++){
                if(numberToCheck % i==0){
                    System.out.println("El numero " + numberToCheck + " no es primo");
                
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime){
            System.out.println("El numero " + numberToCheck + " es primo");
        }

    }

    



}
