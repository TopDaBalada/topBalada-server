package br.com.calcard.calsystem.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.calcard.calsystem.entity.Voucher;
import br.com.calcard.calsystem.util.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VoucherDTO implements Serializable {

	private static final long serialVersionUID = -7360679566052122681L;

	private Integer id;

	// @JsonProperty("codVoucher")
	private String codigo;

	private String status;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date dataGeracao;

	private ContaDTO contaDTO;

	private String senha;

	public VoucherDTO(Voucher voucher) {
		this.id = voucher.getId();
		this.codigo = voucher.getCodigo();
		this.dataGeracao = voucher.getDataGeracao();
		this.status = voucher.getStatus();
		this.contaDTO = new ContaDTO(voucher.getConta());
		this.setSenha(voucher.getSenha());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((contaDTO == null) ? 0 : contaDTO.hashCode());
		result = prime * result
				+ ((dataGeracao == null) ? 0 : dataGeracao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoucherDTO other = (VoucherDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (contaDTO == null) {
			if (other.contaDTO != null)
				return false;
		} else if (!contaDTO.equals(other.contaDTO))
			return false;
		if (dataGeracao == null) {
			if (other.dataGeracao != null)
				return false;
		} else if (!dataGeracao.equals(other.dataGeracao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
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

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public ContaDTO getContaDTO() {
		return contaDTO;
	}

	public void setContaDTO(ContaDTO contaDTO) {
		this.contaDTO = contaDTO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
