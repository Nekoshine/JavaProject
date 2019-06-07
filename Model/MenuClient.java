import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;

public class MenuClient extends JFrame implements ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 1L;
	public JButton ok;
	public JButton retour;
	public JTextField tnom ;
	public JTextField tnumTel; 
	public JButton badd;
	public JButton bsupp;
	public JButton bact;
	public JList<Client> list;
	public ArrayList<Client> tab;

	public MenuClient() {
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
		addsupp.setLayout(new GridLayout(1, 3));
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

		JPanel infos = new JPanel();
		infos.setLayout(new GridLayout(1,3));
		tab= new ArrayList<Client>();
		tab=GestionXML.readXMLClient();
		Client[] listc= new Client[tab.size()];
		for (int i = 0; i < tab.size(); i++) {
			listc[i]=tab.get(i);
		}
		list = new JList<Client>(listc);
		list.addListSelectionListener(this);
		JScrollPane scroll = new JScrollPane(list);
		JPanel scrollp = new JPanel();
		scroll.setPreferredSize(new Dimension(400, 400));
		scrollp.add(scroll);
		scrollp.setBackground(Color.white);
		infos.add(scrollp);

		Icon fleche= new ImageIcon("fleche.png");
		JPanel panf=new JPanel();
		JLabel tf=new JLabel();
		tf.setIcon(fleche);
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setPreferredSize(new DimensionUIResource(400, 400));
		panf.add(tf);
		panf.setBackground(Color.white);
		infos.add(panf);

		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(2,2));
		JLabel nom = new JLabel("Nom:");
		fields.add(nom);
		tnom = new JTextField();
		fields.add(tnom);
		JLabel numTel = new JLabel("Numéro de téléphone:");
		fields.add(numTel);
		tnumTel = new JTextField();
		fields.add(tnumTel);
		fields.setBackground(Color.white);
		fields.setPreferredSize(new Dimension(400, 400));
		JPanel fieldsp = new JPanel();
		fieldsp.setBackground(Color.white);
		fieldsp.add(fields);
		infos.add(fieldsp);
		this.add(infos,BorderLayout.CENTER);

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
		if (source==ok) {
			Client c = list.getSelectedValue();
			GestionXML.deleteClient(c);
			c.setNom(tnom.getText());
			c.setNumTel(Integer.parseInt(tnumTel.getText()));
			GestionXML.addClient(c);

		}
		else if (source==retour) {
			this.setVisible(false);
			MenuPrincipal mp = new MenuPrincipal();
		}
		else if (source==badd) {
			AddClient addc = new AddClient(); 
		}
		else if (source==bsupp) {
			GestionXML.deleteClient(list.getSelectedValue());
		}
		else if (source==bact) {
			this.setVisible(false);
			MenuClient mc = new MenuClient();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source==list) {

			tnom.setText(list.getSelectedValue().getNom());
			tnumTel.setText(Integer.toString(list.getSelectedValue().getNumTel()));
		}
	}
}