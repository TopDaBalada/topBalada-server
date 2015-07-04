package br.com.topoBalada.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ParametroDTO implements Serializable {

	private static final long serialVersionUID = 1654764484814053271L;

	private Map<String, Object> parametros;

	public ParametroDTO() {
		parametros = new HashMap<String, Object>();
	}

	public ParametroDTO doAddParametro(String key, Object value) {
		parametros.put(key, value);
		return this;
	}

	public Map<String, Object> getParametros() {
		return parametros;
	}

}
