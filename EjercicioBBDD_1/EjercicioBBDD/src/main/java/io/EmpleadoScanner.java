package io;

import models.Empleado;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpleadoScanner {

    private Scanner sc = new Scanner(System.in);

    public ArrayList<Empleado> scan() {
        int control = 1;
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println("-----Si desea ingresar un empleado y sus datos ingrese 1. De lo contrario ingrese 0-----");
        control = sc.nextInt();
        while(control != 0){
         empleados.add(scanEmpleado());
            System.out.println("-----Si desea ingresar un empleado y sus datos ingrese 1. De lo contrario ingrese 0-----");
            control = sc.nextInt();
        }
        return empleados;
    }

    private Empleado scanEmpleado(){
        sc.nextLine();
        System.out.println("Ingrese el nombre de un empleado");
        String nombre = sc.nextLine();


        System.out.println("Ingrese el apellido del empleado");
        String apellido = sc.nextLine();

        System.out.println("Ingrese el telefono del  empleado");
        String telefono = sc.nextLine();

        System.out.println("Ingrese el email del  empleado");
        String email = sc.nextLine();

        System.out.println("Ingrese la municipalidad del  empleado");
        String municipalidad = sc.nextLine();

        System.out.println("Ingrese el puesto del  empleado");
        String puesto = sc.nextLine();

        System.out.println("Ingrese la antiguedad del  empleado");
        int antiguedad = sc.nextInt();

        System.out.println("Ingrese el salario del  empleado");
        Double salario = sc.nextDouble();

        return new Empleado(nombre,apellido, telefono, email, salario, antiguedad, puesto, municipalidad);
    }
}
