package jwd.zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.service.StanjeService;
import jwd.zavrsni.support.StanjeToStanjeDTO;
import jwd.zavrsni.web.dto.StanjeDTO;

@RestController
@RequestMapping(value = "/api/stanja")
public class ApiStanjeController {

	@Autowired
	private StanjeService service;
	
	@Autowired
	private StanjeToStanjeDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StanjeDTO>> get() {
		List<Stanje> retVal = service.findAll();
		
		if (retVal == null || retVal.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}
}
