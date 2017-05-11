package model;

public abstract class Vorm implements Drawable{

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
	
}
