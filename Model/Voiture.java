
/**
*
*/
public class Voiture extends Terrestre {
  /**
  *
  */
  private int nbPlace;
  
  
  
  public Voiture() {
    super();
  }
  
  public Voiture(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km, int nbPlace, double puissance,int id) {
    super( marque,  modele,  prixLocation,  etat,  vitesseMax,km,puissance,id);
    this.nbPlace = nbPlace;
    
  }
  
  
  @Override
  public String toString() {
    return "Voiture: "+super.toString();
  }
  
  public int getNbPlace() {
    return nbPlace;
  }
  
  public void setNbPlace(int nbPlace) {
    this.nbPlace = nbPlace;
  }
  
  
}
