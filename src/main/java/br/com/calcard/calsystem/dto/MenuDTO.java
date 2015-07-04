package br.com.calcard.calsystem.dto;

import br.com.calcard.calsystem.entity.Menu;

public class MenuDTO {

	private Integer idMenu;

	private Integer idSubMenu;

	private String nome;

	private String caminho;

	private String icone;

	public MenuDTO(Menu menu) {

		this.idMenu = menu.getMenuPK().getIdMenu();
		this.idSubMenu = menu.getMenuPK().getIdSubMenu();
		this.nome = menu.getNome();
		this.caminho = menu.getCaminho();
		this.icone = menu.getIcone();

	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public Integer getIdSubMenu() {
		return idSubMenu;
	}

	public void setIdSubMenu(Integer idSubMenu) {
		this.idSubMenu = idSubMenu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

}
