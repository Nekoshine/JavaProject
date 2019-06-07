import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
/**
 * Classe qui hérite d'une JFRAME et qui implémente un ActionListener et un ListSelectionListener dans le but de créer un menu qui correspond au menu de location d'un véhicule
 */
public class MenuLocation extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	private JButton ok;
	private JButton retour;
	private JComboBox<Client> cbclient ;
	private JTextField dateDebut;
	private JTextField dateFin;
	private JTextField tprixPrev;
	private JTextField kmPrev;
	private JTextField treduc;
	private JButton bvoit;
	private JButton bmoto;
	private JButton bavion;
	private JList<Voiture> vlist;
	private JList<Moto> mlist;
	private JList<Avion> alist;
	private ArrayList<Voiture> vtab;
	private ArrayList<Moto> mtab;
	private ArrayList<Avion> atab;
	private JPanel list;
	private JPanel scrollvp;
	private JPanel scrollmp;
	private JPanel scrollap;
	private CardLayout cl;
	private ArrayList<Client> tab;
	private String vehicule;
	/**
	 * Constructeur de la classe MenuLocation il permet de mettre en place les éléments au moment de l'appel de la classe
	 */
	public MenuLocation() {
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
		JPanel choix = new JPanel();
		choix.setLayout(new GridLayout(1, 3));
		bvoit = new JButton("Voiture");
		bvoit.addActionListener(this);
		bvoit.setPreferredSize(new Dimension(100, 100));
		bmoto = new JButton("Moto");
		bmoto.addActionListener(this);
		bmoto.setPreferredSize(new Dimension(100, 100));
		bavion = new JButton("Avion");
		bavion.addActionListener(this);
		bavion.setPreferredSize(new Dimension(100, 100));
		JPanel avionp = new JPanel();
		avionp.add(bavion);
		avionp.setBackground(Color.white);
		JPanel voitp = new JPanel();
		voitp.add(bvoit);
		voitp.setBackground(Color.white);
		JPanel motop = new JPanel();
		motop.setBackground(Color.white);
		motop.add(bmoto);
		choix.add(voitp);
		choix.add(motop);
		choix.add(avionp);
		t.add(choix);
		this.add(t,BorderLayout.NORTH);

		list = new JPanel();
		cl = new CardLayout();
		list.setLayout(cl);
		vtab= new ArrayList<Voiture>();
		vtab=GestionXML.readXMLVoiture();
		Voiture[] listv= new Voiture[vtab.size()];
		for (int i = 0; i < vtab.size(); i++) {
			listv[i]=vtab.get(i);
		}
		vlist = new JList<Voiture>(listv);
		vlist.addListSelectionListener(this);
		JScrollPane scrollv = new JScrollPane(vlist);
		scrollvp = new JPanel();
		scrollv.setPreferredSize(new Dimension(400, 400));
		scrollvp.add(scrollv);
		scrollvp.setBackground(Color.white);

		mtab= new ArrayList<Moto>();
		mtab=GestionXML.readXMLMoto();
		Moto[] listm= new Moto[mtab.size()];
		for (int i = 0; i < mtab.size(); i++) {
			listm[i]=mtab.get(i);
		}
		mlist = new JList<Moto>(listm);
		//vlist.addListSelectionListener(this);
		JScrollPane scrollm = new JScrollPane(mlist);
		scrollmp = new JPanel();
		scrollm.setPreferredSize(new Dimension(400, 400));
		scrollmp.add(scrollm);
		scrollmp.setBackground(Color.white);

		atab= new ArrayList<Avion>();
		atab=GestionXML.readXMLAvion();
		Avion[] lista= new Avion[atab.size()];
		for (int i = 0; i < atab.size(); i++) {
			lista[i]=atab.get(i);
		}
		alist = new JList<Avion>(lista);
		vlist.addListSelectionListener(this);
		JScrollPane scrolla = new JScrollPane(alist);
		scrollap = new JPanel();
		scrolla.setPreferredSize(new Dimension(400, 400));
		scrollap.add(scrolla);
		scrollap.setBackground(Color.white);

		list.add("Voiture", scrollvp);
		list.add("Moto", scrollmp);
		list.add("Avion", scrollap);
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

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(6,2));
		JLabel nom = new JLabel("Client:");
		fields.add(nom);
		tab= new ArrayList<Client>();
		tab=GestionXML.readXMLClient();
		Client[] listc= new Client[tab.size()];
		for (int i = 0; i < tab.size(); i++) {
			listc[i]=tab.get(i);
		}
		cbclient = new JComboBox<Client>(listc);
		fields.add(cbclient);
		JLabel dateDeb = new JLabel("Date de debut");
		fields.add(dateDeb);
		dateDebut = new JTextField();
		fields.add(dateDebut);
		JLabel dateF = new JLabel("Date de fin");
		fields.add(dateF);
		dateFin = new JTextField();
		fields.add(dateFin);
		JLabel prixPrev = new JLabel("Prix previsonnel:");
		fields.add(prixPrev);
		tprixPrev = new JTextField();
		fields.add(tprixPrev);
		JLabel kmP = new JLabel("Kilometres previsionnels:");
		fields.add(kmP);
		kmPrev = new JTextField();
		fields.add(kmPrev);
		JLabel reduc= new JLabel("Reduction");
		fields.add(reduc);
		treduc=new JTextField();
		fields.add(treduc);
		fields.setBackground(Color.white);
		fields.setPreferredSize(new Dimension(400, 400));
		JPanel fieldsp = new JPanel();
		fieldsp.setBackground(Color.white);
		fieldsp.add(fields);
		this.add(fieldsp,BorderLayout.EAST);


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
		vehicule="Voiture";
	}
	/**
	 * Procédure qui se déclenche lorsqu'un bouton est pressé
	 * @param e Action réalisée
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		boolean error=false;
		if (source==ok) {
			try {

				Location loc = new Location();
				loc.setClient((Client) cbclient.getSelectedItem());
				try {
					loc.setDateDebut(new SimpleDateFormat("dd/MM/yyyy").parse(dateDebut.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					loc.setDateFin(new SimpleDateFormat("dd/MM/yyyy").parse(dateFin.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				loc.setId(GestionXML.getLastIDLoc());
				loc.setKmPrev(Integer.parseInt(kmPrev.getText()));
				loc.setPrixPrev(Float.parseFloat(tprixPrev.getText()));
				loc.setReduc(Boolean.parseBoolean(treduc.getText()));
				switch (vehicule) {
				case "Voiture":
					loc.setVehicule(vlist.getSelectedValue());
					vlist.getSelectedValue().setEtat(true);
					break;
				case "Moto":
					loc.setVehicule(mlist.getSelectedValue());
					mlist.getSelectedValue().setEtat(true);
					break;
				case "Avion":
					loc.setVehicule(alist.getSelectedValue());
					alist.getSelectedValue().setEtat(true);
					break;
				default:
					break;
				}
				GestionXML.addLocation(loc);
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Vous n'avez pas bien remplie les champs","ERROR",JOptionPane.ERROR_MESSAGE);
				error=true;			
			}
			if (!error) {
				JOptionPane.showMessageDialog(this, "Location valid�e");
			}
		}
		else if (source==retour) {
			this.setVisible(false);
			MenuPrincipal mp = new MenuPrincipal();
		}
		else if (source==bvoit) {
			cl.show(list, "Voiture");
			vehicule="Voiture";
			this.setVisible(true);
		}
		else if (source==bmoto) {
			cl.show(list, "Moto");
			vehicule="Moto";
			this.setVisible(true);
		}
		else if (source==bavion) {
			cl.show(list, "Avion");
			vehicule="Avion";
			this.setVisible(true);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {

	}

}
