

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
	private boolean reduc;
	/**
	* Constructeur par défaut
	*/
	public Location() {
		super();
	}
	/**
	* [Location description]
	* @param dateDebut date de début de la location
	* @param dateFin   date de début de la location
	* @param client    client concerné par la location
	* @param vehicule  véhicule concerné par la location
	* @param prixPrev  prix previsionnel que paiera le client
	* @param kmPrev    km previsionnels que le client effectuera
	* @param id        id de la location
	* @param reduc 		reduction sur la location
	*/
	public Location(Date dateDebut, Date dateFin, Client client, Vehicule vehicule,float prixPrev, int kmPrev,int id,boolean reduc) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.client = client;
		this.vehicule = vehicule;
		this.prixPrev = prixPrev;
		this.kmPrev = kmPrev;
		this.id=id;
		this.reduc=reduc;
	}
	
	public boolean isReduc() {
		return reduc;
	}
	public void setReduc(boolean reduc) {
		this.reduc = reduc;
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
		return "Location [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", client=" + client + ", vehicule="
		+ vehicule + ", prixPrev=" + prixPrev + ", kmPrev=" + kmPrev + ", id=" + id + ", reduc=" + reduc + "]";
	}
}
