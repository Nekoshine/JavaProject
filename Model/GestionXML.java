import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.util.Date;
/**
* Cette classe permet de gérer les fichiers XML, que cela soit en écriture ou en lecture.
*/
public class GestionXML{
	/**
	* Cette procédure permet de supprimer un client en lui donnant ce dernier en parametre
	* @param c Client qui doit etre supprimé
	*/
	public static void deleteClient(Client c){
		int id=c.getId();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataClient.xml"));
			NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeL.getLength() ;i++ ) {
				if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element client = (Element)listeL.item(i);
					if(id==Integer.parseInt(client.getElementsByTagName("id").item(0).getTextContent())){
						client.getParentNode().removeChild(client);
					}
				}
			}
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataClient.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette procédure permet de supprimer un client en lui donnant ce dernier en parametre
	* @param v Véhicule qui doit etre supprimé
	*/
	public static void deleteVehicule(Vehicule v){
		int id = v.getId();
		try{
			if (v instanceof Moto){
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataMoto.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				for (int i=0;i<listeL.getLength() ;i++ ) {
					if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
						Element moto = (Element)listeL.item(i);
						if(id==Integer.parseInt(moto.getElementsByTagName("id").item(0).getTextContent())){
							moto.getParentNode().removeChild(moto);
						}
					}
				}
				DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
				Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
				optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
				StreamResult gentil = new StreamResult("dataMoto.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
				optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			}
			else  if (v instanceof Avion){
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataAvion.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				for (int i=0;i<listeL.getLength() ;i++ ) {
					if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
						Element avion = (Element)listeL.item(i);
						if(id==Integer.parseInt(avion.getElementsByTagName("id").item(0).getTextContent())){
							avion.getParentNode().removeChild(avion);
						}
					}
				}
				DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
				Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
				optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
				StreamResult gentil = new StreamResult("dataAvion.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
				optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			}
			else if (v instanceof Voiture) {
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataVoiture.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				for (int i=0;i<listeL.getLength() ;i++ ) {
					if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
						Element voiture = (Element)listeL.item(i);
						System.out.println(id+" "+ Integer.parseInt(voiture.getElementsByTagName("id").item(0).getTextContent()));
						if(id==Integer.parseInt(voiture.getElementsByTagName("id").item(0).getTextContent())){
							voiture.getParentNode().removeChild(voiture);
						}
					}
				}
				DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
				Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
				optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
				StreamResult gentil = new StreamResult("dataVoiture.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
				optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			}
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	
	/**
	* Cette fonction retourne le prochain ID du client qui va etre ajouté lors du prochain ajout.
	* @return le prochain id
	*/
	public static int getLastIDClient(){
		int id=0;
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataClient.xml"));
			NodeList listeC = doc.getElementsByTagName("element"); //On récupère chaque noeud
			
			Element node = (Element) listeC.item(listeC.getLength()-1);
			id=Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())+1;
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	* Cette fonction retourne le prochain ID de la location qui va etre ajoutée lors du prochain ajout.
	* @return le prochain id
	*/
	public static int getLastIDLoc(){
		int id=0;
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataLocation.xml"));
			NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
			
			Element node = (Element) listeL.item(listeL.getLength()-1);
			id=Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())+1;
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	* Cette fonction retourne le prochain ID du véhicule qui va etre ajoutée lors du prochain ajout.
	* @return le prochain id
	*/
	public static int getLastID(Vehicule v){ // récupère le dernier id de la liste de véhicule en fonction du type de ce dernier
		int id=0;
		try{
			if (v instanceof Moto){
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataMoto.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				
				Element node = (Element) listeL.item(listeL.getLength()-1);
				id=Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())+1;
			}
			else  if (v instanceof Avion){
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataAvion.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				
				Element node = (Element) listeL.item(listeL.getLength()-1);
				id=Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())+1;
			}
			else if (v instanceof Voiture) {
				DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder docb = docbf.newDocumentBuilder();
				Document doc = docb.parse(new File("dataVoiture.xml"));
				NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
				
				Element node = (Element) listeL.item(listeL.getLength()-1);
				id=Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())+1;
			}
		}
		catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return id;
	}
	
	/**
	* Quand un noeud à plusieurs fils, permet de récupérer le fils <name> que l'on cherche.
	* @param parent Noeud parent
	* @param name	Nom du noeud qui nous intéresse
	* @return un noeud si le nom est dans la liste des noms et retourne null sinon
	*/
	private static Node getChildName(Node parent, String name) {
		for (Node child=parent.getFirstChild();child!=null;child=child.getNextSibling()){
			if (name.equals(child.getNodeName()))			{
				return child;
			}
		}
		return null;
	}
	
	/**
	* Cette fonction va lire dans le fichier XML les informations sur les locations
	* @param vehicule valeur qui va correspondre au type de véhicule loué
	* @return Arraylist de locations
	*/
	public static ArrayList<Location> readXMLLocation(String vehicule){
		ArrayList<Location>  location =new ArrayList<Location>();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataLocation.xml"));
			NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeL.getLength() ;i++ ) {
				if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element node = (Element) listeL.item(i);
					Node child = getChildName(node,vehicule);
					if (child!=null && vehicule.equals("Voiture")){
						System.out.println("oucou");
						location.add(new Location(
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateDebut").item(0).getTextContent()),
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateFin").item(0).getTextContent()),
						new Client(
						node.getElementsByTagName("nom").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("numTel").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbKm").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("reduction").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						new Voiture(
						node.getElementsByTagName("marque").item(0).getTextContent(),
						node.getElementsByTagName("modele").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("km").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbPlace").item(0).getTextContent()),
						Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("kmPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
						
					}else if(child!=null && vehicule.equals("Moto")){
						location.add(new Location(
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateDebut").item(0).getTextContent()),
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateFin").item(0).getTextContent()),
						new Client(
						node.getElementsByTagName("nom").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("numTel").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbKm").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("reduction").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						new Moto(
						node.getElementsByTagName("marque").item(0).getTextContent(),
						node.getElementsByTagName("modele").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("km").item(0).getTextContent()),
						Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("kmPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
						
					}else if(child!=null && vehicule.equals("Avion")){
						location.add(new Location(
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateDebut").item(0).getTextContent()),
						new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateFin").item(0).getTextContent()),
						new Client(
						node.getElementsByTagName("nom").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("numTel").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbKm").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("reduction").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						new Avion(
						node.getElementsByTagName("marque").item(0).getTextContent(),
						node.getElementsByTagName("modele").item(0).getTextContent(),
						Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
						Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbHeures").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("nbMoteurs").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())),
						Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("kmPrev").item(0).getTextContent()),
						Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
					}
					
					System.out.println(location.get(i));
				}
			}
		}catch(ParseException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return location;
	}
	
	
	/**
	* Cette procédure va écrire dans le fichier XML les informations sur une location
	* @param l Location à ajouter dans le fichier
	*/
	public static void addLocation(Location l){
		int last=getLastIDLoc();
		
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataLocation.xml"));
			Node racine = doc.getFirstChild(); //On récupère la racine
			Element location = doc.createElement("element"); // On crée une nouvelle location
			
			Element dateDebut = doc.createElement("dateDebut");
			DateFormat date= new SimpleDateFormat("dd/MM/yyyy");
			String dateD = date.format(l.getDateDebut());
			dateDebut.appendChild(doc.createTextNode(dateD));
			location.appendChild(dateDebut);
			Element dateFin = doc.createElement("dateFin");
			String dateF = date.format(l.getDateFin());
			dateFin.appendChild(doc.createTextNode(dateF));
			location.appendChild(dateFin);
			Element client = doc.createElement("Client");
			
			Element nom = doc.createElement("nom");
			nom.appendChild(doc.createTextNode(l.getClient().getNom()));
			client.appendChild(nom);
			Element numTel = doc.createElement("numTel");
			numTel.appendChild(doc.createTextNode(Integer.toString(l.getClient().getNumTel())));
			client.appendChild(numTel);
			Element nbKm = doc.createElement("nbKm");
			nbKm.appendChild(doc.createTextNode(Integer.toString(l.getClient().getNbKm())));
			client.appendChild(nbKm);
			Element prixPrev = doc.createElement("prixPrev");
			prixPrev.appendChild(doc.createTextNode(Float.toString(l.getClient().getPrixPrev())));
			client.appendChild(prixPrev);
			Element reduction = doc.createElement("reduction");
			reduction.appendChild(doc.createTextNode(Boolean.toString(l.getClient().getReduction())));
			client.appendChild(reduction);
			location.appendChild(client);
			if ( l.getVehicule() instanceof Moto){
				Element vehicule = doc.createElement("Moto");
				Moto m = (Moto) l.getVehicule();
				m.setEtat(true);
				Element etat = doc.createElement("etat"); //On crée une spécification du nouvel avion
				etat.appendChild(doc.createTextNode(Boolean.toString(m.getEtat()))); // On ajoute a la spec sa valeur
				vehicule.appendChild(etat); //On ajoute chaque champ a l'avion
				Element km = doc.createElement("km");
				km.appendChild(doc.createTextNode(Integer.toString(m.getKm())));
				vehicule.appendChild(km);
				Element marque = doc.createElement("marque");
				marque.appendChild(doc.createTextNode(m.getMarque()));
				vehicule.appendChild(marque);
				Element modele = doc.createElement("modele");
				modele.appendChild(doc.createTextNode(m.getModele()));
				vehicule.appendChild(modele);
				Element prixLocation = doc.createElement("prixLocation");
				prixLocation.appendChild(doc.createTextNode(Integer.toString(m.getPrixLocation())));
				vehicule.appendChild(prixLocation);
				Element puissance = doc.createElement("puissance");
				puissance.appendChild(doc.createTextNode(Double.toString(m.getPuissance())));
				vehicule.appendChild(puissance);
				Element vitesseMax = doc.createElement("vitesseMax");
				vitesseMax.appendChild(doc.createTextNode(Integer.toString(m.getVitesseMax())));
				vehicule.appendChild(vitesseMax);
				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(Integer.toString(m.getId())));
				vehicule.appendChild(id);
				deleteVehicule(m);
				addMoto(m);
				location.appendChild(vehicule);
			}else if ( l.getVehicule() instanceof Voiture){
				Element vehicule = doc.createElement("Voiture");
				Voiture v = (Voiture) l.getVehicule();
				Element km = doc.createElement("km");
				v.setEtat(true);
				Element etat = doc.createElement("etat"); //On crée une spécification du nouvel avion
				etat.appendChild(doc.createTextNode(Boolean.toString(v.getEtat()))); // On ajoute a la spec sa valeur
				vehicule.appendChild(etat); //On ajoute chaque champ a l'avion
				km.appendChild(doc.createTextNode(Integer.toString(v.getKm())));
				vehicule.appendChild(km);
				Element marque = doc.createElement("marque");
				marque.appendChild(doc.createTextNode(v.getMarque()));
				vehicule.appendChild(marque);
				Element modele = doc.createElement("modele");
				modele.appendChild(doc.createTextNode(v.getModele()));
				vehicule.appendChild(modele);
				Element nbPlace = doc.createElement("nbPlace");
				nbPlace.appendChild(doc.createTextNode(Integer.toString(v.getNbPlace())));
				vehicule.appendChild(nbPlace);
				Element prixLocation = doc.createElement("prixLocation");
				prixLocation.appendChild(doc.createTextNode(Integer.toString(v.getPrixLocation())));
				vehicule.appendChild(prixLocation);
				Element puissance = doc.createElement("puissance");
				puissance.appendChild(doc.createTextNode(Double.toString(v.getPuissance())));
				vehicule.appendChild(puissance);
				Element vitesseMax = doc.createElement("vitesseMax");
				vitesseMax.appendChild(doc.createTextNode(Integer.toString(v.getVitesseMax())));
				vehicule.appendChild(vitesseMax);
				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(Integer.toString(v.getId())));
				vehicule.appendChild(id);
				deleteVehicule(v);
				addVoiture(v);
				location.appendChild(vehicule);
			}else if ( l.getVehicule() instanceof Avion){
				Element vehicule = doc.createElement("Avion");
				Avion a = (Avion) l.getVehicule();
				a.setEtat(true);
				Element etat = doc.createElement("etat"); //On crée une spécification du nouvel avion
				etat.appendChild(doc.createTextNode(Boolean.toString(a.getEtat()))); // On ajoute a la spec sa valeur
				vehicule.appendChild(etat); //On ajoute chaque champ a l'avion
				Element nbMoteurs = doc.createElement("nbMoteurs");
				nbMoteurs.appendChild(doc.createTextNode(Integer.toString(a.getNbMoteurs())));
				vehicule.appendChild(nbMoteurs);
				Element marque = doc.createElement("marque");
				marque.appendChild(doc.createTextNode(a.getMarque()));
				vehicule.appendChild(marque);
				Element modele = doc.createElement("modele");
				modele.appendChild(doc.createTextNode(a.getModele()));
				vehicule.appendChild(modele);
				Element nbHeures = doc.createElement("nbHeures");
				nbHeures.appendChild(doc.createTextNode(Integer.toString(a.getNbHeures())));
				vehicule.appendChild(nbHeures);
				Element prixLocation = doc.createElement("prixLocation");
				prixLocation.appendChild(doc.createTextNode(Integer.toString(a.getPrixLocation())));
				vehicule.appendChild(prixLocation);
				Element vitesseMax = doc.createElement("vitesseMax");
				vitesseMax.appendChild(doc.createTextNode(Integer.toString(a.getVitesseMax())));
				vehicule.appendChild(vitesseMax);
				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(Integer.toString(a.getId())));
				vehicule.appendChild(id);
				deleteVehicule(a);
				addAvion(a);
				location.appendChild(vehicule);
			}
			
			racine.appendChild(location); // On ajoute la voiture a la racine
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataVoiture.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette fonction va écrire dans le fichier XML les informations sur une voiture
	* @param v Voiture à ajouter dans le fichier
	*/
	public static void addVoiture(Voiture v){
		int last=getLastID(v);
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataVoiture.xml"));
			Node racine = doc.getFirstChild(); //On récupère la racine
			Element voiture = doc.createElement("element"); // On crée une nouvelle voiture
			Element etat = doc.createElement("etat"); //On crée une spécification de la nouvelle voiture
			etat.appendChild(doc.createTextNode(Boolean.toString(v.getEtat()))); // On ajoute a la spec sa valeur
			voiture.appendChild(etat); //On ajoute chaque champ a la voiture
			Element km = doc.createElement("km");
			km.appendChild(doc.createTextNode(Integer.toString(v.getKm())));
			voiture.appendChild(km);
			Element marque = doc.createElement("marque");
			marque.appendChild(doc.createTextNode(v.getMarque()));
			voiture.appendChild(marque);
			Element modele = doc.createElement("modele");
			modele.appendChild(doc.createTextNode(v.getModele()));
			voiture.appendChild(modele);
			Element nbPlace = doc.createElement("nbPlace");
			nbPlace.appendChild(doc.createTextNode(Integer.toString(v.getNbPlace())));
			voiture.appendChild(nbPlace);
			Element prixLocation = doc.createElement("prixLocation");
			prixLocation.appendChild(doc.createTextNode(Integer.toString(v.getPrixLocation())));
			voiture.appendChild(prixLocation);
			Element puissance = doc.createElement("puissance");
			puissance.appendChild(doc.createTextNode(Double.toString(v.getPuissance())));
			voiture.appendChild(puissance);
			Element vitesseMax = doc.createElement("vitesseMax");
			vitesseMax.appendChild(doc.createTextNode(Integer.toString(v.getVitesseMax())));
			voiture.appendChild(vitesseMax);
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(Integer.toString(last)));
			voiture.appendChild(id);
			
			racine.appendChild(voiture); // On ajoute la voiture a la racine
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataVoiture.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette procédure va écrire dans le fichier XML les informations sur une moto
	* @param m Moto à ajouter dans le fichier
	*/
	public static void addMoto(Moto m){
		int last=getLastID(m);
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataMoto.xml"));
			Node racine = doc.getFirstChild(); //On récupère la racine
			Element moto = doc.createElement("element"); // On crée une nouvelle voiture
			Element etat = doc.createElement("etat"); //On crée une spécification de la nouvelle voiture
			etat.appendChild(doc.createTextNode(Boolean.toString(m.getEtat()))); // On ajoute a la spec sa valeur
			moto.appendChild(etat); //On ajoute chaque champ a la voiture
			Element km = doc.createElement("km");
			km.appendChild(doc.createTextNode(Integer.toString(m.getKm())));
			moto.appendChild(km);
			Element marque = doc.createElement("marque");
			marque.appendChild(doc.createTextNode(m.getMarque()));
			moto.appendChild(marque);
			Element modele = doc.createElement("modele");
			modele.appendChild(doc.createTextNode(m.getModele()));
			moto.appendChild(modele);
			Element prixLocation = doc.createElement("prixLocation");
			prixLocation.appendChild(doc.createTextNode(Integer.toString(m.getPrixLocation())));
			moto.appendChild(prixLocation);
			Element puissance = doc.createElement("puissance");
			puissance.appendChild(doc.createTextNode(Double.toString(m.getPuissance())));
			moto.appendChild(puissance);
			Element vitesseMax = doc.createElement("vitesseMax");
			vitesseMax.appendChild(doc.createTextNode(Integer.toString(m.getVitesseMax())));
			moto.appendChild(vitesseMax);
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(Integer.toString(last)));
			moto.appendChild(id);
			racine.appendChild(moto); // On ajoute la voiture a la racine
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataMoto.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette procédure va écrire dans le fichier XML les informations sur un avion
	* @param a Avion à ajouter dans le fichier
	*/
	public static void addAvion(Avion a){
		int last=getLastID(a);
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataAvion.xml"));
			Node racine = doc.getFirstChild(); //On récupère la racine
			Element avion = doc.createElement("element"); // On crée un nouvel avion
			Element etat = doc.createElement("etat"); //On crée une spécification du nouvel avion
			etat.appendChild(doc.createTextNode(Boolean.toString(a.getEtat()))); // On ajoute a la spec sa valeur
			avion.appendChild(etat); //On ajoute chaque champ a l'avion
			Element nbMoteurs = doc.createElement("nbMoteurs");
			nbMoteurs.appendChild(doc.createTextNode(Integer.toString(a.getNbMoteurs())));
			avion.appendChild(nbMoteurs);
			Element marque = doc.createElement("marque");
			marque.appendChild(doc.createTextNode(a.getMarque()));
			avion.appendChild(marque);
			Element modele = doc.createElement("modele");
			modele.appendChild(doc.createTextNode(a.getModele()));
			avion.appendChild(modele);
			Element nbHeures = doc.createElement("nbHeures");
			nbHeures.appendChild(doc.createTextNode(Integer.toString(a.getNbHeures())));
			avion.appendChild(nbHeures);
			Element prixLocation = doc.createElement("prixLocation");
			prixLocation.appendChild(doc.createTextNode(Integer.toString(a.getPrixLocation())));
			avion.appendChild(prixLocation);
			Element vitesseMax = doc.createElement("vitesseMax");
			vitesseMax.appendChild(doc.createTextNode(Integer.toString(a.getVitesseMax())));
			avion.appendChild(vitesseMax);
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(Integer.toString(last)));
			avion.appendChild(id);
			racine.appendChild(avion); // On ajoute l' avion a la racine
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataAvion.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette procédure va écrire dans le fichier XML les informations sur un client
	* @param c Client à ajouter dans le fichier
	*/
	public static void addClient(Client c){
		int last=getLastIDClient();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataClient.xml"));
			Node racine = doc.getFirstChild(); //On récupère la racine
			Element client = doc.createElement("element"); // On crée une nouvelle voiture
			Element nom = doc.createElement("nom"); //On crée une spécification de la nouvelle voiture
			nom.appendChild(doc.createTextNode(c.getNom())); // On ajoute a la spec sa valeur
			client.appendChild(nom); //On ajoute chaque champ a la voiture
			Element numTel = doc.createElement("numTel");
			numTel.appendChild(doc.createTextNode(Integer.toString(c.getNumTel())));
			client.appendChild(numTel);
			Element nbKm = doc.createElement("nbKm");
			nbKm.appendChild(doc.createTextNode(Integer.toString(c.getNbKm())));
			client.appendChild(nbKm);
			Element prixPrev = doc.createElement("prixPrev");
			prixPrev.appendChild(doc.createTextNode(Float.toString(c.getPrixPrev())));
			client.appendChild(prixPrev);
			Element reduction = doc.createElement("reduction");
			reduction.appendChild(doc.createTextNode(Boolean.toString(c.getReduction())));
			client.appendChild(reduction);
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode(Integer.toString(last)));
			client.appendChild(id);
			racine.appendChild(client); // On ajoute la voiture a la racine
			DOMSource robot = new DOMSource(doc); // On donne le document xml comme source pour garder les anciennes informations
			Transformer optimus = TransformerFactory.newInstance().newTransformer(); // On crée un transformer pour pouvoir passer du fichier avec les informations de base a un fichier avec de nouvelles informations
			optimus.setOutputProperty(OutputKeys.INDENT,"yes"); //On spécifie que la modification sera indentée
			StreamResult gentil = new StreamResult("dataClient.xml"); // On donne le fichier qui servira a recevoir la transformation réalisée
			optimus.transform(robot, gentil);// On transforme la source avec les informations données.
			
		}catch (TransformerConfigurationException e){
			e.printStackTrace();
		}catch (TransformerException e){
			e.printStackTrace();
			
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	* Cette fonction va lire dans le fichier XML les informations sur les voitures
	* @return Arraylist de voitures
	*/
	public static ArrayList<Voiture> readXMLVoiture(){
		ArrayList<Voiture>  voitures=new ArrayList<Voiture>();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataVoiture.xml"));
			NodeList listeV = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeV.getLength() ;i++ ) {
				if(listeV.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element node = (Element) listeV.item(i);
					voitures.add(new Voiture(
					node.getElementsByTagName("marque").item(0).getTextContent(),
					node.getElementsByTagName("modele").item(0).getTextContent(),
					Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
					Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("km").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("nbPlace").item(0).getTextContent()),
					Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
					System.out.println(voitures.get(i));
				}
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return voitures;
	}
	/**
	* Cette fonction va lire dans le fichier XML les informations sur les motos
	* @return Arraylist de motos
	*/
	public static ArrayList<Moto> readXMLMoto(){
		ArrayList<Moto> motos=new ArrayList<Moto>();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataMoto.xml"));
			NodeList listeM = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeM.getLength() ;i++ ) {
				if(listeM.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element node = (Element) listeM.item(i);
					motos.add(new Moto(
					node.getElementsByTagName("marque").item(0).getTextContent(),
					node.getElementsByTagName("modele").item(0).getTextContent(),
					Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
					Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("km").item(0).getTextContent()),
					Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
					System.out.println(motos.get(i));
				}
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return motos;
	}
	/**
	* Cette fonction va lire dans le fichier XML les informations sur les avions
	* @return Arraylist de avions
	*/
	public static ArrayList<Avion> readXMLAvion(){
		ArrayList<Avion>  avions=new ArrayList<Avion>();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataAvion.xml"));
			NodeList listeA = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeA.getLength() ;i++ ) {
				if(listeA.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element node = (Element) listeA.item(i);
					avions.add(new Avion(
					node.getElementsByTagName("marque").item(0).getTextContent(),
					node.getElementsByTagName("modele").item(0).getTextContent(),
					Integer.parseInt(node.getElementsByTagName("prixLocation").item(0).getTextContent()),
					Boolean.parseBoolean(node.getElementsByTagName("etat").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("vitesseMax").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("nbHeures").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("nbMoteurs").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
					System.out.println(avions.get(i));
				}
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return avions;
	}
	
	/**
	* Cette fonction va lire dans le fichier XML les informations sur les clients
	* @return Arraylist de clients
	*/
	public static ArrayList<Client> readXMLClient(){
		ArrayList<Client>  clients=new ArrayList<Client>();
		try{
			DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder docb = docbf.newDocumentBuilder();
			Document doc = docb.parse(new File("dataClient.xml"));
			NodeList listeC = doc.getElementsByTagName("element"); //On récupère chaque noeud
			for (int i=0;i<listeC.getLength() ;i++ ) {
				if(listeC.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
					Element node = (Element) listeC.item(i);
					clients.add(new Client(
					node.getElementsByTagName("nom").item(0).getTextContent(),
					Integer.parseInt(node.getElementsByTagName("numTel").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("nbKm").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
					Boolean.parseBoolean(node.getElementsByTagName("reduction").item(0).getTextContent()),
					Integer.parseInt(node.getElementsByTagName("id").item(0).getTextContent())));
					System.out.println(clients.get(i));
				}
			}
		}catch(ParserConfigurationException e){
			e.printStackTrace();
		}catch(SAXException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return clients;
	}
}
