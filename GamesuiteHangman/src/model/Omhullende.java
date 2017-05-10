package model;

public class Omhullende {
private Punt linkerBovenhoek;
private int breedte;
private int hoogte;
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerBovenhoek);
	}
	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}
	private void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if (linkerBovenhoek == null) {
			throw new DomainException("leeg punt omhullende");
		} else {
			this.linkerBovenhoek = linkerBovenhoek;
		}
	}
	public int getBreedte() {
		return breedte;
	}
	private void setBreedte(int breedte) {
		if (breedte < 0) {
			throw new DomainException("negatieve breedte bij omhullende");
		} else {
			this.breedte = breedte;
		}
	}
	public int getHoogte() {
		return hoogte;
	}
	public int getMaxX(){
		return linkerBovenhoek.getX() + getBreedte();
	}
	public int getMinX(){
		return linkerBovenhoek.getX();
	}
	public int getMaxY(){
		return linkerBovenhoek.getY() + getHoogte();
	}
	public int getMinY(){
		return linkerBovenhoek.getY();
	}
	private void setHoogte(int hoogte) {
		if (hoogte < 0) {
			throw new DomainException("negatieve hoogte bij omhullende");
		} else {
			this.hoogte = hoogte;
		}
	}
	@Override
	public String toString() {
		 return "Omhullende: " + linkerBovenhoek.toString() + " - " + breedte + " - " + hoogte;
		//return "Rechthoek: postitie: (" + linkerBovenhoek.getX() + ", " + linkerBovenhoek.getY() + ") - breedte: " + getBreedte() + " - hoohte: " + getHoogte() + "\n" +
			//	"Omhullende: (" + linkerBovenhoek.getX() + ", " + linkerBovenhoek.getY() + ") - " + getBreedte() + " - " + getHoogte(); 
	}
	@Override
	public boolean equals(Object o) {
		boolean gelijk = false;
		if (o instanceof Omhullende) {

			Omhullende s = (Omhullende) o;
			if (s.getBreedte() == getBreedte() && s.getHoogte() == getHoogte() && s.getLinkerBovenhoek() == getLinkerBovenhoek()) {
				gelijk = true;
			}
		}

		return gelijk;
	}

}
