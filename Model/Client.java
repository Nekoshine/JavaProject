
import java.util.*;

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
    private Date dateDebut;

    /**
     *
     */
    private Date dateFin;

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

	public Client(String nom, int numTel, Date dateDebut, Date dateFin, int nbKm, int prixPrev, Boolean reduction) {
		super();
		this.nom = nom;
		this.numTel = numTel;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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
		return "Client [nom=" + nom + ", numTel=" + numTel + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbKm=" + nbKm + ", prixPrev=" + prixPrev + ", reduction=" + reduction + "]";
	}
}
