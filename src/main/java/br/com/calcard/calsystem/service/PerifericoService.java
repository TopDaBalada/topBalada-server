package br.com.calcard.calsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.PerifericoDAO;
import br.com.calcard.calsystem.entity.Periferico;
import br.com.calcard.calsystem.exception.PerifericoCodigoInvalidoException;
import br.com.calcard.calsystem.exception.PerifericoNaoEncontradoException;

@Service
public class PerifericoService {

	private PerifericoDAO perifericoDAO;

	@Autowired
	public PerifericoService(PerifericoDAO perifericoDAO) {
		this.perifericoDAO = perifericoDAO;
	}

	public Periferico doConsultarByCodigo(String codigo)
			throws PerifericoCodigoInvalidoException,
			PerifericoNaoEncontradoException, DAOException {

		if (codigo == null)
			throw new PerifericoCodigoInvalidoException();

		Periferico periferico = this.perifericoDAO.doConsultarByCodigo(codigo);

		if (periferico == null)
			throw new PerifericoNaoEncontradoException();

		return periferico;

	}

}
