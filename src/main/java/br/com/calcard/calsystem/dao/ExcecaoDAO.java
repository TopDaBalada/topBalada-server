package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Excecao;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class ExcecaoDAO extends CalsystemDAO<Excecao> {

	@Override
	public Class<Excecao> doGetClass() {
		return Excecao.class;
	}

	public Excecao doConsultar(Integer codigo) throws DAOException {

		return super.doGetSingleResult(
				Excecao.NQ_SELECT_EXCECAO_DETALHE_BY_CODIGOS, new Parametro()
						.doAddParametro("codigo", codigo).getParametros());

	}

}
