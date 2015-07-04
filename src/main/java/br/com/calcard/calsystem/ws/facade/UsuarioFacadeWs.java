package br.com.calcard.calsystem.ws.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.UsuarioDTO;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.rn.UsuarioRN;
import br.com.calcard.calsystem.util.Parametro;
import br.com.calcard.calsystem.ws.IDsExcecao;

@Component
public class UsuarioFacadeWs extends FacadeWS {

	private UsuarioRN usuarioRN;

	@Autowired
	public UsuarioFacadeWs(ExcecaoDAO excecaoDAO, UsuarioRN usuarioRN) {
		super(excecaoDAO);

		this.usuarioRN = usuarioRN;
	}

	public ResponseEntity<Object> doListarByEstabelecimento(Integer id) {

		try {
			List<Usuario> usuarios = this.usuarioRN
					.doListarByEstabelecimento(id);

			List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

			for (Usuario usuario : usuarios)
				usuariosDTO.add(new UsuarioDTO(usuario));

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Usuarios", usuariosDTO).getParametros());

		} catch (EstabelecimentoIdInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_ID_INVALIDO, e);

		} catch (EstabelecimentoNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_NAO_ENCONTRADO, e);

		} catch (DAOException e) {
			return super.doRetornarErroWS(IDsExcecao.ERRO_SISTEMA, e);

		} catch (EstabelecimentoInvalidoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_ESTABELECIMENTO_INVALIDO, e);

		} catch (UsuarioNaoEncontradoException e) {
			return super.doRetornarErroWS(
					IDsExcecao.ERRO_USUARIO_NAO_ENCONTRADO, e);

		}

	}

}
