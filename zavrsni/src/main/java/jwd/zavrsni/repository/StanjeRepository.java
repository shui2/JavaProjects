package jwd.zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.zavrsni.model.Stanje;

@Repository
public interface StanjeRepository extends JpaRepository<Stanje, Long>{
	
}
