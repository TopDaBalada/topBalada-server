package br.com.calcard.calsystem.dto.proposta;

import br.com.calcard.calsystem.dto.EnderecoDTO;
import br.com.calcard.calsystem.dto.TelefoneDTO;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoResidenciaEnum;

public class DadosResidenciaisDTO {

	private EnderecoDTO endereco;

	private Integer anosResidencia;

	private Integer mesesResidencia;

	private TipoResidenciaEnum tipoResidencia;

	private TelefoneDTO telefoneResidencial;

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public TipoResidenciaEnum getTipoResidenciaEnum() {
		return tipoResidencia;
	}

	public Integer getTipoResidencia() {
		return tipoResidencia.getId();
	}

	public void setTipoResidencia(Integer id) {

		this.tipoResidencia = null;

		for (TipoResidenciaEnum tipoResidencia : TipoResidenciaEnum.values()) {

			if (tipoResidencia.getId().equals(id)) {
				this.tipoResidencia = tipoResidencia;
				break;
			}

		}

		if (this.tipoResidencia == null)
			throw new IllegalArgumentException("Tipo de residênicia inválida!");

	}

	public Integer getAnosResidencia() {
		return anosResidencia;
	}

	public void setAnosResidencia(Integer anosResidencia) {
		this.anosResidencia = anosResidencia;
	}

	public Integer getMesesResidencia() {
		return mesesResidencia;
	}

	public void setMesesResidencia(Integer mesesResidencia) {
		this.mesesResidencia = mesesResidencia;
	}

	public TelefoneDTO getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(TelefoneDTO telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

}
