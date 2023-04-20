package models;
public class Perro extends Mascota{
    
    private RazaPerro raza;
    
    public Perro(RazaPerro raza, Paises paisOrige, double costo, String nombre, byte edad ){
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
       
    }

    public Perro(){
        super(null, 0, "",(byte) 0);
    }

    public RazaPerro getRaza() {
        return raza;
    }

    public void setRaza(RazaPerro raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "  ---  " + nombre + "  ---  " + "  ---  "+ edad + "  ---  " + raza + "  ---  " + paisOrige + "  ---  " + vacunas + "  ---  "+ costo ;
    }
}
