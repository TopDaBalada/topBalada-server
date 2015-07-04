package br.com.calcard.calsystem.entity.proposta;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoResidenciaEnum;

@Entity
@Table(name = "tbl_proposta_dados_residenciais")
public class PropostaDadosResidenciais extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3017641794360776063L;

	private static final String COLUNA_ANOS_RESIDENCIA = "anos_residencia";

	private static final String COLUNA_MESES_RESIDENCIA = "meses_residencia";

	private static final String COLUNA_TIPO_RESIDENCIA = "tipo_residencia";

	private static final String COLUNA_ENDERECO = "id_endereco";

	private static final String COLUNA_TELEFONE = "id_telefone";

	private static final String COLUNA_PROPOSTA = "id_proposta_p2";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_ENDERECO, nullable = false, unique = false)
	private Endereco endereco;

	@Column(name = COLUNA_ANOS_RESIDENCIA, length = 2, nullable = false, unique = false)
	private Integer anosResidencia;

	@Column(name = COLUNA_MESES_RESIDENCIA, length = 2, nullable = false, unique = false)
	private Integer mesesResidencia;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_TIPO_RESIDENCIA, length = 20, nullable = false, unique = false)
	private TipoResidenciaEnum tipoResidencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_TELEFONE, nullable = false, unique = false)
	private Telefone telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = COLUNA_PROPOSTA, nullable = false, unique = true)
	private PropostaP2 propostaP2;

	public PropostaDadosResidenciais() {
		this.endereco = new Endereco();
		this.telefone = new Telefone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((anosResidencia == null) ? 0 : anosResidencia.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result
				+ ((mesesResidencia == null) ? 0 : mesesResidencia.hashCode());
		result = prime * result
				+ ((propostaP2 == null) ? 0 : propostaP2.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result
				+ ((tipoResidencia == null) ? 0 : tipoResidencia.hashCode());
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
		PropostaDadosResidenciais other = (PropostaDadosResidenciais) obj;
		if (anosResidencia == null) {
			if (other.anosResidencia != null)
				return false;
		} else if (!anosResidencia.equals(other.anosResidencia))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (mesesResidencia == null) {
			if (other.mesesResidencia != null)
				return false;
		} else if (!mesesResidencia.equals(other.mesesResidencia))
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
		if (tipoResidencia != other.tipoResidencia)
			return false;
		return true;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getAnosResidencia() {
		return anosResidencia;
	}

	public void setAnosResidencia(Integer anosResidencia) {
		this.anosResidencia = anosResidencia;
	}

	public Integer getMesesResidencia() {
		return mesesResidencia;
	}

	public void setMesesResidencia(Integer mesesResidencia) {
		this.mesesResidencia = mesesResidencia;
	}

	public TipoResidenciaEnum getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(TipoResidenciaEnum tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
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
