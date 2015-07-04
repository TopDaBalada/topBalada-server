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
import br.com.calcard.calsystem.enums.PropostaEnum.NaturezaOcupacaoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.ProfissaoEnum;

@Entity
@Table(name = "tbl_proposta_dados_profissionais")
public class PropostaDadosProfissionais extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6972290619618311209L;

	private static final String COLUNA_TELEFONE = "id_telefone";

	private static final String COLUNA_NOME_EMRPESA = "nome_empresa";

	private static final String COLUNA_CNPJ = "cnpj";

	private static final String COLUNA_DATA_ADMISSAO = "data_admissao";

	private static final String COLUNA_SALARIO = "salario";

	private static final String COLUNA_OUTRAS_RENDAS = "outras_rendas";

	private static final String COLUNA_ORIGEM_OUTRAS_RENDAS = "origem_outras_rendas";

	private static final String COLUNA_ENDERECO = "id_endereco";

	private static final String COLUNA_PROPOSTA = "id_proposta";

	private static final String COLUNA_PROFISSAO = "profissao";

	private static final String COLUNA_NATUREZA_OCUPACAO = "natureza_ocupacao";

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_PROFISSAO, length = 50, nullable = false, unique = false)
	private ProfissaoEnum profissao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_ENDERECO, nullable = false, unique = false)
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_TELEFONE, nullable = true, unique = false)
	private Telefone telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_NATUREZA_OCUPACAO, length = 50, nullable = false, unique = false)
	private NaturezaOcupacaoEnum naturezaOcupacao;

	@Column(name = COLUNA_NOME_EMRPESA, length = 100, nullable = true, unique = false)
	private String nomeEmpresa;

	@Column(name = COLUNA_CNPJ, length = 50, nullable = true, unique = false)
	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_ADMISSAO, nullable = false, unique = false)
	private Date dataAdmissao;

	@Column(name = COLUNA_SALARIO, length = 12, nullable = false, unique = false)
	private Double salario;

	@Column(name = COLUNA_OUTRAS_RENDAS, length = 12, nullable = true, unique = false)
	private Double outrasRendas;

	@Column(name = COLUNA_ORIGEM_OUTRAS_RENDAS, length = 100, nullable = true, unique = false)
	private String origemOutrasRendas;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = true)
	private PropostaP2 propostaP2;

	public PropostaDadosProfissionais() {

		this.endereco = new Endereco();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((dataAdmissao == null) ? 0 : dataAdmissao.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime
				* result
				+ ((naturezaOcupacao == null) ? 0 : naturezaOcupacao.hashCode());
		result = prime * result
				+ ((nomeEmpresa == null) ? 0 : nomeEmpresa.hashCode());
		result = prime
				* result
				+ ((origemOutrasRendas == null) ? 0 : origemOutrasRendas
						.hashCode());
		result = prime * result
				+ ((outrasRendas == null) ? 0 : outrasRendas.hashCode());
		result = prime * result
				+ ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result
				+ ((propostaP2 == null) ? 0 : propostaP2.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		PropostaDadosProfissionais other = (PropostaDadosProfissionais) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (dataAdmissao == null) {
			if (other.dataAdmissao != null)
				return false;
		} else if (!dataAdmissao.equals(other.dataAdmissao))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (naturezaOcupacao != other.naturezaOcupacao)
			return false;
		if (nomeEmpresa == null) {
			if (other.nomeEmpresa != null)
				return false;
		} else if (!nomeEmpresa.equals(other.nomeEmpresa))
			return false;
		if (origemOutrasRendas == null) {
			if (other.origemOutrasRendas != null)
				return false;
		} else if (!origemOutrasRendas.equals(other.origemOutrasRendas))
			return false;
		if (outrasRendas == null) {
			if (other.outrasRendas != null)
				return false;
		} else if (!outrasRendas.equals(other.outrasRendas))
			return false;
		if (profissao != other.profissao)
			return false;
		if (propostaP2 == null) {
			if (other.propostaP2 != null)
				return false;
		} else if (!propostaP2.equals(other.propostaP2))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public NaturezaOcupacaoEnum getNaturezaOcupacao() {
		return naturezaOcupacao;
	}

	public void setNaturezaOcupacao(NaturezaOcupacaoEnum naturezaOcupacao) {
		this.naturezaOcupacao = naturezaOcupacao;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getOutrasRendas() {
		return outrasRendas;
	}

	public void setOutrasRendas(Double outrasRendas) {
		this.outrasRendas = outrasRendas;
	}

	public String getOrigemOutrasRendas() {
		return origemOutrasRendas;
	}

	public void setOrigemOutrasRendas(String origemOutrasRendas) {
		this.origemOutrasRendas = origemOutrasRendas;
	}

	public ProfissaoEnum getProfissao() {
		return profissao;
	}

	public void setProfissao(ProfissaoEnum profissao) {
		this.profissao = profissao;
	}

	public PropostaP2 getPropostaP2() {
		return propostaP2;
	}

	public void setPropostaP2(PropostaP2 propostaP2) {
		this.propostaP2 = propostaP2;
	}

}
