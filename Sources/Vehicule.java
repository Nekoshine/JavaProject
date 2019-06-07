
/**
* Classe abstraite qui définit l'objet véhicule
*/
public abstract class Vehicule {
  /**
  *Champ qui contient la marque du véhicule
  */
  private String marque;
  
  /**
  *Champ qui contient le modele du véhicule
  */
  private String modele;
  
  /**
  *Champ qui contient le prix de location du véhicule
  */
  private int prixLocation;
  
  /**
  *Champ qui contient l'état du véhicule, c'est a dire si il est loué ou non
  */
  private Boolean etat;
  
  /**
  *Champ qui contient la vitesse max du véhicule
  */
  private int vitesseMax;
  /**
  *Champ qui contient l'id du véhicule
  */
  private int id;
  /**
  * Constructeur par défaut
  */
  public Vehicule() {
    super();
  }
  /**
  * Constructeur d'un véhicule qui va initialiser les champs en parametre
  * @param marque       String
  * @param modele       String
  * @param prixLocation int
  * @param etat         Boolean
  * @param vitesseMax   int
  * @param id           int
  */
  public Vehicule(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int id) {
    super();
    this.marque = marque;
    this.modele = modele;
    this.prixLocation = prixLocation;
    this.etat = etat;
    this.vitesseMax = vitesseMax;
    this.id = id;
  }
  
  /**
  * Getter de l'id
  * @return l'id d'un véhicule
  */
  public int getId(){
    return id;
  }
  
  /**
  * Setter de l'id
  * @param id d'un véhicule
  */
  public void setId(int id){
    this.id=id;
  }
  /**
  * Getter de la marque
  * @return la marque d'un véhicule
  */
  public String getMarque() {
    return marque;
  }
  /**
  * Setter de la marque
  * @param marque d'un véhicule
  */
  public void setMarque(String marque) {
    this.marque = marque;
  }
  /**
  * Getter du modele
  * @return le modele d'un véhicule
  */
  public String getModele() {
    return modele;
  }
  /**
  * Setter du modele
  * @param modele d'un véhicule
  */
  public void setModele(String modele) {
    this.modele = modele;
  }
  /**
  * Getter du prix de location
  * @return le prix de location d'un véhicule
  */
  public int getPrixLocation() {
    return prixLocation;
  }
  /**
  * Setter du prix de location
  * @param prixLocation d'un véhicule
  */
  public void setPrixLocation(int prixLocation) {
    this.prixLocation = prixLocation;
  }
  /**
  * Getter de l'etat
  * @return l'etat d'un véhicule
  */
  public Boolean getEtat() {
    return etat;
  }
  /**
  * Setter de l'etat
  * @param etat d'un véhicule
  */
  public void setEtat(Boolean etat) {
    this.etat = etat;
  }
  /**
  * Getter de la vitesse max
  * @return la vitesse max d'un véhicule
  */
  public int getVitesseMax() {
    return vitesseMax;
  }
  /**
  * Setter de la vitesse max
  * @param vitesseMax d'un véhicule
  */
  public void setVitesseMax(int vitesseMax) {
    this.vitesseMax = vitesseMax;
  }
  /**
  * Fonction qui retourne la chaine de caractere comprenant les informations d'un véhicule
  * @return Chaine de caractere comprenant les informations
  */
  @Override
  public String toString() {
    return "marque=" + marque + ", modele=" + modele + ", prixLocation=" + prixLocation + ", etat=" + etat + ", vitesseMax=" + vitesseMax ;
  }
}
