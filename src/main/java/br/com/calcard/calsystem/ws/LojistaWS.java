package br.com.calcard.calsystem.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.ws.facade.LojistaFacadeWS;

@RestController
@RequestMapping("/ws/lojistas")
@Scope(value = "request")
public class LojistaWS extends CalsystemWS {

	private LojistaFacadeWS lojistaFacadeWS;

	@Autowired
	public LojistaWS(LojistaFacadeWS lojistaFacadeWS) {
		this.lojistaFacadeWS = lojistaFacadeWS;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doListar(
			@RequestParam(value = "id", required = false) Integer[] ids) {

		return this.lojistaFacadeWS.doListar(ids);

	}

}
