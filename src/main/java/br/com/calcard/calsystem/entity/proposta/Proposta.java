package br.com.calcard.calsystem.entity.proposta;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.StatusProposta;

@Entity
@Table(name = "tbl_proposta")
@NamedQueries({ @NamedQuery(name = Proposta.NQ_SELECT_PROPOSTA_BY_ESTABELECIMENTO, query = "select p from Proposta p join p.propostaP1 p1 where p1.estabelecimento IN :estabelecimentos order by p.id desc") })
public class Proposta extends CalsystemEntity {

	private static final long serialVersionUID = -908897569532322029L;

	public static final String NQ_SELECT_PROPOSTA_BY_ESTABELECIMENTO = "NQPropostaByEstabelecimento";

	private static final String COLUNA_SCORE_FRAUDE = "score_fraude";

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_STATUS, length = 30, nullable = false, unique = false)
	private StatusProposta status;

	@OneToOne(mappedBy = "proposta", cascade = CascadeType.ALL)
	private PropostaP1 propostaP1;

	@OneToOne(mappedBy = "proposta", cascade = CascadeType.ALL)
	private PropostaP2 propostaP2;

	@OneToMany(mappedBy = "proposta", cascade = CascadeType.ALL)
	private List<PropostaIntegracao> propostaIntegracao;

	@Column(name = COLUNA_SCORE_FRAUDE, unique = false, nullable = true)
	private Double scoreFraude;

	public Proposta() {

		this.propostaIntegracao = new ArrayList<PropostaIntegracao>();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((propostaIntegracao == null) ? 0 : propostaIntegracao
						.hashCode());
		result = prime * result
				+ ((propostaP1 == null) ? 0 : propostaP1.hashCode());
		result = prime * result
				+ ((propostaP2 == null) ? 0 : propostaP2.hashCode());
		result = prime * result
				+ ((scoreFraude == null) ? 0 : scoreFraude.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Proposta other = (Proposta) obj;
		if (propostaIntegracao == null) {
			if (other.propostaIntegracao != null)
				return false;
		} else if (!propostaIntegracao.equals(other.propostaIntegracao))
			return false;
		if (propostaP1 == null) {
			if (other.propostaP1 != null)
				return false;
		} else if (!propostaP1.equals(other.propostaP1))
			return false;
		if (propostaP2 == null) {
			if (other.propostaP2 != null)
				return false;
		} else if (!propostaP2.equals(other.propostaP2))
			return false;
		if (scoreFraude == null) {
			if (other.scoreFraude != null)
				return false;
		} else if (!scoreFraude.equals(other.scoreFraude))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public StatusProposta getStatus() {
		return status;
	}

	public void setStatus(StatusProposta status) {
		this.status = status;
	}

	public PropostaP1 getPropostaP1() {
		return propostaP1;
	}

	public void setPropostaP1(PropostaP1 propostaP1) {
		this.propostaP1 = propostaP1;
	}

	public PropostaP2 getPropostaP2() {
		return propostaP2;
	}

	public void setPropostaP2(PropostaP2 propostaP2) {
		this.propostaP2 = propostaP2;
	}

	public List<PropostaIntegracao> getPropostaIntegracao() {
		return propostaIntegracao;
	}

	public void setPropostaIntegracao(
			List<PropostaIntegracao> propostaIntegracao) {
		this.propostaIntegracao = propostaIntegracao;
	}

	public Double getScoreFraude() {
		return scoreFraude;
	}

	public void setScoreFraude(Double scoreFraude) {
		this.scoreFraude = scoreFraude;
	}

}
