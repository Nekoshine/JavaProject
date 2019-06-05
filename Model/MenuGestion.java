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

public class MenuGestion extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	public JButton ok;
	public JButton retour;
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
	public JButton badd;
	public JButton bsupp;
	public JList<Vehicule> vlist;
	public ArrayList<Voiture> vtab;
	public ArrayList<Moto> mtab;
	public ArrayList<Avion> atab;
	public JPanel list;
	public JPanel scrollvp;
	public CardLayout cl;
	public JPanel infos;

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
		bsupp.setPreferredSize(new Dimension(100, 100));
		JPanel addp = new JPanel();
		addp.add(badd);
		JPanel suppp = new JPanel();
		addp.setBackground(Color.white);
		suppp.setBackground(Color.white);
		suppp.add(bsupp);
		addsupp.add(addp);
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
		JLabel nbMoteurs = new JLabel("Nombre d'heures:");
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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		/*if (source==ok) {
			for (int i = 0; i < tab.size(); i++) {
				if(list.getSelectedValue().equals(tab.get(i))) {
					tab.get(i).setNom(tnom.getText());
					tab.get(i).setNumTel(Integer.parseInt(this.tnumTel.getText()));
					tab.get(i).setNbKm(Integer.parseInt(this.tnbKm.getText()));
					tab.get(i).setPrixPrev(Integer.parseInt(this.tprixPrev.getText()));
					tab.get(i).setReduction(Boolean.parseBoolean(this.treduc.getText()));
				}
			}
		}
		else*/ if (source==retour) {
			this.setVisible(false);
			MenuPrincipal mp = new MenuPrincipal();
		}
		else if (source==badd) {
		}
		else if (source==bsupp) {
		}
	}

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