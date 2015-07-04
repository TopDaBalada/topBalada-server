package br.com.calcard.calsystem.entity.proposta;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.enums.PropostaEnum.SexoEnum;

@Entity
@NamedQueries({ @NamedQuery(name = PropostaP1.NQ_SELECT_PROPOSTA_BY_CPF, query = "select p from PropostaP1 p where p.cpf = :cpf") })
@Table(name = "tbl_proposta_p1")
public class PropostaP1 extends CalsystemEntity {

	private static final long serialVersionUID = 8658535520105226156L;

	public static final String NQ_SELECT_PROPOSTA_BY_CPF = "NQPropostaByCPF";

	public static final String STATUS_ATIVO = "ATIVO";

	private static final String COLUNA_NOME = "nome";

	private static final String COLUNA_CPF = "cpf";

	private static final String COLUNA_DATA_NASCIMENTO = "data_nascimento";

	private static final String COLUNA_SEXO = "sexo";

	private static final String COLUNA_USUARIO = "id_usuario";

	private static final String COLUNA_ESTABELECIMENTO = "id_estabelecimento";

	private static final String COLUNA_PROPOSTA = "id_proposta";

	@Column(name = COLUNA_NOME, length = 50, nullable = false, unique = false)
	private String nome;

	@Column(name = COLUNA_CPF, length = 11, nullable = false, unique = false)
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUNA_DATA_NASCIMENTO, unique = false, nullable = false)
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_SEXO, length = 10, unique = false, nullable = false)
	private SexoEnum sexo;

	@ManyToOne
	@JoinColumn(name = COLUNA_USUARIO, nullable = false, unique = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = COLUNA_ESTABELECIMENTO, nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	@OneToOne
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = false)
	private Proposta proposta;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result
				+ ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((proposta == null) ? 0 : proposta.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		PropostaP1 other = (PropostaP1) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (estabelecimento == null) {
			if (other.estabelecimento != null)
				return false;
		} else if (!estabelecimento.equals(other.estabelecimento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (proposta == null) {
			if (other.proposta != null)
				return false;
		} else if (!proposta.equals(other.proposta))
			return false;
		if (sexo != other.sexo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getSexo() {

		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

}