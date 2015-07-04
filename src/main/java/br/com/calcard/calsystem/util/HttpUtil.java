package br.com.calcard.calsystem.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

public class HttpUtil {

	public static final String HEADER_ACESS_CONTROLL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";

	public static HttpServletResponse doAddHeader(HttpServletResponse response,
			String nome, String valor) {

		response.addHeader(HEADER_ACESS_CONTROLL_EXPOSE_HEADERS, nome);

		response.addHeader(nome, valor);

		return response;

	}

	@Deprecated
	public static HttpHeaders doAddHeader(HttpHeaders header, String nome,
			String valor) {

		header.add(HEADER_ACESS_CONTROLL_EXPOSE_HEADERS, nome);

		header.add(nome, valor);

		return header;

	}

	public static void doAdicionarHeaderSucesso(HttpHeaders header) {

		HttpUtil.doAddHeader(header, "codExec", "000000");
		HttpUtil.doAddHeader(header, "msnExec", "Sucesso");

	}

	public static void doAddHeader(HttpServletRequest request, String nome,
			String body) {

	}
}
