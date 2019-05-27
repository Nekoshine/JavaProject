import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MenuPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	public JButton bclient;

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

		bclient = new JButton("Client");
		bclient.setFont(f);
		bclient.addActionListener(this);
		bclient.setPreferredSize(new Dimension(150,100));
		JPanel tc = new JPanel();
		tc.add(bclient);
		JButton bloc = new JButton("Locations");
		bloc.setFont(f);
		bloc.setPreferredSize(new Dimension(150,100));
		JPanel tl = new JPanel();
		tl.add(bloc);
		JButton bres = new JButton("Restitutions");
		bres.setFont(f);
		bres.setPreferredSize(new Dimension(150,100));
		JPanel tr = new JPanel();
		tr.add(bres);
		JButton bgestion = new JButton("Gestion");
		bgestion.setFont(f);
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
		pani2.addMouseListener(new MouseListener() {
			Sound sound = new Sound("dejavu.WAV");
			InputStream stream = new ByteArrayInputStream(sound.getSamples()); 


			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					stream.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Bonjour");
				//sound.play(stream);	
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
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

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==bclient) {
			this.setVisible(false);
			MenuClient mc = new MenuClient();
		}
	}

	
	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
	}
}
