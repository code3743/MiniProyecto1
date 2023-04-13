package utils;

public class Validaciones{
    public static byte validarOpciones(int limiteOpcion, String mensaje){
        byte opt = 0;
        while(true){
        try {
          
          opt = IOConsola.leerByte(mensaje);
          if(opt > 0 && opt <= limiteOpcion){
              return (byte) (opt - 1);
          }else{
            IOConsola.imprimir("La opcion", opt, "No esta en el rango [ 1 -",limiteOpcion,"]");
          }
         }catch(Exception e){
            IOConsola.imprimir("Por favor eliga una opcion valida");
          }
        }
    }

}