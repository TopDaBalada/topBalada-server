package br.com.calcard.calsystem.rn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.entity.Menu;
import br.com.calcard.calsystem.entity.Periferico;
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
import br.com.calcard.calsystem.service.PerifericoService;
import br.com.calcard.calsystem.service.SegurancaService;
import br.com.calcard.calsystem.service.TokenService;

@Component
@Transactional(rollbackFor = Exception.class)
public class SegurancaRN {

	private TokenService tokenService;

	private PerifericoService perifericoService;

	private SegurancaService segurancaService;

	@Autowired
	public SegurancaRN(TokenService tokenService,
			PerifericoService perifericoService,
			SegurancaService segurancaService) {
		this.tokenService = tokenService;
		this.perifericoService = perifericoService;
		this.segurancaService = segurancaService;
	}

	public TokenLogin doGerarTokenLogin(String codigoPeriferico)
			throws PerifericoCodigoInvalidoException,
			PerifericoNaoEncontradoException, PerifericoInvalidoException,
			ServiceException, DAOException {

		Periferico periferico = this.perifericoService
				.doConsultarByCodigo(codigoPeriferico.substring(0, 6));

		return this.tokenService.doGerarTokenLogin(periferico);

	}

	public Map<String, Object> doLogin(String tLogin, String login, String senha)
			throws TokenLoginInvalidoException, DAOException,
			TokenLoginNaoEncontradoException, TokenLoginUtilizadoException,
			TokenLoginExpiradoException, LoginException, ServiceException,
			UsuarioInvalidoException {

		Map<String, Object> retorno = new HashMap<String, Object>();

		TokenLogin tokenLogin = this.tokenService.doValidarTokenLogin(tLogin);

		Usuario usuario = this.segurancaService.doLogin(login, senha);

		usuario.getEstabelecimentos();

		TokenSessao tokenSessao;

		tokenSessao = this.tokenService.doGerarTokenSessao(tokenLogin, usuario);

		retorno.put("usuario", usuario);

		retorno.put("tokenSessao", tokenSessao);

		return retorno;

	}

	public List<Menu> doListarMenus(String tSessao)
			throws TokenSessaoInvalidoException, DAOException,
			TokenSessaoNaoEncontradoException, PerfilInvalidoException {

		if (tSessao == null)
			throw new TokenSessaoInvalidoException(
					"Token Sessão não informado!");

		TokenSessao tokenSessao = this.tokenService
				.doConsultarTokenSessao(tSessao);

		return this.segurancaService.doListarMenus(tokenSessao.getUsuario()
				.getPerfil());

	}
}
