package challenge.poo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Caso 1: Ingrese una clave para que sea evaluada");
        String passwordToEvaluate = sc.nextLine();
        //Creo un objeto de tipo password y le paso por constructor la contrase;a ingresada por el usuario en consola.
        Password pass1 = new Password(passwordToEvaluate.length(), passwordToEvaluate);

        validatePasswordIsStrong(pass1);

        //Genero una contraseña de forma aleatoria pasando una determinada longitud
        System.out.println("\nCaso 2: Ingrese una longitud para generar una clave aleatoria en base a esta.");
        int length1 = sc.nextInt();
        Password pass2 = new Password(length1);
        System.out.println(pass2.getValue());

        validatePasswordIsStrong(pass2);

        //Genero una contraseña con longitud estandar de 8 y value aleatorio
        System.out.println("\n======Caso 3: Se generará una clave aleatoria con longitud estandar de 8======");
        Password pass3 = new Password();
        System.out.println(pass3.getValue());

        validatePasswordIsStrong(pass3);

    }

    public static final void validatePasswordIsStrong(Password passwordToEvaluate){
        if(passwordToEvaluate.isStrong()){
            System.out.println("\nLa contraseña: "+passwordToEvaluate.getValue()+" es fuerte, tiene mas de 2 mayusculas,mas de 1 minuscula y mas de 3 numeros");
        } else{
            System.out.println("\nLa contraseña: "+passwordToEvaluate.getValue()+" es debil. ");
        }
    }
}