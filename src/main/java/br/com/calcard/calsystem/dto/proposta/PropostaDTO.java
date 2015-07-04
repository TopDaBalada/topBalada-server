package br.com.calcard.calsystem.dto.proposta;

import java.util.Date;
import java.util.List;

import br.com.calcard.calsystem.enums.PropostaEnum.StatusProposta;
import br.com.calcard.calsystem.util.CustomJsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PropostaDTO {

	private Integer numeroProposta;

	private StatusProposta status;

	private Integer idEstabelecimento;

	private Integer idUsuario;

	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date dataRegistro;

	private DadosBasicosDTO dadosBasicos;

	private DadosComplementaresDTO dadosComplementares;

	private OutrosDocumentosDTO outrosDocumentos;

	private DadosResidenciaisDTO dadosResidenciais;

	private DadosProfissionaisDTO dadosProfissionais;

	private List<ReferenciaDTO> referencias;

	public PropostaDTO() {

		// this.dadosBasicos = new DadosBasicosDTO();
		// this.dadosComplementares = new DadosComplementaresDTO();
		// this.outrosDocumentos = new OutrosDocumentosDTO();
		// this.contatos = new ArrayList<ContatoDTO>();
		// this.dadosResidenciais = new DadosResidenciaisDTO();
		// this.dadosProfissionais = new DadosProfissionaisDTO();
		// this.referencias = new ArrayList<ReferenciaDTO>();

	}

	public Integer getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public DadosComplementaresDTO getDadosComplementares() {
		return dadosComplementares;
	}

	public void setDadosComplementares(
			DadosComplementaresDTO dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

	public OutrosDocumentosDTO getOutrosDocumentos() {
		return outrosDocumentos;
	}

	public void setOutrosDocumentos(OutrosDocumentosDTO outrosDocumentos) {
		this.outrosDocumentos = outrosDocumentos;
	}

	public DadosResidenciaisDTO getDadosResidenciais() {
		return dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciaisDTO dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public DadosProfissionaisDTO getDadosProfissionais() {
		return dadosProfissionais;
	}

	public void setDadosProfissionais(DadosProfissionaisDTO dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public List<ReferenciaDTO> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<ReferenciaDTO> referencias) {
		this.referencias = referencias;
	}

	public DadosBasicosDTO getDadosBasicos() {
		return dadosBasicos;
	}

	public void setDadosBasicos(DadosBasicosDTO dadosBasicos) {
		this.dadosBasicos = dadosBasicos;
	}

	public StatusProposta getStatus() {
		return status;
	}

	public void setStatus(StatusProposta status) {
		this.status = status;
	}

	public Integer getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(Integer numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
