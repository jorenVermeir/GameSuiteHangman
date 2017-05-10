package model;

import java.util.ArrayList;

public class Tekening {

	private String naam;
	private int MIN_X;
	private int MIN_Y;
	private int MAX_X;
	private int MAX_Y;
	ArrayList <Vorm> vormen = new ArrayList<Vorm>();
	
	public Tekening( String naam){
		setNaam(naam);
	}

	private void setNaam(String naam) {
		if(naam== null || naam.trim().isEmpty() ){
			throw new DomainException("De naam is leeg.");
		}
		this.naam = naam;
		
	}

	public String getNaam() {
		return naam;
	}
	
	public void  voegToe( Vorm vorm){
		if(vorm == null){
			throw new DomainException("De vorm mag niet leeg zijn.");
		}
		else if( vormen.contains(vorm)){
			throw new DomainException("De vorm komt al voor.");
		}
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index){
		return vormen.get(index);
	}
	
	public int getAantalVormen(){
		return vormen.size();
	}
	
	public void  verwijder(Vorm vorm){
		vormen.remove(vorm);
	}
	
	
	public boolean bevat(Vorm vorm){
		if(vormen.contains(vorm)){
			return true;
		}
		else{
			return false;
		}
	}
	

	public ArrayList<Vorm> getVormen() {
		return vormen;
	}

	public void setVormen(ArrayList<Vorm> vormen) {
		this.vormen = vormen;
	}

	@Override
	public boolean equals(Object o){
		boolean gelijk = false;
		if (o instanceof Tekening){
			Tekening t = (Tekening)o;
			if(super.equals(t) && this.vormen == t.getVormen()){
				gelijk = true;
			}
		}
		return gelijk;
	}


	@Override
	public String toString(){
		return 	"De volgende vormen zitten in de tekening: " + this.getVormen(); 
	}
}
