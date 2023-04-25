package models;
public class Vacuna {
    private String nombre;
    private String descripcion;

    public Vacuna(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Vacuna(){}
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

    @Override
    public String toString() {
        return String.format("Nombre: %s - Descripcion: %s", nombre,descripcion);
    }
}
