package model;

public abstract class Vorm {

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
	
	abstract public String getOmhullende();
}
