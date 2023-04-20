package controllers;

import models.Gato;
import models.Mascota;
import models.Paises;
import models.Perro;
import models.RazaGato;
import models.RazaPerro;
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
        eliminarMascota();
        
    }
        
    public void listarMascotas(){
        IOConsola.borrarPantalla();
        IOConsola.imprimirInfo("#  Nombre  ---  Edad  ---  Raza  ---  Pais De Origen  ---  N° Vacunas  ---  Costo ---");
        for(Mascota lista : veterinaria.listarMascotas()){
            IOConsola.imprimir(lista);
        }
        int decision = IOConsola.leerEntero("\n¿Deseas volver a la ventana anterior?  1.Si -- 2.No: ");
        if(decision == 1){
            insertarMascota();
        }else{
            return;
        }
        /*for(int i=0 ; i< veterinaria.listarMascotas().size(); i++){ 
            IOConsola.imprimir(i+1+"."," "+veterinaria.listarMascotas().get(i).getNombre()+" -- "+ 
            veterinaria.listarMascotas().get(i).getEdad() +" ------ "+ veterinaria.listarMascotas().get(i).getPaisOrige()+
            "  ----- "+veterinaria.listarMascotas().get(i).getVacunas() +"  -----  "+ veterinaria.listarMascotas().get(i).getCosto());}
        */ }


    public void buscarMascotaPorNombre(){
        String name = IOConsola.leerString("Digite el nombre de la mascota a buscar: ");
        if(veterinaria.buscarMascotaPorNombre(name) != null){
            IOConsola.imprimir(veterinaria.buscarMascotaPorNombre(name));
        }
    }
    public void insertarMascota(){
        IOConsola.borrarPantalla();
        String opciones[] = {"Gato","Perro", "Atras"};
        IOConsola.imprimir(true, opciones);
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

        if(veterinaria.agregarMascota(mascotaTemp)){
            IOConsola.imprimirRealizado("Se guardo la mascota");
        }else{
            IOConsola.imprimirError("No se pudo guardar");
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
            IOConsola.imprimir(nombre, edad, precio,raza.getNombreRaza(), paisOrige);
            boolean guardar = (IOConsola.leerEntero("1. Si - 2. No: ") == 1);
            if(guardar){
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
            IOConsola.imprimir(nombre, edad, precio, raza.getNombreRaza() ,paisOrige);
            boolean guardar = (IOConsola.leerEntero("1. Si - 2. No: ") == 1);
            if(guardar){
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

    
    public void eliminarMascota(){
        IOConsola.borrarPantalla();
        IOConsola.imprimirInfo("Como desea eliminar su mascota.");
        String opciones[] = {"Buscar por nombre.","Listar mascotas.", "Atras."};
        IOConsola.imprimir(true, opciones);
        byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
        if(veterinaria.listarMascotas().size()!=0){
            switch(opt){
                case 0:
                    String nombreMascota = IOConsola.leerString("Ingrese el nombre: ").toLowerCase();
                    if(veterinaria.eliminarMascota(veterinaria.buscarMascotaPorNombre(nombreMascota))){
                        IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                    }else{
                        IOConsola.imprimirError("No se encontro la mascota: "+nombreMascota);
                    }break;
                case 1:
                    IOConsola.imprimirInfo("Nombres");
                    for(int i=0 ; i< veterinaria.listarMascotas().size(); i++){ 
                        IOConsola.imprimir(i+1+".",veterinaria.listarMascotas().get(i).getNombre());};
                    int indexMascota= IOConsola.leerEntero("Ingrese el numero de opcion: ");
                    // A la variable indexMascota se les resta un uno para dar su indice
                    if(veterinaria.eliminarMascota(veterinaria.elegirMascota(indexMascota-1))== true){
                        IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                    }else{
                        IOConsola.imprimirError("No se encontro la opcion ["+indexMascota+"] en la lista.");
                    };break;
                case 2:
                    return;
                }
                
            }else{
                IOConsola.imprimirProblemas("No hay mascotas agregadas a la lista aun.");
        } 
    }
}
