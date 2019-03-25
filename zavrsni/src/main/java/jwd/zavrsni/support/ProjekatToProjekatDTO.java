package jwd.zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.zavrsni.model.Projekat;
import jwd.zavrsni.web.dto.ProjekatDTO;

@Component
public class ProjekatToProjekatDTO implements Converter<Projekat, ProjekatDTO>{
	
	@Override
	public ProjekatDTO convert(Projekat source) {
		return new ProjekatDTO(source);
	}
	
	public List<ProjekatDTO> convert(List<Projekat> source) {
		List<ProjekatDTO> retVal = new ArrayList<>();
		
		for (Projekat i : source)
			retVal.add(convert(i));
		
		return retVal;
	}
}
