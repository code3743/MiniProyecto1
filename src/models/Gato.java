package models;

public class Gato extends Mascota{
  
    RazaGato raza;
    public Gato(Paises paisOrige, double costo, String nombre, byte edad, RazaGato raza) {
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }
    
}
