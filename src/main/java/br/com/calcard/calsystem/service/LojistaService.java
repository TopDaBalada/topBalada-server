package br.com.calcard.calsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.LojistaDAO;
import br.com.calcard.calsystem.entity.Lojista;
import br.com.calcard.calsystem.exception.LojistaIdInvalidoException;
import br.com.calcard.calsystem.exception.LojistaNaoEncontradoException;

@Service
public class LojistaService {

	private LojistaDAO lojistaDAO;

	@Autowired
	public LojistaService(LojistaDAO lojistaDAO) {
		this.lojistaDAO = lojistaDAO;
	}

	public Lojista doConsultar(Integer id) throws DAOException,
			LojistaIdInvalidoException, LojistaNaoEncontradoException {

		if (id == null)
			throw new LojistaIdInvalidoException("ID do Lojista não informado!");

		Lojista lojista = this.lojistaDAO.doProcurar(id);

		if (lojista == null)
			throw new LojistaNaoEncontradoException(
					new StringBuilder()
							.append("Nenhum Estabelecimento foi encontrado para o ID informado! ID: ")
							.append(id).toString());

		return lojista;

	}
}
