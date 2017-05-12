package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import model.*;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Launcher {

	public static void main(String[] args) {
		
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		JOptionPane.showMessageDialog(null, "... heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

		//Ui ui = new Ui();
		//ui.main();
		
		WoordenLezer lezer = new WoordenLezer("hangman.txt");
		lezer.lees();
		
		//HangManHoofdScherm menu = new HangMan
		
		HangManUi hangManUi = new HangManUi(speler, lezer.lees());
		hangManUi.Play();
	}

}