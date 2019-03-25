package jwd.zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Zadatak;
import jwd.zavrsni.web.dto.ZadatakDTO;

@Component
public class ZadatakToZadatakDTO implements Converter<Zadatak, ZadatakDTO>{
	
	@Override
	public ZadatakDTO convert(Zadatak source) {
		return new ZadatakDTO(source);
	}
	
	public List<ZadatakDTO> convert(List<Zadatak> source) {
		List<ZadatakDTO> retVal = new ArrayList<>();
		
		for (Zadatak i : source)
			retVal.add(convert(i));
		
		return retVal;
	}
}
