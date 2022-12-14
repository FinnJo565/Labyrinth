package labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String name = new String();
	private String farbe = new String();
	private int spielerNummer;
	private int positionX;
	private int positionY;
	private List<Karte> kartenblatt;
	private boolean verschoben;
	
	public Spieler(String NameEingabe, String FarbeEingabe, int spielerNummerEingabe) {		
		this.name = NameEingabe;
		this.farbe = FarbeEingabe;
		this.spielerNummer = spielerNummerEingabe - 1;
		this.kartenblatt = new ArrayList<Karte>();
		
		if(this.farbe == "Gruen"){
			this.positionX = 0; 
			this.positionY = 0;
		}
		
		if(this.farbe == "Gelb"){
			this.positionX = 6; 
			this.positionY = 0;
		}
		
		if(this.farbe == "Blau"){
			this.positionX = 0; 
			this.positionY = 6;
		}
		
		if(this.farbe == "Rot"){
			this.positionX = 6; 
			this.positionY = 6;
		}
	}

	public void schrittNachOben() {
		if(positionY == 0)
		{
			this.positionY = 6;
		}else {
		this.positionY = (this.positionY - 1);
		}
	}
	
	public void schrittNachUnten() {
		this.positionY = (this.positionY + 1)%7;
	}
	
	public void schrittNachLinks() {
		if(positionX == 0)
		{
			this.positionX = 6;
		}else {
		this.positionX = (this.positionX - 1);
		}
	}
	
	public void schrittNachRechts() {
		this.positionX = (this.positionX + 1)%7;
	}
	
	public void kartenblattLeeren() {
        int n = this.kartenblatt.size();
        for(int i = 0; i < n; i++) {
            this.kartenblatt.remove(0);
        }
    }
	
	@Override
	public String toString() {
		String Ausgabe = new String();
		Ausgabe = this.name + " " + this.farbe + " " + positionX + " " + positionY + " " + this.kartenblatt; 
		return Ausgabe;
	}
	
	public boolean isVerschoben() {
		return verschoben;
	}

	public void setVerschoben(boolean verschoben) {
		this.verschoben = verschoben;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public List<Karte> getKartenblatt() {
		return kartenblatt;
	}

	public void setKartenblatt(List<Karte> kartenblatt) {
		this.kartenblatt = kartenblatt;
	}

	public int getSpielerNummer() {
		return spielerNummer;
	}

	public void setSpielerNummer(int spielerNummer) {
		this.spielerNummer = spielerNummer;
	}

}