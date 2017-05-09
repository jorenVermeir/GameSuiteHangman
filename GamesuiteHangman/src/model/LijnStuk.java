package model;

public class LijnStuk {
	
	private Punt startPunt;
	private Punt eindPunt;
	
	public LijnStuk(Punt start, Punt eind) {
		setStartEnEindPunt(start, eind);
	}

	public void setStartEnEindPunt(Punt start, Punt eind) {
		if (start == null || eind == null) {
			throw new DomainException("Start- en/of eindpunt is null");
		}
		if (start.equals(eind)) {
			throw new DomainException("Start- en eindpunt zijn hetzelfde");
		}
		this.startPunt = start;
		this.eindPunt = eind;
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof LijnStuk) {
			LijnStuk lijnstuk = (LijnStuk) object;
			if (lijnstuk.eindPunt.equals(this.eindPunt) && lijnstuk.startPunt.equals(this.startPunt)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Lijn: startpunt: " + startPunt.toString() + " - eindpunt: " + eindPunt.toString();
	}
	
}
