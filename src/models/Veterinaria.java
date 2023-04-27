package models;

import java.util.ArrayList;
import java.util.Collections;

/**
 * La clase Veterinaria representa una veterinaria que puede realizar diversas
 * operaciones con mascotas.
 * 
 * @author Jota Lopez Ramirez
 * 
 * @author Alejandro Martinez
 * 
 * @author Juan Miguel Posso
 * 
 */
public class Veterinaria {

  private ArrayList<Mascota> mascotas;

  public Veterinaria() {
    this.mascotas = new ArrayList<Mascota>();
  }
 /**
   * Busca las mascotas que tienen una vacuna específica.
   * @param nombreVacuna Nombre de la vacuna a buscar en las mascotas.
   * @return Una lista de mascotas que tienen la vacuna especificada, o null si no se encontraron mascotas.
   */
  public ArrayList<Mascota> buscarVacunaEnMascotas(String nombreVacuna) {
    ArrayList<Mascota> mascotasConVacuna = new ArrayList<Mascota>();
    for (Mascota mascota : this.mascotas) {
      if (mascota.existeVacuna(nombreVacuna)) {
        mascotasConVacuna.add(mascota);
      }
    }
    if (mascotasConVacuna.isEmpty()) {
      return null;
    }
    return mascotasConVacuna;
  }
/**
   * Actualiza una mascota en la lista de mascotas.
   * @param index indice de la mascota a actualizar en la lista de mascotas.
   * @param mascota La nueva instancia de la mascota que reemplazará a la antigua.
   */
  public void actulizarMascota(int index, Mascota mascota) {
    mascotas.set(index, mascota);
  }
 /**
   * Retorna una mascota específica de la lista de mascotas.
   * @param index indice de la mascota que se quiere obtener en la lista de mascotas.
   * @return La mascota en el índice especificado, o null si el índice es inválido.
   */
  public Mascota elegirMascota(int index) {
    if (index >= 0 && index < mascotas.size()) {
      return mascotas.get(index);
    }
    return null;
  }
 /**
   * Retorna una lista de mascotas ordenadas por costo, en orden descendente.
   * @return Una lista de mascotas ordenadas por costo, en orden descendente.
   */
  public ArrayList<Mascota> listaMascotasCostosas() {
    ArrayList<Mascota> mascotasCostosas = this.mascotas;
    Mascota auxiliar;
    int minimo;
    for (int i = 0; i < mascotasCostosas.size(); i++) {
      minimo = i;
      for (int j = i + 1; j < mascotasCostosas.size(); j++) {
        if (mascotasCostosas.get(j).getCosto() < mascotasCostosas.get(minimo).getCosto()) {
          minimo = j;
        }
      }
      auxiliar = mascotasCostosas.get(i);
      mascotasCostosas.set(i, mascotasCostosas.get(minimo));
      mascotasCostosas.set(minimo, auxiliar);
    }
    Collections.reverse(mascotasCostosas);
    return mascotasCostosas;
  }
/**
   * Agrega una nueva mascota a la lista de mascotas.
   * @param mascota La mascota a agregar a la lista.
   * @return true si la mascota fue agregada correctamente, o false si no se agregó
   */
  public boolean agregarMascota(Mascota mascota) {
    return this.mascotas.add(mascota);
  }
 /**
   * Elimina una mascota de la lista de mascotas.
   *
   * @param mascota la mascota a eliminar
   * @return true si la mascota se eliminó correctamente, false si no pudo
   * 
   */

  public boolean eliminarMascota(Mascota mascota) {
    return this.mascotas.remove(mascota);
  }
 /**
     * Busca una mascota por su nombre en la lista de mascotas de la veterinaria.
     * 
     * @param nombre el nombre de la mascota a buscar
     * @return la mascota con el nombre dado si se encuentra en la lista de mascotas, 
     *         o null si no se encuentra ninguna mascota con ese nombre
     */
  public Mascota buscarMascotaPorNombre(String nombre) {
    for (Mascota mascota : this.mascotas) {
      if (mascota.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
        return mascota;
      }
    }
    return null;
  }
/**
     * Retorna la lista de todas las mascotas en la lista de mascotas de la veterinaria.
     * 
     * @return una lista de todas las mascotas en la lista de mascotas de la veterinaria
     */
  public ArrayList<Mascota> listarMascotas() {
    return mascotas;
  }

}
