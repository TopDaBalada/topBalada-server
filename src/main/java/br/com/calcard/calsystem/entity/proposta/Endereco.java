package br.com.calcard.calsystem.entity.proposta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;

@Entity
@Table(name = "tbl_endereco")
public class Endereco extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3463655263308523217L;

	private static final String COLUNA_CEP = "cep";

	private static final String COLUNA_LOGRADOURO = "logradouro";

	private static final String COLUNA_NUMERO = "numero";

	private static final String COLUNA_COMPLEMENTO = "complemento";

	private static final String COLUNA_BAIRRO = "bairro";

	private static final String COLUNA_CIDADE = "cidade";

	private static final String COLUNA_UF = "uf";

	@Column(name = COLUNA_CEP, length = 11, nullable = false, unique = false)
	private String cep;

	@Column(name = COLUNA_LOGRADOURO, length = 100, nullable = false, unique = false)
	private String logradouro;

	@Column(name = COLUNA_NUMERO, length = 10, nullable = false, unique = false)
	private Integer numero;

	@Column(name = COLUNA_COMPLEMENTO, length = 50, nullable = true, unique = false)
	private String complemento;

	@Column(name = COLUNA_BAIRRO, length = 50, nullable = false, unique = false)
	private String bairro;

	@Column(name = COLUNA_CIDADE, length = 50, nullable = false, unique = false)
	private String cidade;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_UF, length = 2, nullable = false, unique = false)
	private UFEnum uf;

	public Endereco() {

	}

	public Endereco(String cep, String logradouro, Integer numero,
			String complemento, String bairro, String cidade, UFEnum uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result
				+ ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (uf != other.uf)
			return false;
		return true;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UFEnum getUf() {
		return uf;
	}

	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
