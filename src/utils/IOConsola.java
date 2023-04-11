package utils;
import java.util.Scanner;

public class IOConsola {
    private static Scanner sc = new Scanner(System.in);
    private IOConsola(){}

    @SafeVarargs 
    public static <T> void imprimir(T ... args) {
        if(args == null){
            System.out.println();
            return;
        }
        for (T arg : args) {
            System.out.print(arg.toString() + " ");
        }
        System.out.println();
    }

    public static void imprimir(String[] opciones) {
        if(opciones == null){
            System.out.println();
            return;
        }
        for (int i=0; i< opciones.length; i++) {
            System.out.println(String.format("%d . %s",(i +1), opciones[i]));
        }
    }
 
    public static <T> void imprimirIndex(T[] args) {
        if(args == null ){
            System.out.println();
            return;
        }

       for (int i = 0; i < args.length; i++) {
             System.out.println((i +1) +". " + args[i].toString());
        }
    }

    public static <T> void imprimirIndex(T[] args, int maxIndex) {
        if(args == null ){
            System.out.println();
            return;
        }
        if(maxIndex > args.length){
            System.out.println("Error: El numero no debe ser mayor al permitido");
            return;
        }
       for (int i = 0; i < maxIndex; i++) {
        System.out.println((i +1) +". " + args[i].toString());
     }
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int entero = sc.nextInt();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        return entero;
    }
    
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        double decimal = sc.nextDouble();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        return decimal;
    }
    
    public static byte leerByte(String mensaje) {
        System.out.print(mensaje);
        byte b = sc.nextByte();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        return b;
    }
    
    public static boolean leerBoolean(String mensaje) {
        System.out.print(mensaje);
        boolean bool = sc.nextBoolean();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        return bool;
    }
    
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        String cadena = sc.nextLine();
        return cadena;
    }
}
