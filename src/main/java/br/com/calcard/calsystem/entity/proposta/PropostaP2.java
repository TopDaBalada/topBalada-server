package br.com.calcard.calsystem.entity.proposta;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.EnderecoCorrespondenciaEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.EstadoCivilEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.FaturaPorEmailEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.GrauInstrucaoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.NacionalidadeEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.VencimentoFaturaEnum;
import br.com.calcard.calsystem.enums.VencimentoFaturaConverter;

@Entity
// @NamedQueries({ @NamedQuery(name = PropostaP2.NQ_SELECT_PROPOSTA_BY_P1, query
// =
// "select proposta from Proposta proposta join proposta.dadosP1 propostaP1 where propostaP1 = :propostaP1")
// })
@Table(name = "tbl_proposta_p2")
public class PropostaP2 extends CalsystemEntity {

	private static final long serialVersionUID = -836304273127127761L;

	public static final String NQ_SELECT_PROPOSTA_BY_P1 = "NQPropostaByP1";

	private static final String COLUNA_EMAIL = "email";

	private static final String COLUNA_CELULAR = "celular";

	private static final String COLUNA_NATURALIDADE = "naturalidade";

	private static final String COLUNA_UF = "uf";

	private static final String COLUNA_NACIONALIDADE = "nascionalidade";

	private static final String COLUNA_ESTADO_CIVIL = "estado_civil";

	private static final String COLUNA_GRAU_INSTRUCAO = "grau_instrucao";

	private static final String COLUNA_NOME_PAI = "nome_pai";

	private static final String COLUNA_NOME_MAE = "nome_mae";

	private static final String COLUNA_NUMERO_DEPENDENTES = "numero_dependentes";

	private static final String COLUNA_PROPOSTA = "id_proposta";

	private static final String COLUNA_VENCIMENTO_FATURA = "vencimento_fatura";

	private static final String COLUNA_FATURA_POR_EMAIL = "fatura_por_email";

