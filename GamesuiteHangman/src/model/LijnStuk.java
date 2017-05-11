package model;

import java.awt.Color;
import java.awt.Graphics;

public class LijnStuk extends Vorm implements Drawable{
	
	private Punt startPunt;
	private Punt eindPunt;
	
	public LijnStuk(Punt start, Punt eind) {
		setStartEnEindPunt(start, eind);
	}

	public void setStartEnEindPunt(Punt start, Punt eind) {
		if (start == null || eind == null) {
			throw new DomainException("Start- en/of eindpunt is null");
		}
		if (start.equals(eind)) {
			throw new DomainException("Start- en eindpunt zijn hetzelfde");
		}
		this.startPunt = start;
		this.eindPunt = eind;
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof LijnStuk) {
			LijnStuk lijnstuk = (LijnStuk) object;
			if (lijnstuk.eindPunt.equals(this.eindPunt) && lijnstuk.startPunt.equals(this.startPunt)) {
				return true;
			}
		}
		return false;
	}
	private int zoekHoogsteX(){
		if (getStartPunt().getX() > getEindPunt().getX()) {
			return getStartPunt().getX();
		}else{
			return getEindPunt().getX();
		}
	}
	private int zoekLaagsteX(){
		if (getStartPunt().getX() < getEindPunt().getX()) {
			return getStartPunt().getX();
		}else{
			return getEindPunt().getX();
		}
	}
	private int zoekHoogsteY(){
		if (getStartPunt().getY() > getEindPunt().getY()) {
			return getStartPunt().getY();
		}else{
			return getEindPunt().getY();
		}
	}
	private int zoekLaagsteY(){
		if (getStartPunt().getY() < getEindPunt().getY()) {
			return getStartPunt().getY();
		}else{
			return getEindPunt().getY();
		}
	}
	@Override
	public String toString() {
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
	}

	@Override
	public Omhullende getOmhullende() {
		Punt linkerbovenhoek = new Punt(zoekLaagsteX(), zoekLaagsteY());
		int hoogte = zoekHoogsteY() - zoekLaagsteY();
		int breedte = zoekHoogsteX() - zoekLaagsteX();
		Omhullende omhullende = new Omhullende(linkerbovenhoek, breedte, hoogte);
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		graphics.setColor(Color.RED);
		graphics.drawLine(startPunt.getX(), startPunt.getY(), eindPunt.getX(), eindPunt.getY());
	}


	
}
