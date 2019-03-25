package jwd.zavrsni.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tblProjekat")
public class Projekat {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	private String naziv;
	@Column
	private String rokZavrsetka;
	
	@OneToMany(mappedBy="projekat", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Zadatak> zadaci = new ArrayList<>();
	
	public Projekat() {}

	public Projekat(String naziv, String rokZavrsetka) {
		this.naziv = naziv;
		this.rokZavrsetka = rokZavrsetka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getRokZavrsetka() {
		return rokZavrsetka;
	}

	public void setRokZavrsetka(String rokZavrsetka) {
		this.rokZavrsetka = rokZavrsetka;
	}

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}
	
	public void addZadatak(Zadatak zadatak) {
		this.zadaci.add(zadatak);
		if (!this.equals(zadatak.getProjekat())) {
			zadatak.setProjekat(this);
		}
	}
}