package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Driehoek extends Vorm implements Drawable{

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);

	}
	
	public void setHoekPunten(Punt hoekPunt1,Punt hoekPunt2,Punt hoekPunt3){
		if(hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null){
			throw new DomainException("een van de punten is leeg");
		}
		this.hoekPunt1 = hoekPunt1 ;
		this.hoekPunt2 = hoekPunt2;
		this.hoekPunt3 = hoekPunt3;
	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	
	public Punt getHoekPunt3() {
		return hoekPunt3;
	}
	
	@Override
	public boolean equals(Object o){
		boolean gelijk= false;
		if( o instanceof Driehoek){
			Driehoek h = (Driehoek)o;
			if(super.equals(h) && this.hoekPunt1 == h.getHoekPunt1() && this.hoekPunt2 == h.getHoekPunt2() && this.hoekPunt3 == h.getHoekPunt3()){
				gelijk = true;
			}
		}
		return gelijk;
	}
	private int zoekLaagsteY(){
		int laagsteY = getHoekPunt1().getY();
		if (laagsteY > getHoekPunt2().getY()) {
			laagsteY = getHoekPunt2().getY();
		}
		if (laagsteY > getHoekPunt3().getY()) {
			laagsteY = getHoekPunt3().getY();
		}
		return laagsteY;
	}
	
	private int zoekLaagsteX(){
		int laagsteX = getHoekPunt1().getX();
		if (laagsteX > getHoekPunt2().getX()) {
			laagsteX = getHoekPunt2().getX();
		}
		if (laagsteX > getHoekPunt3().getX()) {
			laagsteX = getHoekPunt3().getX();
		}
		return laagsteX;
	}
	private int zoekHoogsteY(){
		int hoogsteY = getHoekPunt1().getY();
		if (hoogsteY > getHoekPunt2().getY()) {
			hoogsteY = getHoekPunt2().getY();
		}
		if (hoogsteY < getHoekPunt3().getY()) {
			hoogsteY = getHoekPunt3().getY();
		}
		return hoogsteY;
	}
	private int zoekHoogsteX(){
		int hoogsteX = getHoekPunt1().getY();
		if (hoogsteX > getHoekPunt2().getY()) {
			hoogsteX = getHoekPunt2().getY();
		}
		if (hoogsteX < getHoekPunt3().getY()) {
			hoogsteX = getHoekPunt3().getY();
		}
		return hoogsteX;
	}
	@Override
	public String toString(){
		return "Driehoek: hoekpunt1" + getHoekPunt1() + " - hoekpunt2" + getHoekPunt2() + " + hoekpunt3" + getHoekPunt3();
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
	public void teken(Graphics graphics){
		graphics.setColor(Color.orange);
		int xPoints[] = {getHoekPunt1().getX(), getHoekPunt2().getX(), getHoekPunt3().getX()};
		int yPoints[] = {getHoekPunt1().getY(), getHoekPunt2().getY(), getHoekPunt3().getY()};
		graphics.drawPolygon(xPoints, yPoints, 3);
		
	}


}
