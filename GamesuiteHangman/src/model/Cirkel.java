package model;

import java.awt.Color;
import java.awt.Graphics;

public class Cirkel extends Vorm{
	private Punt middelPunt;
	private int radius;
	
	public Cirkel(Punt middelPunt, int radius){
		setMiddelPunt(middelPunt);
		setRadius(radius);
	}
	
	private void setMiddelPunt(Punt middelPunt){
		if(middelPunt == null) throw new DomainException("Middelpunt moet een waarde bevatten.");
		this.middelPunt = middelPunt;
	}
	
	public Punt getMiddelPunt(){
		return middelPunt;
	}
	
	private void setRadius(int radius){
		if(radius <= 0) throw new DomainException("Straal moet strikt positief zijn.");
		this.radius = radius;
	}
	
	public int getRadius(){
		return radius;
	}

	public boolean equals(Object o){
		boolean gelijk = false;
		if (o instanceof Cirkel){
			Cirkel cirkel = (Cirkel)o;
			if(super.equals(cirkel) && this.getMiddelPunt() == cirkel.getMiddelPunt() && this.getRadius() == cirkel.getRadius()){
				gelijk = true;
			}
		}
		return gelijk;
	}
	
	@Override
	public String toString(){
		String output = "Cirkel: middelPunt: (" + middelPunt.getX() + ", " + middelPunt.getY() 
						+ ") - straal: " + radius;
		return output;
	}
	public Punt zoekLinkerbovenhoek(){
		int linkerBovenX = getMiddelPunt().getX()-radius;
		int linkerBovenY = getMiddelPunt().getY()-radius;
		Punt punt=new Punt(linkerBovenX, linkerBovenY);
		return punt;
	}
	@Override
	public Omhullende getOmhullende() {
		Punt linkerbovenhoek = zoekLinkerbovenhoek();
		int hoogte = radius*2;
		int breedte = radius*2;
		Omhullende omhullende = new Omhullende(linkerbovenhoek, breedte, hoogte);
		return omhullende;
	}

	
	public void teken(Graphics graphics) {
			graphics.setColor(Color.MAGENTA);
			graphics.fillOval(getMiddelPunt().getX()-getRadius(), 
					getMiddelPunt().getY()-getRadius(), 2*getRadius(), 2*getRadius());
	}

	
}
