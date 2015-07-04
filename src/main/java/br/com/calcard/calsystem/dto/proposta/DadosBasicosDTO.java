package br.com.calcard.calsystem.dto.proposta;

import java.util.Date;

import br.com.calcard.calsystem.enums.PropostaEnum.SexoEnum;
import br.com.calcard.calsystem.util.CustomJsonDateDeserializer;
import br.com.calcard.calsystem.util.CustomJsonDateSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DadosBasicosDTO {

	private String nome;

	private String cpf;

	private SexoEnum sexo;

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date dataNascimento;

	public DadosBasicosDTO() {

	}

	public DadosBasicosDTO(String nome, String cpf, SexoEnum sexo,
			Date dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return this.sexo.getCodigo();
	}

	public void setSexo(String codigo) {

		this.sexo = null;

		for (SexoEnum s : SexoEnum.values()) {

			if (s.getCodigo().equals(codigo)) {
				this.sexo = s;
				break;
			}

		}

		if (this.sexo == null)
			throw new IllegalArgumentException("Sexo inválido!");

	}

	@JsonIgnore
	public SexoEnum getSexoEnum() {
		return sexo;
	}

}
