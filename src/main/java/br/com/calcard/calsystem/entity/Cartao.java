package br.com.calcard.calsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@Table(name = "tbl_cartao")
public class Cartao extends CalsystemEntity {

	private static final long serialVersionUID = 4636712282306612663L;

	public static final String STATUS_NORMAL = "NORMAL";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@ManyToOne
	@JoinColumn(name = "id_conta", nullable = false, unique = false)
	private Conta conta;

	@Column(name = "senha", length = 4, nullable = true, unique = false)
	private String senha;

	@Column(name = "cpf", length = 11, nullable = false, unique = false)
	private String cpf;

	@Column(name = "numero", length = 16, unique = true, nullable = false)
	private String numero;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", unique = false, nullable = false)
	private Date dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_validade", unique = false, nullable = false)
	private Date dataValidade;

	@Column(name = "nome_portador", length = 50, unique = false, nullable = false)
	private String nomePortador;

	@Type(type = "yes_no")
	@Column(name = "titular", unique = false, nullable = false)
	private boolean titular;

	public Cartao() {
		super();
	}

	public Cartao(String status, Conta conta, String cpf, String numero,
			Date dataCadastro, Date dataValidade, String nomePortador,
			boolean titular) {
		super();
		this.conta = conta;
		this.cpf = cpf;
		this.numero = numero;
		this.dataCadastro = dataCadastro;
		this.dataValidade = dataValidade;
		this.nomePortador = nomePortador;
		this.titular = titular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result
				+ ((nomePortador == null) ? 0 : nomePortador.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + (titular ? 1231 : 1237);
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
		Cartao other = (Cartao) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataValidade == null) {
			if (other.dataValidade != null)
				return false;
		} else if (!dataValidade.equals(other.dataValidade))
			return false;
		if (nomePortador == null) {
			if (other.nomePortador != null)
				return false;
		} else if (!nomePortador.equals(other.nomePortador))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (titular != other.titular)
			return false;
		return true;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getNomePortador() {
		return nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public boolean isTitular() {
		return titular;
	}

	public void setTitular(boolean titular) {
		this.titular = titular;
	}

}
