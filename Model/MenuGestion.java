import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
/**
* Classe qui hérite d'une JFRAME et qui implémente un ActionListener et un ListSelectionListener dans le but de créer un menu qui correspond au menu de gestion des véhicule
*/
public class MenuGestion extends JFrame implements ActionListener, ListSelectionListener{
	
	private JButton ok;
	private JButton retour;
	private JTextField tmarqueMoto;
	private JTextField tmarqueAvion;
	private JTextField tmarqueVoit;
	private JTextField tmodeleVoit;
	private JTextField tmodeleMoto;
	private JTextField tmodeleAvion;
	private JTextField tprixLocVoit;
	private JTextField tprixLocMoto;
	private JTextField tprixLocAvion;
	private JTextField tetatVoit;
	private JTextField tetatMoto;
	private JTextField tetatAvion;
	private JTextField tvitesseMaxVoit;
	private JTextField tvitesseMaxMoto;
	private JTextField tvitesseMaxAvion;
	private JTextField tKmVoit;
	private JTextField tKmMoto;
	private JTextField tpuissanceVoit;
	private JTextField tpuissanceMoto;
	private JTextField tnbPlace;
	private JTextField tnbHeures;
	private JTextField tnbMoteurs;
	private JButton badd;
	private JButton bsupp;
	private JList<Vehicule> vlist;
	private ArrayList<Voiture> vtab;
	private ArrayList<Moto> mtab;
	private ArrayList<Avion> atab;
	private JPanel list;
	private JPanel scrollvp;
	private CardLayout cl;
	private JPanel infos;
	private JButton bact;
	
