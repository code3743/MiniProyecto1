package models;

public class Gato extends Mascota implements Felino{
  
    RazaGato raza;
    public Gato(String paisOrige, double costo, String nombre, byte edad, RazaGato raza) {
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }
  //TODO: Realizar la definicon e implementacion de la clase
    
}
