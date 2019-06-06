
/**
* Classe abstraite qui définit un véhicule de type terrestre
*/
public abstract class Terrestre extends Vehicule {
  /**
  *Champ qui contient le nombre de km du véhicule terrestre
  */
  private int km;
  
  /**
  *Champ qui contient la puissance du véhicule terrestre
  */
  private double puissance;
  
  /**
  * Constructeur par défaut
  */
  public Terrestre() {
    super();
  }
  /**
  * Constructeur d'un véhicule terrestre qui va initialiser les champs et appeler le Constructeur de l'objet véhicule
  * @param marque       String
  * @param modele       String
  * @param prixLocation int
  * @param etat         Boolean
  * @param vitesseMax   int
  * @param km           int
  * @param puissance    int
  * @param id           int
  */
  public Terrestre(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km ,double puissance,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,id);
    this.km = km;
    this.puissance = puissance;
  }
  /**
  * Getter du nombre de km
  * @return le nombre de km
  */
  public int getKm() {
    return km;
  }
  /**
  * Setter du nombre de km
  * @param km nouveau nombre de km
  */
  public void setKm(int km) {
    this.km = km;
  }
  /**
  * Getter de la puissance
  * @return la puissance
  */
  public double getPuissance() {
    return puissance;
  }
  /**
  * Setter de la puissance
  * @param puissance nouvelle puissance
  */
  public void setPuissance(double puissance) {
    this.puissance = puissance;
  }
  
  /**
  * Fonction qui retourne la chaine de caractere comprenant les informations d'un véhicule terrestre
  * @return Chaine de caractere comprenant les informations
  */
  @Override
  public String toString() {
    return super.toString() +", km=" + km + ", puissance=" + puissance ;
  }
}
