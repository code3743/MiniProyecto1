package models;
public enum RazaPerro {
      
   AkitaInu, BassetHound, Beagle, BichonFrise, BichonMaltes, Bloodhound, BorderCollie, BostonTerrier, Boxer, 
   BoyeroDeBerna, BulldogFrances, BulldogIngles, Bullmastiff, CairnTerrier, CaneCorso, Caniche, Carlino,
   CavalierKingCharlesSpaniel, ChesapeakeBayRetriever, Chihuahua, ChowChow, CockerSpaniel, Collie, Dalmata, 
   Dachshund, DobermanPinscher, DogoArgentino, DogoDeBurdeos,DogoDelTibet,DogoAleman,GoldenRetriever,GranPirineo,
   Greyhound,GranDanes,HuskySiberiano,JackRussellTerrier,LabradorRetriever,LhasaApso,MastinNapolitano,MastinEspanol,
   Maltipoo,Papillon,PastorAleman,PastorAustraliano,PastorBelga,PastorDeAnatolia,Pequines,PinscherMiniatura,
   PitbullTerrier,Pointer,Pomerania,Pug,Rottweiler,SanBernardo,Schnauzer,SetterIrlandes,SharPei,ShihTzu,
   SpringerSpaniel,StaffordshireBullTerrier,Terranova,Teckel,Weimaraner,WestHighlandWhiteTerrier,Whippet,
   YorkshireTerrier;
  
   public String getNombreRaza(){
      return name().replaceAll("(\\p{L1})(\\p{Lu})","$1 $2");  
   }
   
}



