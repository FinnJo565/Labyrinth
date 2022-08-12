package labyrinth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SpielerPanel extends JPanel{

	private JLabel kartenanzahl;
	private JLabel spielernummer;
	private JPanel kartenuebrig;
	private JLabel spielername;
	
		
	public SpielerPanel(int y, String spNummer, String spName) {
		this.setLayout(new BorderLayout());
		this.setBounds(40, y, 230, 115);
		
		kartenanzahl = new JLabel("6", SwingConstants.CENTER);
		kartenanzahl.setSize(225, 110);
		kartenanzahl.setFont(kartenanzahl.getFont().deriveFont((float) 27));
		kartenanzahl.setForeground(Color.white);
		kartenanzahl.setBorder(BorderFactory.createEmptyBorder(0, 162, 0, 0));	
		this.add(kartenanzahl, BorderLayout.EAST);	
		spielernummer = new JLabel(spNummer);
		spielernummer.setSize(200, 60);	
		spielernummer.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));		
		spielernummer.setFont(spielernummer.getFont().deriveFont((float) 22));
		this.add(spielernummer,BorderLayout.WEST);
		kartenuebrig = new JPanel();
		generiereGangbilder(kartenuebrig, "Bilder/rueckseite_k.png");
		kartenuebrig.setSize(63,110);
		this.add(kartenuebrig, BorderLayout.EAST);
		spielername = new JLabel(spName);
		spielername.setSize(200, 25);
		spielername.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		spielername.setFont(spielername.getFont().deriveFont((float) 15));
		this.add(spielername,BorderLayout.WEST);
	}
	
	public JLabel getKartenanzahl() {
		return kartenanzahl;
	}

	public void setKartenanzahl(JLabel kartenanzahl) {
		this.kartenanzahl = kartenanzahl;
	}


	public JLabel getSpielername() {
		return spielername;
	}

	public void setSpielername(JLabel spielername) {
		this.spielername = spielername;
	}

	private void generiereGangbilder(JPanel gangpanel, String gangpath) {
		try {
			BufferedImage logo = ImageIO.read(new File(gangpath));
			JLabel picLabel = new JLabel(new ImageIcon(logo));
			gangpanel.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}