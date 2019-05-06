
import java.util.*;

/**
 *
 */
public class Avion extends Vehicule {
    /**
     *
     */
    private int nbHeures;

    /**
     *
     */
    private int nbMoteurs;


	public Avion() {
		super();
	}

	public Avion(int nbHeures, int nbMoteurs) {
		super();
		this.nbHeures = nbHeures;
		this.nbMoteurs = nbMoteurs;
	}

	@Override
	public String toString() {
		return "Avion [nbHeures=" + nbHeures + ", nbMoteurs=" + nbMoteurs + "]";
	}

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}

	public int getNbMoteurs() {
		return nbMoteurs;
	}

	public void setNbMoteurs(int nbMoteurs) {
		this.nbMoteurs = nbMoteurs;
	}
}
