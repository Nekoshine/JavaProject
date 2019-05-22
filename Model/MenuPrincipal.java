import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPrincipal /*extends JFrame implements ActionListener*/{

	public MenuPrincipal() {

		Icon titre= new ImageIcon("VOITOVION.png");
		JPanel pan=new JPanel();
		JLabel t=new JLabel();
		t.setIcon(titre);
		t.setHorizontalAlignment(JTextField.CENTER);
		pan.add(t);
		pan.setBackground(Color.white);
		
		
		JFrame fenetre = new JFrame("VOITOVION");
		fenetre.add(pan,BorderLayout.NORTH);
		
		JPanel boutons = new JPanel(new GridLayout(4, 1));
		
		JButton bclient = new JButton("Client");
		bclient.setPreferredSize(new Dimension(150,100));
		JPanel tc = new JPanel();
		tc.add(bclient);
		JButton bloc = new JButton("Locations");
		bloc.setPreferredSize(new Dimension(150,100));
		JPanel tl = new JPanel();
		tl.add(bloc);
		JButton bres = new JButton("Restitutions");
		bres.setPreferredSize(new Dimension(150,100));
		JPanel tr = new JPanel();
		tr.add(bres);
		JButton bgestion = new JButton("Gestion");
		bgestion.setPreferredSize(new Dimension(150,100));
		JPanel tg = new JPanel();
		tg.setBackground(Color.white);
		tc.setBackground(Color.white);
		tl.setBackground(Color.white);
		tr.setBackground(Color.white);
		tg.add(bgestion);
		boutons.add(tc);
		boutons.add(tl);
		boutons.add(tr);
		boutons.add(tg);
		fenetre.add(boutons,BorderLayout.CENTER);
		
		Icon icon1 = new ImageIcon("giphy.gif");
        JLabel label1 = new JLabel(icon1);
        JPanel pani1 = new JPanel();
        pani1.add(label1);
        pani1.setBackground(Color.white);
        fenetre.add(pani1,BorderLayout.EAST);
        Icon icon2 = new ImageIcon("voiture.gif");
        JLabel label2 = new JLabel(icon2);
        JPanel pani2 = new JPanel();
        pani2.add(label2);
        pani2.setBackground(Color.white);
        fenetre.add(pani2,BorderLayout.SOUTH);
        Icon icon3 = new ImageIcon("moto.gif");
        JLabel label3 = new JLabel(icon3);
        label3.setPreferredSize(new Dimension(550,550));
        JPanel pani3 = new JPanel();
        pani3.add(label3);
        pani3.setBackground(Color.white);;
        fenetre.add(pani3,BorderLayout.WEST);
		
		fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
	}
}