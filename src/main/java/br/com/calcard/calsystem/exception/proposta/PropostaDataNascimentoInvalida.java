package br.com.calcard.calsystem.exception.proposta;

public class PropostaDataNascimentoInvalida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3507957195102049435L;

	public PropostaDataNascimentoInvalida(String mensagem) {
		super(mensagem);
	}

	public PropostaDataNascimentoInvalida(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
