package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MenuPK implements Serializable {

	private static final long serialVersionUID = -3932410267628230266L;

	@Column(name = "id_menu", length = 6, nullable = false, unique = false)
	private Integer idMenu;

	@Column(name = "id_submenu", length = 6, nullable = false, unique = false)
	private Integer idSubMenu;

	public MenuPK() {
		super();
	}

	public MenuPK(Integer idMenu, Integer idSubMenu) {
		super();
		this.idMenu = idMenu;
		this.idSubMenu = idSubMenu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMenu == null) ? 0 : idMenu.hashCode());
		result = prime * result
				+ ((idSubMenu == null) ? 0 : idSubMenu.hashCode());
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
		MenuPK other = (MenuPK) obj;
		if (idMenu == null) {
			if (other.idMenu != null)
				return false;
		} else if (!idMenu.equals(other.idMenu))
			return false;
		if (idSubMenu == null) {
			if (other.idSubMenu != null)
				return false;
		} else if (!idSubMenu.equals(other.idSubMenu))
			return false;
		return true;
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

}
