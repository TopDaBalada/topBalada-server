package br.com.calcard.calsystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.calcard.calsystem.entity.Enum.StatusTokenEnum;
import br.com.calcard.calsystem.entity.Enum.TipoTokenEnum;

@Entity
@NamedQueries({ @NamedQuery(name = TokenLogin.NQ_SELECT_TOKEN_LOGIN_BY_TOKEN, query = "select t from TokenLogin t where t.token = :token") })
@Table(name = "tbl_token_login")
public class TokenLogin extends Token implements Serializable {

	private static final long serialVersionUID = 1920271514599925366L;

	public static final String NQ_SELECT_TOKEN_LOGIN_BY_TOKEN = "NQTokenLoginByToken";

	public TokenLogin() {
		super();
	}

	public TokenLogin(String token, Periferico periferico, Date dataCriacao,
			Date dataExpiracao, StatusTokenEnum status) {
		super(token, periferico, dataCriacao, dataExpiracao,
				TipoTokenEnum.LOGIN, status);

	}

}
