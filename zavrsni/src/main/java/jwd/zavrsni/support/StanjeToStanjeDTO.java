package jwd.zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Stanje;
import jwd.zavrsni.web.dto.StanjeDTO;

@Component
public class StanjeToStanjeDTO implements Converter<Stanje, StanjeDTO>{
	
	@Override
	public StanjeDTO convert(Stanje source) {
		return new StanjeDTO(source);
	}
	
	public List<StanjeDTO> convert(List<Stanje> source) {
		List<StanjeDTO> retVal = new ArrayList<>();
		
		for (Stanje i : source)
			retVal.add(convert(i));
		
		return retVal;
	}
}
