
/**
*Classe qui définit un véhicule aérien nommé avion
*/
public class Avion extends Aerien {
  /**
  * Constructeur par défaut
  */
  public Avion(){
    super();
  }
  /**
  * Constructeur d'un avion qui va appeler le Constructeur d'un véhicule aérien
  * @param marque       marque d'un avion
  * @param modele       modele de l'avion
  * @param prixLocation prix de location de l'avion
  * @param etat         etat de l'avion
  * @param vitesseMax  vitesse maximale de l'avion
  * @param nbHeures   nombre d'heures de vol de l'avion
  * @param nbMoteurs    nombre de moteurs de vol de l'avion
  * @param id           id de l'avion
  */
  public Avion(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int nbHeures, int nbMoteurs,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,nbHeures,nbMoteurs,id);
  }
  
  
  @Override
  public String toString() {
    return "Avion: "+ super.toString();
  }
}
