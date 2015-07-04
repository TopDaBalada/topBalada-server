package br.com.topBalada.exception;

public class TokenTransacaoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1290693108668306462L;

	public TokenTransacaoInvalidoException() {
		super();
	}

	public TokenTransacaoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
