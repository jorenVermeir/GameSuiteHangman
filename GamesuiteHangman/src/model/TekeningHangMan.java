package model;

import java.awt.Graphics;

public class TekeningHangMan extends Tekening {
	
	
	
	public TekeningHangMan() {
		super("hangman");
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
		
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		
		voegToe(galgBodem);
		voegToe(galgStaaf);
		voegToe(hangbar);
		voegToe(koord);
		
		voegToe(hoofd);
		voegToe(oogLinks);
		voegToe(oogRechts);
		voegToe(neus);
		
		voegToe(mond);
		voegToe(lijf);
		voegToe(beenLinks);
		voegToe(beenRechts);
		
		voegToe(voetLinks);
		voegToe(voetRechts);
		voegToe(armLinks);
		voegToe(armRechts);
		
		voegToe(handLinks);
		voegToe(handRechts);
		
		reset();
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
		if (super.getAantalVormen() == 0) {
			throw new DomainException("Er zijn geen vormen toegevoegd");
		}
		if (getAantalOnzichtbaar() < getAantalVormen()) {
			throw new DomainException("Alle vormen zijn zichtbaar");
		}
		super.getVorm(getAantalOnzichtbaar()).setZichtbaar(true);
	}
	
	public void reset() {
		for (Vorm vorm : super.getVormen()) {
			vorm.setZichtbaar(false);
		}
		for (int i = 0; i < 4; i++) {
			super.getVorm(i).setZichtbaar(true);
		}
	}
	
	@Override
	public void teken(Graphics graphics) {
		
	}
	
	@Override
	public void verwijder(Vorm vorm) {
		if (vorm == null) {
			throw new DomainException("Vorm is null");
		}
		super.verwijder(vorm);
	}
	
	@Override
	public void voegToe(Vorm vorm) {
		if (vorm == null) {
			throw new DomainException("Vorm is null");
		}
		super.voegToe(vorm);
	}

}
