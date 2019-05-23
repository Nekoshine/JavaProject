
/**
*
*/
public abstract class Aerien extends Vehicule {
  /**
  *
  */
  private int nbHeures;
  
  /**
  *
  */
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
  
  
  public Aerien(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int nbHeures, int nbMoteurs) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax);
    this.nbHeures=nbHeures;
    this.nbMoteurs=nbMoteurs;
  }
  
  public Aerien(){
    super();
  }
  
  @Override
  public String toString() {
    return super.toString() +", nbHeures="+ nbHeures + ", nbMoteurs=" + nbMoteurs ;
  }
}
