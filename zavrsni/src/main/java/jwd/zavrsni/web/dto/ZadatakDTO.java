package jwd.zavrsni.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jwd.zavrsni.model.Zadatak;

public class ZadatakDTO {
	
	private Long id;
	@NotBlank
	@Size(min=0, max=40)
	private String naziv;
	@NotBlank
	private String zaduzeni;
	@Min(1)
	private Integer procenjenoSati;
	private String opis;
	
	private Long projekatId;
	private String projekatNaziv;
	
	private Long stanjeId;
	private String stanjeNaziv;
	
	public ZadatakDTO() {}
	
	public ZadatakDTO(Zadatak model) {
		this.id = model.getId();
		this.naziv = model.getNaziv();
		this.zaduzeni = model.getZaduzeni();
		this.procenjenoSati = model.getProcenjenoSati();
		this.opis = model.getOpis();
		this.projekatId = model.getProjekat().getId();
		this.projekatNaziv = model.getProjekat().getNaziv();
		this.stanjeId = model.getStanje().getId();
		this.stanjeNaziv = model.getStanje().getNaziv();
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

	public Long getProjekatId() {
		return projekatId;
	}

	public void setProjekatId(Long projekatId) {
		this.projekatId = projekatId;
	}

	public String getProjekatNaziv() {
		return projekatNaziv;
	}

	public void setProjekatNaziv(String projekatNaziv) {
		this.projekatNaziv = projekatNaziv;
	}

	public Long getStanjeId() {
		return stanjeId;
	}

	public void setStanjeId(Long stanjeId) {
		this.stanjeId = stanjeId;
	}

	public String getStanjeNaziv() {
		return stanjeNaziv;
	}

	public void setStanjeNaziv(String stanjeNaziv) {
		this.stanjeNaziv = stanjeNaziv;
	}
}
