package br.com.calcard.calsystem.entity.proposta;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.GrauParentescoEnum;

@Entity
@Table(name = "tbl_proposta_referencia")
public class PropostaReferencia extends CalsystemEntity {

	private static final long serialVersionUID = -6576931937223501850L;

	private static final String COLUNA_GRAU_PARENTESCO = "grau_parentesco";

	private static final String COLUNA_NOME = "nome";

	private static final String COLUNA_TELEFONE = "id_telefone";

	private static final String COLUNA_PROPOSTA = "id_proposta_p2";

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_GRAU_PARENTESCO, length = 10, nullable = false, unique = false)
	private GrauParentescoEnum grauParentesco;

	@Column(name = COLUNA_NOME, length = 100, nullable = false, unique = false)
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_TELEFONE, nullable = false, unique = false)
	private Telefone telefone;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = false)
	private PropostaP2 propostaP2;

	public PropostaReferencia() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((grauParentesco == null) ? 0 : grauParentesco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((propostaP2 == null) ? 0 : propostaP2.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
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
		PropostaReferencia other = (PropostaReferencia) obj;
		if (grauParentesco != other.grauParentesco)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (propostaP2 == null) {
			if (other.propostaP2 != null)
				return false;
		} else if (!propostaP2.equals(other.propostaP2))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public GrauParentescoEnum getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentescoEnum grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public PropostaP2 getPropostaP2() {
		return propostaP2;
	}

	public void setPropostaP2(PropostaP2 propostaP2) {
		this.propostaP2 = propostaP2;
	}

}
