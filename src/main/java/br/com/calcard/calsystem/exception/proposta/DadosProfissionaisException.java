package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DadosProfissionaisException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149727972095756339L;

	public DadosProfissionaisException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_PROFISSIONAIS);
	}

	public DadosProfissionaisException(String message, Throwable cause) {
		super(message, cause, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_PROFISSIONAIS);
	}

}
