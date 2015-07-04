package br.com.calcard.calsystem.dto;

import java.io.Serializable;

import br.com.calcard.calsystem.entity.Conta;
import br.com.calcard.calsystem.exception.CPFInvalidoException;
import br.com.calcard.calsystem.util.CPFUtil;

public class ContaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5730596213194099179L;

	private Integer id;

	private Integer idContaExterna;

	private String nome;

	private String cpf;

	public ContaDTO(Conta conta) {
		this.id = conta.getId();
		this.idContaExterna = conta.getIdContaExterna();
		this.nome = conta.getNomeCliente();

		try {
			this.cpf = CPFUtil.doMascararCPF(conta.getCpf());
		} catch (CPFInvalidoException e) {
			e.printStackTrace();
			this.cpf = null;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idContaExterna == null) ? 0 : idContaExterna.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		ContaDTO other = (ContaDTO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idContaExterna == null) {
			if (other.idContaExterna != null)
				return false;
		} else if (!idContaExterna.equals(other.idContaExterna))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Integer getIdContaExterna() {
		return idContaExterna;
	}

	public void setIdContaExterna(Integer idContaExterna) {
		this.idContaExterna = idContaExterna;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
