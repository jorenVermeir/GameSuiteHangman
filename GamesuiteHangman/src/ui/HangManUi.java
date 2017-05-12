package ui;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import model.*;

public class HangManUi {
	private Speler speler;
	private WoordenLijst woordenLijst;
	private TekenVenster venster;
	private TekeningHangMan t;
	
	public HangManUi(Speler speler, WoordenLijst woordenLijst){
		this.speler = speler;
		this.woordenLijst = woordenLijst;
		this.t = new TekeningHangMan();
		this.venster = new TekenVenster(t);
	}
	
	public void Play() {
		venster.teken();
		HintWoord hintwoord = new HintWoord(woordenLijst.getRandomWoord());
		int kansen = 14;
		while(!hintwoord.isGeraden() && kansen > 0){
			String strGeradenLetter = JOptionPane.showInputDialog("raad een letter", hintwoord.toString());
			char geradenLetter = strGeradenLetter.charAt(0);
			if(hintwoord.raad(geradenLetter)){
				JOptionPane.showMessageDialog(null, "Je hebt een juiste letter geraden! Raad een volgende letter", hintwoord.toString(), 0);
				if(hintwoord.isGeraden()){
					JOptionPane.showMessageDialog(null, "Proficiat! U heeft het woord geraden.");
					return;
				}
			
			}else{
				kansen -= 1;
				JOptionPane.showMessageDialog(null, "Fout!, nog " + kansen + " over.", hintwoord.toString(), 0);
				//
				t.zetVolgendeZichtbaar();
				if(kansen <= 0){
					JOptionPane.showMessageDialog(null, "Kansen zijn op! U heeft verloren.");
					return;
				}
			}
			
		}
		
	}

}
