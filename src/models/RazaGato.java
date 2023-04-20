package models;
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
    public String getNombreRaza(){
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");
    }
    @Override
    public String toString() {
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");

    }
    //Metodo que imprime las opciones de razas de gatos que estan disponibles con numeracion en lista
    /* public void imprimirRazas(){
        Integer i=1;
        for(RazaGato raza: RazaGato.values()){
        System.out.println(i+"."+raza.getNombreRaza());
        i++;
        }
    } */
}
