package jwd.zavrsni;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Projekat;
import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.service.ProjekatService;
import jwd.zavrsni.service.StanjeService;
import jwd.zavrsni.service.ZadatakService;

@Component
public class TestData {

	@Autowired
	private ProjekatService projekatService;
	@Autowired
	private StanjeService stanjeService;
	@Autowired
	private ZadatakService zadatakService;
	
	@PostConstruct
	public void initialize() {
		Projekat p1 = new Projekat("Back-End", "10.10.2010.");
		Projekat p2 = new Projekat("Front-End", "11.11.2011.");
		Projekat p3 = new Projekat("Home", "No time constraint");
		
		projekatService.save(p1);
		projekatService.save(p2);
		projekatService.save(p3);
		
		Stanje s1 = new Stanje("Nov");
		Stanje s2 = new Stanje("W-I-P");
		Stanje s3 = new Stanje("Zavrsen");
		
		stanjeService.save(s1);
		stanjeService.save(s2);
		stanjeService.save(s3);
		
		Zadatak z1 = new Zadatak("Zadatak #1", "Zaduzeni #1", 1, "Opis #1", p1, s1);
		Zadatak z2 = new Zadatak("Zadatak #2", "Zaduzeni #2", 2, "Opis #2", p2, s1);
		Zadatak z3 = new Zadatak("Zadatak #3", "Zaduzeni #3", 3, "Opis #3", p1, s1);
		Zadatak z4 = new Zadatak("Zadatak #4", "Zaduzeni #4", 4, "Opis #4", p3, s1);
		Zadatak z5 = new Zadatak("Zadatak #5", "Zaduzeni #5", 5, "Opis #5", p2, s1);
		
		zadatakService.save(z1);
		zadatakService.save(z2);
		zadatakService.save(z3);
		zadatakService.save(z4);
		zadatakService.save(z5);
	}
}