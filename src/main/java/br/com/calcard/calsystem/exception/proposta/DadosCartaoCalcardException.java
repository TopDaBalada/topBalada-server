package br.com.calcard.calsystem.exception.proposta;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.ExcecaoEnum;

public class DadosCartaoCalcardException extends CalsystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4417227210819507060L;

	public DadosCartaoCalcardException(String message) {
		super(message, ExcecaoEnum.EXCECAO_PROPOSTA_DADOS_CARTAO_CALCARD);
	}

}
