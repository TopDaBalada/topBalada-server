package br.com.calcard.calsystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.calcard.calframework.entity.CalsystemEntity;

@Entity
@NamedQueries({
		@NamedQuery(name = Voucher.NQ_SELECT_VOUCHERS_BY_CPF, query = "select v from Voucher v where v.conta.cpf = :cpf"),
		@NamedQuery(name = Voucher.NQ_SELECT_VOUCHERS_VENCIDOS, query = "select v from Voucher v where v.dataGeracao < :hoje and v.status in (:status1, :status2)"),
		@NamedQuery(name = Voucher.NQ_SELECT_VOUCHER_BY_CODIGO, query = "select v from Voucher v where v.codigo = :codigo") })
@Table(name = "tbl_voucher")
public class Voucher extends CalsystemEntity {

	private static final long serialVersionUID = -255766906672430061L;

	/**
	 * Nome da query de consulta de {@link Voucher} por CPF
	 */
	public static final String NQ_SELECT_VOUCHERS_BY_CPF = "NQVoucherByCpf";

	/**
	 * Nome da query de consulta de {@link Voucher}s vencidos
	 */
	public static final String NQ_SELECT_VOUCHERS_VENCIDOS = "NQVouchersVencidos";

	/**
	 * Nome da query de consulta de {@link Voucher} por Código
	 */
	public static final String NQ_SELECT_VOUCHER_BY_CODIGO = "NQVoucherByCodigo";

	/**
	 * Status do {@link Voucher} quando identificado o cadastro de uma nova.
	 * {@link Conta}. Este é o primerio Status da sequencia e identifica que o
	 * {@link Voucher} está disponível para impressão
	 */
	public static final String STATUS_DISPONIVEL = "DISPONIVEL";

	/**
	 * Status do {@link Voucher} quando o mesmo foi impresso. Este é o segundo
	 * Status da sequencia e identifica que o documento do {@link Voucher} foi
	 * impresso e entregue para o Cliente.
	 */
	public static final String STATUS_EMITIDO = "EMITIDO";

	/**
	 * Status do {@link Voucher} quendo o mesmo está em processo de utilização.
	 * Este é o terceito Status da sequencia e identifica que o PDV iniciou uma
	 * compra utilizando este {@link Voucher}
	 */
	public static final String STATUS_EM_UTILIZACAO = "EM_UTILIZACAO";

	/**
	 * Status do {@link Voucher} quando o mesmo foi utilizado. Este é o quarto
	 * Status da sequencia e identifica que o {@link Voucher} foi utilizado para
	 * a realização de alguma compra
	 */
	public static final String STATUS_UTILIZADO = "UTILIZADO";

	/**
	 * Status do {@link Voucher} quando o mesmo não foi utilizado e sua validade
	 * expirou.
	 */
	public static final String STATUS_EXPIRADO = "EXPIRADO";

	/**
	 * Nome da tabela que armazena os {@link Voucher}s
	 */
	public static final String NOME_TABELA = "tbl_voucher";

	/**
	 * Nome da coluna da tabela que identifica o código do {@link Voucher}
	 */
	public static final String COLUNA_CODIGO = "codigo";

	/**
	 * Nome da coluna da tabela que identifica a data em que o {@link Voucher}
	 * foi emitido.
	 */
	public static final String COLUNA_DATA_GERACAO = "data_geracao";

	/**
	 * Nome da coluna da tabela que identifica para qual {@linkplain Conta} o
	 * {@linkplain Voucher foi emitido}
	 */
	public static final String COLUNA_ID_CONTA = "id_conta";

	/**
	 * Senha para utilização do {@link Voucher}
	 */
	private static final String COLUNA_SENHA = "senha";

	/**
	 * Estabelecimento onde o {@link Voucher} foi Gerado
	 */
	private static final String COLUNA_ID_ESTABELECIMENTO = "id_estabelecimento";

	@Column(name = COLUNA_STATUS, length = 50, nullable = false, unique = false)
	private String status;

	/**
	 * Propriedade que identifica o código do {@link Voucher}
	 */
	@Column(name = Voucher.COLUNA_CODIGO, length = 16, nullable = false, unique = true)
	private String codigo;

	/**
	 * Propriedade que identifica a data e hora da emissão do {@link Voucher}
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = Voucher.COLUNA_DATA_GERACAO, unique = false, nullable = false)
	private Date dataGeracao;

	/**
	 * Propriedade que identifica a {@link Conta} para qual o {@link Voucher}
	 * foi emitido
	 */
	@ManyToOne
	@JoinColumn(name = Voucher.COLUNA_ID_CONTA, nullable = false, unique = false)
	private Conta conta;

	/**
	 * Propriedade que identifica a senha que o Cliente deve utilizar para
	 * transacionar com o {@link Voucher}
	 */
	@Column(name = Voucher.COLUNA_SENHA, unique = false, nullable = false, length = 4)
	private String senha;

	/**
	 * Propriedade que identifica em qual {@link Estabelecimento} o
	 * {@link Voucher} foi Gerado
	 */
	@ManyToOne
	@JoinColumn(name = Voucher.COLUNA_ID_ESTABELECIMENTO, nullable = false, unique = false)
	private Estabelecimento estabelecimento;

	public Voucher() {
		super();
	}

	public Voucher(Integer id, String status, Date dataRegistro,
			Date dataAtualizacao, String codigo, Date dataGeracao, Conta conta,
			String senha, Estabelecimento estabelecimento) {
		super(id, dataRegistro, dataAtualizacao);
		this.codigo = codigo;
		this.dataGeracao = dataGeracao;
		this.conta = conta;
		this.senha = senha;
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result
				+ ((dataGeracao == null) ? 0 : dataGeracao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Voucher other = (Voucher) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataGeracao == null) {
			if (other.dataGeracao != null)
				return false;
		} else if (!dataGeracao.equals(other.dataGeracao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
