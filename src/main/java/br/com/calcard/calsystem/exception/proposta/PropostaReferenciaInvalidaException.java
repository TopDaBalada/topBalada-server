package br.com.calcard.calsystem.exception.proposta;

public class PropostaReferenciaInvalidaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5624634859861973326L;

	public PropostaReferenciaInvalidaException(String mensagem) {
		super(mensagem);
	}

	public PropostaReferenciaInvalidaException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
