package challenge.poo;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Pattern;

/*
Otra manera de implementar lo solicitado sería creando una clase passwordValidator que se encargue de la validación de la contraseña, y
una clase passwordGenerator que se encargue de la generación de la contraseña dados ciertos requisitos, permitiendo así quitarle responsabilidades
a la clase Password y respetando el principio de responsabilidad única de SOLID.
 */
public class Password {

    private int length;
    private String value;

    public Password() {
        this.length = 8;
        generatePassword();
    }

    public Password(int length) {
        this.length = length;
        generatePassword();
    }

    public Password(int length, String value) {
        this.length = length;
        this.value = value;
    }

    /*
    Se crea una constante con los posibles valores que puede tomar la contraseña.
    Genera de manera aleatoria la contraseña utilizando los valores de la constante y con la longitud especifica.
     */
    public void generatePassword() {
        final String possibleValuesForPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int randomIndex = 0;
        SecureRandom random = new SecureRandom();
        StringBuilder valueGenerated = new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomIndex = random.nextInt(possibleValuesForPassword.length());
            valueGenerated.append(possibleValuesForPassword.charAt(randomIndex));
        }
        value = valueGenerated.toString();
    }

    /*
    Se valida si una contraseña es o no fuerte. Para que sea fuerte debe contener:
    -más de 2 mayúsculas
    -más de 1 minúscula
    -más de 3 números

    Se declaran e incializan las variables a utilizar:
    ->caps: acumula la cantidad de mayusculas
    ->numbers: acumula la cantidad de numeros
    ->lowerCase: acumula la cantidad de minusculas

    Se itera sobre el valor de la contraseña hasta encontrar al menos 4 numeros, 3 mayusculas y 2 minusculas.
    Se utiliza como variable de control i<lenght para corroborar la longitud de la cadena.
    En caso de recorrer por completo el valor de la contraseña y que no se cumpla la condicion, el método devuelve false.
    En caso de que se cumpla la condicion, el metodo devuelve true.
     */
    public boolean isStrong() {
        int caps = 0;
        int numbers = 0;
        int lowerCase = 0;
        char character;
        int i = 0;
        while ((numbers < 4 || caps < 3 || lowerCase < 2) && i < length) {
            character = value.charAt(i);
            if (Character.isUpperCase(character))
                caps++;
            else if (Character.isDigit(character))
                numbers++;
            else if (Character.isLowerCase(character))
                lowerCase++;
            i++;
        }
        return  numbers >= 3 && caps >= 2 && lowerCase >= 1;
    }

    /*
    Otra forma de realizar la validación para saber si la contraseña es fuerte o no es utilizando expresiones regulares.
    De esta manera se declaran 3 patrones para cada validación y se evalua si esta cumple con las condiciones.

    Preferí utilizar la implementación de isStrong() en vez de esta ya que la considero mas performante y legible. Sin embargo,
    no queria dejar de aclarar que conozco otra alternativa.
     */
    public boolean isStrongWithPattern() {
        ArrayList<Pattern> patterns = new ArrayList<>();
        final String UPPERCASE_PATTERN = ".([A-Z]).([A-Z]).([A-Z]).";
        final String LOWERCASE_PATTERN = ".([a-z]).([a-z]).*";
        final String DIGIT_PATTERN = ".([0-9]).([0-9]).([0-9]).([0-9]).*";
        patterns.add(Pattern.compile(UPPERCASE_PATTERN));
        patterns.add(Pattern.compile(LOWERCASE_PATTERN));
        patterns.add(Pattern.compile(DIGIT_PATTERN));
        return patterns.stream().allMatch(pattern -> pattern.matcher(value).matches());
    }

    public int getLenght() {
        return length;
    }

    public String getValue() {
        return value;
    }

    public void setLenght(int lenght) {
        this.length = lenght;
    }

}
