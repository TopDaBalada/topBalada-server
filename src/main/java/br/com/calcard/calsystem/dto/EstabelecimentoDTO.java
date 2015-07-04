package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.entity.Estabelecimento;

public class EstabelecimentoDTO {

	private Integer id;

	private String codigo;

	private String cnpj;

	private String status;

	private Integer idLojista;

	public EstabelecimentoDTO(Estabelecimento estabelecimento) {
		this.id = estabelecimento.getId();
		this.codigo = estabelecimento.getCodigo();
		this.cnpj = estabelecimento.getCnpj();
		this.status = estabelecimento.getStatus().name();
		this.idLojista = estabelecimento.getLojista().getId();

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdLojista() {
		return idLojista;
	}

	public void setIdLojista(Integer idLojista) {
		this.idLojista = idLojista;
	}

}
