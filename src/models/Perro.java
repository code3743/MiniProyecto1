package models;
public class Perro extends Mascota{
    
    RazaPerro raza;
    
    public Perro(Paises paisOrige, double costo, String nombre, byte edad){
        super(paisOrige, costo, nombre, edad);
       
    }
}
