import java.util.Date;
/**
*
*/
public class Client {
  /**
  *
  */
  private String nom;
  
  /**
  *
  */
  private int numTel;
  
  /**
  *
  */
  private int nbKm;
  
  /**
  *
  */
  private int prixPrev;
  
  /**
  *
  */
  private Boolean reduction;
  
  public Client() {
    super();
  }
  
  public Client(String nom, int numTel,  int nbKm, int prixPrev, Boolean reduction) {
    super();
    this.nom = nom;
    this.numTel = numTel;
    this.nbKm = nbKm;
    this.prixPrev = prixPrev;
    this.reduction = reduction;
  }
  
  public String getNom() {
    return nom;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public int getNumTel() {
    return numTel;
  }
  
  public void setNumTel(int numTel) {
    this.numTel = numTel;
  }
  
  public int getNbKm() {
    return nbKm;
  }
  
  public void setNbKm(int nbKm) {
    this.nbKm = nbKm;
  }
  
  public int getPrixPrev() {
    return prixPrev;
  }
  
  public void setPrixPrev(int prixPrev) {
    this.prixPrev = prixPrev;
  }
  
  public Boolean getReduction() {
    return reduction;
  }
  
  public void setReduction(Boolean reduction) {
    this.reduction = reduction;
  }
  
  
  @Override
  public String toString() {
    return "Client [nom=" + nom + ", numTel=" + numTel + ", nbKm=" + nbKm + ", prixPrev=" + prixPrev + ", reduction=" + reduction + "]";
  }
}
