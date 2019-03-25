package jwd.zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.service.ZadatakService;
import jwd.zavrsni.support.ZadatakDTOToZadatak;
import jwd.zavrsni.support.ZadatakToZadatakDTO;
import jwd.zavrsni.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value = "/api/zadaci")
public class ApiZadatakController {

	@Autowired
	private ZadatakService service;
	
	@Autowired
	private ZadatakToZadatakDTO toDTO;
	@Autowired
	private ZadatakDTOToZadatak toZadatak;
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<ZadatakDTO> get(@PathVariable Long id) {
		Zadatak retVal = service.findOne(id);
		
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ZadatakDTO>> get(@RequestParam(required=false) String projekat, @RequestParam(required=false) String naziv, @RequestParam(required=false) String zaduzeni, @RequestParam(value="page", defaultValue = "0") int page) {
		Page<Zadatak> pages = null;
		
		if (projekat != null || naziv != null || zaduzeni != null)
			pages = service.search(projekat, naziv, zaduzeni, page);
		else
			pages = service.findAll(page);
		
		List<Zadatak> data = pages.getContent();

		if (data == null || data.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", Integer.toString(pages.getTotalPages()));
			headers.add("ukupnoSati", "0");
		
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}
		
		int ukupnoSati = service.getUkupnoSati(data);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(pages.getTotalPages()));
		headers.add("ukupnoSati", Integer.toString(ukupnoSati));
		return new ResponseEntity<>(toDTO.convert(data), headers, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ZadatakDTO> add(@Validated@RequestBody ZadatakDTO object) {
		Zadatak retVal = service.save(toZadatak.convert(object));
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<ZadatakDTO> edit(@PathVariable Long id, @Validated@RequestBody ZadatakDTO object) {
		if (!id.equals(object.getId()))
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		Zadatak retVal = service.save(toZadatak.convert(object));
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<ZadatakDTO> delete(@PathVariable Long id) {
		Zadatak retVal = service.findOne(id);
		
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}/predji")
	public ResponseEntity<ZadatakDTO> predji(@PathVariable Long id) {
		
		Zadatak zadatak = service.predji(id);
		
		return new ResponseEntity<>(toDTO.convert(zadatak), HttpStatus.OK);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> validationHandler() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
