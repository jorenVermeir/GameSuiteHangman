package model;

import java.awt.Graphics;

public class TekeningHangMan extends Tekening {
	
	
	
	public TekeningHangMan() {
		super("hangman");
	}
	
	@Override
	public String getNaam() {
		return super.getNaam();
	}
	
	@Override
	public int getAantalOnzichtbaar() {
		return super.getAantalOnzichtbaar();
	}
	
	public void zetVolgendeZichtbaar() {
		if (getAantalOnzichtbaar() < getAantalVormen()) {
			throw new DomainException("Alle vormen zijn zichtbaar");
		}
		super.getVorm(getAantalOnzichtbaar() + 1).setZichtbaar(true);
	}
	
	public void reset() {
		
	}
	
	@Override
	public void teken(Graphics graphics) {
		
	}
	
	@Override
	public void verwijder(Vorm vorm) {
		
	}
	
	@Override
	public void voegToe(Vorm vorm) {
		
	}

}
