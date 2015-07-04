package br.com.calcard.calsystem.dao;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calsystem.entity.LogProcesso;

@Repository
public class LogProcessoDAO extends CalsystemDAO<LogProcesso> {

	@Override
	public Class<LogProcesso> doGetClass() {
		return LogProcesso.class;
	}

}
