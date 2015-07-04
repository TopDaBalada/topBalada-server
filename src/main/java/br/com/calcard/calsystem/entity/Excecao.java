package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({ @NamedQuery(name = Excecao.NQ_SELECT_EXCECAO_DETALHE_BY_CODIGOS, query = "select e from Excecao e where e.codigo = :codigo") })
@Table(name = "tbl_excecao")
public class Excecao extends CalsystemEntity implements Serializable {

	private static final long serialVersionUID = -1587748972160361475L;

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String COLUNA_CODIGO = "codigo";
	public static final String COLUNA_DESCRICAO = "descricao";
	public static final String COLUNA_CODIGO_DETALHE = "codigo_detalhe";
	public static final String COLUNA_DESCRICAO_DETALHE = "descricao_detalhe";

	public static final String NQ_SELECT_EXCECAO_DETALHE_BY_CODIGOS = "NQExcecaoByCodigo";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_CODIGO, length = 6, nullable = false, unique = true)
	private Integer codigo;

	@Column(name = COLUNA_DESCRICAO, length = 500, nullable = false, unique = false)
	private String descricao;

	public Excecao() {
		super();
	}

	public Excecao(String status, Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Excecao other = (Excecao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
