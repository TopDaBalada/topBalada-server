package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Conta;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class ContaDAO extends CalsystemDAO<Conta> {

	// Gustavo

	@Override
	public Class<Conta> doGetClass() {
		return Conta.class;
		
		
		
		//teste
	}

	public Conta doConsultarByCpf(String cpf) throws DAOException {

		if (cpf == null)
			throw new IllegalArgumentException("CPF não informado!");

		return super.doGetSingleResult(Conta.NQ_SELECT_CONTA_BY_CPF,
				new Parametro().doAddParametro("cpf", cpf).getParametros());
		
		
	}

}
