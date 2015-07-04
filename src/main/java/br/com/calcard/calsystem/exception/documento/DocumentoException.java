package br.com.calcard.calsystem.exception.documento;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DocumentoException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3183921323281207941L;

	public DocumentoException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_DOCUMENTOS_DIGITALIZADO);
	}

	public DocumentoException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA_DOCUMENTOS_DIGITALIZADO);
	}
}