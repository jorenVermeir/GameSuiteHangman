package model;

import java.awt.Color;
import java.awt.Graphics;

public class Rechthoek extends Vorm{
private int breedte;
private int hoogte;
private Punt linkerBovenhoek;
public Rechthoek(Punt linkerbovenhoek,int breedte, int hoogte) {
	setBreedte(breedte);
	setHoogte(hoogte);
	setLinkerBovenhoek(linkerbovenhoek);
}
public int getBreedte() {
	return breedte;
}
public Punt getLinkerBovenhoek() {
	return linkerBovenhoek;
}
private void setLinkerBovenhoek(Punt hoek){
	if (hoek == null) {
		throw new DomainException("lege hoek bij rechthoek");
	} else {
		this.linkerBovenhoek = hoek;
	}
}
private void setBreedte(int breedte) {
	if (breedte <= 0 ) {
		throw new DomainException("Negatieve breedte rechthoek");
	} else {
		this.breedte = breedte;
	}
}
public int getHoogte() {
	return hoogte;
}
private void setHoogte(int hoogte) {
	if (hoogte <= 0) {
		throw new DomainException("negatieve hoogte rechthoek");
	} else {
		this.hoogte = hoogte;
	}
}
public boolean equals(Object object){
	if (object instanceof Rechthoek) {
		 Rechthoek rechthoek = (Rechthoek) object;
		if (super.equals(rechthoek) && rechthoek.getBreedte() == getBreedte() && rechthoek.getHoogte() == getHoogte() && rechthoek.getLinkerBovenhoek() == getLinkerBovenhoek()) {
			return true;
			}
		}
	return false;
}
@Override
public String toString() {
	return "Rechthoek: positie: " + linkerBovenhoek.toString() + "- breedte: " + getBreedte() + "- hoogte: " + getHoogte();
}
@Override
public Omhullende getOmhullende() {
	Omhullende out = new Omhullende(getLinkerBovenhoek(), getBreedte(), getHoogte());
	return out;
}

public void teken(Graphics graphics) {
	graphics.setColor(Color.pink);
	graphics.drawRect(linkerBovenhoek.getX(), linkerBovenhoek.getY(), getBreedte(), getHoogte());
}



}
