package br.com.calcard.calsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class UsuarioDAO extends CalsystemDAO<Usuario> {

	@Override
	public Class<Usuario> doGetClass() {
		return Usuario.class;
	}

	public List<Usuario> doListar(Estabelecimento estabelecimento)
			throws DAOException {

		if (estabelecimento == null)
			throw new DAOException("Estabelecimento não informado!");

		return super.doGetResultList(
				Usuario.NQ_SELECT_USUARIOS_BY_ESTABELECIMENTO, new Parametro()
						.doAddParametro("estabelecimento", estabelecimento)
						.getParametros());

	}

	public Usuario doConsultarByLogin(String loginUsuario) throws DAOException {

		if (loginUsuario == null)
			throw new DAOException("Login do Usuario não informado!");

		return super.doGetSingleResult(Usuario.NQ_SELECT_USUARIO_BY_LOGIN,
				new Parametro().doAddParametro("login", loginUsuario)
						.getParametros());

	}

	public Usuario doConsultar(String login, String senha) throws DAOException {

		if (login == null)
			throw new DAOException("Login não informado!");

		else if (senha == null)
			throw new DAOException("Login não informado!");

		return super.doGetSingleResult(
				Usuario.NQ_SELECT_USUARIO_BY_LOGIN_SENHA,
				new Parametro().doAddParametro("login", login)
						.doAddParametro("senha", senha).getParametros());

	}
}
