package model;

import java.util.Date;

public class Rezervacija {
	
	private int id;
	private Soba soba;
	private Date datumUlaza;
	private Date datumIzlaza;
	private String gost;
	
	public Rezervacija(int id, Soba soba, Date datumUlaza, Date datumIzlaza, String gost) {
		this.id = id;
		this.soba = soba;
		this.datumUlaza = datumUlaza;
		this.datumIzlaza = datumIzlaza;
		this.gost = gost;
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
		Rezervacija other = (Rezervacija) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rezervacija [id=" + id + ", soba=" + soba.getTip() + ", datumUlaza=" + datumUlaza + ", datumIzlaza="
				+ datumIzlaza + ", gost=" + gost + "]";
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Date getDatumUlaza() {
		return datumUlaza;
	}

	public void setDatumUlaza(Date datumUlaza) {
		this.datumUlaza = datumUlaza;
	}

	public Date getDatumIzlaza() {
		return datumIzlaza;
	}

	public void setDatumIzlaza(Date datumIzlaza) {
		this.datumIzlaza = datumIzlaza;
	}

	public String getGost() {
		return gost;
	}

	public void setGost(String gost) {
		this.gost = gost;
	}

	public int getId() {
		return id;
	}
}
