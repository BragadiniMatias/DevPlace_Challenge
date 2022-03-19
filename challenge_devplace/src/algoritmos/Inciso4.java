package algoritmos;

import java.util.Random;
import java.util.Scanner;

public class Inciso4 {
    public static void main(String[] args) {
        //Inicializo la variable numero a adivinar y llamo al metodo que genera un numero aleatorio.
        int numberToGuess = generateRandomNumber();
        System.out.println("Adivine el numero - entre 0 y 1000 (inclusivo)");
        //Lllamo al metodo que compara numeros y le paso por argumento el numero a adivinar.
        compareNumbers(numberToGuess);
    }

    //Creo un metodo que genera un numero aleatorio entre 0 y 1000. 
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(0,1001);
    }

    //Creo un metodo que compare los numeros.
    private static void compareNumbers(int numberToGuess) {
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;
        int guessedNumber = -1;
        //Creo un ciclo loop que corre mientras que el booleano gameOver no sea falso. 
        //Si es true, quiere decir que el numero adivinado es igual al numero generado aleatoriamente
        while (!gameOver) {
            //Pido por consola al usuario que ingrese un numero para comparar.
            guessedNumber = sc.nextInt();
            if (guessedNumber > numberToGuess){
                System.out.println("El numero ingresado es mayor, intenta de nuevo");
            } else if (guessedNumber < numberToGuess){
                System.out.println("El numero ingresado es menor, intenta de nuevo");
            } else{
                System.out.println("Adivinaste");
                gameOver = true;
            }
        }
    }
}




