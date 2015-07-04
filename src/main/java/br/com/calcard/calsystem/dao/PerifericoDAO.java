package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Periferico;
import br.com.calcard.calsystem.exception.PerifericoCodigoInvalidoException;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class PerifericoDAO extends CalsystemDAO<Periferico> {

	@Override
	public Class<Periferico> doGetClass() {
		return Periferico.class;
	}

	public Periferico doConsultarByCodigo(String codigo)
			throws PerifericoCodigoInvalidoException, DAOException {

		if (codigo == null)
			throw new PerifericoCodigoInvalidoException();

		return super.doGetSingleResult(
				Periferico.NQ_SELECT_PERIFERICO_BY_CODIGO, new Parametro()
						.doAddParametro("codigo", codigo).getParametros());

	}

}
