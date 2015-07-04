package br.com.calcard.calsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({
		@NamedQuery(name = Usuario.NQ_SELECT_USUARIO_BY_LOGIN_SENHA, query = "select u from Usuario u where u.login = :login and u.senha = :senha"),
		@NamedQuery(name = Usuario.NQ_SELECT_USUARIO_BY_LOGIN, query = "select u from Usuario u where u.login = :login"),
		@NamedQuery(name = Usuario.NQ_SELECT_USUARIOS_BY_ESTABELECIMENTO, query = "select u from Usuario u join u.estabelecimentos e where e = :estabelecimento") })
@Table(name = "tbl_usuario")
public class Usuario extends CalsystemEntity {

	private static final long serialVersionUID = 5938989213718432271L;

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String NQ_SELECT_USUARIO_BY_LOGIN_SENHA = "NQUsuarioLoginSenha";

	public static final String NQ_SELECT_USUARIOS_BY_ESTABELECIMENTO = "NQUsuarioByEstabelecimento";

	public static final String NQ_SELECT_USUARIO_BY_LOGIN = "NQUsuarioByLogin";

	public static final String COLUNA_ESTABELECIMENTO = "id_estabelecimento";

	public static final String COLUNA_USUARIO = "id_usuario";

	public static final String COLUNA_LOGIN = "login";

	public static final String COLUNA_SENHA = "senha";

	public static final String COLUNA_NOME = "nome";

	public static final String COLUNA_CPF = "cpf";

	public static final String COLUNA_PERFIL = "id_perfil";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = COLUNA_LOGIN, length = 50, nullable = true, unique = true)
	private String login;

	@Column(name = COLUNA_SENHA, length = 20, nullable = true, unique = false)
	private String senha;

	@Column(name = COLUNA_CPF, length = 11, nullable = true, unique = false)
	private String cpf;

	@Column(name = COLUNA_NOME, length = 40, nullable = true, unique = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = COLUNA_PERFIL, nullable = false, unique = false)
	private Perfil perfil;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_usuario_estabelecimento", joinColumns = { @JoinColumn(name = COLUNA_USUARIO) }, inverseJoinColumns = { @JoinColumn(name = COLUNA_ESTABELECIMENTO) }, uniqueConstraints = @UniqueConstraint(columnNames = {
			COLUNA_USUARIO, COLUNA_ESTABELECIMENTO }))
	private List<Estabelecimento> estabelecimentos;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String status, Date dataRegistro,
			Date dataAtualizacao, String login, String senha, String cpf,
			String nome, Perfil perfil, List<Estabelecimento> estabelecimentos) {
		super(id, dataRegistro, dataAtualizacao);
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.nome = nome;
		this.perfil = perfil;
		this.estabelecimentos = estabelecimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", cpf=" + cpf + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

}
