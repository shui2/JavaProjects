package model;

import java.util.ArrayList;
import java.util.List;

public class Grad {
	
	private int ptt;
	private String naziv;
	private List<Manifestacija> kulturneManifestacije = new ArrayList<>();
	
	public Grad(int ptt, String naziv) {
		this.ptt = ptt;
		this.naziv = naziv;
	}

	public Grad(int ptt, String naziv, List<Manifestacija> kulturneManifestacije) {
		this.ptt = ptt;
		this.naziv = naziv;
		this.kulturneManifestacije = kulturneManifestacije;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ptt;
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
		Grad other = (Grad) obj;
		if (ptt != other.ptt)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grad [ptt=" + ptt + ", naziv=" + naziv + ", broj kulturnih manifestacija=" + kulturneManifestacije.size() + "]";
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Manifestacija> getKulturneManifestacije() {
		return kulturneManifestacije;
	}

	public void setKulturneManifestacije(List<Manifestacija> kulturneManifestacije) {
		this.kulturneManifestacije = kulturneManifestacije;
	}

	public int getPtt() {
		return ptt;
	}
}
