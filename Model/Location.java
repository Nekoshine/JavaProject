

import java.util.ArrayList;
import java.util.Date;
public class Location {
  
  private Date dateDebut;
  private Date dateFin;
  private Client client;
  private Vehicule vehicule;
  private int prixPrev;
  private int kmPrev;
  //UN VEHICULE
  public Location() {
    super();
  }
  
  public Location(Date dateDebut, Date dateFin, Client client, Vehicule vehicule,int prixPrev, int kmPrev) {
    super();
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.client = client;
    this.vehicule = vehicule;
    this.prixPrev = prixPrev;
    this.kmPrev = kmPrev;
  }
  
  public Date getDateDebut() {
    return dateDebut;
  }
  
  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }
  
  public int getPrixPrev() {
    return prixPrev;
  }
  
  public void setPrixPrev(int prixPrev) {
    this.prixPrev = prixPrev;
  }
  public int getKmPrev() {
    return kmPrev;
  }
  
  public void setKmPrev(int kmPrev) {
    this.kmPrev = kmPrev;
  }
  
  public Date getDateFin() {
    return dateFin;
  }
  
  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }
  
  public Client getClient() {
    return client;
  }
  
  public void setClient(Client client) {
    this.client = client;
  }
  
  public Vehicule getVehicule() {
    return vehicule;
  }
  
  public void setVehicule(Vehicule vehicule) {
    this.vehicule = vehicule;
  }
  
  @Override
  public String toString() {
    return "Location [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", client=" + client + ", vehicule=" + vehicule + "]";
  }
}
