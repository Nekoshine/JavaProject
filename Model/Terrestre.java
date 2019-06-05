
/**
*
*/
public abstract class Terrestre extends Vehicule {
  /**
  *
  */
  private int km;
  
  /**
  *
  */
  private double puissance;
  
  
  public Terrestre() {
    super();
  }
  
  public Terrestre(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km ,double puissance,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,id);
    this.km = km;
    this.puissance = puissance;
  }
  
  public int getKm() {
    return km;
  }
  
  public void setKm(int km) {
    this.km = km;
  }
  
  public double getPuissance() {
    return puissance;
  }
  
  public void setPuissance(double puissance) {
    this.puissance = puissance;
  }
  
  
  @Override
  public String toString() {
    return super.toString() +", km=" + km + ", puissance=" + puissance ;
  }
}
