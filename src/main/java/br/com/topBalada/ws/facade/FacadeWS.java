package br.com.topBalada.ws.facade;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.CalsystemException;

@Component
public class FacadeWS {

	public FacadeWS() {

	}

	public ResponseEntity<Object> doRetornarSucessoWS(Map<String, Object> body,
			HttpHeaders headers) {

		headers.add("codExec", "000000");

		headers.add("msnExec", "Sucesso");

		return new ResponseEntity<Object>(body, headers, HttpStatus.OK);
	}

	public ResponseEntity<Object> doRetornarSucessoWS(Map<String, Object> body) {

		HttpHeaders header = new HttpHeaders();

		header.add("codExec", "000000");

		header.add("msnExec", "Sucesso");

		return new ResponseEntity<Object>(body, header, HttpStatus.OK);
	}

	public ResponseEntity<Object> doRetornarErroWS(CalsystemException e) {

		e.printStackTrace();

		HttpHeaders header = new HttpHeaders();

		header.add("codExec", e.getExcecao().getCodigo());

		header.add("msnExec", e.getMessage());

		return new ResponseEntity<Object>(header, HttpStatus.OK);

	}

}
