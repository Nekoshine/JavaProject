
/**
* Classe qui définit un véhicule terrestre nommé Moto
*/
public class Moto extends Terrestre {
  
  
  /**
  * Constructeur par défaut
  */
  public Moto() {
    super();
  }
  /**
  * Constructeur d'une moto qui va appeler le Constructeur d'un véhicule terrestre
  * @param marque       marque de la moto
  * @param modele       modele de la moto
  * @param prixLocation prix de location de la moto
  * @param etat         etat de la moto
  * @param vitesseMax  vitesse maximale de la moto
  * @param km           km parcourus par la moto
  * @param puissance    puissance de la moto
  * @param id           id de la moto
  */
  public Moto(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km, double puissance,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,km,puissance,id);
  }
  
  
  @Override
  public String toString() {
    return "Moto: "+super.toString();
  }
}
