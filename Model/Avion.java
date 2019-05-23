
/**
*
*/
public class Avion extends Aerien {
  
  public Avion(){
    super();
  }
  
  public Avion(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int nbHeures, int nbMoteurs) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,nbHeures,nbMoteurs);
  }
  
  
  @Override
  public String toString() {
    return "Avion: "+ super.toString();
  }
}
