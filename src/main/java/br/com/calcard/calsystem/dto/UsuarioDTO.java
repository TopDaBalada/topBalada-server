package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.util.CalsystemUtil;

public class UsuarioDTO {

	private Integer id;

	private String nome;

	private String codigoPerfil;

	private String cpf;

	public UsuarioDTO(Usuario usuario) {

		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.codigoPerfil = usuario.getPerfil().getCodigo();
		this.cpf = CalsystemUtil.doMascararCPF(usuario.getCpf());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
