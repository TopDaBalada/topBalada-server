package br.com.calcard.calsystem.exception.token;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class TokenSessaoNaoEncontradoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8341229517189281407L;

	public TokenSessaoNaoEncontradoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_TOKEN);
	}

}
