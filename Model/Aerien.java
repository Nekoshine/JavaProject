
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
  * @param marque       marque d'un avion
  * @param modele       modele de l'avion
  * @param prixLocation prix de location de l'avion
  * @param etat         etat de l'avion
  * @param vitesseMax  vitesse maximale de l'avion
  * @param nbHeures   nombre d'heures de vol de l'avion
  * @param nbMoteurs    nombre de moteurs de vol de l'avion
  * @param id           id de l'avion
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
