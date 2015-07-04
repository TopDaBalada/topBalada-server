package br.com.calcard.calsystem.exception;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class UsuarioException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8494121281252105975L;

	public UsuarioException(String message) {
		super(message, ExcecaoEnum.EXCECAO_USUARIO);
	}

}
