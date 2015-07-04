package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class ParametroGlobalDAO extends CalsystemDAO<ParametroGlobal> {

	@Override
	public Class<ParametroGlobal> doGetClass() {
		return ParametroGlobal.class;
	}

	public ParametroGlobal doConsultarByNome(String nomeParametro)
			throws DAOException {

		if (nomeParametro == null)
			throw new IllegalArgumentException(
					"Nome do Parametro não informado!");

		return super.doGetSingleResult("NQParametroGlobalByNome",
				new Parametro().doAddParametro("nome", nomeParametro)
						.getParametros());

	}

}
