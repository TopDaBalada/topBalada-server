package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DadosComplementaresException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 370960252369670129L;

	public DadosComplementaresException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_COMPLEMENTARES);
	}

	public DadosComplementaresException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_COMPLEMENTARES);
	}

}
