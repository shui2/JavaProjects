package model;

public class Soba {
	
	private int id;
	private String tip;
	private int brojKreveta;
	private double cena;
	
	public Soba(int id, String tip, int brojKreveta, double cena) {
		this.id = id;
		this.tip = tip;
		this.brojKreveta = brojKreveta;
		this.cena = cena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soba other = (Soba) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Soba [id=" + id + ", tip=" + tip + ", brojKreveta=" + brojKreveta + ", cena=" + cena + "]";
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getId() {
		return id;
	}
}
