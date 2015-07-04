package br.com.calcard.calsystem.exception.token;

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
