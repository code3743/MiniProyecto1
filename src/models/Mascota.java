package models;
import java.util.ArrayList;


public class Mascota {
    protected ArrayList<Vacuna> vacunas;
    protected Paises paisOrige;
    protected double costo;
    protected String nombre;
    protected byte edad;
    
    public Mascota(Paises paisOrige, double costo, String nombre, byte edad) {
        this.paisOrige = paisOrige;
        this.costo = costo;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void aplicarVacuna(Vacuna vacuna){
        this.vacunas.add(vacuna);
    }
    
    public int totalVacunasAplicadas() {
        return this.vacunas.size();
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


    
}
