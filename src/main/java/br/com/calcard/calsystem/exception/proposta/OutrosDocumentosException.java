package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class OutrosDocumentosException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3137845363371478600L;

	public OutrosDocumentosException(String mensagem) {
		super(mensagem, ExcecaoEnum.EXCECAO_PROPOSTA_OUTROS_DOCUMENTOS);
	}

	public OutrosDocumentosException(String mensagem, Throwable e) {
		super(mensagem, e, ExcecaoEnum.EXCECAO_PROPOSTA_OUTROS_DOCUMENTOS);
	}
}
