import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Main{
  
  
  public static void main(String[] args) {
    Voiture v = new Voiture("Renault","Zoe",0,false,140,10000,4,60);
    Moto m = new Moto("Kawa","jsp",0,false,140,10000,60);
    Avion a = new Avion("Airbus","a320",0,false,800,100,4);
    try{
      Date dateD= new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2019");
      Date dateF= new SimpleDateFormat("dd/MM/yyyy").parse("09/05/2019");
      Client c = new Client("Paul",684758125,dateD,dateF,50,0,false);
      GestionXML gestionnaire = new GestionXML();
      // addVehicules(a); a coder
      GestionXML.addVehicules(v);
      GestionXML.addClient(c);
      GestionXML.readXMLVehicule(v);
      GestionXML.readXMLClient();
    }catch(ParseException e){
      e.printStackTrace();
    }
  }
  
}
