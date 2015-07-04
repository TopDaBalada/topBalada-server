package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.TokenLogin;
import br.com.calcard.calsystem.exception.token.TokenLoginInvalidoException;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class TokenLoginDAO extends CalsystemDAO<TokenLogin> {

	@Override
	public Class<TokenLogin> doGetClass() {
		return TokenLogin.class;
	}

	public TokenLogin doConsultar(String tLogin)
			throws TokenLoginInvalidoException, DAOException {

		if (tLogin == null)
			throw new TokenLoginInvalidoException();

		return super.doGetSingleResult(
				TokenLogin.NQ_SELECT_TOKEN_LOGIN_BY_TOKEN, new Parametro()
						.doAddParametro("token", tLogin).getParametros());

	}

}
