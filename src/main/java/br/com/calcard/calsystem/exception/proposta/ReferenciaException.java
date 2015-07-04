package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class ReferenciaException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2405764303824300801L;

	public ReferenciaException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_REFERENCIA);
	}

	public ReferenciaException(String message, Throwable cause) {
		super(message, cause, ExcecaoEnum.EXCECAO_PROPOSTA_REFERENCIA);
		// TODO Auto-generated constructor stub
	}

}
