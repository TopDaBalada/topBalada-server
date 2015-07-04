package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;

public class EnderecoDTO {

	private String cep;

	private String logradouro;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private UFEnum uf;

	public EnderecoDTO() {

	}

	public EnderecoDTO(String cep, String logradouro, int numero,
			String complemento, String bairro, String cidade, UFEnum uf) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.setNumero(numero);
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
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
