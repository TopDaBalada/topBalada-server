package br.com.calcard.calsystem.dto;

import java.util.List;

public class DocumentoDTO {

	public String nomeDocumento;

	public String corpo;

	public List<String> listaBase64;

	public Double proporcaoThm;

	public String caminhoDocumento;

	public String formatoDocumento;

	public Double getProporcaoThm() {
		return proporcaoThm;
	}

	public void setProporcaoThm(Double proporcaoThm) {
		this.proporcaoThm = proporcaoThm;
	}

	public String getFormatoDocumento() {
		return formatoDocumento;
	}

	public void setFormatoDocumento(String formatoDocumento) {
		this.formatoDocumento = formatoDocumento;
	}

	public String getCaminhoDocumento() {
		return caminhoDocumento;
	}

	public void setCaminhoDocumento(String caminhoDocumento) {
		this.caminhoDocumento = caminhoDocumento;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public List<String> getListaBase64() {
		return listaBase64;
	}

	public void setListaBase64(List<String> listaBase64) {
		this.listaBase64 = listaBase64;
	}

}