package jwd.zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.zavrsni.model.Projekat;
import jwd.zavrsni.repository.ProjekatRepository;
import jwd.zavrsni.service.ProjekatService;

@Service
public class JpaProjekatService implements ProjekatService{

	@Autowired
	private ProjekatRepository repository;
	
	@Override
	public Projekat findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Projekat> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Projekat save(Projekat object) {
		return repository.save(object);
	}

	@Override
	public void remove(Long id) {
		repository.delete(id);
	}
}
