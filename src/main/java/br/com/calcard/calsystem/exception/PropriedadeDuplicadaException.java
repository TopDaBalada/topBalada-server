package br.com.calcard.calsystem.exception;

public class PropriedadeDuplicadaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7027791999439964984L;

	private int idExcecao;

	public PropriedadeDuplicadaException(int idExcecao) {
		super();
		this.idExcecao = idExcecao;
	}

	public int getIdErro() {
		return idExcecao;
	}

}
