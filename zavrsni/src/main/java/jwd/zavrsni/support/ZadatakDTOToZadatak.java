package jwd.zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Projekat;
import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.service.ProjekatService;
import jwd.zavrsni.service.StanjeService;
import jwd.zavrsni.service.ZadatakService;
import jwd.zavrsni.web.dto.ZadatakDTO;

@Component
public class ZadatakDTOToZadatak implements Converter<ZadatakDTO, Zadatak>{

	@Autowired
	private ZadatakService service;
	@Autowired
	private ProjekatService projekatService;
	@Autowired
	private StanjeService stanjeService;

	@Override
	public Zadatak convert(ZadatakDTO source) {
		Projekat projekat = projekatService.findOne(source.getProjekatId());
		Stanje stanje = stanjeService.findOne(source.getStanjeId());
		
		if (projekat == null || stanje == null)
			throw new IllegalStateException("Projekat i Stanje nesmeju biti null");
		
		Zadatak retVal;
		if (source.getId() != null)
			retVal = service.findOne(source.getId());
		else
			retVal = new Zadatak();
		
		if (retVal == null)
			throw new IllegalStateException("Akcija neuspesna");
		
		retVal.setNaziv(source.getNaziv());
		retVal.setZaduzeni(source.getZaduzeni());
		retVal.setProcenjenoSati(source.getProcenjenoSati());
		retVal.setOpis(source.getOpis());
		retVal.setProjekat(projekat);
		retVal.setStanje(stanje);
		
		return retVal;
	}
}
