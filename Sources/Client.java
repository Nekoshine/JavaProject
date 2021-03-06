import java.util.Date;
/**
* Classe qui définit les attributs d'un client
*/
public class Client {
	private String nom;
	private int numTel;
	private int id;
	
	/**
	* Constructeur par défaut
	*/
	public Client() {
		super();
	}
	/**
	* Constructeur qui initialiser les champs du client
	* @param nom       nom du client
	* @param numTel    numéro de téléphone du client
	* @param id        id du client
	*/
	public Client(String nom, int numTel,  int id) {
		super();
		this.nom = nom;
		this.numTel = numTel;
		this.id=id;
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
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
	
	
	
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", numTel=" + numTel + "]";
	}
	
	
}
