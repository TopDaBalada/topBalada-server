package br.com.calcard.calsystem.exception.proposta;

public class PropostaContatosInvalidosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2655098520979770658L;

	public PropostaContatosInvalidosException(String mensagem) {
		super(mensagem);
	}

	public PropostaContatosInvalidosException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
