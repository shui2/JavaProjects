package jwd.zavrsni.service;

import java.util.List;

import jwd.zavrsni.model.Stanje;

public interface StanjeService {
	Stanje findOne(Long id);

	List<Stanje> findAll();

	Stanje save(Stanje object);

	void remove(Long id);
}
