package br.com.calcard.calsystem.entity.proposta;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calsystem.enums.DDDConverter;
import br.com.calcard.calsystem.enums.PropostaEnum.DDDEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoTelefoneEnum;

@Entity
@Table(name = "tbl_telefone")
public class Telefone extends CalsystemEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4868682811173162268L;

	private static final String COLUNA_DDD = "ddd";

	private static final String COLUNA_NUMERO = "numero";

	private static final String COLUNA_RAMAL = "ramal";

	private static final String COLUNA_TIPO = "tipo";

	@Column(name = COLUNA_DDD, length = 2, nullable = false, unique = false)
	@Convert(converter = DDDConverter.class)
	private DDDEnum ddd;

	@Column(name = COLUNA_NUMERO, length = 9, nullable = false, unique = false)
	private Integer numero;

	@Column(name = COLUNA_RAMAL, length = 6, nullable = true, unique = false)
	private Integer ramal;

	@Enumerated(EnumType.STRING)
	@Column(name = COLUNA_TIPO, length = 15, nullable = false, unique = false)
	private TipoTelefoneEnum tipoTelefone;

	public Telefone() {

	}

	public Telefone(DDDEnum ddd, Integer numero, Integer ramal,
			TipoTelefoneEnum tipoTelefone) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.ramal = ramal;
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((ramal == null) ? 0 : ramal.hashCode());
		result = prime * result
				+ ((tipoTelefone == null) ? 0 : tipoTelefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (ddd != other.ddd)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (ramal == null) {
			if (other.ramal != null)
				return false;
		} else if (!ramal.equals(other.ramal))
			return false;
		if (tipoTelefone != other.tipoTelefone)
			return false;
		return true;
	}

	public DDDEnum getDdd() {
		return ddd;
	}

	public void setDdd(DDDEnum ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getRamal() {
		return ramal;
	}

	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}
