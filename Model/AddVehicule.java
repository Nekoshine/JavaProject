import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
* Classe qui hérite d'une JFRAME et qui implémente un ActionListener dans le but de créer un menu qui correspond au menu d'ajout d'un véhicule
*/
public class AddVehicule extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField tMarqueMoto;
	private JTextField tMarqueAvion;
	private JTextField tMarqueVoit;
	private JTextField tModeleVoit;
	private JTextField tModeleMoto;
	private JTextField tModeleAvion;
	private JTextField tPrixLocVoit;
	private JTextField tPrixLocMoto;
	private JTextField tPrixLocAvion;
	private JTextField tEtatVoit;
	private JTextField tetatMoto;
	private JTextField tEtatAvion;
	private JTextField tVitesseMaxVoit;
	private JTextField tVitesseMaxMoto;
	private JTextField tVitesseMaxAvion;
	private JTextField tKmVoit;
	private JTextField tKmMoto;
	private JTextField tPuissanceVoit;
	private JTextField tPuissanceMoto;
	private JTextField tNbPlace;
	private JTextField tNbHeures;
	private JTextField tNbMoteurs;
	private JPanel infos;
	private JButton ok;
	private JButton retour;
	private CardLayout cl;
	private JComboBox<String> cbchoix;
	/**
	* Constructeur de la classe AddVehicule il permet de mettre en place les éléments au démarrage de la fenetre et donc lors de l'instanciation de la classe
	*/
	public AddVehicule() {
		super("Ajouter");
		infos = new JPanel();
		cl= new CardLayout();
		infos.setLayout(cl);
		JPanel fieldsvoit = new JPanel();
		fieldsvoit.setLayout(new GridLayout(8,2));
		JLabel marqueVoit = new JLabel("Marque:");
		fieldsvoit.add(marqueVoit);
		tMarqueVoit = new JTextField();
		fieldsvoit.add(tMarqueVoit);
		JLabel modeleVoit = new JLabel("Modele:");
		fieldsvoit.add(modeleVoit);
		tModeleVoit = new JTextField();
		fieldsvoit.add(tModeleVoit);
		JLabel prixLocVoit = new JLabel("Prix de Location:");
		fieldsvoit.add(prixLocVoit);
		tPrixLocVoit = new JTextField();
		fieldsvoit.add(tPrixLocVoit);
		JLabel etatVoit = new JLabel("Etat:");
		fieldsvoit.add(etatVoit);
		tEtatVoit = new JTextField();
		fieldsvoit.add(tEtatVoit);
		JLabel vitesseMaxVoit = new JLabel("Vitesse Max:");
		fieldsvoit.add(vitesseMaxVoit);
		tVitesseMaxVoit = new JTextField();
		fieldsvoit.add(tVitesseMaxVoit);
		JLabel kmVoit = new JLabel("Kilometres:");
		fieldsvoit.add(kmVoit);
		tKmVoit = new JTextField();
		fieldsvoit.add(tKmVoit);
		JLabel puissanceVoit = new JLabel("Puissance:");
		fieldsvoit.add(puissanceVoit);
		tPuissanceVoit = new JTextField();
		fieldsvoit.add(tPuissanceVoit);
		JLabel nbPlaces = new JLabel("Nombre de places:");
		fieldsvoit.add(nbPlaces);
		tNbPlace = new JTextField();
		fieldsvoit.add(tNbPlace);
		fieldsvoit.setBackground(Color.white);
		fieldsvoit.setPreferredSize(new Dimension(400, 400));
		infos.add("Voiture",fieldsvoit);
		
		JPanel fieldsmoto = new JPanel();
		fieldsmoto.setLayout(new GridLayout(7,2));
		JLabel marqueMoto = new JLabel("Marque:");
		fieldsmoto.add(marqueMoto);
		tMarqueMoto = new JTextField();
		fieldsmoto.add(tMarqueMoto);
		JLabel modeleMoto = new JLabel("Modele:");
		fieldsmoto.add(modeleMoto);
		tModeleMoto = new JTextField();
		fieldsmoto.add(tModeleMoto);
		JLabel prixLocMoto = new JLabel("Prix de Location:");
		fieldsmoto.add(prixLocMoto);
		tPrixLocMoto = new JTextField();
		fieldsmoto.add(tPrixLocMoto);
		JLabel etatMoto = new JLabel("Etat:");
		fieldsmoto.add(etatMoto);
		tetatMoto = new JTextField();
		fieldsmoto.add(tetatMoto);
		JLabel vitesseMaxMoto = new JLabel("Vitesse Max:");
		fieldsmoto.add(vitesseMaxMoto);
		tVitesseMaxMoto = new JTextField();
		fieldsmoto.add(tVitesseMaxMoto);
		JLabel kmMoto = new JLabel("Kilometres:");
		fieldsmoto.add(kmMoto);
		tKmMoto = new JTextField();
		fieldsmoto.add(tKmMoto);
		JLabel puissanceMoto = new JLabel("Puissance:");
		fieldsmoto.add(puissanceMoto);
		tPuissanceMoto= new JTextField();
		fieldsmoto.add(tPuissanceMoto);
		fieldsmoto.setBackground(Color.white);
		fieldsmoto.setPreferredSize(new Dimension(400, 400));
		infos.add("Moto",fieldsmoto);
		
		JPanel fieldsavion = new JPanel();
		fieldsavion.setLayout(new GridLayout(7,2));
		JLabel marqueAvion = new JLabel("Marque:");
		fieldsavion.add(marqueAvion);
		tMarqueAvion = new JTextField();
		fieldsavion.add(tMarqueAvion);
		JLabel modeleAvion = new JLabel("Modele:");
		fieldsavion.add(modeleAvion);
		tModeleAvion = new JTextField();
		fieldsavion.add(tModeleAvion);
		JLabel prixLocAvion = new JLabel("Prix de Location:");
		fieldsavion.add(prixLocAvion);
		tPrixLocAvion = new JTextField();
		fieldsavion.add(tPrixLocAvion);
		JLabel etatAvion = new JLabel("Etat:");
		fieldsavion.add(etatAvion);
		tEtatAvion = new JTextField();
		fieldsavion.add(tEtatAvion);
		JLabel vitesseMaxAvion = new JLabel("Vitesse Max:");
		fieldsavion.add(vitesseMaxAvion);
		tVitesseMaxAvion = new JTextField();
		fieldsavion.add(tVitesseMaxAvion);
		JLabel nbHeures = new JLabel("Nombre d'heures:");
		fieldsavion.add(nbHeures);
		tNbHeures = new JTextField();
		fieldsavion.add(tNbHeures);
		JLabel nbMoteurs = new JLabel("Nombre de moteurs:");
		fieldsavion.add(nbMoteurs);
		tNbMoteurs = new JTextField();
		fieldsavion.add(tNbMoteurs);
		fieldsavion.setBackground(Color.white);
		fieldsavion.setPreferredSize(new Dimension(400, 400));
		infos.add("Avion",fieldsavion);
		
		this.add(infos,BorderLayout.CENTER);
		
		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(1,2));
		ok = new JButton("Sauvegarder");
		ok.addActionListener(this);
		JPanel pok = new JPanel();
		ok.setPreferredSize(new Dimension(150,50));
		pok.add(ok);
		retour = new JButton("Annuler");
		retour.addActionListener(this);
		JPanel pretour = new JPanel();
		retour.setPreferredSize(new Dimension(150,50));
		pretour.add(retour);
		boutons.add(pretour);
		boutons.add(pok);
		pretour.setBackground(Color.white);
		pok.setBackground(Color.white);
		this.add(boutons,BorderLayout.SOUTH);
		
		JPanel choix = new JPanel();
		String[] listc =  {"Voiture","Moto","Avion"};
		cbchoix = new JComboBox<String>(listc);
		DefaultListCellRenderer centr = new DefaultListCellRenderer();
		centr.setHorizontalAlignment(JLabel.CENTER);
		cbchoix.setRenderer(centr);
		cbchoix.setBackground(Color.white);
		cbchoix.setPreferredSize(new Dimension(300,50));
		cbchoix.addActionListener(this);
		choix.setBackground(Color.white);
		choix.add(cbchoix);
		this.add(choix,BorderLayout.NORTH);
		
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
	}
	/**
	* Procédure qui se déclenche lorsqu'un bouton est pressé
	* @param e Action réalisée
	*/
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==ok) {
			switch (cbchoix.getSelectedItem().toString()) {
				case "Voiture":
				Voiture v = new Voiture();
				try {
					v.setEtat(false);
					v.setId(GestionXML.getLastID(v));
					v.setKm(Integer.parseInt(tKmVoit.getText()));
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(tKmVoit,"Vous avez mal remplie les champs!","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				v.setMarque(tMarqueVoit.getText());
				v.setModele(tModeleVoit.getText());
				v.setNbPlace(Integer.parseInt(tNbPlace.getText()));
				v.setPrixLocation(Integer.parseInt(tPrixLocVoit.getText()));
				v.setPuissance(Double.parseDouble(tPuissanceVoit.getText()));
				v.setVitesseMax(Integer.parseInt(tPuissanceVoit.getText()));
				GestionXML.addVoiture(v);
				break;
				case "Moto":
				Moto m = new Moto();
				m.setEtat(false);
				m.setId(GestionXML.getLastID(m));
				m.setKm(Integer.parseInt(tKmMoto.getText()));
				m.setMarque(tMarqueMoto.getText());
				m.setModele(tModeleMoto.getText());
				m.setPrixLocation(Integer.parseInt(tPrixLocMoto.getText()));
				m.setPuissance(Double.parseDouble(tPuissanceMoto.getText()));
				m.setVitesseMax(Integer.parseInt(tVitesseMaxMoto.getText()));
				GestionXML.addMoto(m);
				break;
				case "Avion":
				Avion a = new Avion();
				a.setEtat(false);
				a.setId(GestionXML.getLastID(a));
				a.setMarque(tMarqueAvion.getText());
				a.setModele(tModeleAvion.getText());
				a.setNbHeures(Integer.parseInt(tNbHeures.getText()));
				a.setNbMoteurs(Integer.parseInt(tNbMoteurs.getText()));
				a.setPrixLocation(Integer.parseInt(tPrixLocAvion.getText()));
				a.setVitesseMax(Integer.parseInt(tVitesseMaxAvion.getText()));
				GestionXML.addAvion(a);
				break;
				
				default:
				break;
			}
			
			this.setVisible(false);
		}
		else if (source==retour) {
			this.setVisible(false);
		}
		else if (source==cbchoix) {
			switch (cbchoix.getSelectedItem().toString()) {
				case "Voiture":
				cl.show(infos, "Voiture");
				break;
				case "Moto":
				cl.show(infos, "Moto");
				break;
				case "Avion":
				cl.show(infos, "Avion");
				break;
				
				default:
				break;
			}
		}
	}
}
