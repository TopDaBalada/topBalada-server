package br.com.calcard.calsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.ContaDAO;
import br.com.calcard.calsystem.entity.Conta;
import br.com.calcard.calsystem.exception.CPFInvalidoException;
import br.com.calcard.calsystem.exception.ContaNaoEncontradaException;

@Service
public class ContaService {

	private ContaDAO contaDAO;

	@Autowired
	public ContaService(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	public Conta doConsultarByCpf(String cpf) throws CPFInvalidoException,
			ContaNaoEncontradaException, DAOException {

		if (cpf == null)
			throw new CPFInvalidoException();

		Conta conta = contaDAO.doConsultarByCpf(cpf);

		if (conta == null)
			throw new ContaNaoEncontradaException();

		return conta;

	}

}
