package br.com.calcard.calsystem.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dto.DocumentoDTO;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.documento.DocumentoException;
import br.com.calcard.calsystem.service.DocumentoService;

@Component
@Transactional(rollbackFor = Exception.class)
public class DocumentoServiceFacade {

	private DocumentoService documentoService;

	@Autowired
	public DocumentoServiceFacade(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	public DocumentoDTO anexarDocumento(String numProposta)
			throws ServiceException, DAOException, DocumentoException,
			ParametroGlobalNaoEncontradoException {

		return this.documentoService.doGerarMiniaturas(numProposta);

	}
}