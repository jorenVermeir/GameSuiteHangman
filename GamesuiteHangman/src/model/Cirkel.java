package model;

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
}
