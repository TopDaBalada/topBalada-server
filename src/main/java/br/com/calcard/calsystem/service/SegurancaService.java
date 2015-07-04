package br.com.calcard.calsystem.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.MenuDAO;
import br.com.calcard.calsystem.dao.UsuarioDAO;
import br.com.calcard.calsystem.entity.Menu;
import br.com.calcard.calsystem.entity.Perfil;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.PerfilInvalidoException;

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
			throw new LoginException("Login n�o informado!");

		else if (senha == null)
			throw new LoginException("Senha n�o informada!");

		Usuario usuario = this.usuarioDAO.doConsultar(login, senha);

		if (usuario == null)
			throw new LoginException("Usu�rio n�o encontrado!");

		return usuario;

	}

	public List<Menu> doListarMenus(Perfil perfil)
			throws PerfilInvalidoException, DAOException {

		if (perfil == null)
			throw new PerfilInvalidoException("Perfil n�o informado!");

		if (perfil.getCodigo().equals(Perfil.CODIGO_SUPER_USUARIO))
			return this.menuDAO.doListar();

		else
			return this.menuDAO.doListar(perfil);

	}
}
