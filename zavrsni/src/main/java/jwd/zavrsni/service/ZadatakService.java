package jwd.zavrsni.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwd.zavrsni.model.Zadatak;

public interface ZadatakService {
	Zadatak findOne(Long id);

	Page<Zadatak> findAll(int page);

	Zadatak save(Zadatak object);

	void remove(Long id);
	
	Page<Zadatak> findByProjekatId(Long id, int page);
	
	Page<Zadatak> search(String projekat, String naziv, String zaduzeni, int page);
	
	Zadatak predji(Long id);
	
	int getUkupnoSati(List<Zadatak> zadaci);
}
