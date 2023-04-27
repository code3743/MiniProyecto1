package models;
/**
 * La clase Perro es una subclase de Mascota y representa a un perro en el sistema.
 * Tiene una propiedad adicional de RazaPerro.
 * 
 * @author Alejandro Martinez
 */
public class Perro extends Mascota{
    
    private RazaPerro raza;
    
    /**
     * Constructor de la clase Perro que recibe la raza, el país de origen, el costo, el nombre y la edad del perro.
     * 
     * @param raza La raza del perro.
     * @param paisOrige El país de origen del perro.
     * @param costo El costo del perro.
     * @param nombre El nombre del perro.
     * @param edad La edad del perro.
     */
    public Perro(RazaPerro raza, Paises paisOrige, float costo, String nombre, byte edad ){
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }

    /**
     * Constructor vacío de la clase Perro.
     */
    public Perro(){
        super(null, 0, "",(byte) 0);
    }

    /**
     * Método getter para la propiedad raza.
     * 
     * @return La raza del perro.
     */
    public RazaPerro getRaza() {
        return raza;
    }

    /**
     * Método setter para la propiedad raza.
     * 
     * @param raza La nueva raza del perro.
     */
    public void setRaza(RazaPerro raza) {
        this.raza = raza;
    }

    /**
     * Método que retorna una representación en String del objeto Perro.
     * 
     * @return Una cadena con la información del perro, incluyendo su nombre, edad, país de origen, costo y raza.
     */
    @Override
    public String toString() {
      return super.toString() + String.format(" - Raza: %s", raza.getNombreRaza());
    }
}
