package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Cirkel;
import model.DomainException;
import model.Omhullende;
import model.Punt;

public class CirkelTest {
		private Punt middelPunt;
		private int radius;
		private Cirkel cirkel;
		Omhullende omhullende;
		@Before
		public void setUp() throws Exception{
			middelPunt = new Punt(5,10);
			radius = 3;
			cirkel = new Cirkel(middelPunt, radius);
			
		}
		
		@Test
		public void Cirkel_met_geldig_middelPunt_en_straal(){
			cirkel = new Cirkel(middelPunt, radius);
			assertEquals(middelPunt, cirkel.getMiddelPunt());
			assertEquals(radius, cirkel.getRadius());
		}
		
		@Test (expected = DomainException.class)
		public void Cirkel_met_middelpunt_null_gooit_exception(){
			cirkel = new Cirkel(null, radius);
		}
		
		@Test (expected = DomainException.class)
		public void Cirkel_met_straal_kleiner_als_0_gooit_exception(){
			cirkel = new Cirkel(middelPunt, -3);
		}
		
		@Test (expected = DomainException.class)
		public void Cirkel_met_straal_gelijk_aan_0_gooit_exception(){
			cirkel = new Cirkel(middelPunt, 0);
		}
		
		@Test
		public void twee_cirkels_zijn_gelijk_als_zelfde_middelpunt_en_straal(){
			Cirkel cirkel2 = new Cirkel(middelPunt, radius);
			assertTrue(cirkel.equals(cirkel2));
		}
		
		@Test
		public void twee_cirkels_zijn_verschillend_als_cirkel2_null_is(){
			Cirkel cirkel2 = null;
			assertFalse(cirkel.equals(cirkel2));
		}
		
		@Test
		public void twee_cirkels_zijn_verschillend_wanneer_middelpunt_verschillend(){
			Cirkel cirkel2 = new Cirkel(new Punt(6,2), radius);
			assertFalse(cirkel.equals(cirkel2));
		}
		
		@Test
		public void twee_cirkels_zijn_verschillend_wanneer_straal_verschillend(){
			Cirkel cirkel2 = new Cirkel(middelPunt, radius-1);
			assertFalse(cirkel.equals(cirkel2));
		}
		@Test
		public void getOmhullende_geeft_juiste_omhullende_terug(){
			
			int hoogte = radius*2;
			int breedte = radius*2;
			omhullende = new Omhullende(cirkel.zoekLinkerbovenhoek(), breedte, hoogte);
			Omhullende nieuweO = cirkel.getOmhullende();
			assertEquals(nieuweO.getBreedte(), omhullende.getBreedte());
			assertEquals(nieuweO.getHoogte(), omhullende.getHoogte());
			assertEquals(nieuweO.getLinkerBovenhoek(), omhullende.getLinkerBovenhoek());
		}
		

		
		
}
