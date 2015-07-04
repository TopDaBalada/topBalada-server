package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.proposta.PropostaP1;
import br.com.calcard.calsystem.entity.proposta.PropostaP2;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class PropostaP2DAO extends CalsystemDAO<PropostaP2> {

	@Override
	public Class<PropostaP2> doGetClass() {
		// TODO Auto-generated method stub
		return PropostaP2.class;
	}

	public PropostaP2 doConsultarByP1(PropostaP1 propostaP1)
			throws DAOException {

		if (propostaP1 == null)
			throw new DAOException("Propota P1 não informada!");

		return super.doGetSingleResult(PropostaP2.NQ_SELECT_PROPOSTA_BY_P1,
				new Parametro().doAddParametro("propostaP1", propostaP1)
						.getParametros());

	}

}
