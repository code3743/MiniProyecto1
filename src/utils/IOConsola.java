package utils;
import java.util.Scanner;

public class IOConsola {
    private static Scanner sc = new Scanner(System.in);


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

    public static <T> void imprimir(boolean addIndex,T[] args) {
        if(args == null){
            System.out.println();
            return;
        }
       for (int i = 0; i < args.length; i++) {
            System.out.println(addIndex ?((i+1)+". "): "" + args[i].toString());
       }
    }
    
    public static <T> void imprimir(boolean addIndex, int maxIndex, T[] args) {
        if(args == null){
            System.out.println();
            return;
        }
        if(maxIndex > args.length || maxIndex < 0){
            System.out.println("Error al imprimir");
            return;
        }
       for (int i = 0; i < maxIndex; i++) {
            System.out.println(addIndex ?((i+1)+". "): "" + args[i].toString());
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
    
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        String cadena = sc.nextLine();
        return cadena;
    }
    
    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
