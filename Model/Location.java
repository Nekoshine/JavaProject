

import java.util.ArrayList;
import java.util.Date;
public class Location {
  
  private Date dateDebut;
  private Date dateFin;
  private Client client;
  private Vehicule vehicule;
  private float prixPrev;
  private int kmPrev;
  private int id;
  public Location() {
    super();
  }
  
  public Location(Date dateDebut, Date dateFin, Client client, Vehicule vehicule,int prixPrev, int kmPrev,int id) {
    super();
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.client = client;
    this.vehicule = vehicule;
    this.prixPrev = prixPrev;
    this.kmPrev = kmPrev;
    this.id=id;
  }
  public int getId(){
    return this.id;
  }
  public void setId(int id){
    this.id=id;
  }
  public Date getDateDebut() {
    return dateDebut;
  }
  
  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }
  
  public float getPrixPrev() {
    return prixPrev;
  }
  
  public void setPrixPrev(float prixPrev) {
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
