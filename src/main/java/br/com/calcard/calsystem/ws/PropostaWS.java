package br.com.calcard.calsystem.ws;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.ws.facade.PropostaWSFacade;

@RestController
@RequestMapping("/ws/propostas")
@Scope(value = "request")
public class PropostaWS extends CalsystemWS {

	private PropostaWSFacade propostaFacadeWS;

	@Autowired
	public PropostaWS(PropostaWSFacade propostaFacadeWS) {
		this.propostaFacadeWS = propostaFacadeWS;
	}

	@RequestMapping(value = "/iniciarCadastro", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doCadastrarP1() {

		return this.propostaFacadeWS.doIniciarCadastroProposta();

	}

	/**
	 * Serviço responsável por validar os dados de PropostaDTO antes da
	 * impressão da TAD.
	 * 
	 * @param propostaDTO
	 * @return
	 */
	@RequestMapping(value = "/validarImpressaoTAD", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doValidarImpressaoTAD(
			@RequestBody PropostaDTO propostaDTO,
			@RequestHeader(value = "tSessao") String tSessao) {
		super.doGravarLog(tSessao, propostaDTO);

		return this.propostaFacadeWS.doValidarImpressaoTAD(propostaDTO);

	}

	@RequestMapping(value = "/addP1", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doCadastrarP1(
			@RequestBody PropostaDTO propostaDTO,
			@RequestHeader(value = "tSessao") String tSessao) {
		super.doGravarLog(tSessao, propostaDTO);

		return this.propostaFacadeWS.doCadastrarP1(propostaDTO);

	}

	@RequestMapping(value = "/addP2", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doCadastrarP2(
			@RequestBody PropostaDTO propostaDTO,
			@RequestHeader(value = "tSessao") String tSessao) {
		super.doGravarLog(tSessao, propostaDTO);

		return this.propostaFacadeWS.doCadastrarP2(propostaDTO);

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doListarPropostas(
			@RequestHeader(value = "tSessao") String tSessao,
			@RequestParam(value = "dataInicio", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
			@RequestParam(value = "dataFim", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
			@RequestParam(value = "idProposta", required = false) Integer idProposta) {
		super.doGravarLog(tSessao);

		return this.propostaFacadeWS.doListarPropostas(tSessao, dataInicio,
				dataFim, idProposta);

	}

	@RequestMapping(value = "/anexarDocumentos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doAnexarDocumentos(
			@RequestHeader(value = "tSessao") String tSessao) {
		super.doGravarLog(tSessao);

		return null;

	}

	@RequestMapping(value = "/descartarDocumentos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doDescartarDocumentos(
			@RequestHeader(value = "tSessao") String tSessao,
			@RequestParam(value = "idProposta", required = true) Integer idProposta) {
		super.doGravarLog(tSessao);

		return this.propostaFacadeWS.doDescartarDocumentos(idProposta);

	}
}
