package br.com.calcard.calsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({
		@NamedQuery(name = Conta.NQ_SELECT_CONTAS_SEM_VOUCHER, query = "select c from Conta c where c.dataCadastro >= :dataHoje and c.dataCadastro < :dataAmanha and not exists (select v from Voucher v where v.conta = c)"),
		@NamedQuery(name = Conta.NQ_SELECT_CONTA_BY_CPF, query = "select c from Conta c where c.cpf = :cpf") })
@Table(name = "tbl_conta")
public class Conta extends CalsystemEntity {

	private static final long serialVersionUID = -1861443589826791504L;

	public static final String STATUS_ATIVO = "ATIVO";

	public static final String NQ_SELECT_CONTAS_SEM_VOUCHER = "NQContasSemVoucher";

	public static final String NQ_SELECT_CONTA_BY_CPF = "NQContaByCPF";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	protected String status;

	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "nome_cliente", length = 50, nullable = false, unique = false)
	private String nomeCliente;

	@Column(name = "id_conta_externa", length = 6, nullable = false, unique = true)
	private int idContaExterna;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", unique = false, nullable = false)
	private Date dataCadastro;

	@Column(name = "ddd_celular", length = 2, nullable = true, unique = false)
	private int dddCelular;

	@Column(name = "numero_celular", length = 9, nullable = true, unique = false)
	private int numeroCelular;

	@ManyToOne
	@JoinColumn(name = "id_estabelecimento", nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	// @OneToMany(fetch = FetchType.EAGER)
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conta")
	private List<Cartao> cartoes;

	public Conta() {
		super();
	}

	public Conta(Integer id, String status, Date dataRegistro,
			Date dataAtualizacao, String cpf, String nomeCliente,
			int idContaExterna, Date dataCadastro, int dddCelular,
			int numeroCelular, Estabelecimento estabelecimento,
			List<Cartao> cartoes) {
		super(id, dataRegistro, dataAtualizacao);
		this.cpf = cpf;
		this.nomeCliente = nomeCliente;
		this.idContaExterna = idContaExterna;
		this.dataCadastro = dataCadastro;
		this.dddCelular = dddCelular;
		this.numeroCelular = numeroCelular;
		this.estabelecimento = estabelecimento;
		this.cartoes = cartoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cartoes == null) ? 0 : cartoes.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + dddCelular;
		result = prime * result
				+ ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
		result = prime * result + idContaExterna;
		result = prime * result
				+ ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + numeroCelular;
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
		Conta other = (Conta) obj;
		if (cartoes == null) {
			if (other.cartoes != null)
				return false;
		} else if (!cartoes.equals(other.cartoes))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dddCelular != other.dddCelular)
			return false;
		if (estabelecimento == null) {
			if (other.estabelecimento != null)
				return false;
		} else if (!estabelecimento.equals(other.estabelecimento))
			return false;
		if (idContaExterna != other.idContaExterna)
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (numeroCelular != other.numeroCelular)
			return false;
		return true;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(int dddCelular) {
		this.dddCelular = dddCelular;
	}

	public int getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getIdContaExterna() {
		return idContaExterna;
	}

	public void setIdContaExterna(int idContaExterna) {
		this.idContaExterna = idContaExterna;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

}
