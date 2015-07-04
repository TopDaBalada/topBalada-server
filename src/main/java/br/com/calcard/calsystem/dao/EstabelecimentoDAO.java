package br.com.calcard.calsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class EstabelecimentoDAO extends CalsystemDAO<Estabelecimento> {

	@Override
	public Class<Estabelecimento> doGetClass() {
		return Estabelecimento.class;
	}

	public Estabelecimento doConsultar(String codigo)
			throws EstabelecimentoCodigoInvalidoException, DAOException {

		if (codigo == null)
			throw new EstabelecimentoCodigoInvalidoException();

		return super.doGetSingleResult(
				Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CODIGO,
				new Parametro().doAddParametro("codigo", codigo)
						.getParametros());

	}

	@SuppressWarnings("unchecked")
	public List<Estabelecimento> doListar(String codigo, String cnpj,
			Integer idUsuario, StatusEstabelecimentoEnum statusEstabelecimento)
			throws DAOException {

		Criteria criteria = super.getCriteria();

		if (codigo != null)
			criteria.add(Restrictions.eq(Estabelecimento.COLUNA_CODIGO, codigo));

		if (cnpj != null)
			criteria.add(Restrictions.eq(Estabelecimento.COLUNA_CNPJ, cnpj));

		if (statusEstabelecimento != null)
			criteria.add(Restrictions.eq(Estabelecimento.COLUNA_STATUS,
					statusEstabelecimento));

		if (idUsuario != null) {

			Criteria criteriaUsuario = criteria.createCriteria("usuarios");

			criteriaUsuario.add(Restrictions.eq(Usuario.COLUNA_ID, idUsuario));
		}

		return criteria.list();

		// if (codigo != null && cnpj != null)
		// return super.doGetResultList(
		// Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CODIGO_CNPJ,
		// new Parametro().doAddParametro("codigo", codigo)
		// .doAddParametro("cnpj", cnpj).getParametros());
		//
		// else if (codigo != null)
		// return super.doGetResultList(
		// Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CODIGO,
		// new Parametro().doAddParametro("codigo", codigo)
		// .getParametros());
		//
		// else
		// return super.doGetResultList(
		// Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CNPJ,
		// new Parametro().doAddParametro("cnpj", cnpj)
		// .getParametros());

	}

	public Object doConsultarByCNPJ(String cnpj) throws DAOException {

		if (cnpj == null)
			throw new DAOException("CNPJ não informado!");

		return super.doGetSingleResult(
				Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_CNPJ,
				new Parametro().doAddParametro("cnpj", cnpj).getParametros());

	}

	public Estabelecimento doConsultar(Integer idEstabelecimento)
			throws EstabelecimentoIdInvalidoException, DAOException {

		if (idEstabelecimento == null)
			throw new EstabelecimentoIdInvalidoException(
					"ID do Estabelecimento não informado!");

		return super.doProcurar(idEstabelecimento);

	}

	public List<Estabelecimento> doListarByUsuario(Usuario usuario)
			throws DAOException {

		if (usuario == null)
			throw new DAOException("Usuario não informado!");

		return super.doGetResultList(
				Estabelecimento.NQ_SELECT_ESTABELECIMENTO_BY_USUARIO,
				new Parametro().doAddParametro("usuario", usuario)
						.getParametros());

	}
}
