package controllers;

import java.util.ArrayList;
import models.Gato;
import models.Mascota;
import models.Paises;
import models.Perro;
import models.RazaGato;
import models.RazaPerro;
import models.Vacuna;
import models.Veterinaria;
import utils.IOConsola;
import utils.Validaciones;

public class VeterinariaController {
     private Veterinaria veterinaria;
    

    public VeterinariaController(){
        veterinaria = new Veterinaria();
    }

    public void init(){
        insertarMascota();
        actualizarMascota();
        moduloVacunacion();
    }
        
    public void listarMascotas(){
        IOConsola.borrarPantalla();
        ArrayList<Mascota> mascotas =  veterinaria.listarMascotas();
        if(mascotas.isEmpty()){
            IOConsola.imprimirError("No hay mascotas agregadas");
            return;
        }
        IOConsola.imprimirInfo("# Nombre - Edad - N° Vacunas - Pais origen - Raza");
        IOConsola.imprimir(true, mascotas.toArray());
        
        int decision = IOConsola.leerEntero("\n¿Deseas volver a la ventana anterior?  1.Si -- 2.No: ");
        if(decision == 1){
            
        }else{
            return;
        }
    }


    public void buscarMascotaPorNombre(){
        String name = IOConsola.leerString("Digite el nombre de la mascota a buscar: ");
        Mascota mascota = veterinaria.buscarMascotaPorNombre(name);
        if(mascota != null){
            IOConsola.imprimir(mascota);
        }else {
            IOConsola.imprimirError("No se encontre una mascota con el nombre: "+name);
        }
    }

    public void insertarMascota(){
        IOConsola.borrarPantalla();
        String opciones[] = {"Gato","Perro", "Atras"};
        while (true){
            IOConsola.imprimir(true, opciones);
            IOConsola.imprimirInfo("Modulo Agregar mascota");
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            Mascota mascotaTemp = null;
            switch(opt){
                case 0:
                mascotaTemp = agregaGato();
                break;
                case 1:
                mascotaTemp = agregaPerro();
                break;
                case 2:
                    return;
            }
            IOConsola.borrarPantalla();
            if(veterinaria.agregarMascota(mascotaTemp)){
               
                IOConsola.imprimirRealizado("Se guardo la mascota");
            }else{
                IOConsola.imprimirError("No se pudo guardar");
            }
        }
       
    }
    private Perro agregaPerro(){
        while(true){
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Agrege los datos del Perro");
            String nombre = IOConsola.leerString("Ingrese el nombre: ");
            byte edad = IOConsola.leerByte("Ingrese la edad: ");
            double precio = IOConsola.leerDouble("Precio de la mascota: ");
            Paises paisOrige = elegirPaisesOrigen();
            RazaPerro raza = elegirRazaPerro();
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Desea guardar el perro con los siguientes datos: ");
            IOConsola.imprimirInfo("Nombre - Edad - Precio - Raza - Pais origen");
            IOConsola.imprimir(nombre+"   "+ edad+"    "+precio+"   "+raza.getNombreRaza()+"   "+paisOrige);
            if(IOConsola.leerEntero("1. Si - 2. No: ") == 1){
                  return new Perro(raza, paisOrige, precio, nombre, edad);
            }
        }
    }

    private Gato agregaGato(){
        while(true){
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Agrege los datos del Gato");
            String nombre = IOConsola.leerString("Ingrese el nombre: ");
            byte edad = IOConsola.leerByte("Ingrese la edad: ");
            double precio = IOConsola.leerDouble("Precio de la mascota: ");
            Paises paisOrige = elegirPaisesOrigen();
            RazaGato raza = elegirRazaGato();
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Desea guardar el gato con los siguientes datos: ");
            IOConsola.imprimirInfo("Nombre - Edad - Precio - Raza - Pais origen");
            IOConsola.imprimir(nombre+"   "+ edad+"    "+precio+"   "+raza.getNombreRaza()+"   "+paisOrige);
            if(IOConsola.leerEntero("1. Si - 2. No: ") == 1){
                  return new Gato( paisOrige, precio, nombre, edad, raza);
            }
        }
    }

