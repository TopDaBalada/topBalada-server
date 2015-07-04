package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.enums.PropostaEnum.DDDEnum;

public class TelefoneDTO {

	private DDDEnum ddd;

	private Integer numero;

	private Integer ramal;

	public TelefoneDTO() {

	}
	
	public TelefoneDTO(DDDEnum ddd, Integer numero, Integer ramal) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.ramal = ramal;
	}

	public DDDEnum getDddEnum() {
		return ddd;
	}

	public Integer getDdd() {
		return ddd.getId();
	}

	public void setDdd(Integer id) {
		this.ddd = null;

		for (DDDEnum ddd : DDDEnum.values()) {

			if (ddd.getId().equals(id)) {
				this.ddd = ddd;
				break;
			}

		}

		if (this.ddd == null)
			throw new IllegalArgumentException("DDD inválido!");
	}

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
