package utils;

/**
 * 
 * Esta clase define un método para validar opciones ingresadas por el usuario
 * 
 * que deben estar dentro de un rango predefinido de opciones.
 * 
 * @author Jota Lopez Ramirez
 * 
 * @author Alejandro Martinez
 * 
 * @author Juan Miguel Posso
 */

public class Validaciones {
  /**
   * 
   * Método que valida las opciones ingresadas por el usuario.
   * 
   * @param limiteOpcion el límite superior de las opciones permitidas.
   * 
   * @param mensaje      el mensaje que se muestra al usuario para solicitar la
   *                     opción.
   * 
   * @return la opción ingresada por el usuario, con un índice ajustado a partir
   *         de 0.
   */
  public static int validarOpciones(int limiteOpcion, String mensaje) {
    int opt = 0;
    while (true) {
      try {
        opt = IOConsola.leerEntero(mensaje);
        if (opt > 0 && opt <= limiteOpcion) {
          return opt - 1;
        } else {
          IOConsola.imprimirError("La opcion " + opt + " No esta en el rango [ 1 -" + limiteOpcion + " ]");
        }
      } catch (Exception e) {
        IOConsola.imprimirError("Por favor eliga una opcion valida");
      }
    }
  }

}