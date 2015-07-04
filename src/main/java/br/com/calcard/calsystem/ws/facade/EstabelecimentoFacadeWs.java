package br.com.calcard.calsystem.ws.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.EstabelecimentoDTO;
import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCnpjExistenteException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCnpjInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCodigoDuplicadoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.rn.EstabelecimentoRN;
import br.com.calcard.calsystem.util.Parametro;
import br.com.calcard.calsystem.ws.IDsExcecao;

@Component
public class EstabelecimentoFacadeWs extends FacadeWS {

	private EstabelecimentoRN estabelecimentoRN;

	@Autowired
	public EstabelecimentoFacadeWs(ExcecaoDAO excecaoDAO,
			EstabelecimentoRN estabelecimentoRN) {
		super(excecaoDAO);

		this.estabelecimentoRN = estabelecimentoRN;
	}

	public ResponseEntity<Object> doCadastrar(String codigo, String cnpj) {
		try {

			Estabelecimento estabelecimento = this.estabelecimentoRN
					.doCadastrar(codigo, cnpj);

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Estabelecimento", new EstabelecimentoDTO(estabelecimento))
					.getParametros());

		} catch (EstabelecimentoCodigoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CODIGO_INVALIDO, e);

		} catch (EstabelecimentoCnpjInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CNPJ_INVALIDO, e);

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (EstabelecimentoCodigoDuplicadoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CODIGO_DUPLICADO, e);

		} catch (EstabelecimentoCnpjExistenteException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CNPJ_EXISTENTE, e);
		} catch (EstabelecimentoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_INVALIDO, e);
		}

	}

	public ResponseEntity<Object> doAtualizar(Integer id, String codigo,
			String cnpj) {
		try {

			Estabelecimento estabelecimento = this.estabelecimentoRN
					.doAtualizar(id, codigo, cnpj);

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Estabelecimento", new EstabelecimentoDTO(estabelecimento))
					.getParametros());

		} catch (EstabelecimentoIdInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_ID_INVALIDO, e);

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		} catch (EstabelecimentoCodigoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CODIGO_INVALIDO, e);

		} catch (EstabelecimentoCnpjInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CNPJ_INVALIDO, e);

		} catch (DAOException | CloneNotSupportedException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (EstabelecimentoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_INVALIDO, e);

		} catch (EstabelecimentoCnpjExistenteException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CNPJ_EXISTENTE, e);

		} catch (EstabelecimentoCodigoDuplicadoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_CODIGO_DUPLICADO, e);
		}

	}

	public ResponseEntity<Object> doDeletar(Integer id) {

		try {
			this.estabelecimentoRN.doDeletar(id);

			return super.doRetornarSucessoWS(null);

		} catch (EstabelecimentoIdInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_ID_INVALIDO, e);

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);
		}

	}

	public ResponseEntity<Object> doListar(String codigo, String cnpj,
			Integer idUsuario, StatusEstabelecimentoEnum status) {
		try {

			List<EstabelecimentoDTO> estabelecimentosDTO = new ArrayList<EstabelecimentoDTO>();

			for (Estabelecimento estabelecimento : this.estabelecimentoRN
					.doListar(codigo, cnpj, idUsuario, status))
				estabelecimentosDTO
						.add(new EstabelecimentoDTO(estabelecimento));

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Estabelecimentos", estabelecimentosDTO).getParametros());

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		}

	}

	public ResponseEntity<Object> doInativar(Integer id) {
		try {

			Estabelecimento estabelecimento = this.estabelecimentoRN
					.doInativar(id);

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Estabelecimento", new EstabelecimentoDTO(estabelecimento))
					.getParametros());

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (EstabelecimentoIdInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_ID_INVALIDO, e);

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		}
	}

	public ResponseEntity<Object> doListarByUsuario(Integer id) {

		try {
			List<Estabelecimento> estabelecimentos = this.estabelecimentoRN
					.doListarByUsuario(id);

			List<EstabelecimentoDTO> estabelecimentosDTO = new ArrayList<EstabelecimentoDTO>();

			for (Estabelecimento estabelecimento : estabelecimentos)
				estabelecimentosDTO
						.add(new EstabelecimentoDTO(estabelecimento));

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Estabelecimentos", estabelecimentosDTO).getParametros());

		} catch (UsuarioNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_USUARIO_NAO_ENCONTRADO, e);

		} catch (DAOException | ServiceException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		}
	}
}
