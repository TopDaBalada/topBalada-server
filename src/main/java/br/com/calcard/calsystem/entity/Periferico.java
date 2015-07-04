package br.com.calcard.calsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({ @NamedQuery(name = Periferico.NQ_SELECT_PERIFERICO_BY_CODIGO, query = "select p from Periferico p where p.codigo = :codigo") })
@Table(name = "tbl_periferico")
public class Periferico extends CalsystemEntity {

	private static final long serialVersionUID = 3103057521435935743L;

	public static final String NQ_SELECT_PERIFERICO_BY_CODIGO = "NQPerifericoByCodigo";

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String COLUNA_CODIGO = "codigo";

	public static final String COLUNA_DESCRICAO = "descricao";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	/**
	 * Propriedade que define o Código única que identifica o {@link Periférico}
	 */
	@Column(name = COLUNA_CODIGO, length = 6, nullable = false, unique = true)
	private String codigo;

	/**
	 * Propriedade que descreve o {@link Periférico}
	 */
	@Column(name = COLUNA_DESCRICAO, length = 200, nullable = false, unique = true)
	private String descricao;

	public Periferico() {
		super();
	}

	public Periferico(Integer id, Date dataRegistro, Date dataAtualizacao,
			String status, String codigo, String descricao) {
		super(id, dataRegistro, dataAtualizacao);
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
		Periferico other = (Periferico) obj;
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
