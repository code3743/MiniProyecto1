package models;

public class Gato extends Mascota{
  
    private RazaGato raza;
    public Gato(Paises paisOrige, double costo, String nombre, byte edad, RazaGato raza) {
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }
    public RazaGato getRaza() {
        return raza;
    }
    public void setRaza(RazaGato raza) {
        this.raza = raza;
    }
    
}
