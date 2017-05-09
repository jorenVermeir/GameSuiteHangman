package model;

public class Speler {
	private String naam;
	private int score;

	public Speler(String naam) {
		setNaam(naam);
	}

	public Speler(String naam, int score) {
		setNaam(naam);
		setScore(score);
	}

	public String getNaam() {
		return naam;
	}

	protected void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("naam mag niet leeg zijn");
		}
		this.naam = naam;
	}

	public int getScore() {
		return score;
	}

	protected void setScore(int score) {
		if (score < 0) {
			throw new DomainException("score is ongeldig");
		}
		this.score = score;
	}

	public void addToScore(int score) {
		if ((this.getScore() + score)<0){
			throw new DomainException("totaalscore mag niet negatief zijn");
		}
		setScore(this.getScore() + score);
	}

	public String toString() {
		return this.getNaam() + " met score " + this.getScore();

	}

	@Override
	public boolean equals(Object o) {
		boolean gelijk = false;
		if (o instanceof Speler) {

			Speler s = (Speler) o;
			if (this.getNaam().equals(s.getNaam()) && this.getScore() == s.getScore()) {
				gelijk = true;
			}
		}

		return gelijk;
	}
}
