package br.com.calcard.calsystem.dto.proposta;

import br.com.calcard.calsystem.dto.TelefoneDTO;
import br.com.calcard.calsystem.enums.PropostaEnum.EnderecoCorrespondenciaEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.EstadoCivilEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.FaturaPorEmailEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.GrauInstrucaoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.NacionalidadeEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.VencimentoFaturaEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DadosComplementaresDTO {

	private String naturalidade;

	private UFEnum uf;

	private NacionalidadeEnum nacionalidade;

	private EstadoCivilEnum estadoCivil;

	private GrauInstrucaoEnum grauInstrucao;

	private String nomePai;

	private String nomeMae;

	private int numeroDependentes;

	private String eMail;

	private TelefoneDTO telefoneCelular;

	private VencimentoFaturaEnum vencimentoFatura;

	private EnderecoCorrespondenciaEnum enderecoCorrespondencia;

	private FaturaPorEmailEnum faturaPorEmail;

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	@JsonIgnore
	public EstadoCivilEnum getEstadoCivilEnum() {
		return estadoCivil;
	}

	public Integer getEstadoCivil() {
		return estadoCivil.getId();
	}

	public void setEstadoCivil(Integer id) {

		this.estadoCivil = null;

		for (EstadoCivilEnum estadoCivil : EstadoCivilEnum.values()) {

			if (estadoCivil.getId().equals(id)) {
				this.estadoCivil = estadoCivil;
				break;
			}

		}

		if (this.estadoCivil == null)
			throw new IllegalArgumentException("Estado civil inválido!");
	}

	public GrauInstrucaoEnum getGrauInstrucaoEnum() {
		return grauInstrucao;
	}

	public Integer getGrauInstrucao() {
		return grauInstrucao.getId();
	}

	public void setGrauInstrucao(Integer id) {

		this.grauInstrucao = null;

		for (GrauInstrucaoEnum grauInstrucao : GrauInstrucaoEnum.values()) {
			if (grauInstrucao.getId().equals(id)) {
				this.grauInstrucao = grauInstrucao;
				break;
			}

		}

		if (this.grauInstrucao == null)
			throw new IllegalArgumentException("Grau de instrução inválido!");

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

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}

	public UFEnum getUf() {
		return uf;
	}

	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

	public NacionalidadeEnum getNacionalidadeEnum() {
		return nacionalidade;
	}

	public Integer getNacionalidade() {
		return nacionalidade.getId();
	}

	public void setNacionalidade(Integer id) {

		this.nacionalidade = null;

		for (NacionalidadeEnum nacionalidade : NacionalidadeEnum.values()) {

			if (nacionalidade.getId().equals(id)) {
				this.nacionalidade = nacionalidade;
				break;
			}
		}

		if (this.nacionalidade == null)
			throw new IllegalArgumentException("Nacionalidade inválida!");

	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public TelefoneDTO getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(TelefoneDTO telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public Integer getVencimentoFatura() {
		return vencimentoFatura.getId();
	}

	public VencimentoFaturaEnum getVencimentoFaturaEnum() {
		return vencimentoFatura;
	}

	public void setVencimentoFatura(Integer id) {

		if (id != null) {

			this.vencimentoFatura = null;

			for (VencimentoFaturaEnum vencimento : VencimentoFaturaEnum
					.values()) {

				if (vencimento.getId().equals(id)) {
					this.vencimentoFatura = vencimento;
					break;
				}
			}

			if (this.vencimentoFatura == null)
				throw new IllegalArgumentException(
						"Vencimento fatura inválido!");

		} else
			this.vencimentoFatura = null;

	}

	public FaturaPorEmailEnum getFaturaPorEmail() {
		return faturaPorEmail;
	}

	public void setFaturaPorEmail(FaturaPorEmailEnum faturaPorEmail) {
		this.faturaPorEmail = faturaPorEmail;
	}

	public EnderecoCorrespondenciaEnum getEnderecoCorrespondenciaEnum() {
		return enderecoCorrespondencia;
	}

	public Integer getEnderecoCorrespondencia() {
		return enderecoCorrespondencia.getId();
	}

	public void setEnderecoCorrespondencia(Integer id) {

		if (id != null) {

			this.enderecoCorrespondencia = null;

			for (EnderecoCorrespondenciaEnum endereco : EnderecoCorrespondenciaEnum
					.values()) {
				if (endereco.getId().equals(id)) {
					this.enderecoCorrespondencia = endereco;
					break;
				}
			}

			if (this.enderecoCorrespondencia == null)
				throw new IllegalArgumentException(
						"Endereço de correspondência inválido!");

		} else
			this.enderecoCorrespondencia = null;

	}

}
