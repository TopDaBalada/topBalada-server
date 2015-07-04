package br.com.calcard.calsystem.ws;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calframework.ws.CalsystemWS;

@RestController
@RequestMapping("/ws/vouchers")
@Scope(value = "request")
public class VoucherWS extends CalsystemWS {

	// private VoucherServiceFacade voucherServiceFacade;
	//
	// @Autowired
	// public VoucherWS(VoucherServiceFacade voucherServiceFacade) {
	// this.voucherServiceFacade = voucherServiceFacade;
	// }
	//
	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/imprimir", method = RequestMethod.PUT, produces
	// = "application/json")
	// public ResponseEntity<Object> doGerarVoucher(
	// @RequestBody String codigoVoucher, @RequestBody String loginUsuario) {
	//
	// return (ResponseEntity<Object>) voucherServiceFacade.doImprimirVoucher(
	// codigoVoucher, loginUsuario);
	//
	// }
	//
	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/{cpf}", method = RequestMethod.GET, produces =
	// "application/json")
	// public ResponseEntity<Object> doListarVouchersByCpf(@PathVariable String
	// cpf) {
	// return (ResponseEntity<Object>) voucherServiceFacade
	// .doListarVouchersByCpf(cpf);
	// }

	// @RequestMapping(value = "/confirmar", method = RequestMethod.PUT,
	// produces = "application/json")
	// public ResponseEntity<Object> doConfirmarUtilizacaoVoucher(
	// @RequestBody Map<String, Object> requestBody) {
	//
	// try {
	//
	// String idVoucher = (String) requestBody.get("idVoucher");
	// String idUsuario = (String) requestBody.get("idUsuario");
	//
	// Voucher voucher = voucherService.doConfirmarUtilizacaoVoucher(
	// Integer.parseInt(idVoucher), Integer.parseInt(idUsuario));
	//
	// try {
	// return super.doRetornarSucesso(new Parametro().doAddParametro(
	// "voucher", new VoucherDTO(voucher)).getParametros());
	// } catch (CPFNaoInformadoException | CPFInvalidoException e) {
	// e.printStackTrace();
	// return null;
	// }
	//
	// } catch (ParametrosNaoInformadosException e) {
	// return super.doRetornarErro(e);
	// } catch (VoucherException e) {
	// return super.doRetornarErro(e);
	// } catch (UsuarioException e) {
	// return super.doRetornarErro(e);
	// }
	//
	// }

	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/utilizar", method = RequestMethod.PUT, produces
	// = "application/json")
	// public ResponseEntity<Object> doUtilizarVoucher(
	// @RequestBody Map<String, Object> requestBody) {
	//
	// String codigoVoucher = (String) requestBody.get("codigoVoucher");
	// String cpf = (String) requestBody.get("cpf");
	// String codigoEstabelecimento = (String) requestBody
	// .get("codigoEstabelecimento");
	//
	// return (ResponseEntity<Object>) voucherServiceFacade.doUtilizarVoucher(
	// codigoVoucher, cpf, codigoEstabelecimento);
	//
	// }
}
