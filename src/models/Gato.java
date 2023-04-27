package models;

/**
 * La clase Gato extiende la clase Mascota y representa a un gato con su país de
 * origen,
 * costo, nombre, edad y raza.
 * 
 * @author Juan Miguel Posso
 * 
 */
public class Gato extends Mascota {

    private RazaGato raza;

    /**
     * Constructor de la clase Gato.
     * 
     * @param paisOrige el país de origen del gato.
     * @param costo     el costo del gato.
     * @param nombre    el nombre del gato.
     * @param edad      la edad del gato.
     * @param raza      la raza del gato.
     */
    public Gato(Paises paisOrige, float costo, String nombre, byte edad, RazaGato raza) {
        super(paisOrige, costo, nombre, edad);
        this.raza = raza;
    }

    /**
     * Método que devuelve la raza del gato.
     * 
     * @return la raza del gato.
     */
    public RazaGato getRaza() {
        return raza;
    }

    /**
     * Método que establece la raza del gato.
     * 
     * @param raza la nueva raza del gato.
     */
    public void setRaza(RazaGato raza) {
        this.raza = raza;
    }

    /**
     * Método que devuelve una cadena que representa al gato, incluyendo su país de
     * origen,
     * costo, nombre, edad y raza.
     * 
     * @return una cadena que representa al gato.
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" - Raza: %s", raza.getNombreRaza());
    }
}
