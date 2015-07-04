package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class PropostaException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324621130649897112L;

	public PropostaException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA);
	}

	public PropostaException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA);
	}

}
