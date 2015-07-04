package br.com.calcard.calsystem.exception.estabelecimento;

public class EstabelecimentoCnpjInvalidoException extends Exception {

	private static final long serialVersionUID = 1624526651101036395L;

	public EstabelecimentoCnpjInvalidoException() {
		super();
	}

	public EstabelecimentoCnpjInvalidoException(String mensagem) {
		super(mensagem);
	}

}
