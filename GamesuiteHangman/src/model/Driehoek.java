package model;

public class Driehoek {

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
		
		
	}
	
	private void setHoekPunten(Punt hoekPunt1,Punt hoekPunt2,Punt hoekPunt3){
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
	
}
