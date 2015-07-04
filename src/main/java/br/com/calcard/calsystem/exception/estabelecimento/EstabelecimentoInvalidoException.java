package br.com.calcard.calsystem.exception.estabelecimento;

public class EstabelecimentoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7671985439709683882L;

	public EstabelecimentoInvalidoException() {
		super();
	}

	public EstabelecimentoInvalidoException(String mensagem) {
		super(mensagem);
	}

	public EstabelecimentoInvalidoException(String mensagem, Throwable e) {
		super(mensagem, e);
	}

}
