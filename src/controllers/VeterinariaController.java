package controllers;

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
import java.util.ArrayList;

public class VeterinariaController {
    private Veterinaria veterinaria;

    public VeterinariaController() {
        veterinaria = new Veterinaria();
    }

    public void init() {
        menu();
    }

    public void menu() {
        while (true) {
            IOConsola.borrarPantalla();
            String metodosDelMenu[] = { "Agregar una mascosta", "Actualizar mascota", "Eliminar una mascota",
                    "Buscar una mascota por su nombre", "Listas todas las mascotas", "Otras opciones",
                    "Acerca de la app", "Salir" };
            IOConsola.imprimir(true, metodosDelMenu);
            byte opt = (byte) Validaciones.validarOpciones(metodosDelMenu.length, "Elija la opcion: ");
            switch (opt) {
                case 0:
                    insertarMascota();
                    break;
                case 1:
                    actualizarMascota();
                    break;
                case 2:
                    eliminarMascota();
                    break;
                case 3:
                    buscarMascotaPorNombre();
                    break;
                case 4:
                    listarMascotas();
                    break;
                case 5:
                    IOConsola.borrarPantalla();
                    String metodosDelMenuSecundario[] = { "Buscar vacunas",
                            "Top 5 mascotas mas costosas", "Mascotas que no son orginarias de latinonamerica",
                            "Atras" };
                            boolean bandera = true;
                     while(bandera){
                        IOConsola.imprimir(true, metodosDelMenuSecundario);
                        byte optSecundario = (byte) Validaciones.validarOpciones(metodosDelMenuSecundario.length,  "Elija la opcion: ");
                        switch (optSecundario) {
                            case 0:
                                moduloVacunacion();
                                break;
                            case 1:
                                listaMascotasCostosas();
                                break;
                            case 2:
                                mascotasNoLatinas();
                                break;
                            case 3:
                                bandera = false;
                        }
                    }
                    break;
                case 6:
                    IOConsola.borrarPantalla();
                    IOConsola.imprimir("Programadores");
                    IOConsola.imprimir("Jota Emilio Lopez - 2259394");
                    IOConsola.imprimir("Jhon Alejandro Martinez - 2259565");
                    IOConsola.imprimir("Juan Miguel Posso Alvarado - 2259610");
                    IOConsola.imprimirInfo("\nEspera 5 segundos para volver al menu anterior");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                    break;
                case 7:
                    IOConsola.imprimirInfo("Gracias por usar la app");
                    System.exit(0);
                    break;
            }
        }

    }

    public void listaMascotasCostosas() {
        IOConsola.borrarPantalla();
        if(veterinaria.listarMascotas().isEmpty()){
            IOConsola.imprimirProblemas("No hay mascotas agregadas aun");
            IOConsola.leerString("Presione cualquier letra para continuar...");
            return;
        }
        IOConsola.imprimirInfo("Top 5 de mascotas costosas");
        IOConsola.imprimir(true, 5, veterinaria.listaMascotasCostosas().toArray());
        IOConsola.leerString("Presione cualquier letra para continuar...");
    }

    public void listarMascotas() {
            IOConsola.borrarPantalla();
            ArrayList<Mascota> mascotas = veterinaria.listarMascotas();
            if (mascotas.isEmpty()) {
                IOConsola.imprimirError("No hay mascotas agregadas");
                IOConsola.leerString("Presione cualquier letra para continuar...");
                return;
            }
            IOConsola.imprimirInfo("Listado de mascotas");
            IOConsola.imprimir(true, mascotas.toArray());
            IOConsola.leerString("Presione cualquier letra para continuar...");
    }

    public void buscarMascotaPorNombre() {
        String name = IOConsola.leerString("Digite el nombre de la mascota a buscar: ");
        Mascota mascota = veterinaria.buscarMascotaPorNombre(name);
        if (mascota != null) {
            IOConsola.imprimir(mascota);
        } else {
            IOConsola.imprimirError("No se encontre una mascota con el nombre: " + name);
        }
        IOConsola.leerString("Presione cualquier letra para continuar...");
    }

