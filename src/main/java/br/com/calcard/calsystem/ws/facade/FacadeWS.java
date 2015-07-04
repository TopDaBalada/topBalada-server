package br.com.calcard.calsystem.ws.facade;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.CalsystemException;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.entity.Excecao;
import br.com.calcard.calsystem.util.HttpUtil;
import br.com.calcard.calsystem.ws.IDsExcecao;

@Component
public class FacadeWS {

	private static final String MENSAGEM_PADRAO = "Não foi possível processar sua solicitação!";

	private ExcecaoDAO excecaoDAO;

	@Autowired
	public FacadeWS(ExcecaoDAO excecaoDAO) {
		this.excecaoDAO = excecaoDAO;
	}

	public ResponseEntity<Object> doRetornarSucessoWS(Map<String, Object> body,
			HttpHeaders headers) {

		headers.add("codExec", "000000");

		headers.add("msnExec", "Sucesso");

		return new ResponseEntity<Object>(body, headers, HttpStatus.OK);
	}

	public ResponseEntity<Object> doRetornarSucessoWS(Map<String, Object> body) {

		HttpHeaders header = new HttpHeaders();

		header.add("codExec", "000000");

		header.add("msnExec", "Sucesso");

		return new ResponseEntity<Object>(body, header, HttpStatus.OK);
	}

	public ResponseEntity<Object> doRetornarErroWS(Integer idExcecao,
			Throwable e) {

		return this.doRetornarErroWS(idExcecao, new HttpHeaders(), e);

	}

	public ResponseEntity<Object> doRetornarErroWS(Integer idExcecao,
			HttpHeaders header, Throwable e) {

		try {

			e.printStackTrace();

			Excecao excecao = this.excecaoDAO.doConsultar(idExcecao);

			if (excecao != null) {

				header.add("codExec", excecao.getCodigo().toString());

				header.add("msnExec", excecao.getDescricao());

			} else {

				header.add("codExec", IDsExcecao.ERRO_SISTEMA.toString());

				header.add("msnExec", MENSAGEM_PADRAO);

			}

			return new ResponseEntity<Object>(header, HttpStatus.OK);

		} catch (DAOException e1) {

			header.add("codExec", IDsExcecao.ERRO_SISTEMA.toString());

			header.add("msnExec", MENSAGEM_PADRAO);

			return new ResponseEntity<Object>(header, HttpStatus.OK);

		}

	}

	public HttpServletResponse doRetornarErroWS(Integer idExcecao,
			HttpServletResponse response, Throwable e) {
		try {

			e.printStackTrace();

			Excecao excecaoDetalhe = this.excecaoDAO.doConsultar(idExcecao);

			if (excecaoDetalhe != null) {

				HttpUtil.doAddHeader(response, "codExec", excecaoDetalhe
						.getCodigo().toString());

				HttpUtil.doAddHeader(response, "msnExec",
						excecaoDetalhe.getDescricao());

			} else {

				HttpUtil.doAddHeader(response, "codExec",
						IDsExcecao.ERRO_SISTEMA.toString());

				HttpUtil.doAddHeader(response, "msnExec", MENSAGEM_PADRAO);

			}

			return response;

		} catch (DAOException e1) {

			HttpUtil.doAddHeader(response, "codExec",
					IDsExcecao.ERRO_SISTEMA.toString());

			HttpUtil.doAddHeader(response, "msnExec", MENSAGEM_PADRAO);

			return response;
		}
	}

	public ResponseEntity<Object> doRetornarErroWS(CalsystemException e) {

		e.printStackTrace();

		HttpHeaders header = new HttpHeaders();

		header.add("codExec", e.getExcecao().getCodigo());

		header.add("msnExec", e.getMessage());

		return new ResponseEntity<Object>(header, HttpStatus.OK);

	}

}
