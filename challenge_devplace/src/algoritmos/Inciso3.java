package algoritmos;

import java.util.Scanner;

public class Inciso3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int seniority = 0;
        int weeklyHours = 0;
        double wage = 0;
        double salary = 0;
        //Inicializo todas las variables pertinentes y el Scanner para leer por consola.
        System.out.println("Ingrese para el empelado los siguientes datos:\n");
        System.out.println("-Ingrese el name");
        name = sc.nextLine();
        System.out.println("-Ingrese la antiguedad");
        seniority = sc.nextInt();
        System.out.println("-Ingrese las horas trabajadas");
        weeklyHours = sc.nextInt();
        System.out.println("-Ingrese el valor hora");
        wage = sc.nextDouble();

        //Llamo al metodo Calculador de Sueldo pasando por argumento las distintas variables.
        salary = salaryCalculator(wage,weeklyHours,seniority);

        //Imprimo por consola todos los valores.        
        System.out.println("Nombre del empleado: " + name + ", su antiguedad es de: " + seniority + " años, y el total a cobrar es de: " + salary + " pesos.");
    }

    //Creo un metodo para calcular el importe a cobrar que recibe por parametros el valor hora, las horas semanales y la antiguedad.
    private static double salaryCalculator(double wage, int weeklyHours, int seniority) {
        double salary = wage * weeklyHours;
        if (seniority >= 10) {
            //Dependiendo de la seniority(antiguedad), el valor del importe a cobrar
            salary += (seniority * 30);
        }
        return salary;
    }

}




