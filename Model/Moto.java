
import java.util.*;

/**
 *
 */
public class Moto extends Vehicule {
    /**
     *
     */
    private int km;

    /**
     *
     */
    private int puissance;


	public Moto() {
		super();
	}

	public Moto(int km, int puissance) {
		super();
		this.km = km;
		this.puissance = puissance;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Moto [km=" + km + ", puissance=" + puissance + "]";
	}
}
