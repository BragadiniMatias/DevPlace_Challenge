package algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Inciso5 {
    public static void main(String[] args) {
        //Invoco al metodo que genera mis resultados y le paso como argumento el metodo que pide al usuario numeros.
        generateResultsFrom(getNumbersFromUser());
       
    }

    
    private static int getSumOfEvenNumbers(ArrayList<Integer> numbers){
        int evenSum = 0;
        for (Integer i: numbers){
            if (i%2 == 0){
                evenSum += i;
            } 
        }return evenSum;
    }
    //Creo un metodo que devuelve la suma de todos los numeros ingresados.
    private static int getSumOfNumbers(ArrayList<Integer> numbers){
        int sum = 0;
        for(Integer i: numbers){
            sum += i;
        } return sum;
    }

    //Creo un metodo que me permite pedir al usuario los numeros por consola.
    private static ArrayList<Integer> getNumbersFromUser(){
        System.out.println("Ingrese numeros de manera repetida. Ingrese -1 para finalizar el programa y obtener los resultados.");
        Scanner sc = new Scanner(System.in);
        //Guardo los numeros en un ArrayList para despues poder operar sobre la misma.
        ArrayList<Integer> numbers = new ArrayList<>();
        int number = sc.nextInt();
        //Mientras que el numero no sea -1, el ciclo while sigue loopeando lo que me deja
        //seguir pidiendo numeros.
        while (number != -1){
            numbers.add(number);
            number = sc.nextInt();
        }
        return numbers;
    }

    //Creo un metodo que genera los diferentes resultados utilizando la clase Collections
    //para el maximo y minimo y el metodo de suma para la suma de todos los nuemros.
    private static void generateResultsFrom(ArrayList<Integer> numbers){
        System.out.println("A.- Mayor numero introducido: " + Collections.max(numbers));
        System.out.println("B.- Menor numero introducido: " + Collections.min(numbers));
        System.out.println("C.- Suma de todos los numeros: " + getSumOfNumbers(numbers));
        System.out.println("D.- Suma de todos los numeros pares " + getSumOfEvenNumbers(numbers));
    }

}