    public void insertarMascota() {
        String opciones[] = { "Gato", "Perro", "Atras" };
        while (true) {
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Modulo Agregar mascota");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            Mascota mascotaTemp = null;
            switch (opt) {
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
            if (veterinaria.agregarMascota(mascotaTemp)) {
                IOConsola.imprimirRealizado("Se guardo la mascota");
            } else {
                IOConsola.imprimirError("No se pudo guardar");
            }
            IOConsola.leerString("Presione cualquier letra para continuar...");
        }

    }

    private Perro agregaPerro() {
        Perro nuevoPerro;
        while (true) {
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Agrege los datos del Perro");
            String nombre = IOConsola.leerString("Ingrese el nombre: ");
            byte edad = IOConsola.leerByte("Ingrese la edad: ");
            float precio = (float) IOConsola.leerDouble("Precio de la mascota: ");
            Paises paisOrige = elegirPaisesOrigen();
            RazaPerro raza = elegirRazaPerro();
            nuevoPerro = new Perro(raza, paisOrige, precio, nombre, edad);
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Desea guardar el perro con los siguientes datos: ");
            IOConsola.imprimir(nuevoPerro);
            if (IOConsola.leerEntero("1. Si - 2. No: ") == 1) {
                return nuevoPerro;
            }
        }
    }

    private Gato agregaGato() {
        Gato gatoNuevo;
        while (true) {
            IOConsola.borrarPantalla();
            IOConsola.imprimirInfo("Agrege los datos del Gato");
            String nombre = IOConsola.leerString("Ingrese el nombre: ");
            byte edad = IOConsola.leerByte("Ingrese la edad: ");
            float precio = (float) IOConsola.leerDouble("Precio de la mascota: ");
            Paises paisOrige = elegirPaisesOrigen();
            RazaGato raza = elegirRazaGato();
            IOConsola.borrarPantalla();
            gatoNuevo = new Gato(paisOrige, precio, nombre, edad, raza);
            IOConsola.imprimirInfo("Desea guardar el gato con los siguientes datos: ");
            IOConsola.imprimir(gatoNuevo);
            if (IOConsola.leerEntero("1. Si - 2. No: ") == 1) {
                return gatoNuevo;
            }
        }
    }

    private Paises elegirPaisesOrigen() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Buscar", "Mostrar lista" };
        while (true) {
            IOConsola.imprimirInfo("Elija el pais de origen");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch (opt) {
                case 0:
                    String nombrePais = IOConsola.leerString("Ingrese el nombre del pais: ");
                    for (Paises pais : Paises.values()) {
                        if (pais.getNombrePais().toLowerCase().equals(nombrePais.toLowerCase())) {
                            IOConsola.imprimirRealizado("Pais asignado");
                            IOConsola.leerString("Presione cualquier letra para continuar...");
                            return pais;
                        }
                    }
                    IOConsola.borrarPantalla();
                    IOConsola.imprimirError("No se encontro el pais: " + nombrePais);
                    IOConsola.leerString("Presione cualquier letra para continuar...");
                    break;
                case 1:
                    IOConsola.imprimir(true, Paises.values());
                    int indexPais = Validaciones.validarOpciones(Paises.values().length, "Elija un pais: ");
                    return Paises.values()[indexPais];
            }
        }
    }

