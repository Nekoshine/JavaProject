
/**
*
*/
public class Moto extends Terrestre {
  
  
  
  public Moto() {
    super();
  }
  
  public Moto(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km, double puissance) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,km,puissance);
  }
  
  
  @Override
  public String toString() {
    return "Moto: "+super.toString();
  }
}
