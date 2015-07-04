package br.com.calcard.calsystem.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.TokenLoginDAO;
import br.com.calcard.calsystem.dao.TokenSessaoDAO;
import br.com.calcard.calsystem.entity.Enum.StatusTokenEnum;
import br.com.calcard.calsystem.entity.Periferico;
import br.com.calcard.calsystem.entity.TokenLogin;
import br.com.calcard.calsystem.entity.TokenSessao;
import br.com.calcard.calsystem.entity.TokenTransacao;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.LoginInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginExpiradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenLoginNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenLoginUtilizadoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenTransacaoInvalidoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioInvalidoException;
import br.com.calcard.calsystem.util.DateUtil;

@Service
@Transactional(rollbackFor = Exception.class)
public class TokenService {

	private CriptografiaService criptografiaService;

	private TokenLoginDAO tokenLoginDAO;

	private TokenSessaoDAO tokenSessaoDAO;

	@Autowired
	public TokenService(CriptografiaService criptografiaService,
			TokenLoginDAO tokenLoginDAO, UsuarioService usuarioService,
			TokenSessaoDAO tokenSessaoDAO) {
		this.criptografiaService = criptografiaService;
		this.tokenLoginDAO = tokenLoginDAO;
		this.tokenSessaoDAO = tokenSessaoDAO;
	}

	public String doGerarToken() throws ServiceException {

		Integer r = new Random().nextInt();

		if (r < 0)
			r *= -1;

		String semente = new SimpleDateFormat("MMddyyHHmmssSSS")
				.format(new Date()) + r;

		return criptografiaService.new HASH().MD5(semente);

	}

	public TokenSessao doValidarTokens(String tSessao, String tTransacao)
			throws TokenSessaoInvalidoException, DAOException,
			TokenSessaoNaoEncontradoException, TokenTransacaoInvalidoException,
			ServiceException {

		TokenSessao tokenSessao = this.doConsultarTokenSessao(tSessao);

		// if (!tokenSessao.getTokenTransacao().getToken().equals(tTransacao))
		// throw new TokenTransacaoInvalidoException(
		// "O Token de Transação informado não confere com o vigênte.");

		return tokenSessao;

	}

	public TokenTransacao doGerarTokenTransacao(TokenSessao tokenSessao)
			throws ServiceException, TokenSessaoInvalidoException,
			DAOException, TokenSessaoNaoEncontradoException {

		if (tokenSessao == null)
			throw new TokenSessaoInvalidoException(
					"Token de Sessão não informado!");

		String tTransacao = this.doGerarToken();

		return new TokenTransacao(tTransacao, tokenSessao.getPeriferico(),
				new Date(), null);

	}

	public TokenLogin doGerarTokenLogin(Periferico periferico)
			throws PerifericoCodigoInvalidoException,
			PerifericoNaoEncontradoException, PerifericoInvalidoException,
			ServiceException, DAOException {

		if (periferico == null)
			throw new PerifericoInvalidoException();

		String token = this.doGerarToken();

		TokenLogin tokenLogin = new TokenLogin(token, periferico, new Date(),
				DateUtil.doSomarSegundos(new Date(), 30), StatusTokenEnum.ATIVO);

		tokenLoginDAO.doRegistrar(tokenLogin);

		return tokenLogin;

	}

	public void doLogin(String login, String senha)
			throws LoginInvalidoException {

		if (login == null)
			throw new LoginInvalidoException("Login não informado!");

		else if (senha == null)
			throw new LoginInvalidoException("Senha não informada!");

	}

