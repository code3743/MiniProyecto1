package utils;

public class Validaciones{
    public static int validarOpciones(int limiteOpcion, String mensaje){
       int opt = 0;
        while(true){
        try {
          opt = IOConsola.leerEntero(mensaje);
          if(opt > 0 && opt <= limiteOpcion){
              return opt - 1 ;
          }else{
            IOConsola.imprimirError("La opcion "+  opt + " No esta en el rango [ 1 -"+limiteOpcion+" ]");
          }
         }catch(Exception e){
            IOConsola.imprimirError("Por favor eliga una opcion valida");
          }
        }
    }

}