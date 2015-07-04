package br.com.calcard.calsystem.exception.token;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class TokenSessaoInvalidoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8662739303610802292L;

	public TokenSessaoInvalidoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_TOKEN);
	}

}
