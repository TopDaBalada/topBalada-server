package br.com.calcard.calsystem.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.proposta.Proposta;

@Repository
public class PropostaDAO extends CalsystemDAO<Proposta> {

	@Override
	public Class<Proposta> doGetClass() {
		return Proposta.class;
	}

	@SuppressWarnings("unchecked")
	public List<Proposta> doListarByEstabelecimentos(
			List<Estabelecimento> estabelecimentos, Date dataInicio,
			Date dataFim, Integer idProposta) throws DAOException {

		Criteria criteria = super.getCriteria();

		criteria.createAlias("propostaP1", "p1");

		if (estabelecimentos == null)
			throw new DAOException("Estabelecimentos não informados!");

		if (dataInicio != null && dataFim != null)
			criteria.add(Restrictions.between("dataRegistro", dataInicio,
					dataFim));

		criteria.add(Restrictions.in("p1.estabelecimento", estabelecimentos));

		if (idProposta != null)
			criteria.add(Restrictions.eq("id", idProposta));

		return criteria.list();

	}
}
