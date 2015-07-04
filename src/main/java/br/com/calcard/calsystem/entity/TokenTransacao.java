package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.calcard.calsystem.entity.Enum.StatusTokenEnum;
import br.com.calcard.calsystem.entity.Enum.TipoTokenEnum;

public class TokenTransacao extends Token implements Serializable {

	private static final long serialVersionUID = -4298358665138756676L;

	public TokenTransacao() {
		super();
	}

	public TokenTransacao(String tTransacao, Periferico periferico,
			Date dataCriacao, Date dataExpiracao) {
		super(tTransacao, periferico, dataCriacao, dataExpiracao,
				TipoTokenEnum.TRANSACAO, StatusTokenEnum.ATIVO);

	}

}
