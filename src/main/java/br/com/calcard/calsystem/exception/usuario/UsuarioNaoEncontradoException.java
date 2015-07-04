package br.com.calcard.calsystem.exception.usuario;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class UsuarioNaoEncontradoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3716673491089115582L;

	public UsuarioNaoEncontradoException() {
		super(ExcecaoEnum.EXCECAO_USUARIO);
	}

	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_USUARIO);
	}

}
