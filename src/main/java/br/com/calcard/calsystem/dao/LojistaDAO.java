package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calsystem.entity.Lojista;

@Repository
public class LojistaDAO extends CalsystemDAO<Lojista> {

	@Override
	public Class<Lojista> doGetClass() {
		return Lojista.class;
	}

}