    private Paises elegirPaisesOrigen(){
        String opciones[] = {"Buscar","Mostrar lista"};
        while (true){
            IOConsola.imprimirInfo("Elija el pais de origen");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch(opt){
                case 0:
                String nombrePais = IOConsola.leerString("Ingrese el nombre del pais: ");
                    for (Paises pais : Paises.values()) {
                      if(pais.getNombrePais().toLowerCase().equals(nombrePais.toLowerCase()) ){
                        IOConsola.imprimirRealizado("Pais encontrado y asignado");
                        return pais;
                      }
                    }
                    IOConsola.imprimirError("No se encontro el pais: "+nombrePais);
                    break;
                case 1:
                    IOConsola.imprimir(true, Paises.values());
                    int indexPais =  Validaciones.validarOpciones(Paises.values().length, "Elija un pais: ");
                    return Paises.values()[indexPais];
            }
        }
    }

    private RazaPerro elegirRazaPerro(){
        String opciones[] = {"Buscar","Mostrar lista"};
        while (true){
            IOConsola.imprimirInfo("Elija la raza");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch(opt){
                case 0:
                    String nombreRaza = IOConsola.leerString("Ingrese la raza: ");

                        for (RazaPerro raza : RazaPerro.values()) {
                            if(raza.getNombreRaza().toLowerCase().equals(nombreRaza.toLowerCase())){ 
                                IOConsola.imprimirRealizado("Raza encontrada y asignada"); 
                                return raza;
                            }
                          }
                    IOConsola.imprimirError("No se encontro la raza: "+nombreRaza);
                    break;
                case 1:
                    IOConsola.imprimir(true, RazaPerro.values());
                    int indexRaza =  Validaciones.validarOpciones(RazaPerro.values().length, "Elija una raza: ");
                    return RazaPerro.values()[indexRaza];
            }
        }
    }

    private RazaGato elegirRazaGato(){
        String opciones[] = {"Buscar","Mostrar lista"};
        while (true){
            IOConsola.imprimirInfo("Elija la raza");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch(opt){
                case 0:
                    String nombreRaza = IOConsola.leerString("Ingrese la raza: ").toLowerCase();

                        for (RazaGato raza : RazaGato.values()) {
                            if(raza.getNombreRaza().toLowerCase().equals(nombreRaza.toLowerCase())){
                                IOConsola.imprimirRealizado("Raza encontrada y asignada");
                                return raza;
                            }
                          }
                
                    IOConsola.imprimirError("No se encontro la raza: "+nombreRaza);
                    break;
                case 1:
                    IOConsola.imprimir(true, RazaGato.values());
                    int indexRaza =  Validaciones.validarOpciones(RazaGato.values().length, "Elija una raza: ");
                    return RazaGato.values()[indexRaza];
            }
        }
    }

    
    public void moduloVacunacion(){
        IOConsola.borrarPantalla();
        String opciones[] = {"Buscar mascotas con vacuna.","Listado de vacunas", "Atras."};
        while(true){
            IOConsola.imprimirInfo("Modulo de vacunacion");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
            switch(opt){
                case 0:
                mascotasConVacuna();
                    break;
                case 1:
                    break;
                case 2:
                    return;
            }
        }
    }

    private void mascotasConVacuna(){
        IOConsola.borrarPantalla();
        String nombreVacuna = IOConsola.leerString("Nombre de la vacuna: ");
        ArrayList<Mascota> mascotas = veterinaria.buscarVacunaEnMascotas(nombreVacuna);
        if(mascotas == null || mascotas.isEmpty()){
            IOConsola.imprimirError("No se encontraron mascotas con la vacuna: "+nombreVacuna);
            return;
        }
        IOConsola.imprimirInfo("#  Nombre  -  Edad");
        IOConsola.imprimir(true, mascotas.toArray());   
        
    }
    
