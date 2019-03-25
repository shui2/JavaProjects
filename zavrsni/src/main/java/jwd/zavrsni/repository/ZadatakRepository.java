package jwd.zavrsni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.zavrsni.model.Zadatak;

@Repository
public interface ZadatakRepository extends JpaRepository<Zadatak, Long>{
	Page<Zadatak> findByProjekatId(Long id, Pageable page);
	
	@Query("SELECT z FROM Zadatak z WHERE (:projekat IS NULL OR z.projekat.naziv LIKE :projekat) AND (:naziv IS NULL OR z.naziv LIKE :naziv) AND (:zaduzeni IS NULL OR z.zaduzeni LIKE :zaduzeni)")
	Page<Zadatak> search(@Param("projekat") String projekat, @Param("naziv") String naziv, @Param("zaduzeni") String zaduzeni, Pageable page);
}
