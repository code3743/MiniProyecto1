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
    }


    public void insertarMascota(){
        IOConsola.borrarPantalla();
        String opciones[] = {"Gato","Perro", "Atras"};
        IOConsola.imprimir(true, opciones);
        byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
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
            IOConsola.imprimirInfo("Eliga el pais de origen");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
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
                    int indexPais =  Validaciones.validarOpciones(Paises.values().length, "Eliga un pais: ");
                    return Paises.values()[indexPais];
            }
        }
    }

    private RazaPerro elegirRazaPerro(){
        String opciones[] = {"Buscar","Mostrar lista"};
        while (true){
             IOConsola.imprimirInfo("Eliga la raza");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
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
                    int indexRaza =  Validaciones.validarOpciones(RazaPerro.values().length, "Eliga una raza: ");
                    return RazaPerro.values()[indexRaza];
            }
        }
    }

    private RazaGato elegirRazaGato(){
        String opciones[] = {"Buscar","Mostrar lista"};
        while (true){
            IOConsola.imprimirInfo("Eliga la raza");
            IOConsola.imprimir(true, opciones);
            byte opt =(byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
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
                    int indexRaza =  Validaciones.validarOpciones(RazaGato.values().length, "Eliga una raza: ");
                    return RazaGato.values()[indexRaza];
            }
        }
    }

}
