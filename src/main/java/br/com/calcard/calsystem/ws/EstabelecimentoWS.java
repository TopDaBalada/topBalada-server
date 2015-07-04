package br.com.calcard.calsystem.ws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;
import br.com.calcard.calsystem.dto.EstabelecimentoDTO;
import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.ws.facade.EstabelecimentoFacadeWs;

/**
 * Web Service responsável por centralizar todas as transações relacionadas ao
 * {@link Estabelecimento}
 * 
 * @author gustavos
 *
 */
@RestController
@RequestMapping("/ws/estabelecimentos")
@Scope(value = "request")
public class EstabelecimentoWS extends CalsystemWS {

	private EstabelecimentoFacadeWs estabelecimentoFacadeWS;

	@Autowired
	public EstabelecimentoWS(EstabelecimentoFacadeWs estabelecimentoFacadeWS) {
		this.estabelecimentoFacadeWS = estabelecimentoFacadeWS;
	}

	/**
	 * Serviço responsável por cadastrar um novo {@link Estabelecimento}
	 * 
	 * @param estabelecimentoDTO
	 *            {@link EstabelecimentoDTO}
	 * @return
	 */

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doCadastrar(
			@RequestBody Map<String, String> requestBody) {

		return this.estabelecimentoFacadeWS.doCadastrar(
				requestBody.get("codigo"), requestBody.get("cnpj"));

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doAtualizar(
			@RequestBody Map<String, String> requestBody,
			@PathVariable Integer id) {

		return this.estabelecimentoFacadeWS.doAtualizar(id,
				requestBody.get("codigo"), requestBody.get("cnpj"));

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> doListar(
			@RequestParam(value = "codigo", required = false) String codigo,
			@RequestParam(value = "cnpj", required = false) String cnpj,
			@RequestParam(value = "idUsuario", required = false) Integer idUsuario,
			@RequestParam(value = "status", required = false) StatusEstabelecimentoEnum status) {

		return this.estabelecimentoFacadeWS.doListar(codigo, cnpj, idUsuario,
				status);

	}

	@RequestMapping(value = "/inativar/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object> doInativar(@PathVariable Integer id) {

		return this.estabelecimentoFacadeWS.doInativar(id);

	}

	/**
	 * 
	 * @param idEstabelecimento
	 * @return
	 */
	@RequestMapping(value = "/usuario/{idUsuario}/listar", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> doListarUsuarios(
			@PathVariable Integer idUsuario) {

		return this.estabelecimentoFacadeWS.doListarByUsuario(idUsuario);

	}
}
