package br.com.calcard.calsystem.exception;

public class PropriedadeObrigatoriaNaoInformadaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4544179083397899030L;

	private int idExcecao;

	public PropriedadeObrigatoriaNaoInformadaException(int idExcecao) {
		super();

		this.idExcecao = idExcecao;
	}

	public int getIdExcecao() {
		return idExcecao;
	}

}
