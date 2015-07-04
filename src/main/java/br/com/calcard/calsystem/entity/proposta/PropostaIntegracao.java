package br.com.calcard.calsystem.entity.proposta;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@Table(name = "tbl_proposta_integracao")
public class PropostaIntegracao extends CalsystemEntity {

	private static final long serialVersionUID = -4580441134283268722L;

	private static final String COLUNA_PROPOSTA = "id_proposta";

	private static final String COLUNA_INTEGRACAO = "id_integracao";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = false)
	private Proposta proposta;

	@Column(name = COLUNA_INTEGRACAO, length = 6, nullable = false, unique = false)
	private Integer idIntegracao;

	public PropostaIntegracao() {
		super();
	}

	public PropostaIntegracao(Proposta proposta, Integer idIntegracao) {
		this.proposta = proposta;
		this.idIntegracao = idIntegracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((idIntegracao == null) ? 0 : idIntegracao.hashCode());
		result = prime * result
				+ ((proposta == null) ? 0 : proposta.hashCode());
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
		PropostaIntegracao other = (PropostaIntegracao) obj;
		if (idIntegracao == null) {
			if (other.idIntegracao != null)
				return false;
		} else if (!idIntegracao.equals(other.idIntegracao))
			return false;
		if (proposta == null) {
			if (other.proposta != null)
				return false;
		} else if (!proposta.equals(other.proposta))
			return false;
		return true;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public Integer getIdIntegracao() {
		return idIntegracao;
	}

	public void setIdIntegracao(Integer idIntegracao) {
		this.idIntegracao = idIntegracao;
	}

}
