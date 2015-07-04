package br.com.calcard.calsystem.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.calcard.calsystem.enums.PropostaEnum.DDDEnum;

@Converter
public class DDDConverter implements AttributeConverter<DDDEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(DDDEnum arg0) {

		return arg0.getId();

	}

	@Override
	public DDDEnum convertToEntityAttribute(Integer arg0) {

		DDDEnum retorno = null;

		for (DDDEnum ddd : DDDEnum.values()) {

			if (ddd.getId().equals(arg0)) {
				retorno = ddd;
				break;
			}

		}

		if (retorno == null)
			throw new IllegalArgumentException("Enum inválido!");

		return retorno;

	}

}
