package br.com.calcard.calsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@Table(name = "tbl_log_processo")
public class LogProcesso extends CalsystemEntity {

	private static final long serialVersionUID = -7651557976488527280L;

	public static final String COLUNA_PROCESSO = "processo";
	public static final String COLUNA_DATA_INICIO = "data_inicio";
	public static final String COLUNA_DATA_FIM = "data_fim";
	public static final String COLUNA_TOKEN = "token";

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String PROCESSO_JOB_ENVIAR_SMS_SENHA_CARTAO = "JOB_ENVIAR_SMS_SENHA_CARTAO";
	public static final String PROCESSO_JOB_EXPIRAR_TOKENS = "JOB_EXPIRAR_TOKENS";
	public static final String PROCESSO_JOB_IMPORTAR_NOVOS_CADASTROS = "JOB_IMPORTAR_NOVOS_CADASTROS";
	public static final String PROCESSO_JOB_EXPIRAR_VOUCHERS = "JOB_EXPIRAR_VOUCHERS";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_PROCESSO, length = 50, unique = false, nullable = false)
	private String processo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_INICIO, unique = false, nullable = false)
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_FIM, unique = false, nullable = true)
	private Date dataFim;

	@Column(name = COLUNA_TOKEN, length = 40, unique = false, nullable = true)
	private String token;

	public LogProcesso() {
		super();
	}

	public LogProcesso(String processo, Date dataInicio, String token) {
		super();

		this.processo = processo;
		this.dataInicio = dataInicio;
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((processo == null) ? 0 : processo.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		LogProcesso other = (LogProcesso) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
