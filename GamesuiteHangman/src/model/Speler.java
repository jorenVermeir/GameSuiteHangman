package model;

public class Speler {
	private String naam;
	private int score;
public Speler (String naam){
	setNaam(naam);
}
public Speler(String naam, int score){
	setNaam(naam);
	setScore(score);
}

public String getNaam() {
	return naam;
}

protected void setNaam(String naam) {
	if (naam == null||naam.trim().isEmpty()){
		throw new IllegalArgumentException("naam mag niet leeg zijn");
	}
	this.naam = naam;
}

public int getScore() {
	return score;
}

protected void setScore(int score) {
	if (score<0){throw new IllegalArgumentException("score is ongeldig");}
	this.score = score;
}
public int addToScore (int score){
	return this.getScore()+score;
}
public String toString(){
	return this.getNaam()+" met score "+this.getScore();

}

public boolean equals(Speler speler){
	if (this.naam.equals(speler.getNaam())&&this.score == speler.getScore()){
		return true;}
	
		else{ return false;}
	}
}


