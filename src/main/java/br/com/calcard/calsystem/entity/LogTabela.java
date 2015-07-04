package br.com.calcard.calsystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@Table(name = "tbl_log_tabela")
public class LogTabela extends CalsystemEntity implements Serializable {

	private static final long serialVersionUID = 6319257835216581633L;

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String COLUNA_TABELA = "tabela";
	public static final String COLUNA_COLUNA = "coluna";
	public static final String COLUNA_DE = "de";
	public static final String COLUNA_PARA = "para";
	public static final String COLUNA_ID_USUARIO = "id_usuario";
	public static final String COLUNA_ID_REGISTRO = "id_registro";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_TABELA, length = 30, nullable = false, unique = false)
	private String tabela;

	@Column(name = COLUNA_COLUNA, length = 30, nullable = false, unique = false)
	private String coluna;

	@Column(name = COLUNA_DE, length = 100, nullable = false, unique = false)
	private String de;

	@Column(name = COLUNA_PARA, length = 100, nullable = false, unique = false)
	private String para;

	@Column(name = COLUNA_ID_REGISTRO, length = 6, nullable = false, unique = false)
	private Integer idRegistro;

	@ManyToOne
	@JoinColumn(name = COLUNA_ID_USUARIO, nullable = true, unique = false)
	private Usuario usuario;

	public LogTabela() {
		super();
	}

	public LogTabela(String tabela, String coluna, String de, String para,
			Usuario usuario, Integer idRegistro) {
		super();

		this.tabela = tabela;
		this.coluna = coluna;
		this.de = de;
		this.para = para;
		this.idRegistro = idRegistro;
		this.usuario = usuario;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((coluna == null) ? 0 : coluna.hashCode());
		result = prime * result + ((de == null) ? 0 : de.hashCode());
		result = prime * result
				+ ((idRegistro == null) ? 0 : idRegistro.hashCode());
		result = prime * result + ((para == null) ? 0 : para.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogTabela other = (LogTabela) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (de == null) {
			if (other.de != null)
				return false;
		} else if (!de.equals(other.de))
			return false;
		if (idRegistro == null) {
			if (other.idRegistro != null)
				return false;
		} else if (!idRegistro.equals(other.idRegistro))
			return false;
		if (para == null) {
			if (other.para != null)
				return false;
		} else if (!para.equals(other.para))
			return false;
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getColuna() {
		return coluna;
	}

	public void setColuna(String coluna) {
		this.coluna = coluna;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the idRegistro
	 */
	public Integer getIdRegistro() {
		return idRegistro;
	}

	/**
	 * @param idRegistro
	 *            the idRegistro to set
	 */
	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

}
