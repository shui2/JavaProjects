package jwd.zavrsni.web.dto;

import jwd.zavrsni.model.Projekat;

public class ProjekatDTO {
	
	private Long id;
	private String naziv;
	private String rokZavrsetka;
	
	public ProjekatDTO() {}
	
	public ProjekatDTO(Projekat model) {
		this.id = model.getId();
		this.naziv = model.getNaziv();
		this.rokZavrsetka = model.getRokZavrsetka();
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
}
