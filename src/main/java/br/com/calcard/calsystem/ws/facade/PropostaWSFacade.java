package br.com.calcard.calsystem.ws.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calintegrador.motorFraude.exception.IntegracaoFraudeException;
import br.com.calcard.calsystem.dao.ExcecaoDAO;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.entity.proposta.Proposta;
import br.com.calcard.calsystem.exception.EstabelecimentoException;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.UsuarioException;
import br.com.calcard.calsystem.exception.documento.DocumentoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoIdInvalidoException;
import br.com.calcard.calsystem.exception.estabelecimento.EstabelecimentoNaoEncontradoException;
import br.com.calcard.calsystem.exception.proposta.ContatosException;
import br.com.calcard.calsystem.exception.proposta.DadosBasicosException;
import br.com.calcard.calsystem.exception.proposta.DadosCartaoCalcardException;
import br.com.calcard.calsystem.exception.proposta.DadosComplementaresException;
import br.com.calcard.calsystem.exception.proposta.DadosProfissionaisException;
import br.com.calcard.calsystem.exception.proposta.DadosResidenciaisException;
import br.com.calcard.calsystem.exception.proposta.OutrosDocumentosException;
import br.com.calcard.calsystem.exception.proposta.PropostaException;
import br.com.calcard.calsystem.exception.proposta.ReferenciaException;
import br.com.calcard.calsystem.exception.token.TokenSessaoInvalidoException;
import br.com.calcard.calsystem.exception.token.TokenSessaoNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.service.facade.PropostaServiceFacade;
import br.com.calcard.calsystem.util.Parametro;

@Component
public class PropostaWSFacade extends FacadeWS {

	private PropostaServiceFacade propostaServiceFacade;

	@Autowired
	public PropostaWSFacade(ExcecaoDAO excecaoDAO,
			PropostaServiceFacade cadastroPropostaServiceFacade) {
		super(excecaoDAO);
		this.propostaServiceFacade = cadastroPropostaServiceFacade;

	}

	public ResponseEntity<Object> doCadastrarP1(PropostaDTO propostaDTO) {

		try {

			Proposta proposta = this.propostaServiceFacade
					.doCadastrarP1(propostaDTO);

			PropostaDTO propostaRetorno = new PropostaDTO();

			propostaRetorno.setNumeroProposta(proposta.getId());

			propostaRetorno.setStatus(proposta.getStatus());

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Proposta", propostaRetorno).getParametros());

		} catch (DadosBasicosException | DAOException | PropostaException
				| UsuarioNaoEncontradoException
				| EstabelecimentoIdInvalidoException
				| EstabelecimentoNaoEncontradoException
				| EstabelecimentoException | UsuarioException e) {
			return super.doRetornarErroWS(e);

		}

	}

	public ResponseEntity<Object> doCadastrarP2(PropostaDTO propostaDTO) {

		try {

			Proposta proposta = this.propostaServiceFacade
					.doCadastrarP2(propostaDTO);

			PropostaDTO propostaRetorno = new PropostaDTO();

			propostaRetorno.setNumeroProposta(proposta.getId());

			propostaRetorno.setStatus(proposta.getStatus());

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Proposta", propostaRetorno).getParametros());

		} catch (PropostaException | DadosBasicosException | DAOException
				| DadosComplementaresException | DadosResidenciaisException
				| ContatosException | DadosProfissionaisException
				| OutrosDocumentosException | ReferenciaException
				| DadosCartaoCalcardException | IntegracaoFraudeException
				| ServiceException e) {
			return super.doRetornarErroWS(e);
		}

	}

	public ResponseEntity<Object> doIniciarCadastroProposta() {

		try {
			Proposta proposta = this.propostaServiceFacade
					.doIniciarCadastroProposta();

			PropostaDTO propostaDTO = new PropostaDTO();

			propostaDTO.setNumeroProposta(proposta.getId());

			propostaDTO.setStatus(proposta.getStatus());

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Proposta", propostaDTO).getParametros());

		} catch (DAOException e) {
			return super.doRetornarErroWS(e);
		}

	}

	public ResponseEntity<Object> doValidarImpressaoTAD(PropostaDTO propostaDTO) {

		try {
			this.propostaServiceFacade.doValidarImpressaoTAD(propostaDTO);

			return super.doRetornarSucessoWS(null);

		} catch (PropostaException | DAOException
				| DadosComplementaresException | DadosBasicosException
				| DadosResidenciaisException | ContatosException
				| DadosProfissionaisException | OutrosDocumentosException
				| ReferenciaException | DadosCartaoCalcardException e) {
			return super.doRetornarErroWS(e);
		}

	}

	public ResponseEntity<Object> doListarPropostas(String tSessao,
			Date dataInicio, Date dataFim, Integer idProposta) {

		try {

			List<Proposta> propostas = this.propostaServiceFacade
					.doListarPropostas(tSessao, dataInicio, dataFim, idProposta);

			List<PropostaDTO> propostasDTO = new ArrayList<PropostaDTO>();

			for (Proposta proposta : propostas) {

				PropostaDTO propostaDTO = new PropostaDTO();
				propostaDTO.setNumeroProposta(proposta.getId());

				propostaDTO
						.setIdEstabelecimento(proposta.getPropostaP1() == null ? null
								: proposta.getPropostaP1().getEstabelecimento()
										.getId());

				propostaDTO.setStatus(proposta.getStatus());

				propostaDTO.setDataRegistro(proposta.getDataRegistro());

				propostasDTO.add(propostaDTO);

			}

			return super.doRetornarSucessoWS(new Parametro().doAddParametro(
					"Propostas", propostasDTO).getParametros());

		} catch (DAOException | TokenSessaoInvalidoException
				| TokenSessaoNaoEncontradoException | PropostaException e) {
			return super.doRetornarErroWS(e);
		}
	}

	public ResponseEntity<Object> doDescartarDocumentos(Integer idProposta) {

		try {

			this.propostaServiceFacade.doDescartarDocumentos(idProposta);

			return super.doRetornarSucessoWS(null);

		} catch (DocumentoException | ParametroGlobalNaoEncontradoException
				| DAOException | ServiceException e) {
			return super.doRetornarErroWS(e);
		}

	}
}
