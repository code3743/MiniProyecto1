package models;
import java.util.ArrayList;
import java.util.Collections;

public class Veterinaria {
    
  private ArrayList<Mascota> mascotas;

  public Veterinaria() {
    this.mascotas = new ArrayList<Mascota>();
  }

  public  ArrayList<Mascota> buscarVacunaEnMascotas(String nombreVacuna){
    ArrayList<Mascota> mascotasConVacuna = new ArrayList<Mascota>();
    for (Mascota mascota : this.mascotas) {
      if(mascota.existeVacuna(nombreVacuna)){
        mascotasConVacuna.add(mascota);
      }
    }
    if(mascotasConVacuna.isEmpty()){
      return null;
    }
    return mascotasConVacuna;
  }
 
  public void actulizarMascota(int index, Mascota mascota){
      mascotas.set(index, mascota);
  }

  public Mascota elegirMascota(int index ){
    if(index >= 0 && index < mascotas.size()){
      return mascotas.get(index);
    }
    return null;
  }

  public ArrayList<Mascota> listaMascotasCostosas(){
    ArrayList<Mascota> mascotasCostosas = this.mascotas;
    Mascota auxiliar;
    int minimo;
    for(int i=0;i<mascotasCostosas.size();i++){
        minimo = i;
        for(int j=i+1;j<mascotasCostosas.size();j++){
            if(mascotasCostosas.get(j).getCosto() < mascotasCostosas.get(minimo).getCosto()){
                minimo = j;
            }
        }
        auxiliar = mascotasCostosas.get(i);
        mascotasCostosas.set(i,mascotasCostosas.get(minimo));
        mascotasCostosas.set(minimo, auxiliar);
    }
    
    Collections.reverse(mascotasCostosas);
    return mascotasCostosas;
  }  

  public boolean agregarMascota(Mascota mascota){
    return this.mascotas.add(mascota);
  }
  
  public boolean eliminarMascota(Mascota mascota) {
    return this.mascotas.remove(mascota);
  }
  
  public Mascota buscarMascotaPorNombre(String nombre) {
    for (Mascota mascota :  this.mascotas) {
      if (mascota.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
        return mascota;
      }
    }
  return null;
  }

  public ArrayList<Mascota> listarMascotas(){
    return mascotas;
  }

}
