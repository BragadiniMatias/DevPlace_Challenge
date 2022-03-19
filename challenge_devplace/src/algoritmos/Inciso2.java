package algoritmos;

import java.util.Scanner;

public class Inciso2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Declaro una variable de control "flag"
        boolean success = false;
        // Declaro la cantidad de intentos que voy a tener, un contador.
        int intentos = 3;
        System.out.println("Ingrese una clave cualquiera");
        //Leo por consola la primera Clave ingresada que va a ser con la cual se van a comprar los intentos.
        String password = sc.nextLine();
        
        System.out.println("Repita la clave ingresada - tiene 3 intentos");
        do {
            //Pido repetir por consola la clave.
            String password_2 = sc.nextLine();
            //Si la contraseña ingresada coincide con la contraseña declarada en el comienzo, entro al if.
            if (password.equals(password_2)) {
                System.out.println("Felicitaciones, recordas tu clave");
                //La variable de control se vuelve true.
                success = true;
                //Le quito los intentos, para que el while no siga loopeando.
                intentos = 0;
            } else {
                //Entra al else cuando no coinciden las contraseñas
                intentos--;
                //Informo que es incorrecto y la cantidad de intentos que tiene.
                System.out.println("Incorrecto - tiene " + intentos + " intentos");
            }
        } while (intentos > 0); //Verifico si quedan intentos..
        if (!success) //Verifico la variable de control y si los intentos son 0, imprime el siguiente mensaje.
            System.out.println("\n----Tiene que ejercitar mas la memoria----");
    }
}