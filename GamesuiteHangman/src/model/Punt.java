package model;

public class Punt {
private int x;
private int y;

public Punt(int x, int y) {
	this.x = x;
	this.y = y;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}
public boolean equals(Object object){
	if (object instanceof Punt) {
		 Punt punt = (Punt) object;
		if (punt.getX() == getX() && punt.getY() == getY()) {
			return true;
		}
	}
	return false;
}


@Override
public String toString() {
	return "(" + this.x + ", " + this.y + ")" ;
}




}
