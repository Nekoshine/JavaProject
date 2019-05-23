
import java.util.*;

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
  
  public Terrestre(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km ,double puissance) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax);
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
