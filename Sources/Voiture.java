
/**
*  Classe qui définit un véhicule terrestre nommé voiture
*/
public class Voiture extends Terrestre {
  private int nbPlace;
  /**
  * Constructeur par défaut
  */
  public Voiture() {
    super();
  }
  /**
  * Constructeur d'une moto qui va appeler le Constructeur d'un véhicule terrestre et initialiser un attribut de la voiture
  * @param marque       marque de la voiture
  * @param modele       modele de la voiture
  * @param prixLocation prix de location de la voiture
  * @param etat         etat de la voiture
  * @param vitesseMax  vitesse maximale de la voiture
  * @param km           km parcourus par la voiture
  * @param nbPlace     nombre de places dans la voiture
  * @param puissance    puissance de la voiture
  * @param id           id de la voiture
  */
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
