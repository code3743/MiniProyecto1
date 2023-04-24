package models;
import java.util.ArrayList;

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
    for (int i = 0; i < mascotasCostosas.size(); i++) {
      for(int j = 0; j < mascotasCostosas.size(); j++){
        if( mascotasCostosas.get(i).getCosto() > mascotasCostosas.get(i).getCosto()){
          Mascota temp = mascotasCostosas.get(i);
          mascotasCostosas.set(i,mascotasCostosas.get(j));
          mascotasCostosas.set(j, temp);
      }
    }  
  }
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
