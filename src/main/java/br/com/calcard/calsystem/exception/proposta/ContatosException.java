package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class ContatosException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5715181268751808593L;

	public ContatosException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_CONTATOS);
	}

	public ContatosException(String message, Throwable cause) {
		super(message, cause, ExcecaoEnum.EXCECAO_PROPOSTA_CONTATOS);
		// TODO Auto-generated constructor stub
	}

}
