package model;

public class HangMan {
	private Speler speler;
	private WoordenLijst woordenlijst;
	private HintWoord hintWoord;
	

	public HangMan(Speler speler, WoordenLijst woordenLijst) {
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
		hintWoord = new HintWoord(woordenLijst.getRandomWoord());
		}

	private void setWoordenLijst(WoordenLijst woordenLijst) {
		if (woordenLijst != null && woordenLijst.getAantalWoorden()>0){
			this.woordenlijst=woordenLijst;
		}
		
	}

	private void setSpeler(Speler speler) {
		if (speler==null){throw new DomainException("speler mag niet null zijn");
			
			
		}this.speler=speler;
		
	}

	public Speler getSpeler() {
		return speler;
	}

	public boolean isGameOver() {
		return speler.getScore()>=14;
	}



	public void raad(char letter) {
		hintWoord.raad(letter);
		
	}

	public boolean isGewonnen() {
		
		return hintWoord.isGeraden();
	}

	public Tekening getTekening() {
		return null;
	}

	public String getHint() {
		return hintWoord.toString();
	}

}
