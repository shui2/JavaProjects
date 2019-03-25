package model;

public class Manifestacija {
	
	private int id;
	private String naziv;
	private int brojPosetioca;
	private Grad grad;
	
	public Manifestacija(int id, String naziv, int brojPosetioca, Grad grad) {
		this.id = id;
		this.naziv = naziv;
		this.brojPosetioca = brojPosetioca;
		this.grad = grad;
	}

	
	public String toFileRepresentation() {
		return naziv + " " + brojPosetioca;
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
		Manifestacija other = (Manifestacija) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manifestacija [id=" + id + ", naziv=" + naziv + ", brojPosetioca=" + brojPosetioca + ", grad=" + grad.getNaziv()
				+ "]";
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrojPosetioca() {
		return brojPosetioca;
	}

	public void setBrojPosetioca(int brojPosetioca) {
		this.brojPosetioca = brojPosetioca;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public int getId() {
		return id;
	}
}
