package labyrinth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class LabyrinthGUI extends JFrame {

	private LabyrinthDaten daten;

	// Menueleiste
	private JMenuBar menueLeiste;
	private JMenu spielMenue;
	private JMenuItem beenden;
	private JMenuItem neuesSpiel;
	private JMenuItem hilfe;
	private JButton oben;
	private JButton unten;
	private JButton links;
	private JButton rechts;
	private JButton fertig;
	private JPanel p1;
	private JPanel spielerKartenUebersicht;
	private JPanel spielfeldPanel;
	private JPanel einschiebeGangPanel;
	private JPanel aktuellerSpielerPanel;
	private JPanel joysticksPanel;
	
	private GridBagLayout gridHauptfenster;
	private GridBagConstraints constraintsHauptfenster;
	
	private Willkommen willkommen;
	
	
	public LabyrinthGUI(LabyrinthDaten model) {
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("Das Verrueckte Labyrinth");
		this.daten = model;
		
		// JFrame-Konfiguration
		this.setSize(1500, 1000);
		this.setLocation(200, 20);
		
		gridHauptfenster = new GridBagLayout();
		
		//BackgroundPanel
		p1 = new JPanel();
		p1.setLayout(null);
		this.add(p1);
		//p1.setBackground(Color.lightGray);
		p1.setLayout(gridHauptfenster);
		
		constraintsHauptfenster = new GridBagConstraints();
		constraintsHauptfenster.fill = GridBagConstraints.HORIZONTAL;
		//Padding (top, left, bottom, right)
		constraintsHauptfenster.insets = new Insets(5,5,5,5);
		
		//SpielerKartenUebersicht Panel
		constraintsHauptfensterEigenschaftenSetzen(0,0,1,1);
		spielerKartenUebersicht = new JPanel();
		spielerKartenUebersicht.setBackground(Color.black);
		gridHauptfenster.setConstraints(spielerKartenUebersicht, constraintsHauptfenster);
		this.add(spielerKartenUebersicht);
		
		//Spielfeld
		constraintsHauptfensterEigenschaftenSetzen(1,0,1,1);
		spielfeldPanel = new JPanel();
		spielfeldPanel.setBackground(Color.blue);
		gridHauptfenster.setConstraints(spielfeldPanel, constraintsHauptfenster);
		this.add(spielfeldPanel);
		
		//EinschiebeGang
		constraintsHauptfensterEigenschaftenSetzen(2,0,1,1);
		einschiebeGangPanel = new JPanel();
		einschiebeGangPanel.setBackground(Color.CYAN);
		gridHauptfenster.setConstraints(einschiebeGangPanel, constraintsHauptfenster);
		this.add(einschiebeGangPanel);
		
		//AktuellerSpielerPanel
		constraintsHauptfensterEigenschaftenSetzen(1,1,1,1);
		aktuellerSpielerPanel = new JPanel();
		aktuellerSpielerPanel.setBackground(Color.yellow);
		gridHauptfenster.setConstraints(aktuellerSpielerPanel, constraintsHauptfenster);
		this.add(aktuellerSpielerPanel);
		
		//Joysticks Panel
		constraintsHauptfensterEigenschaftenSetzen(2,2,1,1);
		joysticksPanel = new JPanel();
		joysticksPanel.setBackground(Color.red);
		gridHauptfenster.setConstraints(joysticksPanel, constraintsHauptfenster);
		this.add(joysticksPanel);
		
		//Icons
		ImageIcon obenIcon = new ImageIcon("iconOben.png");
		ImageIcon untenIcon = new ImageIcon("iconUnten.png");
		ImageIcon linksIcon = new ImageIcon("iconLinks.png");
		ImageIcon rechtsIcon = new ImageIcon("iconRechts.png");
		ImageIcon fertigIcon = new ImageIcon("iconFertig.png");
		
		// Menue
		menueLeiste = new JMenuBar();
		spielMenue = new JMenu("Spiel");
		neuesSpiel = new JMenuItem("Neues Spiel");
		hilfe = new JMenuItem("Hilfe");
		beenden = new JMenuItem("Beenden");
		
		oben = new JButton(obenIcon);
		unten = new JButton(untenIcon);
		rechts = new JButton(rechtsIcon);
		links = new JButton(linksIcon);
		fertig = new JButton(fertigIcon);
		
		
		//Joystick
		oben.setBounds(1250, 690, 52, 52);
		oben.setBorderPainted(false);
		oben.setContentAreaFilled(false);
		oben.setFocusPainted(false);
		oben.setOpaque(false);
		
		unten.setBounds(1250, 810, 52, 52);
		unten.setBorderPainted(false);
		unten.setContentAreaFilled(false);
		unten.setFocusPainted(false);
		unten.setOpaque(false);
		
		rechts.setBounds(1310, 750, 52, 52);
		rechts.setBorderPainted(false);
		rechts.setContentAreaFilled(false);
		rechts.setFocusPainted(false);
		rechts.setOpaque(false);
		
		links.setBounds(1190, 750, 52, 52);
		links.setBorderPainted(false);
		links.setContentAreaFilled(false);
		links.setFocusPainted(false);
		links.setOpaque(false);
		
		fertig.setBounds(1250, 750, 52, 52);
		fertig.setBorderPainted(false);
		fertig.setContentAreaFilled(false);
		fertig.setFocusPainted(false);
		fertig.setOpaque(false);
		
		//ActionListener
		neuesSpiel.addActionListener(e -> {System.exit(0);});
		hilfe.addActionListener(e -> {System.exit(0);});
		beenden.addActionListener(e -> {beenden();});
		
		oben.addActionListener(e -> {System.exit(0);});
		unten.addActionListener(e -> {System.exit(0);});
		rechts.addActionListener(e -> {System.exit(0);});
		links.addActionListener(e -> {System.exit(0);});
		fertig.addActionListener(e -> {System.exit(0);});
		
		//Menueleiste Zuordnung
		menueLeiste.add(spielMenue);
		spielMenue.add(neuesSpiel);
		spielMenue.add(hilfe);
		spielMenue.add(beenden);
		
		p1.add(oben);
		p1.add(unten);
		p1.add(rechts);
		p1.add(links);
		p1.add(fertig);
		
		// zum Fenster hinzufuegen
		this.setJMenuBar(menueLeiste);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				beenden();
			}
		});
		
		//Willkommens-Fenster
		willkommen = new Willkommen();
		willkommen.setVisible(true);
		willkommen.setAlwaysOnTop(true);
		
	}
	
	
	private class Willkommen extends JDialog{
		
		private JPanel bildpanel;
		private JPanel abfragepanel;		
		
		//Abfrage 1
		private JLabel spielerAnzahl;
		private JButton zweiSpieler;
		private JButton dreiSpieler;
		private JButton vierSpieler;
		
		//Abfrage 2
		private JLabel spielerNamelabel;
		private JLabel spielerFarbe;
		private JTextArea spielerNametext;
		private JComboBox<String> spielerFarbeAuswahl;
		private String[] farben = {"Rot","Blau","Gruen","Gelb"};
		private JButton fertig;
		private GridBagLayout gbl;
		
		
		private GridBagConstraints gbc;
		private GridBagConstraints gbcZwei;
		
		Willkommen(){
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setTitle("Das Verrueckte LabyrINTh");
			
			// JFrame-Konfiguration
			this.setSize(1200, 800);
			this.setLocation(400, 100);
			gbl = new GridBagLayout();
			this.setLayout(gbl);
						
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(5,5,5,5);
			
			gbcEigenschaftenSetzen(0,0,3,1);
			//gbc.gridx = 0;
			//gbc.gridy = 0;
			//gbc.gridwidth = 3;
			//gbc.gridheight = 1;
			String imagePath = "Labyrinth_Logo.png";
			try {
				BufferedImage logo = ImageIO.read(new File(imagePath));
				JLabel picLabel = new JLabel(new ImageIcon(logo));
				bildpanel = new JPanel();
				gbl.setConstraints(bildpanel, gbc);
				this.add(bildpanel);
				bildpanel.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 3;
			gbc.gridheight = 1;
			gbc.insets = new Insets(5,30,5,5);
			spielerAnzahl = new JLabel ("Wie viele Spieler seid ihr?");
			spielerAnzahl.setSize(300, 30);
			gbl.setConstraints(spielerAnzahl, gbc);
			this.add(spielerAnzahl);
						
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,30,30,15);
			zweiSpieler = new JButton("Zwei Spieler");
			zweiSpieler.setSize(200, 20);
			zweiSpieler.addActionListener(e -> spielerAnzahlSetzen(2));
			gbl.setConstraints(zweiSpieler, gbc);
			this.add(zweiSpieler);
					
			gbc.gridx = 1;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,15,30,15);
			dreiSpieler = new JButton("Drei Spieler");
			dreiSpieler.setSize(200, 20);
			dreiSpieler.addActionListener(e -> spielerAnzahlSetzen(3));
			gbl.setConstraints(dreiSpieler, gbc);
			this.add(dreiSpieler);
			
			gbc.gridx = 2;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.insets = new Insets(15,15,30,30);
			vierSpieler = new JButton("Vier Spieler");
			vierSpieler.setSize(200, 20);
			vierSpieler.addActionListener(e -> spielerAnzahlSetzen(4));
			gbl.setConstraints(vierSpieler, gbc);
			this.add(vierSpieler);
			
			pack();			
		}
		
		private void spielerAnzahlSetzen(int spAnzahl){
			daten.setSpieleranzahl(spAnzahl);
			
			gbl.removeLayoutComponent(bildpanel);
			this.remove(bildpanel);
			gbl.removeLayoutComponent(spielerAnzahl);
			this.remove(spielerAnzahl);
			gbl.removeLayoutComponent(zweiSpieler);
			this.remove(zweiSpieler);
			gbl.removeLayoutComponent(dreiSpieler);
			this.remove(dreiSpieler);
			gbl.removeLayoutComponent(vierSpieler);
			this.remove(vierSpieler);
			
			//repaint();
			spielerEigenschaftenSetzen(1);
		}
		
		private void spielerEigenschaftenSetzen(int spielerNummer) {
				
			gbcZwei = new GridBagConstraints();
			gbcZwei.fill = GridBagConstraints.HORIZONTAL;
			gbcZwei.insets = new Insets(5,5,5,5);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 0;
			gbcZwei.gridwidth = 4;
			gbcZwei.gridheight = 1;
			gbl.setConstraints(bildpanel, gbcZwei);
			this.add(bildpanel);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 1;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerNamelabel = new JLabel ("Wie heisst Spieler " + spielerNummer + "?");
			//spielerNamelabel.setSize(300, 30);
			gbl.setConstraints(spielerNamelabel, gbcZwei);
			this.add(spielerNamelabel);
			
			gbcZwei.gridx = 2;
			gbcZwei.gridy = 1;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerFarbe = new JLabel ("Farbe:");
			//spielerFarbe.setSize(300, 30);
			gbl.setConstraints(spielerFarbe, gbcZwei);
			this.add(spielerFarbe);
			
			gbcZwei.gridx = 0;
			gbcZwei.gridy = 2;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerNametext = new JTextArea();
			//spielerNametext.setSize(400, 30);
			gbl.setConstraints(spielerNametext, gbcZwei);
			this.add(spielerNametext);
			
			gbcZwei.gridx = 2;
			gbcZwei.gridy = 2;
			gbcZwei.gridwidth = 2;
			gbcZwei.gridheight = 1;
			spielerFarbeAuswahl = new JComboBox<String>(farben);
			//spielerFarbeAuswahl.setSize(300, 30);
			gbl.setConstraints(spielerFarbeAuswahl, gbcZwei);
			this.add(spielerFarbeAuswahl);
			
			
			gbcZwei.gridx = 3;
			gbcZwei.gridy = 3;
			gbcZwei.gridwidth = 1;
			gbcZwei.gridheight = 1;
			gbcZwei.insets = new Insets(5,130,15,30);
			fertig = new JButton("Fertig");
			//fertig.setSize(100, 30);
			fertig.addActionListener(e -> spielerEigenschaftenSpeichern(spielerNummer));
			gbl.setConstraints(fertig, gbcZwei);
			this.add(fertig);
			
			pack();
		
		}
		
		private void spielerEigenschaftenSpeichern(int spielerNummer) {
			
			String name = spielerNametext.getText();
			int indexFarbe = spielerFarbeAuswahl.getSelectedIndex();
			String farbe = spielerFarbeAuswahl.getItemAt(indexFarbe);
			daten.getSpielerliste().add(new Spieler(name, farbe));
	

			if(daten.getSpielerliste().size() < daten.getSpieleranzahl()) {
				String[] neueFarbauswahl = new String[farben.length - 1];
				int j = 0;
				for(int i = 0; i < farben.length; i++) {
					if (!farbe.equals(farben[i])) {
						neueFarbauswahl[j] = farben[i];
						j++;
					}
				}
				farben = neueFarbauswahl;
				spielerNametext.setText("");
				gbl.removeLayoutComponent(bildpanel);
				this.remove(bildpanel);
				gbl.removeLayoutComponent(spielerNamelabel);
				this.remove(spielerNamelabel);
				gbl.removeLayoutComponent(spielerFarbe);
				this.remove(spielerFarbe);
				gbl.removeLayoutComponent(spielerNametext);
				this.remove(spielerNametext);
				gbl.removeLayoutComponent(spielerFarbeAuswahl);
				this.remove(spielerFarbeAuswahl);
				gbl.removeLayoutComponent(fertig);
				this.remove(fertig);
				
				//repaint();
				spielerEigenschaftenSetzen(spielerNummer + 1);
			} else {
				willkommenSchliessen();
				System.out.println(daten.getSpielerliste());
			}
		}
		
		private void gbcEigenschaftenSetzen(int x, int y, int width, int height) {
			this.gbc.gridx = x;
			this.gbc.gridy = y;
			this.gbc.gridwidth = width;
			this.gbc.gridheight = height;
		}
		
		private void gbcZweiEigenschaftenSetzen(int x, int y, int width, int height) {
			this.gbcZwei.gridx = x;
			this.gbcZwei.gridy = y;
			this.gbcZwei.gridwidth = width;
			this.gbcZwei.gridheight = height;
		}
		
		
	}
	
	private void willkommenSchliessen() {
		this.willkommen.setVisible(false);
		spielGenerieren();
	}
	
	private void spielGenerieren() {
		daten.setKartendeck(Karte.erstelleKartenDeck()); 
		Karte.shuffleKartenDeck(daten.getKartendeck());
		daten.schatzkartenAusteilen(daten.getKartendeck());
		
		System.out.println(daten.getSpielerliste());
	}
	
	private void constraintsHauptfensterEigenschaftenSetzen(int x, int y, int width, int height) {
		this.constraintsHauptfenster.gridx = x;
		this.constraintsHauptfenster.gridy = y;
		this.constraintsHauptfenster.gridwidth = width;
		this.constraintsHauptfenster.gridheight = height;
	}
	
	private void beenden() {
		System.exit(0);		
	}
	
}
