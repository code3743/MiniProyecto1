package models;

/**
 * 
 * Clase que representa una vacuna que puede ser aplicada a una mascota.
 * 
 * @author Jota Lopez Ramirez
 * 
 * @author Alejandro Martinez
 * 
 * @author Juan Miguel Posso
 * 
 */
public class Vacuna {
    private String nombre;
    private String descripcion;

    /**
     * 
     * Constructor de la clase Vacuna.
     * 
     * @param nombre      Nombre de la vacuna.
     * @param descripcion Descripcion de la vacuna.
     */
    public Vacuna(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * 
     * Devuelve una cadena que representa la vacuna.
     * 
     * @return Una cadena con el formato "Nombre: %s - Descripcion: %s", donde %s es
     *         el nombre y la descripcion de la vacuna, respectivamente.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s - Descripcion: %s", nombre, descripcion);
    }
}
