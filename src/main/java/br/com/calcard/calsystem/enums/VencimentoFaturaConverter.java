package br.com.calcard.calsystem.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.calcard.calsystem.enums.PropostaEnum.VencimentoFaturaEnum;

@Converter
public class VencimentoFaturaConverter implements
		AttributeConverter<VencimentoFaturaEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(VencimentoFaturaEnum arg0) {
		return arg0.getId();
	}

	@Override
	public VencimentoFaturaEnum convertToEntityAttribute(Integer arg0) {

		VencimentoFaturaEnum retorno = null;

		for (VencimentoFaturaEnum vencimento : VencimentoFaturaEnum.values()) {

			if (vencimento.getId().equals(arg0)) {
				retorno = vencimento;
				break;
			}

		}

		if (retorno == null)
			throw new IllegalArgumentException("Enum inválido!");

		return retorno;

	}

}
