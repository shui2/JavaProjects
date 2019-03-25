package jwd.zavrsni.web.dto;

import jwd.zavrsni.model.Stanje;

public class StanjeDTO {
	
	private Long id;
	private String naziv;
	
	public StanjeDTO() {}
	
	public StanjeDTO(Stanje model) {
		this.id = model.getId();
		this.naziv = model.getNaziv();
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
}
