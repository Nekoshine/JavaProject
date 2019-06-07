import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
* Classe principale qui va contenir les différents menus, elle hérite d'une JFRAME et implémente un ActionListener
*/
public class MenuPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton bClient;
	private JButton bLoc;
	private JButton bGestion;
	private JButton bRes;
	/**
	* Constructeur de la classe MenuPrincipal il permet de mettre en place les éléments du menu lors de l'instanciation
	*/
	public MenuPrincipal() {
		super("VOITOVION");
		
		Icon titre= new ImageIcon("VOITOVION.png");
		JPanel pan=new JPanel();
		JLabel t=new JLabel();
		t.setIcon(titre);
		t.setHorizontalAlignment(JTextField.CENTER);
		pan.add(t);
		pan.setBackground(Color.white);
		
		this.add(pan,BorderLayout.NORTH);
		
		JPanel boutons = new JPanel(new GridLayout(4, 1));
		
		Font f = new Font("Bernard MT Condensed",Font.PLAIN,20);
		
		bClient = new JButton("Client");
		bClient.setFont(f);
		bClient.addActionListener(this);
		bClient.setPreferredSize(new Dimension(150,100));
		JPanel tc = new JPanel();
		tc.add(bClient);
		bLoc = new JButton("Locations");
		bLoc.addActionListener(this);
		bLoc.setFont(f);
		bLoc.setPreferredSize(new Dimension(150,100));
		JPanel tl = new JPanel();
		tl.add(bLoc);
		bRes = new JButton("Restitutions");
		bRes.addActionListener(this);
		bRes.setFont(f);
		bRes.setPreferredSize(new Dimension(150,100));
		JPanel tr = new JPanel();
		tr.add(bRes);
		bGestion = new JButton("Gestion");
		bGestion.addActionListener(this);
		bGestion.setFont(f);
		bGestion.setPreferredSize(new Dimension(150,100));
		JPanel tg = new JPanel();
		tg.setBackground(Color.white);
		tc.setBackground(Color.white);
		tl.setBackground(Color.white);
		tr.setBackground(Color.white);
		tg.add(bGestion);
		boutons.add(tc);
		boutons.add(tl);
		boutons.add(tr);
		boutons.add(tg);
		this.add(boutons,BorderLayout.CENTER);
		
		
		Icon icon1 = new ImageIcon("giphy.gif");
		JLabel label1 = new JLabel(icon1);
		label1.setPreferredSize(new Dimension(550,550));
		JPanel pani1 = new JPanel();
		pani1.add(label1);
		pani1.setBackground(Color.white);
		this.add(pani1,BorderLayout.EAST);
		Icon icon2 = new ImageIcon("voiture.gif");
		JLabel label2 = new JLabel(icon2);
		JPanel pani2 = new JPanel();
		pani2.add(label2);
		pani2.setBackground(Color.white);
		this.add(pani2,BorderLayout.SOUTH);
		Icon icon3 = new ImageIcon("moto.gif");
		JLabel label3 = new JLabel(icon3);
		label3.setPreferredSize(new Dimension(550,550));
		JPanel pani3 = new JPanel();
		pani3.add(label3);
		pani3.setBackground(Color.white);
		this.add(pani3,BorderLayout.WEST);
		
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
		if (source==bClient) {
			this.setVisible(false);
			MenuClient mc = new MenuClient();
		}
		else if (source==bLoc) {
			this.setVisible(false);
			MenuLocation ml = new MenuLocation();
		}
		else if (source==bGestion) {
			this.setVisible(false);
			MenuGestion mg = new MenuGestion();
		}
		else if (source==bRes) {
			this.setVisible(false);
			MenuRest mg = new MenuRest();
		}
	}
}
