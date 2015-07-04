package br.com.calcard.calsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.EstabelecimentoDAO;
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

@Service
public class EstabelecimentoService {

	private EstabelecimentoDAO estabelecimentoDAO;

	@Autowired
	public EstabelecimentoService(EstabelecimentoDAO estabelecimentoDAO) {

		this.estabelecimentoDAO = estabelecimentoDAO;

	}

	public Estabelecimento doConsultar(String codigo)
			throws EstabelecimentoNaoEncontradoException,
			EstabelecimentoCodigoInvalidoException, DAOException {

		if (codigo == null)
			throw new IllegalArgumentException(
					"Código do Estabelecimento não informado!");

		Estabelecimento estabelecimento = estabelecimentoDAO
				.doConsultar(codigo);

		if (estabelecimento == null)
			throw new EstabelecimentoNaoEncontradoException();

		return estabelecimento;

	}

	public Estabelecimento doConsultar(Integer id)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException {

		if (id == null)
			throw new EstabelecimentoIdInvalidoException(
					"ID do Estabelecimento não informado!");

		Estabelecimento estabelecimento = estabelecimentoDAO.doProcurar(id);

		if (estabelecimento == null)
			throw new EstabelecimentoNaoEncontradoException();

		return estabelecimento;

	}

	public void doValidarNovoEstabelecimento(
			Estabelecimento estabelecimentoAtual,
			Estabelecimento estabelecimentoNovo)
			throws EstabelecimentoInvalidoException,
			EstabelecimentoCodigoInvalidoException,
			EstabelecimentoCnpjInvalidoException,
			EstabelecimentoCnpjExistenteException, DAOException,
			EstabelecimentoCodigoDuplicadoException {

		if (estabelecimentoNovo == null)
			throw new EstabelecimentoInvalidoException(
					"Estabelecimento não informado!");

		else if (estabelecimentoNovo.getCodigo() == null)
			throw new EstabelecimentoCodigoInvalidoException(
					"Código do Estabelecimento não informado!");

		else if (estabelecimentoNovo.getCnpj() == null)
			throw new EstabelecimentoCnpjInvalidoException(
					"CNPJ do Estabelecimento não informado!");

		if (estabelecimentoAtual == null) {

			if (this.estabelecimentoDAO.doConsultarByCNPJ(estabelecimentoNovo
					.getCnpj()) != null)
				throw new EstabelecimentoCnpjExistenteException(
						new StringBuilder()
								.append("Já existe um Estabelecimento cadastrado com este CNPJ! CNPJ: ")
								.append(estabelecimentoNovo.getCnpj())
								.toString());

			else if (estabelecimentoDAO.doConsultar(estabelecimentoNovo
					.getCodigo()) != null)
				throw new EstabelecimentoCodigoDuplicadoException(
						new StringBuilder()
								.append("Já existe um Estabelecimento cadastrado com este código: ")
								.append(estabelecimentoNovo.getCodigo())
								.toString());
		} else {

			if (!estabelecimentoAtual.getCnpj().equals(
					estabelecimentoNovo.getCnpj())
					&& this.estabelecimentoDAO
							.doConsultarByCNPJ(estabelecimentoNovo.getCnpj()) != null)
				throw new EstabelecimentoCnpjExistenteException(
						new StringBuilder()
								.append("Já existe um Estabelecimento cadastrado com este CNPJ! CNPJ: ")
								.append(estabelecimentoNovo.getCnpj())
								.toString());

			else if (!estabelecimentoAtual.getCodigo().equals(
					estabelecimentoNovo.getCodigo())
					&& estabelecimentoDAO.doConsultar(estabelecimentoNovo
							.getCodigo()) != null)
				throw new EstabelecimentoCodigoDuplicadoException(
						new StringBuilder()
								.append("Já existe um Estabelecimento cadastrado com este código: ")
								.append(estabelecimentoNovo.getCodigo())
								.toString());

		}

	}

	public Estabelecimento doCadastrar(String codigo, String cnpj)
			throws EstabelecimentoInvalidoException,
			EstabelecimentoCodigoInvalidoException,
			EstabelecimentoCnpjInvalidoException,
			EstabelecimentoCnpjExistenteException, DAOException,
			EstabelecimentoCodigoDuplicadoException {

		Estabelecimento estabelecimento = new Estabelecimento(codigo, cnpj);

		this.doValidarNovoEstabelecimento(null, estabelecimento);

		return estabelecimentoDAO.doRegistrar(estabelecimento);

	}

	public Estabelecimento doAtualizar(Estabelecimento estabelecimentoAtual,
			String codigo, String cnpj)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException,
			EstabelecimentoInvalidoException,
			EstabelecimentoCodigoInvalidoException,
			EstabelecimentoCnpjInvalidoException,
			EstabelecimentoCnpjExistenteException,
			EstabelecimentoCodigoDuplicadoException, CloneNotSupportedException {

		Estabelecimento estabelecimentoNovo = estabelecimentoAtual.clone();

		estabelecimentoNovo.setCodigo(codigo);
		estabelecimentoNovo.setCnpj(cnpj);

		this.doValidarNovoEstabelecimento(estabelecimentoAtual,
				estabelecimentoNovo);

		return estabelecimentoDAO.doAtualizar(estabelecimentoNovo);

	}

	public void doDeletar(Integer id)
			throws EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, DAOException {

		if (id == null)
			throw new EstabelecimentoIdInvalidoException();

		Estabelecimento estabelecimento = estabelecimentoDAO.doProcurar(id);

		if (estabelecimento == null)
			throw new EstabelecimentoNaoEncontradoException();

		estabelecimentoDAO.doRemover(estabelecimento);

	}

	public List<Estabelecimento> doListar(String codigo, String cnpj,
			Integer idUsuario, StatusEstabelecimentoEnum statusEstabelecimento)
			throws EstabelecimentoNaoEncontradoException, DAOException {

		List<Estabelecimento> estabelecimentos = estabelecimentoDAO.doListar(
				codigo, cnpj, idUsuario, statusEstabelecimento);

		if (estabelecimentos.size() == 0)
			throw new EstabelecimentoNaoEncontradoException(
					new StringBuilder()
							.append("Nenhum Estabelecimento foi encontrado para os parâmetros informados! Código: ")
							.append(codigo).append(" CNPJ: ").append(cnpj)
							.toString());

		return estabelecimentos;

	}

	public Estabelecimento doInativar(Integer id) throws DAOException,
			EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException {

		Estabelecimento estabelecimento = this.doConsultar(id);

		estabelecimento.setStatus(StatusEstabelecimentoEnum.INATIVO);

		return this.estabelecimentoDAO.doAtualizar(estabelecimento);

	}

	public List<Estabelecimento> doListarByUsuario(Usuario usuario)
			throws ServiceException, DAOException,
			EstabelecimentoNaoEncontradoException {

		if (usuario == null)
			throw new ServiceException("Usuario não informado!");

		List<Estabelecimento> estabelecimentos = this.estabelecimentoDAO
				.doListarByUsuario(usuario);

		if (estabelecimentos.size() == 0)
			throw new EstabelecimentoNaoEncontradoException(
					new StringBuilder()
							.append("Nenhum Estabelecimento vinculado para este Usuario! ID Usuario: ")
							.append(usuario.getId()).toString());

		return estabelecimentos;

	}
}