	public TokenSessao doGerarTokenSessao(TokenLogin tokenLogin, Usuario usuario)
			throws TokenLoginInvalidoException, UsuarioInvalidoException,
			ServiceException, DAOException, TokenLoginNaoEncontradoException {

		if (tokenLogin == null)
			throw new TokenLoginInvalidoException(
					"Token de Login não informado!");

		else if (usuario == null)
			throw new UsuarioInvalidoException("Usuário não informado!");

		String tSessao = this.doGerarToken();

		String tTransacao = this.doGerarToken();

		TokenTransacao tokenTransacao = new TokenTransacao(tTransacao,
				tokenLogin.getPeriferico(), new Date(), null);

		TokenSessao tokenSessao = new TokenSessao(tSessao,
				tokenLogin.getPeriferico(), new Date(), null, tokenTransacao,
				usuario, StatusTokenEnum.ATIVO);

		this.tokenSessaoDAO.doRegistrar(tokenSessao);

		return tokenSessao;
	}

	public TokenLogin doConsultarTokenLogin(String tLogin)
			throws TokenLoginInvalidoException, DAOException,
			TokenLoginNaoEncontradoException {

		if (tLogin == null)
			throw new TokenLoginInvalidoException(
					"Token de Login não informado!");

		TokenLogin tokenLogin = this.tokenLoginDAO.doConsultar(tLogin);

		if (tokenLogin == null)
			throw new TokenLoginNaoEncontradoException();

		return tokenLogin;

	}

	public TokenSessao doConsultarTokenSessao(String tSessao)
			throws TokenSessaoInvalidoException, DAOException,
			TokenSessaoNaoEncontradoException {

		if (tSessao == null)
			throw new TokenSessaoInvalidoException(
					"Token Sessão não informado!");

		TokenSessao tokenSessao = this.tokenSessaoDAO.doConsultar(tSessao);

		if (tokenSessao == null)
			throw new TokenSessaoNaoEncontradoException(
					new StringBuilder()
							.append("Não foi encontrado nenhum Token de Sessão para o Token informado! tSessao: ")
							.append(tSessao).toString());

		return tokenSessao;

	}

	public TokenLogin doValidarTokenLogin(String tLogin)
			throws TokenLoginInvalidoException, DAOException,
			TokenLoginNaoEncontradoException, TokenLoginUtilizadoException,
			TokenLoginExpiradoException {

		if (tLogin == null)
			throw new TokenLoginInvalidoException(
					"Token de Login não informado!");

		TokenLogin tokenLogin = tokenLoginDAO.doConsultar(tLogin);

		if (tokenLogin == null)
			throw new TokenLoginNaoEncontradoException();

		else if (tokenLogin.getStatus().equals(StatusTokenEnum.UTILIZADO))
			throw new TokenLoginUtilizadoException();

		else if (tokenLogin.getStatus().equals(StatusTokenEnum.EXPIRADO))
			throw new TokenLoginExpiradoException();

		else if (tokenLogin.getDataExpiracao().before(new Date())) {
			tokenLogin.setStatus(StatusTokenEnum.EXPIRADO);
			this.tokenLoginDAO.doAtualizar(tokenLogin);
			throw new TokenLoginExpiradoException();

		} else {
			tokenLogin.setStatus(StatusTokenEnum.UTILIZADO);
			this.tokenLoginDAO.doAtualizar(tokenLogin);
			return tokenLogin;
		}

	}

	public TokenSessao doGerarTokenSessao(String tSessao)
			throws TokenSessaoInvalidoException, DAOException,
			TokenSessaoNaoEncontradoException, ServiceException {

		TokenSessao tokenSessao = this.doConsultarTokenSessao(tSessao);

		String tTransacao = this.doGerarToken();

		tokenSessao.setTokenTransacao(new TokenTransacao(tTransacao,
				tokenSessao.getPeriferico(), new Date(), null));

		this.tokenSessaoDAO.doAtualizar(tokenSessao);

		return tokenSessao;

	}

	public void doRenovarTokenSessao(TokenSessao tokenSessao)
			throws TokenSessaoInvalidoException, DAOException {

		if (tokenSessao == null)
			throw new TokenSessaoInvalidoException(
					"Token de Sessão não informado!");

		tokenSessao.setDataExpiracao(DateUtil.doSomarMinutos(new Date(), 10));

		this.tokenSessaoDAO.doAtualizar(tokenSessao);

	}

}