    private RazaPerro elegirRazaPerro() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Buscar", "Mostrar lista" };
        while (true) {
            IOConsola.imprimirInfo("Elija la raza");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch (opt) {
                case 0:
                    String nombreRaza = IOConsola.leerString("Ingrese la raza: ");
                    for (RazaPerro raza : RazaPerro.values()) {
                        if (raza.getNombreRaza().toLowerCase().equals(nombreRaza.toLowerCase())) {
                            IOConsola.imprimirRealizado("Raza encontrada y asignada");
                            IOConsola.leerString("Presione cualquier letra para continuar...");
                            return raza;
                        }
                    }
                    IOConsola.borrarPantalla();
                    IOConsola.imprimirError("No se encontro la raza: " + nombreRaza);
                    IOConsola.leerString("Presione cualquier letra para continuar...");
                    break;
                case 1:
                    IOConsola.imprimir(true, RazaPerro.values());
                    int indexRaza = Validaciones.validarOpciones(RazaPerro.values().length, "Elija una raza: ");
                    return RazaPerro.values()[indexRaza];
            }
        }
    }

    private RazaGato elegirRazaGato() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Buscar", "Mostrar lista" };
        while (true) {
            IOConsola.imprimirInfo("Elija la raza");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            switch (opt) {
                case 0:
                    String nombreRaza = IOConsola.leerString("Ingrese la raza: ").toLowerCase();

                    for (RazaGato raza : RazaGato.values()) {
                        if (raza.getNombreRaza().toLowerCase().equals(nombreRaza.toLowerCase())) {
                            IOConsola.imprimirRealizado("Raza encontrada y asignada");
                            IOConsola.leerString("Presione cualquier letra para continuar...");
                            return raza;
                        }
                    }
                    IOConsola.borrarPantalla();
                    IOConsola.imprimirError("No se encontro la raza: " + nombreRaza);
                    IOConsola.leerString("Presione cualquier letra para continuar...");
                    break;
                case 1:
                    IOConsola.imprimir(true, RazaGato.values());
                    int indexRaza = Validaciones.validarOpciones(RazaGato.values().length, "Elija una raza: ");
                    return RazaGato.values()[indexRaza];
            }
        }
    }

    public void moduloVacunacion() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Buscar mascotas con vacuna.", "Atras." };
        while (true) {
            IOConsola.imprimirInfo("Modulo de vacunacion");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
            switch (opt) {
                case 0:
                    mascotasConVacuna();
                    break;
                case 1:
                    return;
            }
        }
    }

    private void mascotasConVacuna() {
        IOConsola.borrarPantalla();
        String nombreVacuna = IOConsola.leerString("Nombre de la vacuna: ");
        ArrayList<Mascota> mascotas = veterinaria.buscarVacunaEnMascotas(nombreVacuna);
        if (mascotas == null || mascotas.isEmpty()) {
            IOConsola.imprimirError("No se encontraron mascotas con la vacuna: " + nombreVacuna);
            IOConsola.leerString("Presione cualquier letra para continuar...");
            return;
        }
        IOConsola.imprimirInfo("Lista de Mascotas con la vacuna " + nombreVacuna);
        IOConsola.imprimir(true, mascotas.toArray());
        IOConsola.leerString("Presione cualquier letra para continuar...");
    }

    public void eliminarMascota() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Buscar por nombre.", "Listar mascotas.", "Atras." };
        while (true) {
            IOConsola.imprimirInfo("¿Como desea eliminar su mascota?.");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Eliga la opcion: ");
            if (!veterinaria.listarMascotas().isEmpty()) {
                switch (opt) {
                    case 0:
                        IOConsola.borrarPantalla();
                        String nombreMascota = IOConsola.leerString("Ingrese el nombre: ");
                        if (veterinaria.eliminarMascota(veterinaria.buscarMascotaPorNombre(nombreMascota))) {
                            IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                        } else {
                            IOConsola.imprimirError("No se encontro la mascota: " + nombreMascota);
                        }
                        IOConsola.leerString("Presione cualquier letra para continuar...");
                        break;
                    case 1:
                        IOConsola.borrarPantalla();
                        IOConsola.imprimirInfo("Mascotas");
                        IOConsola.imprimir(true, veterinaria.listarMascotas().toArray());
                        int indexMascota = Validaciones.validarOpciones(veterinaria.listaMascotasCostosas().size(),
                                "Ingrese el numero de la mascota: ");
                        if (veterinaria.eliminarMascota(veterinaria.elegirMascota(indexMascota))) {
                            IOConsola.imprimirRealizado("Se ha eliminado la mascota correctamente.");
                        } else {
                            IOConsola.imprimirError("No se pudo eliminar la mascota");
                        }
                        IOConsola.leerString("Presione cualquier letra para continuar...");
                        break;
                    case 2:
                        return;
                }
            } else {
                IOConsola.imprimirProblemas("No hay mascotas agregadas a la lista aun.");
                IOConsola.leerString("Presione cualquier letra para continuar...");
                return;
            }
        }
    }

    public void actualizarMascota() {
        IOConsola.borrarPantalla();
        String opciones[] = { "Listado de mascotas", "Atras" };
        while (true) {
            IOConsola.imprimirInfo("Actualizaciar Mascotas");
            IOConsola.imprimir(true, opciones);
            byte opt = (byte) Validaciones.validarOpciones(opciones.length, "Elija la opcion: ");
            
                switch (opt) {

                    case 0:
                    if (!(veterinaria.listarMascotas().isEmpty())) {
                        IOConsola.imprimirInfo("Listado");
                        IOConsola.imprimir(true, veterinaria.listarMascotas().toArray());
                        int indexMascota = -1;
                        String nombreMascota = IOConsola.leerString("Ingrese el nombre o el numero de la mascota a actualizar: ")
                                .toLowerCase();
                        if(nombreMascota.matches("[0-9]+")){
                            int indexTemp = Integer.parseInt(nombreMascota) - 1;
                            indexMascota = indexTemp >= 0 && indexTemp < veterinaria.listaMascotasCostosas().size() ? indexTemp : -1;
                        }else{
                            for (int i = 0; i < veterinaria.listarMascotas().size(); i++) {
                                if (veterinaria.listarMascotas().get(i).getNombre().toLowerCase().equals(nombreMascota)) {
                                    indexMascota = i;
                                    break;
                                }
                            }
                        }
                        if (indexMascota != -1) {
                            IOConsola.imprimirInfo("¿Que quieres modificar de esta mascota?");
                            String opcionesMascota[] = { "Nombre", "Edad", "Costo", "Pais de origen", "Vacunas",
                                    "Atras" };
                            IOConsola.imprimir(true, opcionesMascota);
                            byte decision = (byte) Validaciones.validarOpciones(opcionesMascota.length,
                                    "Elija la opcion: ");
                            switch (decision) {
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
                                    actualizarVacunas(indexMascota);
                                    break;
                                case 5:
                                    break;
                            }
                           
                        }else{
                            IOConsola.borrarPantalla();
                            IOConsola.imprimirError("No se encontro la mascota");
                            IOConsola.leerString("Presione cualquier letra para continuar...");
                        }
                    }else{
                        IOConsola.borrarPantalla();
                        IOConsola.imprimirError("No hay mascotas agregadas");
                        IOConsola.leerString("Presione cualquier letra para continuar...");
                        return;
                    }
                        break;
                    case 1:
                        return;
                }
        }
    }

    public void actualizarVacunas(int indexMascota) {
        String options[] = { "Agregar Vacuna", "Borrar vacuna", "Atras" };
        IOConsola.borrarPantalla();
        Vacuna vacunaUpdate;
        while (true) {
            IOConsola.imprimirInfo("Actualizar vacunas");
            IOConsola.imprimirProblemas("Mascota:" + veterinaria.listarMascotas().get(indexMascota).getNombre());
            IOConsola.imprimir(true, options);
            byte eleccion = (byte) Validaciones.validarOpciones(options.length, "Elija la opcion: ");
            switch (eleccion) {
                case 0:
                    IOConsola.borrarPantalla();
                    String nameVacuna = IOConsola.leerString("Digite el nombre de la vacuna: ");
                    String descripcion = IOConsola.leerString("Digite la descripcion de la vacuna: ");
                    vacunaUpdate = new Vacuna(nameVacuna, descripcion);
                    veterinaria.listarMascotas().get(indexMascota).aplicarVacuna(vacunaUpdate);
                    IOConsola.borrarPantalla();
                    IOConsola.imprimirRealizado("Se aplico la vacuna:" + nameVacuna);
                    IOConsola.leerString("Presione cualquier letra para continuar...");
                    break;
                case 1:
                    IOConsola.borrarPantalla();
                    IOConsola.imprimir(true, veterinaria.listarMascotas().get(indexMascota).getVacunas().toArray());
                    String nombreVacuna = IOConsola.leerString("Digite el nombre de la vacuna: ");
                    vacunaUpdate = veterinaria.listarMascotas().get(indexMascota).buscarVacuna(nombreVacuna);
                    if (veterinaria.listarMascotas().get(indexMascota).eliminarVacuna(vacunaUpdate)) {
                        IOConsola.borrarPantalla();
                        IOConsola.imprimirRealizado("Se elimino la vacuna " + nombreVacuna);
                        IOConsola.leerString("Presione cualquier letra para continuar...");
                    } else {
                        IOConsola.borrarPantalla();
                        IOConsola.imprimirError("No se pudo encontrar o eliminar la vacuna " + nombreVacuna);
                        IOConsola.leerString("Presione cualquier letra para continuar...");
                    }
                    break;
                case 2:
                    return;
            }
        }
    }

    public void mascotasNoLatinas() {
        IOConsola.borrarPantalla();
        IOConsola.imprimirInfo("Mascotas que no tienen pais de origen en latinoamerica");
        ArrayList<Mascota> mascotasNoLatinas = new ArrayList<Mascota>();
        for(Mascota mascota: veterinaria.listarMascotas()){
            if(!mascota.getPaisOrige().isLatino()){
                mascotasNoLatinas.add( mascota);
            }
        }
        if(mascotasNoLatinas.isEmpty()){
            IOConsola.imprimirProblemas("No hay mascotas que coincidan");
            IOConsola.leerString("Presione cualquier letra para continuar...");
            return;
        }
        IOConsola.imprimir(true, mascotasNoLatinas.toArray());
        IOConsola.leerString("Presione cualquier letra para continuar...");

    }
}
