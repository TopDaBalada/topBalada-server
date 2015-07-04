package br.com.calcard.calsystem.dto.proposta;

import br.com.calcard.calsystem.dto.TelefoneDTO;
import br.com.calcard.calsystem.enums.PropostaEnum.GrauParentescoEnum;

public class ReferenciaDTO {

	private String nome;

	private GrauParentescoEnum grauParentesco;

	private TelefoneDTO telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrauParentescoEnum getGrauParentescoEnum() {
		return grauParentesco;
	}

	public Integer getGrauParentesco() {
		return grauParentesco.getId();
	}

	public void setGrauParentesco(Integer id) {

		if (id != null) {

			this.grauParentesco = null;

			for (GrauParentescoEnum grauParentesco : GrauParentescoEnum
					.values()) {

				if (grauParentesco.getId().equals(id)) {
					this.grauParentesco = grauParentesco;
					break;
				}

			}

			if (this.grauParentesco == null)
				throw new IllegalArgumentException(
						"Grau de parentesco inválido!");

		}

	}

	public TelefoneDTO getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneDTO telefone) {
		this.telefone = telefone;
	}

}
