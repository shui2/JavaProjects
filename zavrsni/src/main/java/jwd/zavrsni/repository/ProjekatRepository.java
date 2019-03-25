package jwd.zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.zavrsni.model.Projekat;

@Repository
public interface ProjekatRepository extends JpaRepository<Projekat, Long>{
	
}
