package br.com.calcard.calsystem.rn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCnpjExistenteException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCnpjInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCodigoDuplicadoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.service.EstabelecimentoService;
import br.com.calcard.calsystem.service.UsuarioService;

@Component
@Transactional(rollbackFor = Exception.class)
public class EstabelecimentoRN {

	private EstabelecimentoService estabelecimentoService;

	private UsuarioService usuarioService;

	@Autowired
	public EstabelecimentoRN(EstabelecimentoService estabelecimentoService,
			UsuarioService usuarioService) {
		this.estabelecimentoService = estabelecimentoService;
		this.usuarioService = usuarioService;
	}

	public Estabelecimento doCadastrar(String codigo, String cnpj)
			throws EstabelecimentoInvalidoException,
			EstabelecimentoCodigoInvalidoException,
			EstabelecimentoCnpjInvalidoException,
			EstabelecimentoCnpjExistenteException, DAOException,
			EstabelecimentoCodigoDuplicadoException {

		return this.estabelecimentoService.doCadastrar(codigo, cnpj);

	}

	public Estabelecimento doAtualizar(Integer id, String codigo, String cnpj)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException,
			EstabelecimentoInvalidoException,
			EstabelecimentoCodigoInvalidoException,
			EstabelecimentoCnpjInvalidoException,
			EstabelecimentoCnpjExistenteException,
			EstabelecimentoCodigoDuplicadoException, CloneNotSupportedException {

		Estabelecimento estabelecimento = this.estabelecimentoService
				.doConsultar(id);

		return this.estabelecimentoService.doAtualizar(estabelecimento, codigo,
				cnpj);

	}

	public void doDeletar(Integer id)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException {

		this.estabelecimentoService.doDeletar(id);

	}

	public List<Estabelecimento> doListar(String codigo, String cnpj,
			Integer idUsuario, StatusEstabelecimentoEnum status)
			throws EstabelecimentoNaoEncontradoException, DAOException {

		return this.estabelecimentoService.doListar(codigo, cnpj, idUsuario,
				status);

	}

	public Estabelecimento doInativar(Integer id) throws DAOException,
			EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException {

		return this.estabelecimentoService.doInativar(id);

	}

	public List<Estabelecimento> doListarByUsuario(Integer id)
			throws UsuarioNaoEncontradoException, DAOException,
			ServiceException, EstabelecimentoNaoEncontradoException {

		Usuario usuario = this.usuarioService.doConsultar(id);

		return this.estabelecimentoService.doListarByUsuario(usuario);

	}
}
