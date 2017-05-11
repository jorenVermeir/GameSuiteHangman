package ui;

import javax.swing.JOptionPane;

import model.*;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt p = new Punt(x,y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + p.toString());
	}

}