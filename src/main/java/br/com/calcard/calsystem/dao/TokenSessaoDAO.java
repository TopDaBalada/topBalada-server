package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.TokenSessao;
import br.com.calcard.calsystem.exception.token.TokenSessaoInvalidoException;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class TokenSessaoDAO extends CalsystemDAO<TokenSessao> {

	public TokenSessao doConsultar(String tSessao) throws DAOException,
			TokenSessaoInvalidoException {

		if (tSessao == null)
			throw new TokenSessaoInvalidoException(
					"Token Sessão não informado!");

		return super.doGetSingleResult(
				TokenSessao.NQ_SELECT_TOKEN_SESSAO_BY_TOKEN, new Parametro()
						.doAddParametro("token", tSessao).getParametros());

	}

	@Override
	public Class<TokenSessao> doGetClass() {
		return TokenSessao.class;
	}

}
