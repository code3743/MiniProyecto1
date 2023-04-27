package models;

/**
 * 
 * 
 * Enumeración de razas de gatos.
 * 
 * @author Juan Miguel Posso
 * 
 */
public enum RazaGato {
    Abisinio,
    AmericanShorthair,
    AngoraTurco,
    AzulRuso,
    Bengali,
    BobtailAmericano,
    BobtailJapones,
    Bombay,
    BritishShorthair,
    Burmese,
    CornishRex,
    DevonRex,
    Esfinge,
    HabanaBrown,
    Himalayo,
    MaineCoon,
    Manx,
    MauEgipcio,
    NoruegoDeBosque,
    Ocicat,
    Oriental,
    Persa,
    Peterbald,
    Ragdoll,
    Savannah,
    ScottishFold,
    SelkirkRex,
    Siames,
    Siberiano,
    Singapura,
    Somali,
    Sphynx,
    Tonkines,
    Toyger,
    VanTurco;

    /**
     * 
     * Obtiene el nombre de la raza en un formato legible.
     * 
     * @return El nombre de la raza con espacios en lugar de mayúsculas.
     */
    public String getNombreRaza() {
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");
    }

    /**
     * 
     * Obtiene una representación en String de la raza en un formato legible.
     * 
     * @return El nombre de la raza con espacios en lugar de mayúsculas.
     */
    @Override
    public String toString() {
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");

    }
}
