package br.com.calcard.calsystem.dto;

import java.util.Date;

import br.com.calcard.calsystem.enums.PropostaEnum.OrgaoEmissorEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.UFEnum;
import br.com.calcard.calsystem.util.CustomJsonDateDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RGDTO {

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date dataEmissao;

	private UFEnum uf;

	private OrgaoEmissorEnum orgaoEmissor;

	private String numero;

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public OrgaoEmissorEnum getOrgaoEmissorEnum() {
		return orgaoEmissor;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor.getCodigo();
	}

	public void setOrgaoEmissor(String codigo) {

		if (codigo != null) {

			this.orgaoEmissor = null;

			for (OrgaoEmissorEnum orgaoEmissor : OrgaoEmissorEnum.values()) {

				if (orgaoEmissor.getCodigo().equals(codigo)) {
					this.orgaoEmissor = orgaoEmissor;
					break;
				}

			}

			if (this.orgaoEmissor == null)
				throw new IllegalArgumentException("Órgão emissor inválido!");

		}

	}

	public UFEnum getUf() {
		return uf;
	}

	public void setUf(UFEnum uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