	private static final String COLUNA_ENDERECO_CORRESPONDENCIA = "endereco_correspondencia";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = false)
	private Proposta proposta;

	@OneToOne(mappedBy = "propostaP2", cascade = CascadeType.ALL)
	private PropostaOutrosDocumentos outrosDocumentos;

	@OneToOne(mappedBy = "propostaP2", cascade = CascadeType.ALL)
	private PropostaDadosResidenciais dadosResidenciais;

	@OneToOne(mappedBy = "propostaP2", cascade = CascadeType.ALL)
	private PropostaDadosProfissionais dadosProfissionais;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "propostaP2")
	private List<PropostaReferencia> referencias;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_CELULAR, nullable = true, unique = false)
	private Telefone celular;

	@Column(name = COLUNA_EMAIL, length = 50, nullable = false, unique = false)
	private String email;

	@Column(name = COLUNA_NATURALIDADE, length = 50, nullable = false, unique = false)
	private String naturalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_UF, length = 2, nullable = false, unique = false)
	private UFEnum uf;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_NACIONALIDADE, length = 20, nullable = false, unique = false)
	private NacionalidadeEnum nacionalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_ESTADO_CIVIL, length = 10, nullable = false, unique = false)
	private EstadoCivilEnum estadoCivil;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_GRAU_INSTRUCAO, length = 30, nullable = false, unique = false)
	private GrauInstrucaoEnum grauInstrucao;

	@Column(name = COLUNA_NOME_PAI, length = 100, nullable = true, unique = false)
	private String nomePai;

	@Column(name = COLUNA_NOME_MAE, length = 100, nullable = true, unique = false)
	private String nomeMae;

	@Column(name = COLUNA_NUMERO_DEPENDENTES, length = 2, nullable = false, unique = false)
	private Integer numeroDependentes;

	@Convert(converter = VencimentoFaturaConverter.class)
	@Column(name = COLUNA_VENCIMENTO_FATURA, length = 2, nullable = false, unique = false)
	private VencimentoFaturaEnum vencimentoFatura;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_FATURA_POR_EMAIL, length = 3, nullable = false, unique = false)
	private FaturaPorEmailEnum faturaPorEmail;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_ENDERECO_CORRESPONDENCIA, length = 20, nullable = false, unique = false)
	private EnderecoCorrespondenciaEnum enderecoCorrespondencia;

	public PropostaP2() {
		this.proposta = new Proposta();
		this.outrosDocumentos = new PropostaOutrosDocumentos();
		this.dadosProfissionais = new PropostaDadosProfissionais();
		this.dadosResidenciais = new PropostaDadosResidenciais();
		// this.referencias = new ArrayList<PropostaReferencia>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime
				* result
				+ ((dadosProfissionais == null) ? 0 : dadosProfissionais
						.hashCode());
		result = prime
				* result
				+ ((dadosResidenciais == null) ? 0 : dadosResidenciais
						.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime
				* result
				+ ((enderecoCorrespondencia == null) ? 0
						: enderecoCorrespondencia.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime
				* result
				+ ((getFaturaPorEmail() == null) ? 0 : getFaturaPorEmail()
						.hashCode());
		result = prime * result
				+ ((grauInstrucao == null) ? 0 : grauInstrucao.hashCode());
		result = prime * result
				+ ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result
				+ ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime
				* result
				+ ((numeroDependentes == null) ? 0 : numeroDependentes
						.hashCode());
		result = prime
				* result
				+ ((outrosDocumentos == null) ? 0 : outrosDocumentos.hashCode());
		result = prime * result
				+ ((proposta == null) ? 0 : proposta.hashCode());
		result = prime * result
				+ ((referencias == null) ? 0 : referencias.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		result = prime
				* result
				+ ((vencimentoFatura == null) ? 0 : vencimentoFatura.hashCode());
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
		PropostaP2 other = (PropostaP2) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (dadosProfissionais == null) {
			if (other.dadosProfissionais != null)
				return false;
		} else if (!dadosProfissionais.equals(other.dadosProfissionais))
			return false;
		if (dadosResidenciais == null) {
			if (other.dadosResidenciais != null)
				return false;
		} else if (!dadosResidenciais.equals(other.dadosResidenciais))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enderecoCorrespondencia != other.enderecoCorrespondencia)
			return false;
		if (estadoCivil != other.estadoCivil)
			return false;
		if (getFaturaPorEmail() != other.getFaturaPorEmail())
			return false;
		if (grauInstrucao != other.grauInstrucao)
			return false;
		if (nacionalidade != other.nacionalidade)
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (numeroDependentes == null) {
			if (other.numeroDependentes != null)
				return false;
		} else if (!numeroDependentes.equals(other.numeroDependentes))
			return false;
		if (outrosDocumentos == null) {
			if (other.outrosDocumentos != null)
				return false;
		} else if (!outrosDocumentos.equals(other.outrosDocumentos))
			return false;
		if (proposta == null) {
			if (other.proposta != null)
				return false;
		} else if (!proposta.equals(other.proposta))
			return false;
		if (referencias == null) {
			if (other.referencias != null)
				return false;
		} else if (!referencias.equals(other.referencias))
			return false;
		if (uf != other.uf)
			return false;
		if (vencimentoFatura != other.vencimentoFatura)
			return false;
		return true;
	}

	public PropostaOutrosDocumentos getOutrosDocumentos() {
		return outrosDocumentos;
	}

	public void setOutrosDocumentos(PropostaOutrosDocumentos outrosDocumentos) {
		this.outrosDocumentos = outrosDocumentos;
	}

	public PropostaDadosResidenciais getDadosResidenciais() {
		return dadosResidenciais;
	}

	public void setDadosResidenciais(PropostaDadosResidenciais dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public PropostaDadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}

	public void setDadosProfissionais(
			PropostaDadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public List<PropostaReferencia> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<PropostaReferencia> referencias) {
		this.referencias = referencias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getCelular() {
		return celular;
	}

	public void setCelular(Telefone celular) {
		this.celular = celular;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public UFEnum getUf() {
		return uf;
	}

	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

	public NacionalidadeEnum getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(NacionalidadeEnum nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public GrauInstrucaoEnum getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(GrauInstrucaoEnum grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Integer getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(Integer numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public VencimentoFaturaEnum getVencimentoFatura() {
		return vencimentoFatura;
	}

	public void setVencimentoFatura(VencimentoFaturaEnum vencimentoFatura) {
		this.vencimentoFatura = vencimentoFatura;
	}

	public EnderecoCorrespondenciaEnum getEnderecoCorrespondencia() {
		return enderecoCorrespondencia;
	}

	public void setEnderecoCorrespondencia(
			EnderecoCorrespondenciaEnum enderecoCorrespondencia) {
		this.enderecoCorrespondencia = enderecoCorrespondencia;
	}

	public FaturaPorEmailEnum getFaturaPorEmail() {
		return faturaPorEmail;
	}

	public void setFaturaPorEmail(FaturaPorEmailEnum faturaPorEmail) {
		this.faturaPorEmail = faturaPorEmail;
	}

}
