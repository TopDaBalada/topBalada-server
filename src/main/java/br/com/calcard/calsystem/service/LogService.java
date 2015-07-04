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
	 * Método responsavel por registrar um Log de alteração do valor de alguma
	 * coluna em alguma tabela.
	 * 
	 * @param nomeTabela
	 *            Nome da coluna que sofreu alteração
	 * @param nomeColuna
	 *            Nome da tabela que sofreu alteração
	 * @param de
	 *            Valor original da coluna antes da alteração
	 * @param para
	 *            Volor registrado na coluna depois da alteração
	 * @param usuario
	 *            {@link Usuario} do sistema responsável pela alteração
	 * @param idEntidade
	 *            ID da entidade que sofreu alteração
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public void doRegistrarLogTabela(String nomeTabela, String nomeColuna,
			String de, String para, Usuario usuario, CalsystemEntity entity)
			throws DAOException {

		if (nomeTabela == null || nomeColuna == null || de == null
				|| para == null || usuario == null || entity == null)
			throw new IllegalArgumentException(
					"Parâmetros obrigatórios não informados");

		LogTabela log = new LogTabela(nomeTabela, nomeColuna, de, para,
				usuario, entity.getId());

		logTabelaDAO.doRegistrar(log);

	}

}
