package br.com.topBalada.exception;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class ParametroGlobalNaoEncontradoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539376633806475653L;

	public ParametroGlobalNaoEncontradoException() {
		super(ExcecaoEnum.EXCECAO_SISTEMA);
	}

	public ParametroGlobalNaoEncontradoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_SISTEMA);
	}

}
