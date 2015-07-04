package br.com.calcard.calsystem.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.DocumentoDTO;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.documento.DocumentoException;
import br.com.calcard.calsystem.service.facade.DocumentoServiceFacade;
import br.com.calcard.calsystem.util.Parametro;

@Component
public class DocumentoWSFacade extends FacadeWS {

	private DocumentoServiceFacade documentoServiceFacade;

	@Autowired
	public DocumentoWSFacade(ExcecaoDAO excecaoDAO,
			DocumentoServiceFacade documentoServiceFacade) {
		super(excecaoDAO);
		this.documentoServiceFacade = documentoServiceFacade;
	}

	public ResponseEntity<Object> doListarMiniaturas(String numProposta) {

		try {

			DocumentoDTO documentoRetorno = this.documentoServiceFacade
					.anexarDocumento(numProposta);

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Proposta", documentoRetorno).getParametros());

		} catch (ServiceException | DAOException | DocumentoException
				| ParametroGlobalNaoEncontradoException e) {
			return super.doRetornarErroWS(e);
		}

	}
}
