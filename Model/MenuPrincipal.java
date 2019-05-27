import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MenuPrincipal /*extends JFrame implements ActionListener*/ {
	
	
	
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
		
		Font f = new Font("Bernard MT Condensed",Font.PLAIN,20);
		
		JButton bclient = new JButton("Client");
		bclient.setFont(f);
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
		fenetre.add(boutons,BorderLayout.CENTER);
		
		
		
		Icon icon1 = new ImageIcon("giphy.gif");
		JLabel label1 = new JLabel(icon1);
		label1.setPreferredSize(new Dimension(550,550));
		JPanel pani1 = new JPanel();
		pani1.add(label1);
		pani1.setBackground(Color.white);
		fenetre.add(pani1,BorderLayout.EAST);
		Icon icon2 = new ImageIcon("voiture.gif");
		JLabel label2 = new JLabel(icon2);
		JPanel pani2 = new JPanel();
		pani2.add(label2);
		pani2.setBackground(Color.white);
		pani2.addMouseListener(new MouseListener() {
			private AudioFormat format;
			private byte[] samples;
			/**
			*
			* @param filename le lien vers le fichier song (URL ou absolute path)
			*/
			public void sound(String filename){
				try{
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File(filename));
					format = stream.getFormat();
					samples = getSamples(stream);
				}
				catch (UnsupportedAudioFileException e){
					e.printStackTrace();
				}
				catch (IOException e){
					e.printStackTrace();
				}
			}
			public byte[] getSamples(){
				return samples;
			}
			public byte[] getSamples(AudioInputStream stream){
				int length = (int)(stream.getFrameLength() * format.getFrameSize());
				byte[] samples = new byte[length];
				DataInputStream in = new DataInputStream(stream);
				try{
					in.readFully(samples);
				}
				catch (IOException e){
					e.printStackTrace();
				}
				return samples;
			}
			public void play(InputStream source) {
				int bufferSize = format.getFrameSize() * Math.round(format.getSampleRate() / 10);
				byte[] buffer = new byte[bufferSize];
				SourceDataLine line;
				try{
					DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
					line = (SourceDataLine)AudioSystem.getLine(info);
					line.open(format, bufferSize);
				}
				catch (LineUnavailableException e){
					e.printStackTrace();
					return;
				}
				line.start();
				try{
					int numBytesRead = 0;
					while (numBytesRead != -1){
						numBytesRead = source.read(buffer, 0, buffer.length);
						if (numBytesRead != -1)
						line.write(buffer, 0, numBytesRead);
					}
				}
				catch (IOException e){
					e.printStackTrace();
				}
				line.drain();
				line.close();
			}
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Bonjour");/*
				this.sound("dejavu.WAV");
				InputStream stream = new ByteArrayInputStream(this.getSamples());
				this.play(stream);	*/
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
