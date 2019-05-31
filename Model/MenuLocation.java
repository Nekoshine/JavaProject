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

public class MenuLocation extends JFrame implements ActionListener/*, ListSelectionListener*/{

	private static final long serialVersionUID = 1L;
	public JButton ok;
	public JButton retour;
	public JComboBox<Client> cbclient ;
	public JTextField dateDebut;
	public JTextField dateFin;
	public JTextField tprixPrev;
	public JTextField kmPrev;
	public JButton bvoit;
	public JButton bmoto;
	public JButton bavion;
	public JList<Vehicule> vlist;
	public JList<Vehicule> mlist;
	public JList<Vehicule> alist;
	public ArrayList<Vehicule> vtab;
	public ArrayList<Vehicule> mtab;
	public ArrayList<Vehicule> atab;
	public JPanel list;
	public JPanel scrollvp;
	public JPanel scrollmp;
	public JPanel scrollap;
	public CardLayout cl;
	public ArrayList<Client> tab;
	
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
		vtab= new ArrayList<Vehicule>();
		vtab=GestionXML.readXMLVehicule(new Voiture());
		Vehicule[] listv= new Vehicule[vtab.size()];
		for (int i = 0; i < vtab.size(); i++) {
			listv[i]=vtab.get(i);
		}
		vlist = new JList<Vehicule>(listv);
		//vlist.addListSelectionListener(this);
		JScrollPane scrollv = new JScrollPane(vlist);
		scrollvp = new JPanel();
		scrollv.setPreferredSize(new Dimension(400, 400));
		scrollvp.add(scrollv);
		scrollvp.setBackground(Color.white);
		
		mtab= new ArrayList<Vehicule>();
		mtab=GestionXML.readXMLVehicule(new Moto());
		Vehicule[] listm= new Vehicule[mtab.size()];
		for (int i = 0; i < mtab.size(); i++) {
			listm[i]=mtab.get(i);
		}
		mlist = new JList<Vehicule>(listm);
		//vlist.addListSelectionListener(this);
		JScrollPane scrollm = new JScrollPane(mlist);
		scrollmp = new JPanel();
		scrollm.setPreferredSize(new Dimension(400, 400));
		scrollmp.add(scrollm);
		scrollmp.setBackground(Color.white);
		
		atab= new ArrayList<Vehicule>();
		atab=GestionXML.readXMLVehicule(new Avion());
		Vehicule[] lista= new Vehicule[atab.size()];
		for (int i = 0; i < atab.size(); i++) {
			lista[i]=atab.get(i);
		}
		alist = new JList<Vehicule>(lista);
		//vlist.addListSelectionListener(this);
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
		//infos.add(panf);

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(5,2));
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
		JLabel dateDeb = new JLabel("Date de début");
		fields.add(dateDeb);
		dateDebut = new JTextField();
		fields.add(dateDebut);
		JLabel dateF = new JLabel("Date de fin");
		fields.add(dateF);
		dateFin = new JTextField();
		fields.add(dateFin);
		JLabel prixPrev = new JLabel("Prix prévisonnel:");
		fields.add(prixPrev);
		tprixPrev = new JTextField();
		fields.add(tprixPrev);
		JLabel kmP = new JLabel("Kilomètres prévisionnels:");
		fields.add(kmP);
		kmPrev = new JTextField();
		fields.add(kmPrev);
		fields.setBackground(Color.white);
		fields.setPreferredSize(new Dimension(400, 400));
		JPanel fieldsp = new JPanel();
		fieldsp.setBackground(Color.white);
		fieldsp.add(fields);
		this.add(fieldsp,BorderLayout.EAST);
		//infos.add(fieldsp);
		//this.add(infos,BorderLayout.CENTER);

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
		else if (source==bvoit) {
			cl.show(list, "Voiture");
			this.setVisible(true);
		}
		else if (source==bmoto) {
			cl.show(list, "Moto");
			this.setVisible(true);
		}
		else if (source==bavion) {
			cl.show(list, "Avion");
			this.setVisible(true);
		}
	}

	/*@Override
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();	
		if (source==list) {
			for (int i = 0; i < tab.size(); i++) {
				if(list.getSelectedValue().equals(tab.get(i))) {
					tnom.setText(tab.get(i).getNom());
					tnumTel.setText(Integer.toString(tab.get(i).getNumTel()));
					tnbKm.setText(Integer.toString(tab.get(i).getNbKm()));
					tprixPrev.setText(Integer.toString(tab.get(i).getPrixPrev()));
					treduc.setText(Boolean.toString(tab.get(i).getReduction()));
				}
			}
		}
	}*/
}