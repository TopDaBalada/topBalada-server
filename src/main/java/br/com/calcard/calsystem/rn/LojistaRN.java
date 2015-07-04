package br.com.calcard.calsystem.rn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.entity.Lojista;
import br.com.calcard.calsystem.exception.LojistaIdInvalidoException;
import br.com.calcard.calsystem.exception.LojistaNaoEncontradoException;
import br.com.calcard.calsystem.service.LojistaService;

@Component
@Transactional(rollbackFor = Exception.class)
public class LojistaRN {

	private LojistaService lojistaService;

	@Autowired
	public LojistaRN(LojistaService lojistaService) {
		this.lojistaService = lojistaService;
	}

	public List<Lojista> doListar(Integer[] ids) throws DAOException,
			LojistaIdInvalidoException, LojistaNaoEncontradoException {

		List<Lojista> lojistas = new ArrayList<Lojista>();

		for (Integer idLojista : ids)
			lojistas.add(this.lojistaService.doConsultar(idLojista));

		return lojistas;
	}

}
