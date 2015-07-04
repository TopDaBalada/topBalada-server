package br.com.calcard.calsystem.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.ws.facade.UsuarioFacadeWs;

@RestController
@RequestMapping("/ws/usuarios")
@Scope(value = "request")
public class UsuarioWS extends CalsystemWS {

	private UsuarioFacadeWs usuarioFacadeWs;

	@Autowired
	public UsuarioWS(UsuarioFacadeWs usuarioFacadeWs) {
		this.usuarioFacadeWs = usuarioFacadeWs;
	}

	@RequestMapping(value = "/estabelecimento/{id}/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doListar(@PathVariable Integer id) {

		return this.usuarioFacadeWs.doListarByEstabelecimento(id);

	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doAdicionar(
			@RequestBody Map<String, String> requestBody) {

		return null;
	}

}
