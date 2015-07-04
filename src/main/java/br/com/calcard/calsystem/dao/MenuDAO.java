package br.com.calcard.calsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Menu;
import br.com.calcard.calsystem.entity.Perfil;
import br.com.calcard.calsystem.exception.PerfilInvalidoException;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class MenuDAO extends CalsystemDAO<Menu> {

	@Override
	public Class<Menu> doGetClass() {
		return Menu.class;
	}

	public List<Menu> doListar(Perfil perfil) throws PerfilInvalidoException,
			DAOException {

		if (perfil == null)
			throw new PerfilInvalidoException("Perfil não informado!");

		return super.doGetResultList(Menu.NQ_SELECT_MENUS_BY_PERFIL,
				new Parametro().doAddParametro("perfil", perfil)
						.getParametros());

	}

	public List<Menu> doListar() throws DAOException {

		return (List<Menu>) super.doListar();

	}

}
