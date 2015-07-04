package br.com.calcard.calsystem.entity;

public class Enum {

	public enum TipoTokenEnum {
		LOGIN, SESSAO, TRANSACAO;
	}

	public enum StatusPadraoEnum {
		ATIVO, INATIVO;
	}

	public enum StatusTokenEnum {
		ATIVO, EXPIRADO, UTILIZADO
	}

	public enum StatusEstabelecimentoEnum {
		ATIVO, INATIVO;
	}

}
