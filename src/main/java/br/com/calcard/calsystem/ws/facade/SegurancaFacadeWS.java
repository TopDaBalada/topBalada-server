package br.com.calcard.calsystem.ws.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.MenuDTO;
import br.com.calcard.calsystem.dto.UsuarioDTO;
import br.com.calcard.calsystem.entity.Menu;
import br.com.calcard.calsystem.entity.TokenLogin;
import br.com.calcard.calsystem.entity.TokenSessao;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.PerfilInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginExpiradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenLoginNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginUtilizadoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioInvalidoException;
import br.com.calcard.calsystem.rn.SegurancaRN;
import br.com.calcard.calsystem.util.Parametro;
import br.com.calcard.calsystem.ws.IDsExcecao;

@Component
public class SegurancaFacadeWS extends FacadeWS {

	private SegurancaRN segurancaRN;

	@Autowired
	public SegurancaFacadeWS(ExcecaoDAO excecaoDAO, SegurancaRN segurancaRN) {
		super(excecaoDAO);

		this.segurancaRN = segurancaRN;
	}

	public ResponseEntity<Object> doGerarTokenLoginWS(String idPeriferico) {
		try {

			TokenLogin tokenLogin = segurancaRN.doGerarTokenLogin(idPeriferico);

			HttpHeaders headers = new HttpHeaders();

			headers.add("tLogin", tokenLogin.getToken());

			return super.doRetornarSucessoWS(null, headers);

		} catch (PerifericoCodigoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_PERIFERICO_CODIGO_INVALIDO, e);

		} catch (ServiceException | DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (PerifericoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_PERIFERICO_NAO_ENCONTRADO, e);

		} catch (PerifericoInvalidoException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_PERIFERICO_INVALIDO,
					e);

		}

	}

	public ResponseEntity<Object> doLogin(String tLogin, String login,
			String senha) {
		try {

			Map<String, Object> retorno = segurancaRN.doLogin(tLogin, login,
					senha);

			TokenSessao tokenSessao = (TokenSessao) retorno.get("tokenSessao");

			HttpHeaders header = new HttpHeaders();

			header.add("tSessao", tokenSessao.getToken());
			header.add("tTransacao", tokenSessao.getTokenTransacao().getToken());

			return super.doRetornarSucessoWS(
					new Parametro().doAddParametro("usuarioDTO",
							new UsuarioDTO((Usuario) retorno.get("usuario")))
							.getParametros(), header);

		} catch (LoginException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_LOGIN_INVALIDO,
					new HttpHeaders(), e);

		} catch (DAOException | UsuarioInvalidoException | ServiceException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA,
					new HttpHeaders(), e);

		} catch (TokenLoginInvalidoException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_LOGIN_INVALIDO,
					new HttpHeaders(), e);

		} catch (TokenLoginNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_TOKEN_LOGIN_NAO_ENCONTRADO,
					new HttpHeaders(), e);

		} catch (TokenLoginUtilizadoException e) {
			return super
					.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_LOGIN_UTILIZADO,
							new HttpHeaders(), e);

		} catch (TokenLoginExpiradoException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_LOGIN_EXPIRADO,
					new HttpHeaders(), e);

		}

	}

	public ResponseEntity<Object> doListarMenus(String tSessao) {
		try {

			List<MenuDTO> menusDTO = new ArrayList<MenuDTO>();

			for (Menu menu : this.segurancaRN.doListarMenus(tSessao))
				menusDTO.add(new MenuDTO(menu));

			return super.doRetornarSucessoWS(
					new Parametro().doAddParametro("menus", menusDTO)
							.getParametros(), new HttpHeaders());

		} catch (TokenSessaoInvalidoException e) {
			return super
					.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_SESSAO_INVALIDO,
							new HttpHeaders(), e);

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA,
					new HttpHeaders(), e);

		} catch (TokenSessaoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_TOKEN_SESSAO_NAO_ENCONTRADO,
					new HttpHeaders(), e);

		} catch (PerfilInvalidoException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_PERFIL_INVALIDO,
					new HttpHeaders(), e);

		}
	}
}
