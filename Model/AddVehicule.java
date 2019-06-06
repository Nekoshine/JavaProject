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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddVehicule extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField tmarqueMoto;
	public JTextField tmarqueAvion;
	public JTextField tmarqueVoit;
	public JTextField tmodeleVoit;
	public JTextField tmodeleMoto;
	public JTextField tmodeleAvion;
	public JTextField tprixLocVoit;
	public JTextField tprixLocMoto;
	public JTextField tprixLocAvion;
	public JTextField tetatVoit;
	public JTextField tetatMoto;
	public JTextField tetatAvion;
	public JTextField tvitesseMaxVoit;
	public JTextField tvitesseMaxMoto;
	public JTextField tvitesseMaxAvion;
	public JTextField tKmVoit;
	public JTextField tKmMoto;
	public JTextField tpuissanceVoit;
	public JTextField tpuissanceMoto;
	public JTextField tnbPlace;
	public JTextField tnbHeures;
	public JTextField tnbMoteurs;
	private JPanel infos;
	public JButton ok;
	public JButton retour;
	public CardLayout cl;
	public JButton bvoit;
	public JButton bmoto;
	public JButton bavion;
	public JComboBox<String> cbchoix;

	public AddVehicule() {
		super("Ajouter");
		infos = new JPanel();
		cl= new CardLayout();
		infos.setLayout(cl);
		JPanel fieldsvoit = new JPanel();
		fieldsvoit.setLayout(new GridLayout(8,2));
		JLabel marqueVoit = new JLabel("Marque:");
		fieldsvoit.add(marqueVoit);
		tmarqueVoit = new JTextField();
		fieldsvoit.add(tmarqueVoit);
		JLabel modeleVoit = new JLabel("Modèle:");
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
		JLabel kmVoit = new JLabel("Kilomètres:");
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
		JLabel modeleMoto = new JLabel("Modèle:");
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
		JLabel kmMoto = new JLabel("Kilomètres:");
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
		JLabel modeleAvion = new JLabel("Modèle:");
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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==ok) {
			switch (cbchoix.getSelectedItem().toString()) {
			case "Voiture":
				Voiture v = new Voiture();
				v.setEtat(false);
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
			case "Moto":
				Moto m = new Moto();
				m.setEtat(false);
				m.setId(GestionXML.getLastID(m));
				m.setKm(Integer.parseInt(tKmMoto.getText()));
				m.setMarque(tmarqueMoto.getText());
				m.setModele(tmodeleMoto.getText());
				m.setPrixLocation(Integer.parseInt(tprixLocMoto.getText()));
				m.setPuissance(Double.parseDouble(tpuissanceMoto.getText()));
				m.setVitesseMax(Integer.parseInt(tvitesseMaxMoto.getText()));
				GestionXML.addMoto(m);
				break;
			case "Avion":
				Avion a = new Avion();
				a.setEtat(false);
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

	
