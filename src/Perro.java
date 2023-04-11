public class Perro extends Mascota implements Canino{
    RazaPerro raza;
    public Perro(String paisOrige, double costo, String nombre, byte edad, RazaPerro raza){
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }
  
    
  
}
