package jwd.zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.repository.StanjeRepository;
import jwd.zavrsni.service.StanjeService;

@Service
public class JpaStanjeService implements StanjeService{

	@Autowired
	private StanjeRepository repository;
	
	@Override
	public Stanje findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Stanje> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Stanje save(Stanje object) {
		return repository.save(object);
	}

	@Override
	public void remove(Long id) {
		repository.delete(id);
	}
}
