package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DadosBasicosException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 198509309103587037L;

	public DadosBasicosException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_BASICOS);
	}

	public DadosBasicosException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_BASICOS);
	}

}
