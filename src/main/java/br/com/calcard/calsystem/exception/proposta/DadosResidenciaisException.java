package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DadosResidenciaisException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3183921323281207941L;

	public DadosResidenciaisException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_RESIDENCIAIS);
	}

	public DadosResidenciaisException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_RESIDENCIAIS);
	}

}
