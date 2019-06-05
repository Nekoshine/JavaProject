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

public class GestionXML{
  
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
  
  
  
  
  public static int getLastIDClient(){
    int id=0;
    try{
      DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder docb = docbf.newDocumentBuilder();
      Document doc = docb.parse(new File("dataClient.xml"));
      NodeList listeC = doc.getElementsByTagName("element"); //On récupère chaque noeud
      id=listeC.getLength();
    }catch(ParserConfigurationException e){
      e.printStackTrace();
    }catch(SAXException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
    return id;
  }
  
  public static int getLastIDLoc(){
    int id=0;
    try{
      DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder docb = docbf.newDocumentBuilder();
      Document doc = docb.parse(new File("dataLocation.xml"));
      NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
      id=listeL.getLength();
    }catch(ParserConfigurationException e){
      e.printStackTrace();
    }catch(SAXException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
    return id;
  }
  public static int getLastID(Vehicule v){ // récupère le dernier id de la liste de véhicule en fonction du type de ce dernier
    int id=0;
    try{
      if (v instanceof Moto){
        DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docb = docbf.newDocumentBuilder();
        Document doc = docb.parse(new File("dataMoto.xml"));
        NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
        id=listeL.getLength();
      }
      else  if (v instanceof Avion){
        DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docb = docbf.newDocumentBuilder();
        Document doc = docb.parse(new File("dataAvion.xml"));
        NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
        id=listeL.getLength();
      }
      else if (v instanceof Voiture) {
        DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docb = docbf.newDocumentBuilder();
        Document doc = docb.parse(new File("dataVoiture.xml"));
        NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
        id=listeL.getLength();
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
  
  public static void addVehicules(Vehicule v){
    if (v instanceof Moto) addMoto((Moto)v);
    else  if (v instanceof Avion) addAvion((Avion)v);
    else if (v instanceof Voiture) addVoiture((Voiture)v);
    
  }
  
  
  public static ArrayList<Location> readXMLLocation(){
    ArrayList<Location>  location =new ArrayList<Location>();
    try{
      DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder docb = docbf.newDocumentBuilder();
      Document doc = docb.parse(new File("dataVoiture.xml"));
      NodeList listeL = doc.getElementsByTagName("element"); //On récupère chaque noeud
      for (int i=0;i<listeL.getLength() ;i++ ) {
        if(listeL.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
          Element node = (Element) listeL.item(i);
          for (Node child = node.getFirstChild(); child != null; child.getNextSibling()){
            
            if (child.getNodeName().equals("Voiture")){
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
              
            }else if(child.getNodeName().equals("Moto")){
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
              
            }else if(child.getNodeName().equals("Avion")){
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
  
  
  
  public static void addLocation(Location l){
    int last=getLastIDLoc();
    Vehicule a = null;
    if ( l.getVehicule() instanceof Moto){
      a = (Moto) l.getVehicule();
      // updateMoto(a); On passe le booleén de location de false a true
    }else if ( l.getVehicule() instanceof Voiture){
      a = (Voiture) l.getVehicule();
      // updateVoiture(a); On passe le booleén de location de false a true
    }else if ( l.getVehicule() instanceof Avion){
      a = (Avion) l.getVehicule();
      // updateAvion(a); On passe le booleén de location de false a true
    }
    
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
      prixPrev.appendChild(doc.createTextNode(Integer.toString(l.getClient().getPrixPrev())));
      client.appendChild(prixPrev);
      Element reduction = doc.createElement("reduction");
      reduction.appendChild(doc.createTextNode(Boolean.toString(l.getClient().getReduction())));
      client.appendChild(reduction);
      location.appendChild(client);
      Element vehicule = doc.createElement("Vehicule");
      Element marque = doc.createElement("marque");
      marque.appendChild(doc.createTextNode(a.getMarque()));
      vehicule.appendChild(marque);
      Element modele = doc.createElement("modele");
      modele.appendChild(doc.createTextNode(a.getModele()));
      vehicule.appendChild(modele);
      
      location.appendChild(vehicule);
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
  
  private static void addVoiture(Voiture v){
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
  
  private static void addMoto(Moto m){
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
  
  private static void addAvion(Avion a){
    int last=getLastID(a);
    try{
      DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder docb = docbf.newDocumentBuilder();
      Document doc = docb.parse(new File("dataAvion.xml"));
      Node racine = doc.getFirstChild(); //On récupère la racine
      Element avion = doc.createElement("element"); // On crée une nouvelle voiture
      Element etat = doc.createElement("etat"); //On crée une spécification de la nouvelle voiture
      etat.appendChild(doc.createTextNode(Boolean.toString(a.getEtat()))); // On ajoute a la spec sa valeur
      avion.appendChild(etat); //On ajoute chaque champ a la voiture
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
      racine.appendChild(avion); // On ajoute la voiture a la racine
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
      prixPrev.appendChild(doc.createTextNode(Integer.toString(c.getPrixPrev())));
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
