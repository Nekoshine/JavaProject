
/**
*
*/
public class Moto extends Terrestre {
  
  
  
  public Moto() {
    super();
  }
  
  public Moto(String marque, String modele, int prixLocation, Boolean etat, int vitesseMax,int km, double puissance,int id) {
    super(marque,  modele,  prixLocation,  etat,  vitesseMax,km,puissance,id);
  }
  
  
  @Override
  public String toString() {
    return "Moto: "+super.toString();
  }
}
