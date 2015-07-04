package br.com.calcard.calsystem.rn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.service.EstabelecimentoService;
import br.com.calcard.calsystem.service.UsuarioService;

@Component
@Transactional(rollbackFor = Exception.class)
public class UsuarioRN {

	private UsuarioService usuarioService;

	private EstabelecimentoService estabelecimentoService;

	@Autowired
	public UsuarioRN(UsuarioService usuarioService,
			EstabelecimentoService estabelecimentoService) {
		this.usuarioService = usuarioService;
		this.estabelecimentoService = estabelecimentoService;
	}

	public List<Usuario> doListarByEstabelecimento(Integer id)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException,
			EstabelecimentoInvalidoException, UsuarioNaoEncontradoException {

		Estabelecimento estabelecimento = this.estabelecimentoService
				.doConsultar(id);

		return this.usuarioService.doListar(estabelecimento);

	}
}
