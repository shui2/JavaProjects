package jwd.zavrsni.service;

import java.util.List;

import jwd.zavrsni.model.Projekat;

public interface ProjekatService {
	Projekat findOne(Long id);

	List<Projekat> findAll();

	Projekat save(Projekat object);

	void remove(Long id);
}
