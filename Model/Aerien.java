
/**
* Classe abstraite qui définit un véhicule de type aérien
*/
public abstract class Aerien extends Vehicule {
  private int nbHeures;
  private int nbMoteurs;
  
  public int getNbHeures() {
    return nbHeures;
  }
  
  public void setNbHeures(int nbHeures) {
    this.nbHeures = nbHeures;
  }
  
  public int getNbMoteurs() {
    return nbMoteurs;
  }
  
  public void setNbMoteurs(int nbMoteurs) {
    this.nbMoteurs = nbMoteurs;
  }
  
  /**
  * Constructeur d'un véhicule aérien qui va initialiser les champs et appeler le Constructeur de l'objet véhicule
  * @param marque       marque d'un véhicule aérien
  * @param modele       modele du  véhicule aérien
  * @param prixLocation prix de location du  véhicule aérien
  * @param etat         etat du  véhicule aérien
  * @param vitesseMax  vitesse maximale du  véhicule aérien
  * @param nbHeures   nombre d'heures de vol du  véhicule aérien
  * @param nbMoteurs    nombre de moteurs de vol du  véhicule aérien
  * @param id           id du  véhicule aérien
  */
  public Aerien(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int nbHeures, int nbMoteurs,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,id);
    this.nbHeures=nbHeures;
    this.nbMoteurs=nbMoteurs;
  }
  /**
  * Constructeur par défaut
  */
  public Aerien(){
    super();
  }
  
  @Override
  public String toString() {
    return super.toString() +", nbHeures="+ nbHeures + ", nbMoteurs=" + nbMoteurs ;
  }
}
