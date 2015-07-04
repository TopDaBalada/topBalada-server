package br.com.calcard.calsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.entity.CalsystemEntity;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.LogTabelaDAO;
import br.com.calcard.calsystem.entity.LogTabela;
import br.com.calcard.calsystem.entity.Usuario;

@Service
public class LogService {

	private LogTabelaDAO logTabelaDAO;

	@Autowired
	public LogService(LogTabelaDAO logTabelaDAO) {
		this.logTabelaDAO = logTabelaDAO;
	}

	/**
	 * M�todo responsavel por registrar um Log de altera��o do valor de alguma
	 * coluna em alguma tabela.
	 * 
	 * @param nomeTabela
	 *            Nome da coluna que sofreu altera��o
	 * @param nomeColuna
	 *            Nome da tabela que sofreu altera��o
	 * @param de
	 *            Valor original da coluna antes da altera��o
	 * @param para
	 *            Volor registrado na coluna depois da altera��o
	 * @param usuario
	 *            {@link Usuario} do sistema respons�vel pela altera��o
	 * @param idEntidade
	 *            ID da entidade que sofreu altera��o
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public void doRegistrarLogTabela(String nomeTabela, String nomeColuna,
			String de, String para, Usuario usuario, CalsystemEntity entity)
			throws DAOException {

		if (nomeTabela == null || nomeColuna == null || de == null
				|| para == null || usuario == null || entity == null)
			throw new IllegalArgumentException(
					"Par�metros obrigat�rios n�o informados");

		LogTabela log = new LogTabela(nomeTabela, nomeColuna, de, para,
				usuario, entity.getId());

		logTabelaDAO.doRegistrar(log);

	}

}
