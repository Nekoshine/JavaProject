import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
* Classe qui hérite d'une JFRAME et qui implémente un ActionListener et un ListSelectionListener dans le but de créer un menu qui correspond au menu de restitution
*/
public class MenuRest extends JFrame implements ActionListener, ListSelectionListener{
	private static final long serialVersionUID = 1L;
	private ArrayList<Location> tab;
	private JList<Location> list;
	private JTextField tkm;
	private JTextField tprix;
	private JButton retour;
	private JButton ok;
	/**
	* Constructeur de la classe MenuRest il permet de mettre en place les éléments au moment de l'instanciation de la classe
	*/
	public MenuRest(){
		super("VOITOVION");
		
		JPanel t = new JPanel();
		Icon titre= new ImageIcon("VOITOVION.png");
		JPanel pan=new JPanel();
		JLabel tl=new JLabel();
		tl.setIcon(titre);
		tl.setHorizontalAlignment(JTextField.CENTER);
		pan.add(tl);
		pan.setBackground(Color.white);
		t.add(pan);
		t.setBackground(Color.white);
		this.add(t,BorderLayout.NORTH);
		
		tab= new ArrayList<Location>();
		try {
			tab=GestionXML.readXMLLocation("Voiture");
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
			
			ArrayList<Location>tab2= new ArrayList<Location>();
			try {
				tab2=GestionXML.readXMLLocation("Moto");
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
			finally {
				
				ArrayList<Location>tab3= new ArrayList<Location>();
				try {
					tab3=GestionXML.readXMLLocation("Avion");
				} catch (IndexOutOfBoundsException e) {
					e.printStackTrace();
				}
				finally {
					
					Location[] listv= new Location[tab.size()];
					Location[] listm= new Location[tab2.size()];
					Location[] lista= new Location[tab3.size()];
					for (int i = 0; i < tab.size(); i++) {
						listv[i]=tab.get(i);
					}
					for (int i = 0; i < tab2.size(); i++) {
						listm[i]=tab2.get(i);
					}
					for (int i = 0; i < tab3.size(); i++) {
						lista[i]=tab3.get(i);
					}
					listv=concat(listv, concat(listm, lista));
					list = new JList<Location>(listv);
					list.addListSelectionListener(this);
					JScrollPane scroll = new JScrollPane(list);
					JPanel scrollp = new JPanel();
					scroll.setPreferredSize(new Dimension(400, 400));
					scrollp.add(scroll);
					scrollp.setBackground(Color.white);
					JPanel plist = new JPanel();
					plist.add(scrollp);
					plist.setBackground(Color.white);
					this.add(plist,BorderLayout.WEST);
					
					JPanel km = new JPanel();
					km.setLayout(new GridLayout(5,2));
					JLabel lkm = new JLabel("Nombre de km:");
					JPanel palk1 = new JPanel();
					JPanel palk2 = new JPanel();
					JPanel palk3 = new JPanel();
					JPanel palk4 = new JPanel();
					JPanel palk5 = new JPanel();
					JPanel patk1 = new JPanel();
					JPanel patk2 = new JPanel();
					JPanel patk3 = new JPanel();
					JPanel patk4 = new JPanel();
					JPanel patk5 = new JPanel();
					patk1.setBackground(Color.white);
					patk2.setBackground(Color.white);
					patk3.setBackground(Color.white);
					patk4.setBackground(Color.white);
					patk5.setBackground(Color.white);
					palk1.setBackground(Color.white);
					palk2.setBackground(Color.white);
					palk3.setBackground(Color.white);
					palk4.setBackground(Color.white);
					palk5.setBackground(Color.white);
					km.add(palk1);
					km.add(patk1);
					km.add(palk2);
					km.add(patk2);
					lkm.setHorizontalAlignment(JLabel.LEFT);
					palk3.add(lkm);
					km.add(palk3);
					tkm = new JTextField();
					tkm.setPreferredSize(new Dimension(200,50));
					patk3.add(tkm);
					km.add(patk3);
					km.add(palk4);
					km.add(patk4);
					km.add(palk5);
					km.add(patk5);
					km.setBackground(Color.white);
					this.add(km,BorderLayout.CENTER);
					
					JPanel prix = new JPanel();
					prix.setLayout(new GridLayout(5,2));
					JLabel lprix = new JLabel("Prix � payer:");
					JPanel palp1 = new JPanel();
					JPanel palp2 = new JPanel();
					JPanel palp3 = new JPanel();
					JPanel palp4 = new JPanel();
					JPanel palp5 = new JPanel();
					JPanel patp1 = new JPanel();
					JPanel patp2 = new JPanel();
					JPanel patp3 = new JPanel();
					JPanel patp4 = new JPanel();
					JPanel patp5 = new JPanel();
					patp1.setBackground(Color.white);
					patp2.setBackground(Color.white);
					patp3.setBackground(Color.white);
					patp4.setBackground(Color.white);
					patp5.setBackground(Color.white);
					palp1.setBackground(Color.white);
					palp2.setBackground(Color.white);
					palp3.setBackground(Color.white);
					palp4.setBackground(Color.white);
					palp5.setBackground(Color.white);
					prix.add(palp1);
					prix.add(patp1);
					prix.add(palp2);
					prix.add(patp2);
					lprix.setHorizontalAlignment(JLabel.LEFT);
					palp3.add(lprix);
					prix.add(palp3);
					tprix = new JTextField();
					tprix.setPreferredSize(new Dimension(200,50));
					patp3.add(tprix);
					prix.add(patp3);
					prix.add(palp4);
					prix.add(patp4);
					//prix.add(palp5);
					prix.add(patp5);
					prix.setBackground(Color.white);
					this.add(prix,BorderLayout.EAST);
					
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
			}
		}
	}
	/**
	* Procédure qui se déclenche lorsqu'un bouton est pressé
	* @param e Action réalisée
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==ok) {
			int kmparc = Integer.parseInt(tkm.getText())-50;
			float res = list.getSelectedValue().getPrixPrev();
			if (100-kmparc<0) {
				res=(res+0.5f*100);
				kmparc=kmparc-100;
				if (100-kmparc<0) {
					res=res+0.3f*100;
					kmparc=kmparc-100;
					if (100-kmparc<0) {
						res=res+0.2f*100;
						kmparc=kmparc-100;
						res=res+0.1f*kmparc;
					}
					else {
						res=res+0.2f*kmparc;
					}
				}
				else {
					res=res+0.3f*kmparc;
				}
			}
			else {
				if (kmparc>0) {
					res=res+0.5f*kmparc;
				}
			}
			if (list.getSelectedValue().isReduc()) {
				tprix.setText(Float.toString(res-(res*10)/100));
			}
			else {
				tprix.setText(Float.toString(res));
			}
			/*ArrayList<Location> lloc = GestionXML.readXMLLocation();
			for (int i = 0; i < lloc.size(); i++) {
			if (list.getSelectedValue().equals(lloc.get(i).getClient())) {
			lloc.get(i).getVehicule().setEtat(false);
			list.getSelectedValue().setPrixPrev(0);
			//GestionXML.delete
		}
	}*/
}
else if (source==retour) {
	this.setVisible(false);
	MenuPrincipal mp = new MenuPrincipal();
}

}
/**
* Procédure qui se déclenche quand un élément de la liste est sélectionne
* @param e Action réalisée
*/
@Override
public void valueChanged(ListSelectionEvent e) {
	Object source = e.getSource();
	tprix.setText(Float.toString(list.getSelectedValue().getPrixPrev()));
	
}

private Location[] concat(Location[] A, Location[] B) {
	int aLen = A.length;
	int bLen = B.length;
	Location[] C= new Location[aLen+bLen];
	System.arraycopy(A, 0, C, 0, aLen);
	System.arraycopy(B, 0, C, aLen, bLen);
	return C;
}

}
