package br.com.calcard.calsystem.exception.estabelecimento;

public class PropostaDadosResidenciaisInvalidosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7709190491356399133L;

	public PropostaDadosResidenciaisInvalidosException(String mensagem) {
		super(mensagem);
	}

	public PropostaDadosResidenciaisInvalidosException(String mensagem,
			Throwable e) {
		super(mensagem, e);
	}

}
