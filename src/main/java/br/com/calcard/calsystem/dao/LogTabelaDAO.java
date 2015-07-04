package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calsystem.entity.LogTabela;

@Repository
public class LogTabelaDAO extends CalsystemDAO<LogTabela> {

	@Override
	public Class<LogTabela> doGetClass() {
		return LogTabela.class;
	}

}
