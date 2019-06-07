import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddClient extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tnom;
	private JTextField tnumTel;
	private JPanel infos;
	public JButton ok;
	public JButton retour;

	public AddClient() {
		super("Ajouter");
		infos = new JPanel();
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(2,2));
		JLabel nom = new JLabel("Nom:");
		fields.add(nom);
		tnom = new JTextField();
		fields.add(tnom);
		JLabel numTel = new JLabel("Num�ro de t�l�phone:");
		fields.add(numTel);
		tnumTel = new JTextField();
		fields.add(tnumTel);
		fields.setBackground(Color.white);
		fields.setPreferredSize(new Dimension(400, 350));
		JPanel fieldsp = new JPanel();
		fieldsp.setBackground(Color.white);
		fieldsp.add(fields);
		infos.add(fieldsp);
		infos.setBackground(Color.white);
		
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
		
		this.add(infos); 
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==ok) {
			Client c = new Client(this.tnom.getText(), Integer.parseInt(this.tnumTel.getText()), GestionXML.getLastIDClient());
			GestionXML.addClient(c);
			this.setVisible(false);
		} 
		else if (source==retour) {
			this.setVisible(false);
		}
	}
}
