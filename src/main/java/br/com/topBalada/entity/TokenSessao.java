package br.com.topBalada.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.topBalada.enums.StatusTokenEnum;
import br.com.topBalada.enums.TipoTokenEnum;

@Entity
@NamedQueries({ @NamedQuery(name = TokenSessao.NQ_SELECT_TOKEN_SESSAO_BY_TOKEN, query = "select t from TokenSessao t where t.token = :token") })
@Table(name = "tbl_token_sessao")
public class TokenSessao extends Token implements Serializable {

	private static final long serialVersionUID = -6964614886009235343L;

	public static final String COLUNA_ID_USUARIO = "id_usuario";

	public static final String NQ_SELECT_TOKEN_SESSAO_BY_TOKEN = "NQTokenSessaoByToken";

	@Transient
	private TokenTransacao tokenTransacao;

	@ManyToOne
	@JoinColumn(name = COLUNA_ID_USUARIO, nullable = false, unique = false)
	private Usuario usuario;

	public TokenSessao() {
		// TODO Auto-generated constructor stub
	}

	public TokenSessao(String tSessao, Periferico periferico, Date dataCriacao,
			Date dataExpiracao, TokenTransacao tokenTransacao, Usuario usuario,
			StatusTokenEnum status) {
		super(tSessao, periferico, dataCriacao, dataExpiracao,
				TipoTokenEnum.SESSAO, status);

		this.tokenTransacao = tokenTransacao;
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((tokenTransacao == null) ? 0 : tokenTransacao.hashCode());
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
		TokenSessao other = (TokenSessao) obj;
		if (tokenTransacao == null) {
			if (other.tokenTransacao != null)
				return false;
		} else if (!tokenTransacao.equals(other.tokenTransacao))
			return false;
		return true;
	}

	public TokenTransacao getTokenTransacao() {
		return tokenTransacao;
	}

	public void setTokenTransacao(TokenTransacao tokenTransacao) {
		this.tokenTransacao = tokenTransacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
