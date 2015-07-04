package br.com.calcard.calsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.entity.Enum.StatusTokenEnum;
import br.com.calcard.calsystem.entity.Enum.TipoTokenEnum;

@MappedSuperclass
public abstract class Token extends CalsystemEntity {

	private static final long serialVersionUID = 2571198839545813383L;

	public static final String COLUNA_TOKEN = "token";
	public static final String COLUNA_ID_PERIFERICO = "id_periferico";
	public static final String COLUNA_DATA_CRIACAO = "data_criacao";
	public static final String COLUNA_DATA_EXPIRACAO = "data_expiracao";
	public static final String COLUNA_TIPO = "tipo";

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	private StatusTokenEnum status;

	@Column(name = COLUNA_TOKEN, length = 40, nullable = false, unique = true)
	private String token;

	@ManyToOne
	@JoinColumn(name = COLUNA_ID_PERIFERICO, nullable = false, unique = false)
	private Periferico periferico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_CRIACAO, nullable = false, unique = false)
	private Date dataCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_EXPIRACAO, nullable = true, unique = false)
	private Date dataExpiracao;

	@Transient
	private TipoTokenEnum tipo;

	public Token() {

	}

	public Token(String token, Periferico periferico, Date dataCriacao,
			Date dataExpiracao, TipoTokenEnum tipo, StatusTokenEnum status) {
		super();
		this.token = token;
		this.periferico = periferico;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
		this.tipo = tipo;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result
				+ ((dataExpiracao == null) ? 0 : dataExpiracao.hashCode());
		result = prime * result
				+ ((periferico == null) ? 0 : periferico.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataExpiracao == null) {
			if (other.dataExpiracao != null)
				return false;
		} else if (!dataExpiracao.equals(other.dataExpiracao))
			return false;
		if (periferico == null) {
			if (other.periferico != null)
				return false;
		} else if (!periferico.equals(other.periferico))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Periferico getPeriferico() {
		return periferico;
	}

	public void setPeriferico(Periferico periferico) {
		this.periferico = periferico;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TipoTokenEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoTokenEnum tipo) {
		this.tipo = tipo;
	}

	public StatusTokenEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTokenEnum status) {
		this.status = status;
	}

}
