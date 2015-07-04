package br.com.topBalada.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.topBalada.dao.MenuDAO;
import br.com.topBalada.dao.UsuarioDAO;
import br.com.topBalada.entity.Menu;
import br.com.topBalada.entity.Perfil;
import br.com.topBalada.entity.Usuario;
import br.com.topBalada.exception.PerfilInvalidoException;

@Service
public class SegurancaService {

	private UsuarioDAO usuarioDAO;

	private MenuDAO menuDAO;

	@Autowired
	public SegurancaService(UsuarioDAO usuarioDAO, MenuDAO menuDAO) {
		this.usuarioDAO = usuarioDAO;
		this.menuDAO = menuDAO;
	}

	public Usuario doLogin(String login, String senha) throws LoginException,
			DAOException {

		if (login == null)
			throw new LoginException("Login não informado!");

		else if (senha == null)
			throw new LoginException("Senha não informada!");

		Usuario usuario = this.usuarioDAO.doConsultar(login, senha);

		if (usuario == null)
			throw new LoginException("Usuário não encontrado!");

		return usuario;

	}

	public List<Menu> doListarMenus(Perfil perfil)
			throws PerfilInvalidoException, DAOException {

		if (perfil == null)
			throw new PerfilInvalidoException("Perfil não informado!");

		if (perfil.getCodigo().equals(Perfil.CODIGO_SUPER_USUARIO))
			return this.menuDAO.doListar();

		else
			return this.menuDAO.doListar(perfil);

	}
}