	/**
	* Constructeur du menu de gestion il va permettre de mettre en place les éléments graphiques de la fenetre
	*/
	public MenuGestion() {
		super("VOITOVION");
		JPanel t = new JPanel();
		t.setLayout(new GridLayout(2, 1));
		Icon titre= new ImageIcon("VOITOVION.png");
		JPanel pan=new JPanel();
		JLabel tl=new JLabel();
		tl.setIcon(titre);
		tl.setHorizontalAlignment(JTextField.CENTER);
		pan.add(tl);
		pan.setBackground(Color.white);
		t.add(pan);
		JPanel addsupp = new JPanel();
		addsupp.setLayout(new GridLayout(1, 2));
		badd = new JButton("Ajouter");
		badd.addActionListener(this);
		badd.setPreferredSize(new Dimension(100, 100));
		bsupp = new JButton("Supprimer");
		bsupp.addActionListener(this);
		bsupp.setPreferredSize(new Dimension(100, 100));
		bact = new JButton("Actualiser");
		bact.addActionListener(this);
		bact.setPreferredSize(new Dimension(100, 100));
		JPanel actp = new JPanel();
		actp.add(bact);
		actp.setBackground(Color.white);
		JPanel addp = new JPanel();
		addp.add(badd);
		JPanel suppp = new JPanel();
		addp.setBackground(Color.white);
		suppp.setBackground(Color.white);
		suppp.add(bsupp);
		addsupp.add(addp);
		addsupp.add(actp);
		addsupp.add(suppp);
		t.add(addsupp);
		this.add(t,BorderLayout.NORTH);
		
		list = new JPanel();
		vtab= new ArrayList<Voiture>();
		mtab= new ArrayList<Moto>();
		atab= new ArrayList<Avion>();
		vtab=GestionXML.readXMLVoiture();
		mtab=GestionXML.readXMLMoto();
		atab=GestionXML.readXMLAvion();
		int taille = vtab.size()+mtab.size()+atab.size();
		Vehicule[] listv= new Vehicule[taille];
		for (int i = 0; i < vtab.size(); i++) {
			listv[i]=vtab.get(i);
		}
		for (int i = 0; i < mtab.size(); i++) {
			listv[i+vtab.size()]=mtab.get(i);
		}
		for (int i = 0; i < atab.size(); i++) {
			listv[i+vtab.size()+mtab.size()]=atab.get(i);
		}
		vlist = new JList<Vehicule>(listv);
		vlist.addListSelectionListener(this);
		JScrollPane scrollv = new JScrollPane(vlist);
		scrollvp = new JPanel();
		scrollv.setPreferredSize(new Dimension(400, 400));
		scrollvp.add(scrollv);
		scrollvp.setBackground(Color.white);
		
		
		list.add(scrollvp);
		list.setBackground(Color.white);
		this.add(list,BorderLayout.WEST);
		
		
		Icon fleche= new ImageIcon("fleche.png");
		JPanel panf=new JPanel();
		JLabel tf=new JLabel();
		tf.setIcon(fleche);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setPreferredSize(new DimensionUIResource(400, 400));
		panf.add(tf);
		panf.setBackground(Color.white);
		this.add(panf,BorderLayout.CENTER);
		
		
		
		infos = new JPanel();
		cl= new CardLayout();
		infos.setLayout(cl);
		JPanel fieldsvoit = new JPanel();
		fieldsvoit.setLayout(new GridLayout(8,2));
		JLabel marqueVoit = new JLabel("Marque:");
		fieldsvoit.add(marqueVoit);
		tmarqueVoit = new JTextField();
		fieldsvoit.add(tmarqueVoit);
		JLabel modeleVoit = new JLabel("Mod�le:");
		fieldsvoit.add(modeleVoit);
		tmodeleVoit = new JTextField();
		fieldsvoit.add(tmodeleVoit);
		JLabel prixLocVoit = new JLabel("Prix de Location:");
		fieldsvoit.add(prixLocVoit);
		tprixLocVoit = new JTextField();
		fieldsvoit.add(tprixLocVoit);
		JLabel etatVoit = new JLabel("Etat:");
		fieldsvoit.add(etatVoit);
		tetatVoit = new JTextField();
		fieldsvoit.add(tetatVoit);
		JLabel vitesseMaxVoit = new JLabel("Vitesse Max:");
		fieldsvoit.add(vitesseMaxVoit);
		tvitesseMaxVoit = new JTextField();
		fieldsvoit.add(tvitesseMaxVoit);
		JLabel kmVoit = new JLabel("Kilom�tres:");
		fieldsvoit.add(kmVoit);
		tKmVoit = new JTextField();
		fieldsvoit.add(tKmVoit);
		JLabel puissanceVoit = new JLabel("Puissance:");
		fieldsvoit.add(puissanceVoit);
		tpuissanceVoit = new JTextField();
		fieldsvoit.add(tpuissanceVoit);
		JLabel nbPlaces = new JLabel("Nombre de places:");
		fieldsvoit.add(nbPlaces);
		tnbPlace = new JTextField();
		fieldsvoit.add(tnbPlace);
		fieldsvoit.setBackground(Color.white);
		fieldsvoit.setPreferredSize(new Dimension(400, 400));
		infos.add("Voiture",fieldsvoit);
		
		JPanel fieldsmoto = new JPanel();
		fieldsmoto.setLayout(new GridLayout(7,2));
		JLabel marqueMoto = new JLabel("Marque:");
		fieldsmoto.add(marqueMoto);
		tmarqueMoto = new JTextField();
		fieldsmoto.add(tmarqueMoto);
		JLabel modeleMoto = new JLabel("Mod�le:");
		fieldsmoto.add(modeleMoto);
		tmodeleMoto = new JTextField();
		fieldsmoto.add(tmodeleMoto);
		JLabel prixLocMoto = new JLabel("Prix de Location:");
		fieldsmoto.add(prixLocMoto);
		tprixLocMoto = new JTextField();
		fieldsmoto.add(tprixLocMoto);
		JLabel etatMoto = new JLabel("Etat:");
		fieldsmoto.add(etatMoto);
		tetatMoto = new JTextField();
		fieldsmoto.add(tetatMoto);
		JLabel vitesseMaxMoto = new JLabel("Vitesse Max:");
		fieldsmoto.add(vitesseMaxMoto);
		tvitesseMaxMoto = new JTextField();
		fieldsmoto.add(tvitesseMaxMoto);
		JLabel kmMoto = new JLabel("Kilom�tres:");
		fieldsmoto.add(kmMoto);
		tKmMoto = new JTextField();
		fieldsmoto.add(tKmMoto);
		JLabel puissanceMoto = new JLabel("Puissance:");
		fieldsmoto.add(puissanceMoto);
		tpuissanceMoto= new JTextField();
		fieldsmoto.add(tpuissanceMoto);
		fieldsmoto.setBackground(Color.white);
		fieldsmoto.setPreferredSize(new Dimension(400, 400));
		infos.add("Moto",fieldsmoto);
		
		JPanel fieldsavion = new JPanel();
		fieldsavion.setLayout(new GridLayout(7,2));
		JLabel marqueAvion = new JLabel("Marque:");
		fieldsavion.add(marqueAvion);
		tmarqueAvion = new JTextField();
		fieldsavion.add(tmarqueAvion);
		JLabel modeleAvion = new JLabel("Mod�le:");
		fieldsavion.add(modeleAvion);
		tmodeleAvion = new JTextField();
		fieldsavion.add(tmodeleAvion);
		JLabel prixLocAvion = new JLabel("Prix de Location:");
		fieldsavion.add(prixLocAvion);
		tprixLocAvion = new JTextField();
		fieldsavion.add(tprixLocAvion);
		JLabel etatAvion = new JLabel("Etat:");
		fieldsavion.add(etatAvion);
		tetatAvion = new JTextField();
		fieldsavion.add(tetatAvion);
		JLabel vitesseMaxAvion = new JLabel("Vitesse Max:");
		fieldsavion.add(vitesseMaxAvion);
		tvitesseMaxAvion = new JTextField();
		fieldsavion.add(tvitesseMaxAvion);
		JLabel nbHeures = new JLabel("Nombre d'heures:");
		fieldsavion.add(nbHeures);
		tnbHeures = new JTextField();
		fieldsavion.add(tnbHeures);
		JLabel nbMoteurs = new JLabel("Nombre de moteurs:");
		fieldsavion.add(nbMoteurs);
		tnbMoteurs = new JTextField();
		fieldsavion.add(tnbMoteurs);
		fieldsavion.setBackground(Color.white);
		fieldsavion.setPreferredSize(new Dimension(400, 400));
		infos.add("Avion",fieldsavion);
		
		this.add(infos,BorderLayout.EAST);
		
		
		JPanel boutret = new JPanel();
		boutret.setLayout(new GridLayout(1,2));
		JPanel retp= new JPanel();
		retour = new JButton("Retour");
		retour.addActionListener(this);
		retour.setPreferredSize(new Dimension(100, 50));
		retp.add(retour);
		boutret.add(retp);
		JPanel okp= new JPanel();
		ok = new JButton("OK");
		ok.addActionListener(this);
		ok.setPreferredSize(new Dimension(100, 50));
		okp.add(ok);
		boutret.add(okp);
		okp.setBackground(Color.white);
		retp.setBackground(Color.white);
		this.add(boutret,BorderLayout.SOUTH);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	* Procédure qui se déclenche lorsqu'un bouton est pressé
	* @param e Action réalisée
	*/
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==ok) {
			System.out.println(vlist.getSelectedValue().getClass().toString());
			switch (vlist.getSelectedValue().getClass().toString()) {
				case "class Voiture":
				Voiture v = (Voiture)vlist.getSelectedValue();
				GestionXML.deleteVehicule(v);
				v.setEtat(Boolean.parseBoolean(tetatVoit.getText()));
				v.setId(GestionXML.getLastID(v));
				v.setKm(Integer.parseInt(tKmVoit.getText()));
				v.setMarque(tmarqueVoit.getText());
				v.setModele(tmodeleVoit.getText());
				v.setNbPlace(Integer.parseInt(tnbPlace.getText()));
				v.setPrixLocation(Integer.parseInt(tprixLocVoit.getText()));
				v.setPuissance(Double.parseDouble(tpuissanceVoit.getText()));
				v.setVitesseMax(Integer.parseInt(tpuissanceVoit.getText()));
				GestionXML.addVoiture(v);
				break;
				case "class Moto":
				Moto m = (Moto)vlist.getSelectedValue();
				GestionXML.deleteVehicule(m);
				m.setEtat(Boolean.parseBoolean(tetatMoto.getText()));
				m.setId(GestionXML.getLastID(m));
				m.setKm(Integer.parseInt(tKmMoto.getText()));
				m.setMarque(tmarqueMoto.getText());
				m.setModele(tmodeleMoto.getText());
				m.setPrixLocation(Integer.parseInt(tprixLocMoto.getText()));
				m.setPuissance(Double.parseDouble(tpuissanceMoto.getText()));
				m.setVitesseMax(Integer.parseInt(tvitesseMaxMoto.getText()));
				GestionXML.addMoto(m);
				break;
				case "class Avion":
				Avion a = (Avion)vlist.getSelectedValue();
				GestionXML.deleteVehicule(a);
				a.setEtat(Boolean.parseBoolean(tetatAvion.getText()));
				a.setId(GestionXML.getLastID(a));
				a.setMarque(tmarqueAvion.getText());
				a.setModele(tmodeleAvion.getText());
				a.setNbHeures(Integer.parseInt(tnbHeures.getText()));
				a.setNbMoteurs(Integer.parseInt(tnbMoteurs.getText()));
				a.setPrixLocation(Integer.parseInt(tprixLocAvion.getText()));
				a.setVitesseMax(Integer.parseInt(tvitesseMaxAvion.getText()));
				GestionXML.addAvion(a);
				break;
				
				default:
				break;
			}
		}
		else if (source==retour) {
			this.setVisible(false);
			MenuPrincipal mp = new MenuPrincipal();
		}
		else if (source==badd) {
			AddVehicule mg = new AddVehicule();
		}
		else if (source==bsupp) {
			GestionXML.deleteVehicule(vlist.getSelectedValue());
		}
		else if (source==bact) {
			this.setVisible(false);
			MenuGestion mg = new MenuGestion();
		}
	}
	/**
	* Procédure qui se déclenche lorsqu'un élément de la liste est sélectionné
	* @param e Action réalisée
	*/
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source==vlist) {
			if (vlist.getSelectedValue().getClass().getName().equals("Voiture")) {
				cl.show(infos, "Voiture");
				for (int i = 0; i < vtab.size(); i++) {
					if(vlist.getSelectedValue().equals(vtab.get(i))) {
						tmarqueVoit.setText(vtab.get(i).getMarque());
						tmodeleVoit.setText(vtab.get(i).getModele());
						tprixLocVoit.setText(Integer.toString(vtab.get(i).getPrixLocation()));
						tetatVoit.setText(Boolean.toString(vtab.get(i).getEtat()));
						tvitesseMaxVoit.setText(Integer.toString(vtab.get(i).getVitesseMax()));
						tKmVoit.setText(Integer.toString(vtab.get(i).getKm()));
						tpuissanceVoit.setText(Double.toString(vtab.get(i).getPuissance()));
						tnbPlace.setText(Integer.toString(vtab.get(i).getNbPlace()));
					}
				}
			}
			else if (vlist.getSelectedValue().getClass().getName().equals("Moto")) {
				cl.show(infos, "Moto");
				for (int i = 0; i < mtab.size(); i++) {
					if(vlist.getSelectedValue().equals(mtab.get(i))) {
						tmarqueMoto.setText(mtab.get(i).getMarque());
						tmodeleMoto.setText(mtab.get(i).getModele());
						tprixLocMoto.setText(Integer.toString(mtab.get(i).getPrixLocation()));
						tetatMoto.setText(Boolean.toString(mtab.get(i).getEtat()));
						tvitesseMaxMoto.setText(Integer.toString(mtab.get(i).getVitesseMax()));
						tKmMoto.setText(Integer.toString(mtab.get(i).getKm()));
						tpuissanceMoto.setText(Double.toString(mtab.get(i).getPuissance()));
					}
				}
			}
			else if (vlist.getSelectedValue().getClass().getName().equals("Avion")) {
				cl.show(infos, "Avion");
				for (int i = 0; i < atab.size(); i++) {
					if(vlist.getSelectedValue().equals(atab.get(i))) {
						tmarqueAvion.setText(atab.get(i).getMarque());
						tmodeleAvion.setText(atab.get(i).getModele());
						tprixLocAvion.setText(Integer.toString(atab.get(i).getPrixLocation()));
						tetatAvion.setText(Boolean.toString(atab.get(i).getEtat()));
						tvitesseMaxAvion.setText(Integer.toString(atab.get(i).getVitesseMax()));
						tnbHeures.setText(Integer.toString(atab.get(i).getNbHeures()));
						tnbMoteurs.setText(Integer.toString(atab.get(i).getNbMoteurs()));
					}
				}
			}
		}
	}
}
