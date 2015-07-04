package br.com.topBalada.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.topBalada.dao.ParametroGlobalDAO;
import br.com.topBalada.entity.ParametroGlobal;
import br.com.topBalada.exception.ParametroGlobalNaoEncontradoException;

@Component
public class ParametroService {

	private ParametroGlobalDAO parametroGlobalDAO;

	private Map<String, ParametroGlobal> parametrosGlobais;

	@Autowired
	public ParametroService(ParametroGlobalDAO parametroGlobalDAO) {
		this.parametroGlobalDAO = parametroGlobalDAO;

		parametrosGlobais = new HashMap<String, ParametroGlobal>();

	}

	public void doCarregarParametrosGlobais() throws DAOException {

		for (ParametroGlobal parametroGlobal : (List<ParametroGlobal>) parametroGlobalDAO
				.doListar())
			parametrosGlobais.put(parametroGlobal.getNome(), parametroGlobal);

	}

	public ParametroGlobal doConsultar(String nomeParametro)
			throws ParametroGlobalNaoEncontradoException, DAOException,
			ServiceException {

		if (nomeParametro == null)
			throw new ServiceException("Nome do Par�metro n�o informado!");

		ParametroGlobal parametroGlobal = this.parametrosGlobais
				.get(nomeParametro);

		if (parametroGlobal == null)
			throw new ParametroGlobalNaoEncontradoException(new StringBuilder()
					.append("Parametro Global n�o encontrado: ")
					.append(nomeParametro).toString());

		return parametroGlobal;

	}

	public Map<String, ParametroGlobal> doListarParametrosByNome(
			String... parametros) throws ParametroGlobalNaoEncontradoException,
			DAOException, ServiceException {

		if (parametros == null)
			throw new IllegalArgumentException("Parametros n�o informados!");

		Map<String, ParametroGlobal> parametrosGlobais = new HashMap<String, ParametroGlobal>();

		for (String parametro : Arrays.asList(parametros)) {

			ParametroGlobal p = this.doConsultar(parametro);

			parametrosGlobais.put(parametro, p);

		}

		return parametrosGlobais;
	}

}
