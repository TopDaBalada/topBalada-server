package br.com.calcard.calsystem.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.entity.Periferico;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.ws.facade.SegurancaFacadeWS;

/**
 * Classe responsaveis por encapsular todos os WebServices relacionados �
 * seguran�a.
 * 
 * @author gustavos
 * 
 *
 */

@RestController
@RequestMapping("/ws/seguranca")
@Scope(value = "request")
public class SegurancaWS extends CalsystemWS {

	private SegurancaFacadeWS segurancaFacadeWS;

	@Autowired
	public SegurancaWS(SegurancaFacadeWS segurancaFacadeWS) {
		this.segurancaFacadeWS = segurancaFacadeWS;
	}

	@RequestMapping(value = "/menus", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doListarMenus(
			@RequestHeader(value = "tSessao") String tSessao) {

		return this.segurancaFacadeWS.doListarMenus(tSessao);

	}

	/**
	 * 
	 * Servi�o respons�vel por Autenticar o usu�rio no sistema.
	 * 
	 * @param login
	 *            Login do {@link Usuario} para autentica��o.
	 * @param senha
	 *            Senha do {@link Usuario} para autentica��o.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> doLogin(
			@RequestBody Map<String, String> requestBody,
			@RequestHeader(value = "tLogin") String tLogin) {

		return this.segurancaFacadeWS.doLogin(tLogin, requestBody.get("login"),
				requestBody.get("senha"));

	}

	/**
	 * 
	 * Servi�o respons�vel por disponibilizar um Token de Login para o
	 * solicitante realizar a autentica��o no sistema.
	 * 
	 * @param idPeriferico
	 *            identificador do {@link Periferico} que est� solicitando
	 *            acesso.
	 * 
	 * @return tLogin (Header) Token de Login v�lido para autentica��o no
	 *         sistema.
	 * 
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/tokenLogin", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doGerarTokenLogin(
			@RequestHeader(value = "idPeriferico") String idPeriferico)
			throws ServiceException {

		return this.segurancaFacadeWS.doGerarTokenLoginWS(idPeriferico);

	}
}
