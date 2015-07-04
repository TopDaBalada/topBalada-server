package br.com.calcard.calsystem.entity.proposta;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.OrgaoEmissorEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoDocumentoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;

@Entity
@Table(name = "tbl_proposta_outros_documentos")
public class PropostaOutrosDocumentos extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5325941052630770243L;

	private static final String COLUNA_PROPOSTA = "id_proposta_p2";

	private static final String COLUNA_DATA_EMISSAO = "data_emissao";

	private static final String COLUNA_UF = "uf";

	private static final String COLUNA_ORGAO_EMISSOR = "orgao_emissor";

	private static final String COLUNA_NUMERO = "numero";

	private static final String COLUNA_TIPO_DOCUMENTO = "tipo_documento";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_EMISSAO, unique = false, nullable = false)
	private Date dataEmissao;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_UF, length = 2, unique = false, nullable = false)
	private UFEnum uf;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_ORGAO_EMISSOR, unique = false, nullable = false)
	private OrgaoEmissorEnum orgaoEmissor;

	@Column(name = COLUNA_NUMERO, length = 30, unique = false, nullable = false)
	private String numero;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_TIPO_DOCUMENTO, unique = false, nullable = false)
	private TipoDocumentoEnum tipoDocumento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = true)
	private PropostaP2 propostaP2;

	public PropostaOutrosDocumentos() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((dataEmissao == null) ? 0 : dataEmissao.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((orgaoEmissor == null) ? 0 : orgaoEmissor.hashCode());
		result = prime * result
				+ ((propostaP2 == null) ? 0 : propostaP2.hashCode());
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		PropostaOutrosDocumentos other = (PropostaOutrosDocumentos) obj;
		if (dataEmissao == null) {
			if (other.dataEmissao != null)
				return false;
		} else if (!dataEmissao.equals(other.dataEmissao))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (orgaoEmissor != other.orgaoEmissor)
			return false;
		if (propostaP2 == null) {
			if (other.propostaP2 != null)
				return false;
		} else if (!propostaP2.equals(other.propostaP2))
			return false;
		if (tipoDocumento != other.tipoDocumento)
			return false;
		if (uf != other.uf)
			return false;
		return true;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public UFEnum getUf() {
		return uf;
	}

	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

	public OrgaoEmissorEnum getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(OrgaoEmissorEnum orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public PropostaP2 getPropostaP2() {
		return propostaP2;
	}

	public void setPropostaP2(PropostaP2 propostaP2) {
		this.propostaP2 = propostaP2;
	}

}
