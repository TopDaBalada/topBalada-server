package br.com.calcard.calsystem.exception.token;

public class TokenLoginInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1033919753034665423L;

	public TokenLoginInvalidoException(String mensagem) {
		super(mensagem);
	}

	public TokenLoginInvalidoException() {
		super();
	}

}
