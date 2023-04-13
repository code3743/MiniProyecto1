package models;
public enum RazaGato {
    Siames, Persa, GatoMontesEscoces, BritanicoDePeloCorto, MaineCoon, Esfinge, Bengali, Abisinio, DevonRex, AzulRuso, AmericanoDePeloCorto, Birmano, AngoraTurco, Siberiano, Criollo;
    public String getNombreRaza(){
        return name().replaceAll("([a-z][A-Z])","( )");
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
