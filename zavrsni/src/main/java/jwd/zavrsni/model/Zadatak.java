package jwd.zavrsni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblZadatak")
public class Zadatak {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String naziv;
	@Column(nullable=false)
	private String zaduzeni;
	@Column(nullable=false)
	private Integer procenjenoSati;
	@Column
	private String opis;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Projekat projekat;
	@ManyToOne(fetch=FetchType.EAGER)
	private Stanje stanje;
	
	public Zadatak() {}

	public Zadatak(String naziv, String zaduzeni, Integer procenjenoSati, String opis, Projekat projekat,
			Stanje stanje) {
		this.naziv = naziv;
		this.zaduzeni = zaduzeni;
		this.procenjenoSati = procenjenoSati;
		this.opis = opis;
		setProjekat(projekat);
		setStanje(stanje);
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

	public String getZaduzeni() {
		return zaduzeni;
	}

	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}

	public Integer getProcenjenoSati() {
		return procenjenoSati;
	}

	public void setProcenjenoSati(Integer procenjenoSati) {
		this.procenjenoSati = procenjenoSati;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Projekat getProjekat() {
		return projekat;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
		if (projekat != null && !projekat.getZadaci().contains(this)) {
			projekat.getZadaci().add(this);
		}
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
		if (stanje != null && !stanje.getZadaci().contains(this)) {
			stanje.getZadaci().add(this);
		}
	}
}