package br.com.calcard.calsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.UsuarioDAO;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoInvalidoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioLoginInvalidoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {

	private UsuarioDAO usuarioDAO;

	@Autowired
	public UsuarioService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public List<Usuario> doListar(Estabelecimento estabelecimento)
			throws EstabelecimentoInvalidoException, DAOException,
			UsuarioNaoEncontradoException {

		if (estabelecimento == null)
			throw new EstabelecimentoInvalidoException(
					"Estabelecimento não informado!");

		List<Usuario> usuarios = this.usuarioDAO.doListar(estabelecimento);

		if (usuarios.size() == 0)
			throw new UsuarioNaoEncontradoException(
					new StringBuilder()
							.append("Nenhum usuário vinculado ao Estabelecimento informado! ID Estabelecimento: ")
							.append(estabelecimento.getId()).toString());

		return usuarios;

	}

	public Usuario doConsultar(Integer id)
			throws UsuarioNaoEncontradoException, DAOException {

		if (id == null)
			throw new IllegalArgumentException("Id do Usuário não informado!");

		Usuario usuario = usuarioDAO.doProcurar(id);

		if (usuario == null)
			throw new UsuarioNaoEncontradoException();

		return usuario;

	}

	public Usuario doConsultarByLogin(String loginUsuario)
			throws UsuarioNaoEncontradoException, DAOException,
			UsuarioLoginInvalidoException {

		if (loginUsuario == null)
			throw new UsuarioLoginInvalidoException();

		Usuario usuario = usuarioDAO.doConsultarByLogin(loginUsuario);

		if (usuario == null)
			throw new UsuarioNaoEncontradoException();

		return usuario;

	}

}
