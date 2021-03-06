package model;


import java.awt.Graphics;
import java.util.*;

public class Tekening implements Drawable {

	private String naam;
	private int MIN_X = 0;
	private int MIN_Y = 0;
	private int MAX_X = 399;
	private int MAX_Y = 399;
	List <Vorm> vormen = new ArrayList<Vorm>();
	
	public Tekening( String naam){
		setNaam(naam);
	}

	private void setNaam(String naam) {
		if(naam== null || naam.trim().isEmpty() ){
			throw new IllegalArgumentException("De naam is leeg.");
		}
		this.naam = naam;
		
	}

	public String getNaam() {
		return naam;
	}
	
	public void  voegToe(Vorm vorm){
		if(vorm == null){
			throw new DomainException("De vorm mag niet leeg zijn.");
		}
		else if( vormen.contains(vorm)){
			throw new DomainException("De vorm komt al voor.");
		}
		if (vorm.getOmhullende().getMinX() < this.MIN_X || vorm.getOmhullende().getMaxX() > this.MAX_X || vorm.getOmhullende().getMinY() < this.MIN_Y || vorm.getOmhullende().getMaxY() > this.MAX_Y) {
			throw new DomainException("Vorm ligt niet volledig op de tekening.");
		}
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index){
		if(index > vormen.size() -1 || index < 0){
			throw new DomainException("ongeldige index");
		}
		return vormen.get(index);
	}
	
	public int getAantalVormen(){
		return vormen.size();
	}
	
	public void  verwijder(Vorm vorm){
		if(!vormen.contains(vorm)){
			throw new DomainException("De tekening bevat deze vorm niet");
		}
		else{
		vormen.remove(vorm);
		}
	}
	
	
	public boolean bevat(Vorm vorm){
		if(vormen.contains(vorm)){
			return true;
		}
		else{
			return false;
		}
	}
	

	public List<Vorm> getVormen() {
		return vormen;
	}

	public void setVormen(ArrayList<Vorm> vormen) {
		this.vormen = vormen;
	}

	@Override
	public boolean equals(Object o){
		if (o instanceof Tekening){
			Tekening t = (Tekening)o;
			for(Vorm vorm: vormen){
				if(!((Tekening) o).getVormen().contains(vorm)){ 
					return false;
				}
			}
			if(this.getAantalVormen() == t.getAantalVormen()){
				return true;
			}
			else{
				return false;
			}
				
		}
		return false;
	}


	@Override
	public String toString(){
		return 	"De volgende vormen zitten in de tekening: " + this.getVormen(); 
	}

	@Override
	public void teken(Graphics graphics) {
		for (Vorm vorm : vormen) {
			vorm.teken(graphics);
		}
		
	}

	public int getAantalOnzichtbaar() {
		int aantal = 0;
		for (Vorm vorm : getVormen()) {
			if (!vorm.isZichtbaar()) {
				aantal++;
			}
		}
		return aantal;
	
	}
}
