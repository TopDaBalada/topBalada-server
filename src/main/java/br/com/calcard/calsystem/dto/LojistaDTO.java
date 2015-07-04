package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.entity.Lojista;

public class LojistaDTO {

	private Integer id;

	private String codigo;

	public LojistaDTO(Integer id, String codigo) {
		super();
		this.id = id;
		this.codigo = codigo;
	}

	public LojistaDTO(Lojista lojista) {
		super();
		this.id = lojista.getId();
		this.codigo = lojista.getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
