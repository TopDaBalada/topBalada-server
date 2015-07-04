package br.com.calcard.calsystem.exception.estabelecimento;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class EstabelecimentoNaoEncontradoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9214272776071411746L;

	public EstabelecimentoNaoEncontradoException() {
		super(ExcecaoEnum.EXCECAO_ESTABELECIMENTO);
	}

	public EstabelecimentoNaoEncontradoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_ESTABELECIMENTO);
	}

}
