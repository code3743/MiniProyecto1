package utils;

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


    Colores(String codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return codigo;
    }
}
