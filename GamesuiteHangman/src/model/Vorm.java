package model;

import java.awt.Graphics;

public abstract class Vorm implements Drawable{
	
	private boolean zichtbaar = true;

	@Override
	public boolean equals(Object object) {
		if (object instanceof Vorm) {
			return true;
		}
		return false;
	}
	public String toString(){
		return "Vorm: ";
	}
	
	abstract public Omhullende getOmhullende();
	
	public void teken(Graphics graphics) {
		
	}
	
	public boolean isZichtbaar() {
		return false;
	}
	
	public void setZichtbaar(boolean zichtbaar) {
		
	}
	
}
