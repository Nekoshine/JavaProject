
import java.util.*;

/**
 *
 */
public class Voiture extends Vehicule {
      /**
     *
     */
    private int km;

    /**
     *
     */
    private int nbPlace;

    /**
     *
     */
    private int puissance;


	public Voiture() {
		super();
	}

	public Voiture(int km, int nbPlace, int puissance) {
		super();
		this.km = km;
		this.nbPlace = nbPlace;
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Voiture [km=" + km + ", nbPlace=" + nbPlace + ", puissance=" + puissance + "]";
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}


}
