

import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.Document;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.util.Date;
import java.io.*;
import java.util.*;

import javax.swing.text.Document;
import org.w3c.dom.*;


public class Main{
  
  
  public static void main(String[] args) {
    readXMLVoiture();
    readXMLMoto();
    readXMLAvion();
    readXMLClient();
  }
  
  public static ArrayList<Voiture> readXMLVoiture(){
    ArrayList<Voiture>  voitures=new ArrayList<Voiture>();
    try{
      DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder docb = docbf.newDocumentBuilder();
      org.w3c.dom.Document doc = docb.parse(new File("dataVoiture.xml"));
      //document.getDocumentElement().normalize();
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
          Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent())));
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
      org.w3c.dom.Document doc = docb.parse(new File("dataMoto.xml"));
      //document.getDocumentElement().normalize();
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
          Double.parseDouble(node.getElementsByTagName("puissance").item(0).getTextContent())));
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
      org.w3c.dom.Document doc = docb.parse(new File("dataAvion.xml"));
      //document.getDocumentElement().normalize();
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
          Integer.parseInt(node.getElementsByTagName("nbMoteurs").item(0).getTextContent())));
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
      org.w3c.dom.Document doc = docb.parse(new File("dataClient.xml"));
      //document.getDocumentElement().normalize();
      NodeList listeC = doc.getElementsByTagName("element"); //On récupère chaque noeud
      for (int i=0;i<listeC.getLength() ;i++ ) {
        if(listeC.item(i).getNodeType()==Node.ELEMENT_NODE){ //On récupère les noeuds qui sont des éléments
          Element node = (Element) listeC.item(i);
          clients.add(new Client(
          node.getElementsByTagName("nom").item(0).getTextContent(),
          Integer.parseInt(node.getElementsByTagName("numTel").item(0).getTextContent()),
          new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateDebut").item(0).getTextContent()),
          new SimpleDateFormat("dd/MM/yyyy").parse(node.getElementsByTagName("dateFin").item(0).getTextContent()),
          Integer.parseInt(node.getElementsByTagName("nbKm").item(0).getTextContent()),
          Integer.parseInt(node.getElementsByTagName("prixPrev").item(0).getTextContent()),
          Boolean.parseBoolean(node.getElementsByTagName("reduction").item(0).getTextContent())));
          System.out.println(clients.get(i));
        }
      }
    }catch(ParserConfigurationException e){
      e.printStackTrace();
    }catch(SAXException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }catch(ParseException e){
      e.printStackTrace();
    }
    return clients;
  }
}
