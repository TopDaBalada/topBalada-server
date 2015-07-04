package br.com.calcard.calsystem.exception.estabelecimento;

public class EstabelecimentoCodigoDuplicadoException extends Exception {

	private static final long serialVersionUID = -6850248912549662555L;

	public EstabelecimentoCodigoDuplicadoException(String mensagem) {
		super(mensagem);
	}

	public EstabelecimentoCodigoDuplicadoException() {
		super();
	}

}
