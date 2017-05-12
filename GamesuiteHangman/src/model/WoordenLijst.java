package model;

import java.util.ArrayList;
import java.util.Random;

import model.*;

public class WoordenLijst {
	private ArrayList<String> woordenLijst;
	
	public WoordenLijst(){
		woordenLijst = new ArrayList<>();
	}
	
	public int getAantalWoorden(){
		return woordenLijst.size();
	}
	
	public void voegToe(String woord){
		if(woord == null || woord.trim().isEmpty()) throw new DomainException("Woord mag niet leeg zijn.");
		else if(woordenLijst.contains(woord)) throw new DomainException("Woord zit al in de lijst");
		woordenLijst.add(woord);
	}
	
	public String getRandomWoord(){
		Random random = new Random();
		int n = random.nextInt(woordenLijst.size()-1);
		return woordenLijst.get(n);
		
	}
	
}

