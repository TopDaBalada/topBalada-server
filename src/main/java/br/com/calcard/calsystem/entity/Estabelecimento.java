package br.com.calcard.calsystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;

@Entity
@NamedQueries({
		@NamedQuery(name = Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CODIGO, query = "select e from Estabelecimento e where e.codigo = :codigo"),
		@NamedQuery(name = Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CODIGO_CNPJ, query = "select e from Estabelecimento e where e.codigo = :codigo and e.cnpj = :cnpj"),
		@NamedQuery(name = Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CNPJ, query = "select e from Estabelecimento e where e.cnpj = :cnpj"),
		@NamedQuery(name = Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_USUARIO, query = "select e from Usuario u join u.estabelecimentos e where u = :usuario") })
@Table(name = Estabelecimento.NOME_TABELA)
public class Estabelecimento extends CalsystemEntity implements Cloneable {

	private static final long serialVersionUID = 8447343672383564988L;

	public static final String NQ_SELECT_ESTABELECIMENTO_BY_CODIGO = "NQEstabelecimentoByCodigo";

	public static final String NQ_SELECT_ESTABELECIMENTO_BY_CODIGO_CNPJ = "NQEstabelecimentoByCodigoCNPJ";

	public static final String NQ_SELECT_ESTABELECIMENTO_BY_CNPJ = "NQEstabelecimentoByCNPJ";

	public static final String NQ_SELECT_ESTABELECIMENTO_BY_USUARIO = "NQEstabelecimentoByUsuario";

	public static final String COLUNA_CODIGO = "codigo";

	public static final String COLUNA_CNPJ = "cnpj";

	private static final String COLUNA_LOJISTA = "id_lojista";

	public static final String NOME_TABELA = "tbl_estabelecimento";

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	private StatusEstabelecimentoEnum status;

	/**
	 * Propriedade que define o Código único de identificação do
	 * {@link Estabelecimento}
	 */
	@Column(name = COLUNA_CODIGO, length = 6, nullable = false, unique = true)
	private String codigo;

	/**
	 * Propriedade que define o CNPJ do {@link Estabelecimento}
	 */
	@Column(name = COLUNA_CNPJ, length = 14, nullable = false, unique = false)
	private String cnpj;

	@ManyToMany(mappedBy = "estabelecimentos")
	private List<Usuario> usuarios;

	@ManyToOne
	@JoinColumn(name = COLUNA_LOJISTA, nullable = false, unique = false)
	private Lojista lojista;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String codigo, String cnpj) {
		super();
		this.codigo = codigo;
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((lojista == null) ? 0 : lojista.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Estabelecimento other = (Estabelecimento) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (lojista == null) {
			if (other.lojista != null)
				return false;
		} else if (!lojista.equals(other.lojista))
			return false;
		if (status != other.status)
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Lojista getLojista() {
		return lojista;
	}

	public void setLojista(Lojista lojista) {
		this.lojista = lojista;
	}

	public Estabelecimento clone() {
		return clone();

	}

	public StatusEstabelecimentoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEstabelecimentoEnum status) {
		this.status = status;
	}

}
