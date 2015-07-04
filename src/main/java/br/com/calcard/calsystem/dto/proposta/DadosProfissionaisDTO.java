package br.com.calcard.calsystem.dto.proposta;

import java.util.Date;

import br.com.calcard.calsystem.dto.EnderecoDTO;
import br.com.calcard.calsystem.dto.TelefoneDTO;
import br.com.calcard.calsystem.enums.PropostaEnum.NaturezaOcupacaoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.ProfissaoEnum;
import br.com.calcard.calsystem.util.CustomJsonDateDeserializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class DadosProfissionaisDTO {

	private EnderecoDTO endereco;

	private TelefoneDTO telefoneComercial;

	private NaturezaOcupacaoEnum naturezaOcupacao;

	private String nomeEmpresa;

	private String cnpj;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date dataAdmissao;

	private Double salario;

	private Double outrasRendas;

	private String origemOutrasRendas;

	private ProfissaoEnum profissao;

	public DadosProfissionaisDTO() {
		// TODO Auto-generated constructor stub
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	@JsonIgnore
	public NaturezaOcupacaoEnum getNaturezaOcupacaoEnum() {
		return naturezaOcupacao;
	}

	public Integer getNaturezaOcupacao() {
		return naturezaOcupacao.getId();
	}

	public void setNaturezaOcupacao(Integer id) {

		if (id != null) {

			this.naturezaOcupacao = null;

			for (NaturezaOcupacaoEnum naturezaOcupacao : NaturezaOcupacaoEnum
					.values()) {

				if (naturezaOcupacao.getId().equals(id)) {
					this.naturezaOcupacao = naturezaOcupacao;
					break;
				}
			}

			if (this.naturezaOcupacao == null)
				throw new IllegalArgumentException(
						"Natureza da ocupação não informado!");
		}
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

	public String getOrigemOutrasRendas() {
		return origemOutrasRendas;
	}

	public void setOrigemOutrasRendas(String origemOutrasRendas) {
		this.origemOutrasRendas = origemOutrasRendas;
	}

	public ProfissaoEnum getProfissaoEnum() {
		return profissao;
	}

	public Integer getProfissao() {
		return profissao.getId();
	}

	public void setProfissao(Integer id) {

		if (id != null) {

			this.profissao = null;

			for (ProfissaoEnum profissao : ProfissaoEnum.values()) {

				if (profissao.getId().equals(id)) {
					this.profissao = profissao;
					break;
				}
			}

			if (this.profissao == null)
				throw new IllegalArgumentException("Profissão inválida!");

		}
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

	public TelefoneDTO getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(TelefoneDTO telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

}
