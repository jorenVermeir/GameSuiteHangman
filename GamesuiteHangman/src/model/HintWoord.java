package model;

import java.util.ArrayList;

public class HintWoord {
	
	private ArrayList<HintLetter> hintLetters = new ArrayList<>();
	
	public HintWoord(String woord) {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("Woord is leeg.");
		}
		for (char letter : woord.toCharArray()) {
			hintLetters.add(new HintLetter(letter));
		}
	}
	
	public boolean raad(char letter) {
		boolean geraden = false;
		for (HintLetter hintLetter : hintLetters) {
			if (hintLetter.raad(letter)) {
				geraden = true;
			}
		}
		return geraden;
	}
	
	public boolean isGeraden() {
		String geradenWoord = this.toString();
		for (char letter : geradenWoord.toCharArray()) {
			if (letter == '_') {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		String out = "";
		for (HintLetter hintLetter : hintLetters) {
			out += " " + hintLetter.toChar();
		}
		out = out.substring(1, out.length());
		return out;
	}
	
	public String getWoord() {
		String out = "";
		for (HintLetter hintLetter : hintLetters) {
			out += hintLetter.getLetter();
		}
		return out;
	}

}
