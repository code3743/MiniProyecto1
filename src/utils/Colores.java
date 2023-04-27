package utils;

/**
 * 
 * Esta clase enum define los diferentes colores que se pueden utilizar para la
 * salida de texto en la consola.
 * 
 * Cada color está definido como una cadena de caracteres ANSI que se utiliza
 * para establecer el color
 * 
 * de la salida de texto en la consola. Estos caracteres son reconocidos por la
 * mayoría de las terminales modernas.
 * 
 * @author Jota Lopez Ramirez
 * 
 * @author Alejandro Martinez
 * 
 * @author Juan Miguel Posso
 */
public enum Colores {
    RESET("\033[0m"),
    NEGRO("\033[0;30m"),
    ROJO("\033[0;31m"),
    VERDE("\033[0;32m"),
    AMARILLO("\033[0;33m"),
    AZUL("\033[0;34m"),
    MAGENTA("\033[0;35m"),
    CYAN("\033[0;36m"),
    BLANCO("\033[0;37m");

    private final String codigo;

    /**
     * 
     * Constructor para la clase Colores.
     * 
     * @param codigo la cadena de caracteres ANSI que representa el color.
     */
    Colores(String codigo) {
        this.codigo = codigo;
    }

    /**
     * 
     * Devuelve la cadena de caracteres ANSI que representa el color.
     * 
     * @return la cadena de caracteres ANSI que representa el color.
     */
    public String getColor() {
        return codigo;
    }
}