    public void eliminarMascota(){
        IOConsola.borrarPantalla();
        String opciones[] = {"Buscar por nombre.","Listar mascotas.", "Atras."};
        while(true){
            IOConsola.imprimirInfo("¿Como desea eliminar su mascota?.");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
            if(!veterinaria.listarMascotas().isEmpty()){
                switch(opt){
                    case 0:
                        String nombreMascota = IOConsola.leerString("Ingrese el nombre: ");
                        if(veterinaria.eliminarMascota(veterinaria.buscarMascotaPorNombre(nombreMascota))){
                            IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                        }else{
                            IOConsola.imprimirError("No se encontro la mascota: "+ nombreMascota);
                        }break;
                    case 1:
                        IOConsola.imprimirInfo("Nombres");
                        for(int i=0 ; i< veterinaria.listarMascotas().size(); i++){ 
                            IOConsola.imprimir(i+1+".",veterinaria.listarMascotas().get(i).getNombre());};
                        int indexMascota= Validaciones.validarOpciones( veterinaria.listaMascotasCostosas().size(),"Ingrese el numero de opcion: ");
                        if(veterinaria.eliminarMascota(veterinaria.elegirMascota(indexMascota))){
                            IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                        }else{
                            IOConsola.imprimirError("No se pudo eliminar la mascota");
                        };break;
                    case 2:
                        return;
                    }    
                }else{
                    IOConsola.imprimirProblemas("No hay mascotas agregadas a la lista aun.");
            } 
        }
    }
    public void actualizarMascota(){
        IOConsola.borrarPantalla();
        IOConsola.imprimirInfo("Actualizacion  de las mascotas");
        String opciones2[] = {"Ver lista de mascotas", "Atras"};
        IOConsola.imprimir(true, opciones2);
        byte opt = (byte) Validaciones.validarOpciones(opciones2.length, "Elija la opcion: ");
        if(!(veterinaria.listarMascotas().isEmpty())){
            switch(opt){
                case 0:
                    IOConsola.imprimirInfo("Nombres");
                    for(int i=0 ; i< veterinaria.listarMascotas().size(); i++){ 
                    IOConsola.imprimir(i+1+".",veterinaria.listarMascotas().get(i).getNombre());};
                    int i=0;
                    String nombreMascota = IOConsola.leerString("Ingrese el nombre de la mascota a actualizar: ").toLowerCase();
                    for( i=0 ; i< veterinaria.listarMascotas().size(); i++){
                        if (veterinaria.listarMascotas().get(i).getNombre().toLowerCase().equals(nombreMascota)){
                            break;   
                        }
                    }
                    if(veterinaria.buscarMascotaPorNombre(nombreMascota) != null){
                        IOConsola.imprimirInfo("¿Que quieres modificar de esta mascota?");
                        String opciones1[] = {"Nombre","Edad", "Costo","Pais de origen","Vacunas","Atras"};
                        IOConsola.imprimir(true, opciones1);
                        byte decision = (byte) Validaciones.validarOpciones(opciones1.length, "Elija la opcion: ");
                        switch(decision){
                            case 0:
                                String newName = IOConsola.leerString("Digite el nuevo nombre de la mascota: ");
                                veterinaria.listarMascotas().get(i).setNombre(newName);
                                break;
                            case 1:
                                Byte newAge = (byte) IOConsola.leerByte("Digite la nueva edad de la mascota: ");
                                veterinaria.listarMascotas().get(i).setEdad(newAge);
                                break;
                            case 2: 
                                int newCost = IOConsola.leerEntero("Digite el nuevo costo de la mascota: ");
                                veterinaria.listarMascotas().get(i).setCosto(newCost);
                                break;
                            case 3:
                                IOConsola.imprimirInfo("¿Como desea asignar el nuevo pais?");
                                Paises newCountry = elegirPaisesOrigen();
                                veterinaria.listarMascotas().get(i).setPaisOrige(newCountry);
                                break;
                            case 4:
                                IOConsola.imprimirInfo("¿Que desea hacer?: ");
                                String options[] = {"Agregar Vacuna", "Borrar vacuna","Atras"};
                                IOConsola.imprimir(true, options);
                                byte eleccion = (byte) Validaciones.validarOpciones(options.length, "Elija la opcion: ");
                                switch(eleccion){
                                    case 0:
                                        String nameVacuna = IOConsola.leerString("Digite el nombre de la vacuna: ");
                                        String descripcion = IOConsola.leerString("Digite la descripcion de la vacuna: ");
                                        Vacuna name = new Vacuna(nameVacuna, descripcion);
                                        veterinaria.listarMascotas().get(i).aplicarVacuna(name); break;
                                    case 1:
                                        String nameVacuna1 = IOConsola.leerString("Digite el nombre de la vacuna: ");
                                        Vacuna elimVacuna = veterinaria.listarMascotas().get(i).buscarVacuna(nameVacuna1);
                                        veterinaria.listarMascotas().get(i).elminarVacuna(elimVacuna); break;
                                    case 2:
                                        return;
                                } break;
                            case 5: return;      
                        }
                    }
                case 1: return;
                }
           }
    }
}
