package model;

public class HintLetter {
	
	private char letter;
	private boolean geraden;
	
	public HintLetter(char letter) {
		String strLetter = letter + "";
		strLetter = strLetter.toLowerCase();
		letter = strLetter.charAt(0);
		this.letter = letter;
		this.geraden = false;
	}
	
	public boolean raad(char letter) {
		if (this.geraden) {
			return false;
		}
		String strLetter = letter + "";
		strLetter = strLetter.toLowerCase();
		letter = strLetter.charAt(0);
		if (this.letter == letter) {
			this.geraden = true;
			return true;
		}
		return false;
	}
	
	public boolean isGeraden() {
		return this.geraden;
	}
	
	public char toChar() {
		if (this.geraden) {
			return this.letter;
		}
		return '_';
	}
	
	public char getLetter() {
		return this.letter;
	}

}
