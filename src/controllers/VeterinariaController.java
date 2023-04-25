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
        menu();
    }

    public void menu(){
        while(true){
        IOConsola.borrarPantalla();
        String metodosDelMenu[] = {"Agregar una mascosta", "Actualizar mascota", "Eliminar una mascota",
        "Buscar una mascota por su nombre", "Listas todas las mascotas","Ir al siguiente menu",
        "Acerca de la app", "Salir"};
        IOConsola.imprimir(true, metodosDelMenu);
        byte opt = (byte )Validaciones.validarOpciones(metodosDelMenu.length, "Elija la opcion: ");
            switch(opt){
                case 0: 
                    insertarMascota();break;
                case 1: 
                    actualizarMascota(); break;
                case 2:
                    eliminarMascota();break;
                case 3:
                    buscarMascotaPorNombre();break;
                case 4:
                    listarMascotas();break;
                case 5: 
                IOConsola.borrarPantalla();
                String metodosDelMenuSecundario[] = { "Buscar mascotas con una vacuna determinada", 
                "Top 5 mascotas mas costosas", "Mascotas que no son orginarias de latinonamerica","Atras"};
                IOConsola.imprimir(true, metodosDelMenuSecundario);
                byte opt2 = (byte) Validaciones.validarOpciones(metodosDelMenuSecundario.length, "Elija la opcion: ");

                    switch(opt2){
                        case 0:mascotasConVacuna();break; 
                        case 1: listaMascotasCostosas();
                            IOConsola.imprimirInfo("\nEspera 5 segundos para volver al menu anterior");
                            try{Thread.sleep(5000);}
                            catch(InterruptedException e){};break;
                        case 2: mascotasNoLatinas();
                            IOConsola.imprimirInfo("\nEspera 5 segundos para volver al menu anterior");
                            try{Thread.sleep(5000);}
                            catch(InterruptedException e){}break;
                        case 3: break;
                    }break;
                
                case 6:
                    IOConsola.borrarPantalla();
                    IOConsola.imprimir("Programadores");
                    IOConsola.imprimir("Jota Emilio Lopez - 2259394");
                    IOConsola.imprimir("Jhon Alejandro Martinez - 2259565");
                    IOConsola.imprimir("Juan Miguel Posso Alvarado - 2259610");
                    IOConsola.imprimirInfo("\nEspera 5 segundos para volver al menu anterior");
                    try{Thread.sleep(5000);}
                    catch(InterruptedException e){};break;
                case 7:
                    IOConsola.imprimirInfo("Gracias por usar la app");
                    System.exit(0);break;
            }
        }
    }

    public void listaMascotasCostosas(){
        IOConsola.borrarPantalla();
        IOConsola.imprimir(true,5, veterinaria.listaMascotasCostosas().toArray());
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
        Integer decision = IOConsola.leerEntero("\nIngrese cualquier numero para volver a la ventana anterior: ");
        if(decision != null){
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
        Integer decision = IOConsola.leerEntero("\nIngrese cualquier numero para volver a la ventana anterior: ");
        if(decision != null){
            return;
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
                mascotaTemp = agregaPerro();break;
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
            float precio = (float)IOConsola.leerDouble("Precio de la mascota: ");
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
            float precio = (float)IOConsola.leerDouble("Precio de la mascota: ");
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
                    int indexMascota=-1;
                    String nombreMascota = IOConsola.leerString("Ingrese el nombre de la mascota a actualizar: ").toLowerCase();
                    for( int i=0 ; i< veterinaria.listarMascotas().size(); i++){
                        if (veterinaria.listarMascotas().get(i).getNombre().toLowerCase().equals(nombreMascota)){
                            indexMascota = i;
                            break;   
                        }
                    }
                    if(indexMascota != -1){
                        IOConsola.imprimirInfo("¿Que quieres modificar de esta mascota?");
                        String opciones1[] = {"Nombre","Edad", "Costo","Pais de origen","Vacunas","Atras"};
                        IOConsola.imprimir(true, opciones1);
                        byte decision = (byte) Validaciones.validarOpciones(opciones1.length, "Elija la opcion: ");
                        switch(decision){
                            case 0:
                                String newName = IOConsola.leerString("Digite el nuevo nombre de la mascota: ");
                                veterinaria.listarMascotas().get(indexMascota).setNombre(newName);
                                break;
                            case 1:
                                Byte newAge = (byte) IOConsola.leerByte("Digite la nueva edad de la mascota: ");
                                veterinaria.listarMascotas().get(indexMascota).setEdad(newAge);
                                break;
                            case 2: 
                                int newCost = IOConsola.leerEntero("Digite el nuevo costo de la mascota: ");
                                veterinaria.listarMascotas().get(indexMascota).setCosto(newCost);
                                break;
                            case 3:
                                IOConsola.imprimirInfo("¿Como desea asignar el nuevo pais?");
                                Paises newCountry = elegirPaisesOrigen();
                                veterinaria.listarMascotas().get(indexMascota).setPaisOrige(newCountry);
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
                                        veterinaria.listarMascotas().get(indexMascota).aplicarVacuna(name); break;
                                    case 1:
                                        String nameVacuna1 = IOConsola.leerString("Digite el nombre de la vacuna: ");
                                        Vacuna elimVacuna = veterinaria.listarMascotas().get(indexMascota).buscarVacuna(nameVacuna1);
                                        veterinaria.listarMascotas().get(indexMascota).elminarVacuna(elimVacuna); break;
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
    public void mascotasNoLatinas(){
        IOConsola.borrarPantalla();
        IOConsola.imprimirInfo("Mascotas que no tienen pais de origen en latinoamerica");
        int cuenta =0;
        for(int i=0 ; i< veterinaria.listarMascotas().size(); i++){
            if(veterinaria.listarMascotas().get(i).getPaisOrige().isLatino()){
                cuenta=cuenta+1;
            }else{
                IOConsola.imprimir((i-cuenta)+1+".",veterinaria.listarMascotas().get(i).getNombre());
            }
        }

    }
}
