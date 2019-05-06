
import java.util.*;

/**
 *
 */
public class Vehicule {
    /**
     *
     */
    private String marque;

    /**
     *
     */
    private String modele;

    /**
     *
     */
    private int prixLocation;

    /**
     *
     */
    private Boolean Etat;

    /**
     *
     */
    private int vitesseMax;



	public Vehicule() {
		super();
	}

	public Vehicule(String marque, String modele, int prixLocation, Boolean Etat, int vitesseMax) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.prixLocation = prixLocation;
		this.Etat = Etat;
		this.vitesseMax = vitesseMax;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getPrixLocation() {
		return prixLocation;
	}

	public void setPrixLocation(int prixLocation) {
		this.prixLocation = prixLocation;
	}

	public Boolean getEtat() {
		return Etat;
	}

	public void setEtat(Boolean Etat) {
		this.Etat = Etat;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", modele=" + modele + ", prixLocation=" + prixLocation + ", Etat=" + Etat + ", vitesseMax=" + vitesseMax + "]";
	}
}
