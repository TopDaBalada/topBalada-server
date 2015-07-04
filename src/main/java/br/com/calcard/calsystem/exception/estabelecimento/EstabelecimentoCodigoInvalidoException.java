package br.com.calcard.calsystem.exception.estabelecimento;

public class EstabelecimentoCodigoInvalidoException extends Exception {

	private static final long serialVersionUID = 7662360622532394253L;

	public EstabelecimentoCodigoInvalidoException() {
		super();
	}

	public EstabelecimentoCodigoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
