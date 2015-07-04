package br.com.calcard.calsystem.ws.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.LojistaDTO;
import br.com.calcard.calsystem.entity.Lojista;
import br.com.calcard.calsystem.exception.LojistaIdInvalidoException;
import br.com.calcard.calsystem.exception.LojistaNaoEncontradoException;
import br.com.calcard.calsystem.rn.LojistaRN;
import br.com.calcard.calsystem.util.Parametro;
import br.com.calcard.calsystem.ws.IDsExcecao;

@Component
public class LojistaFacadeWS extends FacadeWS {

	private LojistaRN lojistaRN;

	@Autowired
	public LojistaFacadeWS(ExcecaoDAO excecaoDAO, LojistaRN lojistaRN) {
		super(excecaoDAO);
		this.lojistaRN = lojistaRN;
	}

	public ResponseEntity<Object> doListar(Integer[] ids) {

		try {

			List<LojistaDTO> lojistasDTO = new ArrayList<LojistaDTO>();

			for (Lojista lojista : lojistaRN.doListar(ids))
				lojistasDTO.add(new LojistaDTO(lojista));

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Lojistas", lojistasDTO).getParametros());

		} catch (DAOException | LojistaIdInvalidoException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (LojistaNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_LOJISTA_NAO_ENCONTRADO, e);
		}

	}
}
