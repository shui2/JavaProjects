package jwd.zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.zavrsni.model.Projekat;
import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.service.ProjekatService;
import jwd.zavrsni.service.ZadatakService;
import jwd.zavrsni.support.ProjekatToProjekatDTO;
import jwd.zavrsni.support.ZadatakToZadatakDTO;
import jwd.zavrsni.web.dto.ProjekatDTO;
import jwd.zavrsni.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value = "/api/projekti")
public class ApiProjekatController {

	@Autowired
	private ProjekatService service;
	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private ProjekatToProjekatDTO toDTO;
	@Autowired
	private ZadatakToZadatakDTO toZadatakDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProjekatDTO>> get() {
		List<Projekat> retVal = service.findAll();
		
		if (retVal == null || retVal.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<ProjekatDTO> get(@PathVariable Long id) {
		Projekat retVal = service.findOne(id);
		
		if (retVal == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}/zadaci")
	public ResponseEntity<List<ZadatakDTO>> get(@PathVariable Long id, @RequestParam(defaultValue = "0") int page) {
		Page<Zadatak> pages = zadatakService.findByProjekatId(id, page);
		List<Zadatak> retVal = pages.getContent();
		
		if (retVal == null || retVal.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", Integer.toString(pages.getTotalPages()));
			
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(pages.getTotalPages()));
		return new ResponseEntity<>(toZadatakDTO.convert(retVal), headers, HttpStatus.OK);
	}
}
