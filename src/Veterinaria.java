import java.util.ArrayList;

import utils.IOConsola;

public class Veterinaria {
    
  private ArrayList<Mascota> mascotas;

  public Veterinaria() {
    this.mascotas = new ArrayList<Mascota>();
  }

  public void buscarVacunaEnMascotas(String nombreVacuna){
    ArrayList<Mascota> mascotasConVacuna = new ArrayList<Mascota>();
    for (Mascota mascota : this.mascotas) {
      if(mascota.existeVacuna(nombreVacuna)){
        mascotasConVacuna.add(mascota);
      }
    }
    if(mascotasConVacuna.isEmpty()){
      IOConsola.imprimir("No se encotraron mascotas con la vacuna:",nombreVacuna);
      return;
    }
    IOConsola.imprimir(mascotasConVacuna);
  }
 
  public void actulizarMascota(Mascota mascota){
    byte opt = 0;
    String[] opciones = {"Nombre", "Edad", "Paise de orgien", "Costo", "Vacunas" };
    IOConsola.imprimir(opciones);
    opt = validarOpciones(opciones.length, "Eliga una opcion: ");
    //TODO: Realizar funcionalidad para cada opcion
  }

  public void actulizarVacunas(ArrayList<Vacuna> vacunas){
    byte opt = 0;
    String[] opciones = {"Lista", "Editar", "Eliminar" };
    IOConsola.imprimir(opciones);
    opt = validarOpciones(opciones.length, "Eliga una opcion: ");
    //TODO: Realizar funcionalidad para cada opcion
  }

  private byte validarOpciones(int limiteOpcion, String mensaje){
    byte opt = 0;
    while(true){
    try {
      opt = IOConsola.leerByte(mensaje);
      if(opt > 0 && opt <= limiteOpcion){
          return (byte) (opt - 1);
      }else throw new Exception("No esta en el rango");
      
     }catch(Exception e){
        IOConsola.imprimir("Por favor eliga una opcion valida");
      }
    }
  }

  public Mascota elegitMascota(){
    byte opt = 0;
    
    for(int i =0 ; i< mascotas.size(); i++){
        System.out.println(String.format("%d . $s - %d ",(i +1), mascotas.get(i).getNombre(),mascotas.get(i).getEdad()));
    }
    opt = validarOpciones(mascotas.size(), "Eliga una mascota");
    return mascotas.get(opt);
  }

  public void listaMascotasCostosas(){
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
  IOConsola.imprimirIndex(mascotasCostosas.toArray(), 5);
  }

  public boolean agregarMascota(Mascota mascota){
   return this.mascotas.add(mascota);
  }
  
  public boolean eliminarMascota(Mascota mascota) {
   return this.mascotas.remove(mascota);
  }
    
  public Mascota buscarMascotaPorNombre(String nombre) {
    for (Mascota mascota :  this.mascotas) {
      if (mascota.getNombre().equals(nombre)) {
        return mascota;
      }
    }
  return null;
  }

  public void listarMascotas(){
   IOConsola.imprimirIndex(mascotas.toArray());
  }

}
