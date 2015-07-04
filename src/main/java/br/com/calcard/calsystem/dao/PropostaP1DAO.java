package br.com.calcard.calsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.proposta.PropostaP1;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class PropostaP1DAO extends CalsystemDAO<PropostaP1> {

	@Override
	public Class<PropostaP1> doGetClass() {
		return PropostaP1.class;
	}

	public List<PropostaP1> doConsultar(String cpf) throws DAOException {

		if (cpf == null)
			throw new DAOException("CPF da Proposta não informado!");

		return super.doGetResultList(PropostaP1.NQ_SELECT_PROPOSTA_BY_CPF,
				new Parametro().doAddParametro("cpf", cpf).getParametros());

	}

}
