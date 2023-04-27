package utils;

import java.util.Scanner;

/**
 * Clase que ofrece métodos para leer y escribir en la consola con colores y
 * formato.
 * 
 * @author Jota Lopez Ramirez
 * 
 * @author Alejandro Martinez
 * 
 * @author Juan Miguel Posso
 */
public class IOConsola {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Método para imprimir en la consola una o varias cadenas de texto.
     * 
     * @param args Varargs de tipo genérico con uno o varios objetos a imprimir.
     * @param <T>  Tipo genérico.
     */
    @SafeVarargs
    public static <T> void imprimir(T... args) {
        if (args == null) {
            System.out.println();
            return;
        }
        for (T arg : args) {
            System.out.print(arg.toString() + " ");
        }
        System.out.println();
    }

    /**
     * Método para imprimir en la consola un array de objetos con la opción de
     * añadir un índice numérico.
     * 
     * @param addIndex Indica si se debe añadir un índice numérico antes de cada
     *                 objeto.
     * @param args     Array de objetos a imprimir.
     * @param <T>      Tipo genérico.
     */
    public static <T> void imprimir(boolean addIndex, T[] args) {
        if (args == null) {
            System.out.println();
            return;
        }
        for (int i = 0; i < args.length; i++) {
            imprimirIndex(addIndex ? ((i + 1) + ". ") : "", args[i].toString());
        }
    }

    /**
     * Método para imprimir en la consola un subconjunto de un array de objetos con
     * la opción de añadir un índice numérico.
     * 
     * @param addIndex Indica si se debe añadir un índice numérico antes de cada
     *                 objeto.
     * @param maxIndex indice maximo del subconjunto a imprimir.
     * @param args     Array de objetos a imprimir.
     * @param <T>      Tipo genérico.
     */
    public static <T> void imprimir(boolean addIndex, int maxIndex, T[] args) {
        if (args == null) {
            System.out.println();
            return;
        }
        if (maxIndex < 0) {
            imprimirError("Error al imprimir");
            return;
        }
        for (int i = 0; i < (maxIndex < args.length ? maxIndex : args.length); i++) {

            imprimirIndex(addIndex ? ((i + 1) + ". ") : "", args[i].toString());
        }
    }

    /**
     * Método privado para imprimir un objeto con un índice numérico.
     * 
     * @param index   indice numerico.
     * @param mensaje Objeto a imprimir.
     */
    private static void imprimirIndex(String index, String mensaje) {
        System.out.println(Colores.AZUL.getColor() + index + Colores.RESET.getColor() + " " + mensaje);
    }

    /**
     * Método para imprimir en la consola un mensaje de error con color rojo.
     * 
     * @param mensaje Mensaje de error.
     */
    public static void imprimirError(String mensaje) {
        System.out.println(Colores.ROJO.getColor() + mensaje + Colores.RESET.getColor());
    }

    /**
     * Método para imprimir en la consola un mensaje de información con color azul.
     * 
     * @param mensaje Mensaje de información.
     */
    public static void imprimirInfo(String mensaje) {
        System.out.println(Colores.AZUL.getColor() + mensaje + Colores.RESET.getColor());
    }

    /**
     * Método para imprimir en la consola un mensaje de problemas con color
     * amarillo.
     * 
     * @param mensaje Mensaje de problema.
     */
    public static void imprimirProblemas(String mensaje) {
        System.out.println(Colores.AMARILLO.getColor() + mensaje + Colores.RESET.getColor());
    }

    /**
     * Método para imprimir en la consola un mensaje de realizado con color verde.
     * 
     * @param mensaje Mensaje de realizado.
     */
    public static void imprimirRealizado(String mensaje) {
        System.out.println(Colores.VERDE.getColor() + mensaje + Colores.RESET.getColor());
    }

    /**
     * 
     * Método para leer un número entero ingresado por el usuario.
     * 
     * @param mensaje el mensaje que se muestra al usuario para solicitar el número
     *                entero.
     * @return el número entero ingresado por el usuario.
     */
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        int entero = sc.nextInt();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return entero;
    }

    /**
     * 
     * Método para leer un número decimal ingresado por el usuario.
     * 
     * @param mensaje el mensaje que se muestra al usuario para solicitar el número
     *                decimal.
     * @return el número decimal ingresado por el usuario.
     */
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        double decimal = sc.nextDouble();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return decimal;
    }

    /**
     * 
     * Método para leer un byte ingresado por el usuario.
     * 
     * @param mensaje el mensaje que se muestra al usuario para solicitar el byte.
     * @return el byte ingresado por el usuario.
     */
    public static byte leerByte(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        byte b = sc.nextByte();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return b;
    }

    /**
     * 
     * Método para leer una cadena ingresada por el usuario.
     * 
     * @param mensaje el mensaje que se muestra al usuario para solicitar la cadena.
     * @return la cadena ingresada por el usuario.
     */
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        String cadena = sc.nextLine();
        System.out.print(Colores.RESET.getColor());
        return cadena;
    }

    /**
     * 
     * Método para borrar la pantalla de la consola.
     */
    public static void borrarPantalla() {
        System.out.print(Colores.RESET.getColor());
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
