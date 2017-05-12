package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.DomainException;
import model.TekeningHangMan;

public class TekeningHangManTest {
	
	private TekeningHangMan tekening;
	
	@Before
	public void setUp() throws Exception {
		tekening = new TekeningHangMan();
	}
	
	@Test
	public void TekeningHangMan_maakt_18_vormen_waarvan_14_onzichtbaar_en_naam_hangman() {
		assertEquals(tekening.getNaam(), "hangman");
		assertEquals(tekening.getAantalOnzichtbaar(), 14);
		assertEquals(tekening.getAantalVormen(), 18);
	}
	
	@Test
	public void zetVolgendeZichtbaar_verhoogt_aantal_zichtbare_vormen_met_1() {
		int aantalZichtbaar = tekening.getAantalVormen() - tekening.getAantalOnzichtbaar();
		tekening.zetVolgendeZichtbaar();
		assertEquals(tekening.getAantalVormen() - tekening.getAantalOnzichtbaar(), aantalZichtbaar + 1);
	}
	
	@Test (expected = DomainException.class)
	public void zetVolgendeZichtbaar_gooit_exception_als_alle_vormen_zichtbaar() {
		while (tekening.getAantalOnzichtbaar() > 0) {
			tekening.zetVolgendeZichtbaar();
		}
		tekening.zetVolgendeZichtbaar();
	}
	
	@Test
	public void reset_moet_alle_vormen_buiten_galg_onzichtbaar_zetten() {
		tekening.reset();
		assertEquals(tekening.getAantalOnzichtbaar(), 14);
		assertEquals(tekening.getAantalVormen(), 18);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_gooit_exception_als_argument_null() {
		tekening.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void verwijder_gooit_exception_als_argument_null() {
		tekening.verwijder(null);
	}

}
