package model;

import java.awt.Graphics;

public class TekeningHangMan extends Tekening {
	
	
	
	public TekeningHangMan() {
		super("hangman");
	}
	
	public String getNaam() {
		return super.getNaam();
	}
	
	public int getAantalOnzichtbaar() {
		int aantal = 0;
		for (Vorm vorm : super.getVormen()) {
			if (!vorm.isZichtbaar()) {
				aantal++;
			}
		}
		return aantal;
	}
	
	public void zetVolgendeZichtbaar() {
		
		super.getVorm(getAantalOnzichtbaar() + 1).setZichtbaar(true);
	}
	
	public void reset() {
		
	}
	
	public void teken(Graphics graphics) {
		
	}
	
	public void verwijder(Vorm vorm) {
		
	}
	
	public void voegToe(Vorm vorm) {
		
	}

}
