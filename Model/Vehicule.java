
/**
*
*/
public abstract class Vehicule {
  /**
  *
  */
  private String marque;
  
  /**
  *
  */
  private String modele;
  
  /**
  *
  */
  private int prixLocation;
  
  /**
  *
  */
  private Boolean etat;
  
  /**
  *
  */
  private int vitesseMax;
  
  
  
  public Vehicule() {
    super();
  }
  
  public Vehicule(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax) {
    super();
    this.marque = marque;
    this.modele = modele;
    this.prixLocation = prixLocation;
    this.etat = etat;
    this.vitesseMax = vitesseMax;
  }
  
  public String getMarque() {
    return marque;
  }
  
  public void setMarque(String marque) {
    this.marque = marque;
  }
  
  public String getModele() {
    return modele;
  }
  
  public void setModele(String modele) {
    this.modele = modele;
  }
  
  public int getPrixLocation() {
    return prixLocation;
  }
  
  public void setPrixLocation(int prixLocation) {
    this.prixLocation = prixLocation;
  }
  
  public Boolean getEtat() {
    return etat;
  }
  
  public void setEtat(Boolean etat) {
    this.etat = etat;
  }
  
  public int getVitesseMax() {
    return vitesseMax;
  }
  
  public void setVitesseMax(int vitesseMax) {
    this.vitesseMax = vitesseMax;
  }
  
  @Override
  public String toString() {
    return "marque=" + marque + ", modele=" + modele + ", prixLocation=" + prixLocation + ", etat=" + etat + ", vitesseMax=" + vitesseMax ;
  }
}
