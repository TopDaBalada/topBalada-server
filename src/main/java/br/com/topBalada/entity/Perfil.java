package br.com.topBalada.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({ @NamedQuery(name = Perfil.NQ_SELECT_PERFIL_BY_CODIGO, query = "select p from Periferico p where p.codigo = :codigo") })
@Table(name = "tbl_perfil")
public class Perfil extends CalsystemEntity implements Serializable {

	private static final long serialVersionUID = -4908825505442978667L;

	public static final String NQ_SELECT_PERFIL_BY_CODIGO = "NQPerfilByCodigo";

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String CODIGO_SUPER_USUARIO = "SUPER";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = "nome", length = 20, nullable = false, unique = true)
	private String nome;

	@Column(name = "codigo", length = 20, nullable = false, unique = true)
	private String codigo;

	// @ManyToMany
	// @JoinTable(name = "tbl_menu_perfil", joinColumns = { @JoinColumn(name =
	// "id_perfil") }, inverseJoinColumns = {
	// @JoinColumn(name = "id_menu"), @JoinColumn(name = "id_submenu") })
	// private List<Menu> menus;

	public Perfil() {
		super();
	}

	public Perfil(Integer id, String status, Date dataRegistro,
			Date dataAtualizacao, String nome, String codigo) {
		super(id, dataRegistro, dataAtualizacao);
		this.nome = nome;
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Perfil other = (Perfil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
