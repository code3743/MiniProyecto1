package models;
import java.util.ArrayList;


public class Mascota {
    private ArrayList<Vacuna> vacunas;
    private Paises paisOrige;
    private double costo;
    private String nombre;
    private byte edad;
    
    public Mascota(Paises paisOrige, double costo, String nombre, byte edad) {
        this.paisOrige = paisOrige;
        this.costo = costo;
        this.nombre = nombre;
        this.edad = edad;
        vacunas = new ArrayList<Vacuna>();
    }
    
    public void aplicarVacuna(Vacuna vacuna){
        this.vacunas.add(vacuna);
    }
    
    public int totalVacunasAplicadas() {
        return this.vacunas.size();
    }
    
    public boolean elminarVacuna(Vacuna name){
        return this.vacunas.remove(name);
    }

    public Vacuna buscarVacuna(String nombre){
        for(Vacuna vacuna :this.vacunas){
            if(vacuna.getNombre().equals(nombre)){
                return vacuna;
            }
        }
        return null;
    }
    public boolean existeVacuna(String nombreVacuna){
        for (Vacuna vacuna : this.vacunas) {
            if(vacuna.getNombre().equals(nombreVacuna)){
                return true;
            } 
        }
        return false;
    }

    public ArrayList<Vacuna> getVacunas() {
        return this.vacunas;
    }

    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public Paises getPaisOrige() {
        return paisOrige;
    }

    public void setPaisOrige(Paises paisOrige) {
        this.paisOrige = paisOrige;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s - Edad: %d - Numero Vacunas: %d - Pais origen: %s", nombre, edad, vacunas.size(), paisOrige.getNombrePais());
    }
    
}
