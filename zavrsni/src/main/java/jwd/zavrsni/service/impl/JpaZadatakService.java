package jwd.zavrsni.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.repository.ZadatakRepository;
import jwd.zavrsni.service.StanjeService;
import jwd.zavrsni.service.ZadatakService;

@Service
@Transactional
public class JpaZadatakService implements ZadatakService{

	@Autowired
	private ZadatakRepository repository;
	@Autowired
	private StanjeService stanjeService;
	
	@Override
	public Zadatak findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Zadatak> findAll(int page) {
		return repository.findAll(new PageRequest(page, 4));
	}
	
	@Override
	public Zadatak save(Zadatak object) {
		return repository.save(object);
	}

	@Override
	public void remove(Long id) {
		repository.delete(id);
	}

	@Override
	public Page<Zadatak> findByProjekatId(Long id, int page) {
		return repository.findByProjekatId(id, new PageRequest(page, 4));
	}

	@Override
	public Page<Zadatak> search(String projekat, String naziv, String zaduzeni, int page) {
		if (projekat != null)
			projekat = "%" + projekat + "%";
		
		if (naziv != null)
			naziv = "%" + naziv + "%";
		
		if (zaduzeni != null)
			zaduzeni = "%" + zaduzeni + "%";
		
		return repository.search(projekat, naziv, zaduzeni, new PageRequest(page, 4));
	}

	@Override
	public Zadatak predji(Long id) {
		if (id == null)
			throw new IllegalStateException();
		
		Zadatak zadatak = repository.findOne(id);
		if (zadatak == null)
			throw new IllegalStateException();
		
		Stanje stanje = null;
		if (zadatak.getStanje().getNaziv().equals("Nov")) {
			stanje = stanjeService.findOne(2L);
		} else if (zadatak.getStanje().getNaziv().equals("W-I-P")) {
			stanje = stanjeService.findOne(3L);
		}
		
		if (stanje != null) {
			zadatak.setStanje(stanje);
			repository.save(zadatak);
		}
		
		return zadatak;
	}

	@Override
	public int getUkupnoSati(List<Zadatak> zadaci) {
		int total = 0;
		for (Zadatak z : zadaci)
			total += z.getProcenjenoSati();
		
		return total;
	}
}
