package br.com.calcard.calsystem.exception.usuario;

public class UsuarioInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4814849701069456125L;

	public UsuarioInvalidoException() {
		super();
	}

	public UsuarioInvalidoException(String mensagem) {
		super(mensagem);
	}

	public UsuarioInvalidoException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
