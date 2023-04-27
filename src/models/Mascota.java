package models;

import java.util.ArrayList;

/**
 * La clase Mascota representa una mascota que puede recibir vacunas y tiene
 * información como su país de origen, costo y edad.
 * 
 * @author Jota Lopez
 * 
 */

public class Mascota {
    private ArrayList<Vacuna> vacunas;
    private Paises paisOrige;
    private float costo;
    private String nombre;
    private byte edad;

    /**
     * Crea una nueva mascota con los datos especificados.
     * 
     * @param paisOrige El país de origen de la mascota.
     * @param costo     El costo de la mascota en la moneda local.
     * @param nombre    El nombre de la mascota.
     * @param edad      La edad de la mascota en años.
     */
    public Mascota(Paises paisOrige, float costo, String nombre, byte edad) {
        this.paisOrige = paisOrige;
        this.costo = costo;
        this.nombre = nombre;
        this.edad = edad;
        vacunas = new ArrayList<Vacuna>();
    }

    /**
     * Agrega una vacuna a la lista de vacunas aplicadas a la mascota.
     * 
     * @param vacuna La vacuna a agregar.
     */
    public void aplicarVacuna(Vacuna vacuna) {
        this.vacunas.add(vacuna);
    }

    /**
     * Retorna el número de vacunas aplicadas a la mascota.
     * 
     * @return El número de vacunas aplicadas.
     */
    public int totalVacunasAplicadas() {
        return this.vacunas.size();
    }

    /**
     * Elimina una vacuna de la lista de vacunas aplicadas a la mascota.
     * 
     * @param vacuna La vacuna a eliminar.
     * @return true si la vacuna fue eliminada, false si no se encontró en la lista.
     */
    public boolean eliminarVacuna(Vacuna vacuna) {
        if (vacuna == null) {
            return false;
        }
        return this.vacunas.remove(vacuna);
    }

    /**
     * Busca una vacuna por su nombre en la lista de vacunas aplicadas a la mascota.
     * 
     * @param nombre El nombre de la vacuna a buscar.
     * @return La vacuna encontrada, o null si no se encontró.
     */
    public Vacuna buscarVacuna(String nombre) {
        for (Vacuna vacuna : this.vacunas) {
            if (vacuna.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                return vacuna;
            }
        }
        return null;
    }

    /**
     * Verifica si una vacuna con el nombre especificado fue aplicada a la mascota.
     * 
     * @param nombreVacuna El nombre de la vacuna a buscar.
     * @return true si la vacuna fue aplicada, false si no fue aplicada.
     * 
     */
    public boolean existeVacuna(String nombreVacuna) {
        for (Vacuna vacuna : this.vacunas) {
            if (vacuna.getNombre().toLowerCase().equals(nombreVacuna.toLowerCase())) {
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
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

    /**
     * Retorna una cadena de texto que representa la mascota.
     * 
     * @return La cadena de texto que representa la mascota.
     */
    @Override
    public String toString() {
        return String.format("Nombre: %s - Edad: %d - Numero Vacunas: %d - Pais origen: %s - Precio: %d ", nombre, edad,
                vacunas.size(), paisOrige.getNombrePais(), Math.round(costo));
    }

}
