package br.com.calcard.calsystem.exception.estabelecimento;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class EstabelecimentoIdInvalidoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4692456551363095211L;

	public EstabelecimentoIdInvalidoException() {
		super(ExcecaoEnum.EXCECAO_ESTABELECIMENTO);
	}

	public EstabelecimentoIdInvalidoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_ESTABELECIMENTO);
	}

}
