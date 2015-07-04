package br.com.topBalada.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({ @NamedQuery(name = "NQParametroGlobalByNome", query = "select p from ParametroGlobal p where p.nome = :nome") })
@Table(name = "tbl_parametro_global")
public class ParametroGlobal extends CalsystemEntity {

	private static final long serialVersionUID = -5512559889223164201L;
	
	/**
	 * Parametro que define se ao interceptar as requisições HTTP Servidor deve
	 * vallidar o {@link Token}
	 */
	public static final String PARAMETRO_VALIDA_TOKEN = "VALIDA_TOKEN";

	public static final String TIPO_TEXTO = "TEXTO";

	public static final String TIPO_BOOLEANO = "BOOLEANO";

	public static final String TIPO_INTEIRO = "INTEIRO";

	public static final String STATUS_ATIVO = "ATIVO";

	private static final String COLUNA_VALOR_NUMERO = "valor_numero";

	private static final String COLUNA_NOME = "nome";

	private static final String COLUNA_TIPO = "tipo";

	private static final String COLUNA_VALOR_TEXTO = "valor_texto";

	private static final String COLUNA_VALOR_BOOLEANO = "valor_booleano";

	private static final String COLUNA_DESCRICAO = "descricao";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_NOME, length = 50, nullable = false, unique = true)
	private String nome;

	@Column(name = COLUNA_TIPO, length = 10, nullable = false, unique = false)
	private String tipo;

	@Column(name = COLUNA_VALOR_TEXTO, length = 50, nullable = true, unique = false)
	private String valorTexto;

	@Type(type = "yes_no")
	@Column(name = COLUNA_VALOR_BOOLEANO, nullable = true, unique = false)
	private Boolean valorBooleano;

	@Column(name = COLUNA_VALOR_NUMERO, nullable = true, unique = false)
	private Double valorNumero;

	@Column(name = COLUNA_DESCRICAO, length = 200, nullable = true, unique = false)
	private String descricao;

	public ParametroGlobal() {
		super();
	}

	public ParametroGlobal(Integer id, String status, Date dataRegistro,
			Date dataAtualizacao, String nome, String tipo, String valorTexto,
			Boolean valorBooleano, Double valorNumero, String descricao) {
		super(id, dataRegistro, dataAtualizacao);
		this.nome = nome;
		this.tipo = tipo;
		this.valorTexto = valorTexto;
		this.valorBooleano = valorBooleano;
		this.setValorNumero(valorNumero);
		this.descricao = descricao;
	}

	public ParametroGlobal(String status, String nome, String valor) {
		super();
		this.nome = nome;
		this.tipo = TIPO_TEXTO;
		this.valorTexto = valor;
	}

	public ParametroGlobal(String status, String nome, boolean valor) {
		super();
		this.nome = nome;
		this.tipo = TIPO_BOOLEANO;
		this.setValorBooleano(valor);
	}

	public ParametroGlobal(String status, String nome, Double valor) {
		super();
		this.nome = nome;
		this.tipo = TIPO_INTEIRO;
		this.setValorNumero(valor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((valorBooleano == null) ? 0 : valorBooleano.hashCode());
		result = prime
				* result
				+ ((getValorNumero() == null) ? 0 : getValorNumero().hashCode());
		result = prime * result
				+ ((valorTexto == null) ? 0 : valorTexto.hashCode());
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
		ParametroGlobal other = (ParametroGlobal) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valorBooleano == null) {
			if (other.valorBooleano != null)
				return false;
		} else if (!valorBooleano.equals(other.valorBooleano))
			return false;
		if (getValorNumero() == null) {
			if (other.getValorNumero() != null)
				return false;
		} else if (!getValorNumero().equals(other.getValorNumero()))
			return false;
		if (valorTexto == null) {
			if (other.valorTexto != null)
				return false;
		} else if (!valorTexto.equals(other.valorTexto))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValorTexto() {
		return valorTexto;
	}

	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the valorBooleano
	 */
	public Boolean getValorBooleano() {
		return valorBooleano;
	}

	/**
	 * @param valorBooleano
	 *            the valorBooleano to set
	 */
	public void setValorBooleano(Boolean valorBooleano) {
		this.valorBooleano = valorBooleano;
	}

	public Double getValorNumero() {
		return valorNumero;
	}

	public void setValorNumero(Double valorNumero) {
		this.valorNumero = valorNumero;
	}

}
