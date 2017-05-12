package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import model.DomainException;
import model.WoordenLijst;

public class WoordenLezer {
	private String bestandsNaam;
	
	
	
	public WoordenLezer(String bestandsNaam){
		this.bestandsNaam = bestandsNaam;
	}
	
	public WoordenLijst lees(){
		File woordenFile = new File(bestandsNaam);
		WoordenLijst woorden = new WoordenLijst();
		try{
			Scanner scannerFile = new Scanner(woordenFile);
			while(scannerFile.hasNextLine()){
				Scanner scannerLijn = new Scanner(scannerFile.nextLine());
				String woord = scannerLijn.next();
				woorden.voegToe(woord);
			}
		}catch(FileNotFoundException ex){
			throw new DomainException("Fout bij het inlezen");
		}
		return woorden;
	}
}
