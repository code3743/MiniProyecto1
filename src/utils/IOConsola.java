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
        imprimirIndex(addIndex ?((i+1)+". "): "", args[i].toString());
       }
    }
    
    public static <T> void imprimir(boolean addIndex, int maxIndex, T[] args) {
        if(args == null){
            System.out.println();
            return;
        }
        if(maxIndex < 0){
            imprimirError("Error al imprimir");
            return;
        }
       for (int i = 0; i < (maxIndex <args.length?maxIndex:args.length); i++) {
        
            imprimirIndex(addIndex ?((i+1)+". "): "", args[i].toString());
       }
    }

    private static void imprimirIndex(String index, String mensaje){
        System.out.println(Colores.AZUL.getColor()+ index + Colores.RESET.getColor() + " " + mensaje);
    }
    public static void imprimirError(String mensaje){
        System.out.println(Colores.ROJO.getColor() + mensaje + Colores.RESET.getColor());
    }

    public static void imprimirInfo(String mensaje){
        System.out.println(Colores.AZUL.getColor() + mensaje + Colores.RESET.getColor());
    }

    public static void imprimirProblemas(String mensaje){
        System.out.println(Colores.AMARILLO.getColor() + mensaje + Colores.RESET.getColor());
    }
    public static void imprimirRealizado(String mensaje){
        System.out.println(Colores.VERDE.getColor() + mensaje + Colores.RESET.getColor());
    }
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        int entero = sc.nextInt();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return entero;
    }
    
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        double decimal = sc.nextDouble();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return decimal;
    }
    
    public static byte leerByte(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        byte b = sc.nextByte();
        sc.nextLine(); // consume el salto de línea que queda en el buffer
        System.out.print(Colores.RESET.getColor());
        return b;
    }
    
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        System.out.print(Colores.VERDE.getColor());
        String cadena = sc.nextLine();
        System.out.print(Colores.RESET.getColor());
        return cadena;
    }
    
    public static void borrarPantalla() {
        System.out.print(Colores.RESET.getColor());
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
