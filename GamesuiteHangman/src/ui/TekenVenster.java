package ui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.*;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new UiException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));

		for (Vorm vorm : tekening.getVormen()){
			/*switch(vorm.getClass()){
				case LijnStuk.class:

			}*/
			if(vorm instanceof LijnStuk){
				LijnStuk ls = (LijnStuk) vorm;
				graphics.drawLine(ls.getStartPunt().getX(),ls.getEindPunt().getX(),ls.getStartPunt().getY(),ls.getEindPunt().getY());
			}
			if(vorm instanceof Driehoek){
				Driehoek dh = (Driehoek) vorm;
				int[] xPoints = { dh.getHoekPunt1().getX(), dh.getHoekPunt2().getX(),
						dh.getHoekPunt3().getX() };
				int[] yPoints = { dh.getHoekPunt1().getY(), dh.getHoekPunt2().getY(),
						dh.getHoekPunt3().getY() };
				graphics.drawPolygon(xPoints, yPoints, 3);
			}
			if(vorm instanceof Rechthoek){
				Rechthoek rh = (Rechthoek) vorm;
				graphics.drawRect(rh.getLinkerBovenhoek().getX(),rh.getLinkerBovenhoek().getY(),rh.getBreedte(),rh.getHoogte());
			}
			if(vorm instanceof Cirkel){
				Cirkel c = (Cirkel) vorm;
				graphics.drawOval(c.getOmhullende().getMinX(), c.getOmhullende().getMinY(), c.getOmhullende().getBreedte(), c.getOmhullende().getHoogte());
			}
		}
	}
	/*
	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));

		Cirkel boomkruin = new Cirkel(new Punt(70, 70), 60);
		LijnStuk boomstam = new LijnStuk(new Punt(70, 130), new Punt(70, 380));
		Rechthoek gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
		Driehoek dak = new Driehoek(new Punt(100, 200), new Punt(300, 200),
				new Punt(200, 100));

		graphics.drawOval(boomkruin.getOmhullende().getMinX(), boomkruin
				.getOmhullende().getMinY(), boomkruin.getOmhullende()
				.getBreedte(), boomkruin.getOmhullende().getHoogte());

		graphics.drawRect(gebouw.getLinkerBovenhoek().getX(), gebouw
				.getLinkerBovenhoek().getY(), gebouw.getBreedte(), gebouw
				.getHoogte());

		graphics.drawLine(boomstam.getStartPunt().getX(), boomstam
				.getStartPunt().getY(), boomstam.getEindPunt().getX(), boomstam
				.getEindPunt().getY());

		int[] xPoints = { dak.getHoekPunt1().getX(), dak.getHoekPunt2().getX(),
				dak.getHoekPunt3().getX() };
		int[] yPoints = { dak.getHoekPunt1().getY(), dak.getHoekPunt2().getY(),
				dak.getHoekPunt3().getY() };
		graphics.drawPolygon(xPoints, yPoints, 3);
	}*/
}