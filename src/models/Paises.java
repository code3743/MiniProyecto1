package models;

import java.util.EnumSet;
import java.util.Set;

public enum Paises {
    Barbados,
    Reunion,
    Surinam,
    Namibia,
    Guinea,
    Vanuatu,
    Samoa,
    Francia,
    Andorra,
    Azerbaiyan,
    Maldivas,
    PolinesiaFrancesa,
    SantaLucia,
    Panama,
    TimorOriental,
    MacedoniadelNorte,
    Dinamarca,
    Egipto,
    Estonia,
    Chequia,
    Bahamas,
    Uruguay,
    Alandia,
    Comoras,
    IslasCook,
    CostaRica,
    Togo,
    SantoTomeyPrincipe,
    PaisesBajos,
    HongKong,
    Australia,
    Malasia,
    Nepal,
    Cuba,
    CoreadelNorte,
    GuayanaFrancesa,
    Moldavia,
    Zambia,
    Dominica,
    IslasMarshall,
    Tonga,
    Peru,
    CaboVerde,
    Kiribati,
    Finlandia,
    CostadeMarfil,
    Martinica,
    Pakistan,
    Djibouti,
    IslasTurksyCaicos,
    Micronesia,
    Eslovenia,
    Kirguizistan,
    CaribeNeerlandes,
    TierrasAustralesyAntarticasFrancesas,
    SanBartolome,
    Suiza,
    Kuwait,
    Seychelles,
    ReinoUnido,
    IslasVirgenesdelosEstadosUnidos,
    Fiyi,
    Yemen,
    IslasVirgenesdelReinoUnido,
    IslaBouvet,
    RepublicaCentroafricana,
    Belgica,
    Curazao,
    Argentina,
    Madagascar,
    Sudafrica,
    Letonia,
    Zimbabue,
    Antartida,
    Guernsey,
    Gabon,
    Rumania,
    Alemania,
    Bangladesh,
    Montserrat,
    Jordania,
    Mozambique,
    Israel,
    Eritrea,
    Indonesia,
    IsladeMan,
    Japon,
    Espana,
    Afganistan,
    EmiratosArabesUnidos,
    Malawi,
    Turquia,
    Bielorrusia,
    Montenegro,
    BosniayHerzegovina,
    Suazilandia,
    Lituania,
    Turkmenistan,
    Etiopia,
    Anguilla,
    Hungria,
    SamoaAmericana,
    Chad,
    Guadalupe,
    Nigeria,
    SanMarino,
    Ucrania,
    Haiti,
    Botswana,
    Portugal,
    Guyana,
    Irlanda,
    NuevaCaledonia,
    SaintMartin,
    Mauricio,
    Gibraltar,
    SanCristobalyNieves,
    Islandia,
    IslasSvalbardyJanMayen,
    Chile,
    IslasUltramarinasMenoresdeEstadosUnidos,
    Kazajistan,
    China,
    Macao,
    Armenia,
    Bolivia,
    Sudan,
    Vietnam,
    WallisyFutuna,
    Burundi,
    Canada,
    Colombia,
    Lesotho,
    Bermudas,
    Guatemala,
    Uzbekistan,
    IslasCaiman,
    Senegal,
    Gambia,
    Liechtenstein,
    IslasPitcairn,
    Tuvalu,
    GuineaEcuatorial,
    Butan,
    Aruba,
    Paraguay,
    Grenada,
    PapuaNuevaGuinea,
    Jamaica,
    Congo,
    Polonia,
    Rusia,
    Mauritania,
    SaharaOccidental,
    BurkinaFaso,
    CongoRepDem,
    Benin,
    Uganda,
    Mongolia,
    Laos,
    Argelia,
    Brunei,
    Kenia,
    SriLanka,
    RepublicaDominicana,
    Austria,
    Luxemburgo,
    Georgia,
    RepublicaEslovaca,
    Noruega,
    Tailandia,
    TerritorioBritanicodelOceanoIndico,
    India,
    Marruecos,
    SanPedroyMiquelon,
    Groenlandia,
    Nicaragua,
    Catar,
    Taiwan,
    Brasil,
    NuevaZelanda,
    Singapur,
    Siria,
    Belice,
    IslasMalvinas,
    Venezuela,
    Bahrein,
    IslasCocosoIslasKeeling,
    IslasMarianasdelNorte,
    Camerun,
    Chipre,
    EstadosUnidos,
    Angola,
    Tunez,
    Monaco,
    Ruanda,
    TrinidadyTobago,
    Malta,
    Mexico,
    Mayotte,
    AntiguayBarbuda,
    IslasTokelau,
    CoreadelSur,
    Niger,
    Albania,
    Somalia,
    Liberia,
    Myanmar,
    Tanzania,
    Irak,
    IslasGeorgiasdelSurySandwichdelSur,
    SanVicenteyGranadinas,
    Libia,
    SierraLeone,
    SintMaarten,
    Serbia,
    IslasHeardyMcDonald,
    Ghana,
    SudandelSur,
    Suecia,
    Grecia,
    IslasFaroe,
    Filipinas,
    GuineaBisau,
    ArabiaSaudi,
    Palau,
    Bulgaria,
    Nauru,
    Camboya,
    Jersey,
    Palestina,
    Italia,
    Mali,
    Iran,
    Niue,
    Tayikistan,
    Kosovo,
    SantaElenaAscensionyTristandeAcuna,
    IsladeNorfolk,
    Oman,
    ElSalvador,
    Libano,
    CiudaddelVaticano,
    Ecuador,
    Guam,
    Croacia,
    IslasSalomon,
    Honduras,
    IsladeNavidad,
    PuertoRico;

    public String getNombrePais(){
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");
    }
    @Override
    public String toString() {
        return name().replaceAll("(?<=\\p{Lower})(?=\\p{Upper})", " ");

    }
    private static Set<Paises> paisesLatinos = EnumSet.of(
        Argentina,
        Bolivia,
        Brasil,
        Chile,
        Colombia,
        CostaRica,
        Cuba,
        Ecuador,
        ElSalvador,
        Guatemala,
        Haiti,
        Honduras,
        Mexico,
        Nicaragua,
        Panama,
        Paraguay,
        Peru,
        RepublicaDominicana,
        Uruguay,
        Venezuela
    );
    public boolean isLatino(){
        return paisesLatinos.contains(this);
    }
  }