package br.com.calcard.calsystem.exception;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class EstabelecimentoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472973080019505492L;

	public EstabelecimentoException(String message) {
		super(message, ExcecaoEnum.EXCECAO_ESTABELECIMENTO);
	}

}
