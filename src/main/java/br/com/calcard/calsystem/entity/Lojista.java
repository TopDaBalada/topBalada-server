package br.com.calcard.calsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@Table(name = Lojista.NOME_TABELA)
public class Lojista extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -623123599819995750L;

	public static final String NOME_TABELA = "tbl_lojista";

	private static final String COLUNA_CODIGO = "codigo";

	private static final String COLUNA_DESCRICAO = "descricao";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_CODIGO, length = 6, nullable = false, unique = true)
	private String codigo;

	@Column(name = COLUNA_DESCRICAO, length = 50, nullable = false, unique = false)
	private String descricao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
