package br.com.calcard.calsystem.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.ws.facade.DocumentoWSFacade;

@RestController
@RequestMapping("/ws/documentos")
@Scope(value = "request")
public class DocumentoWS extends CalsystemWS {

	private DocumentoWSFacade documentoFacadeWS;

	@Autowired
	public DocumentoWS(DocumentoWSFacade documentoFacadeWS) {
		this.documentoFacadeWS = documentoFacadeWS;
	}

	@RequestMapping(value = "/listarMiniaturas", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doListarMiniaturas(
			@RequestBody Map<String, String> requestBody) {
		return this.documentoFacadeWS.doListarMiniaturas(requestBody
				.get("numeroProposta"));
	}
}