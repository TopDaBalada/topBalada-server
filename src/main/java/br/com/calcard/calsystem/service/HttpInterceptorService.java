package br.com.calcard.calsystem.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.entity.TokenSessao;
import br.com.calcard.calsystem.entity.TokenTransacao;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoNaoEncontradoException;
import br.com.calcard.calsystem.exception.token.TokenTransacaoInvalidoException;
import br.com.calcard.calsystem.ws.IDsExcecao;
import br.com.calcard.calsystem.ws.facade.FacadeWS;

@Component
public class HttpInterceptorService extends HandlerInterceptorAdapter {

	private ParametroService parametroService;

	private TokenService tokenService;

	private FacadeWS facadeWS;

	@Autowired
	public HttpInterceptorService(ParametroService parametroService,
			TokenService tokenService, FacadeWS facadeWS) {
		this.parametroService = parametroService;
		this.tokenService = tokenService;
		this.facadeWS = facadeWS;
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {

		try {

			// this.cloneInputStream(request.getInputStream());

			if (!isValidarToken()) {

				response.addHeader("tSessao", request.getHeader("tSessao"));

				response.addHeader("tTransacao",
						request.getHeader("tTransacao"));

				return true;

			} else if (!request.getPathInfo()
					.equals("/ws/seguranca/tokenLogin")
					&& !request.getPathInfo().equals("/ws/seguranca/login")) {

				String tSessao = request.getHeader("tSessao");

				if (tSessao == null)
					throw new TokenSessaoInvalidoException(
							"Token de Sessão não informado!");

				String tTransacao = request.getHeader("tTransacao");

				if (tTransacao == null)
					throw new TokenTransacaoInvalidoException();

				TokenSessao tokenSessao = tokenService.doValidarTokens(tSessao,
						tTransacao);

				this.tokenService.doRenovarTokenSessao(tokenSessao);

				TokenTransacao tokenTransacao = this.tokenService
						.doGerarTokenTransacao(tokenSessao);

				response.addHeader("tSessao", tSessao);

				response.addHeader("tTransacao", tokenTransacao.getToken());

			}

			return true;

		} catch (TokenSessaoInvalidoException e) {
			facadeWS.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_SESSAO_INVALIDO,
					response, e);

			return false;

		} catch (TokenTransacaoInvalidoException e) {
			facadeWS.doRetornarErroWS(IDsExcecao.ERRO_TOKEN_TRANSACAO_INVALIDO,
					response, e);

			return false;
		} catch (ServiceException | DAOException e) {
			facadeWS.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, response, e);

			return false;

		} catch (TokenSessaoNaoEncontradoException e) {
			facadeWS.doRetornarErroWS(
					IDsExcecao.ERRO_TOKEN_SESSAO_NAO_ENCONTRADO, response, e);

			return false;
		} catch (ParametroGlobalNaoEncontradoException e) {
			facadeWS.doRetornarErroWS(
					IDsExcecao.ERRO_SISTEMA_PARAMETRO_GLOBAL_NAO_ENCONTRADO,
					response, e);

			return false;
		}

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {

		// if (!request.getPathInfo().equals("/ws/seguranca/tokenLogin")
		// && !request.getPathInfo().equals("/ws/seguranca/login")) {
		//
		// String tSessao = request.getHeader("tSessao");
		//
		// try {
		// TokenSessao tokenSessao = this.tokenService
		// .doGerarTokenSessao(tSessao);
		//
		// response.addHeader("tSessao", tokenSessao.getToken());
		// response.addHeader("tTransacao", tokenSessao
		// .getTokenTransacao().getToken());
		//
		// } catch (TokenSessaoInvalidoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (DAOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (TokenSessaoNaoEncontradoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ServiceException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // TokenSessao tokenSessao =
		// // this.tokenService.doConsultarTokenSessao(tSessao);
		// //
		// // response.addHeader(name, value);
		// //
		// // response.addHeader(name, value);
		// }

	}

	private boolean isValidarToken()
			throws ParametroGlobalNaoEncontradoException, DAOException,
			ServiceException {

		return parametroService.doConsultar(
				ParametroGlobal.PARAMETRO_VALIDA_TOKEN).getValorBooleano();

	}

	private String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();

			if (inputStream != null) {
				// bufferedReader = new BufferedReader(new
				// InputStreamReader(inputStream));
				// char[] charBuffer = new char[128];
				// int bytesRead = -1;
				// while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
				// stringBuilder.append(charBuffer, 0, bytesRead);
				// }
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}
}
