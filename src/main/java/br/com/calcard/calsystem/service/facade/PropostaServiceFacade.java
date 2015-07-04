package br.com.calcard.calsystem.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calintegrador.motorFraude.dto.RespostaAnaliseDTO;
import br.com.calcard.calintegrador.motorFraude.exception.IntegracaoFraudeException;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.entity.TokenSessao;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.proposta.Proposta;
import br.com.calcard.calsystem.enums.PropostaEnum.StatusProposta;
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
import br.com.calcard.calsystem.service.DocumentoService;
import br.com.calcard.calsystem.service.EstabelecimentoService;
import br.com.calcard.calsystem.service.MotorFraudeService;
import br.com.calcard.calsystem.service.ParametroService;
import br.com.calcard.calsystem.service.PropostaService;
import br.com.calcard.calsystem.service.TokenService;
import br.com.calcard.calsystem.service.UsuarioService;

@Component
@Transactional(rollbackFor = Exception.class)
public class PropostaServiceFacade {

	private PropostaService propostaService;

	private UsuarioService usuarioService;

	private EstabelecimentoService estabelecimentoService;

	private MotorFraudeService motorFraudeService;

	private TokenService tokenService;

	private DocumentoService documentoService;

	private ParametroService parametroService;

	@Autowired
	public PropostaServiceFacade(PropostaService cadastroPropostaService,
			UsuarioService usuarioService,
			EstabelecimentoService estabelecimentoService,
			MotorFraudeService motorFraudeService, TokenService tokenService,
			DocumentoService documentoService, ParametroService parametroService) {

		this.propostaService = cadastroPropostaService;

		this.usuarioService = usuarioService;

		this.estabelecimentoService = estabelecimentoService;

		this.motorFraudeService = motorFraudeService;

		this.tokenService = tokenService;

		this.documentoService = documentoService;

		this.parametroService = parametroService;

	}

	public Proposta doCadastrarP1(PropostaDTO propostaDTO)
			throws PropostaException, DAOException, DadosBasicosException,
			UsuarioNaoEncontradoException, EstabelecimentoIdInvalidoException,
			EstabelecimentoNaoEncontradoException, EstabelecimentoException,
			UsuarioException {

		if (propostaDTO.getIdEstabelecimento() == null)
			throw new EstabelecimentoException(
					"ID do estabelecimento não informado!");

		if (propostaDTO.getIdUsuario() == null)
			throw new UsuarioException("ID do usuário não informado!");

		Usuario usuario = this.usuarioService.doConsultar(propostaDTO
				.getIdUsuario());

		Estabelecimento estabelecimento = this.estabelecimentoService
				.doConsultar(propostaDTO.getIdEstabelecimento());

		Proposta proposta = this.propostaService.doCadastrarPropostaP1(
				propostaDTO, usuario, estabelecimento);

		return proposta;

	}

	public Proposta doCadastrarP2(PropostaDTO propostaDTO)
			throws PropostaException, DAOException,
			DadosComplementaresException, DadosBasicosException,
			DadosResidenciaisException, ContatosException,
			DadosProfissionaisException, OutrosDocumentosException,
			ReferenciaException, DadosCartaoCalcardException,
			IntegracaoFraudeException, ServiceException {

		Proposta proposta = this.propostaService
				.doCadastrarPropostaP2(propostaDTO);

		Integer idIntegracao = this.motorFraudeService
				.doEnviarProposta(proposta);

		this.propostaService.doVincularIntegracao(proposta, idIntegracao);

		proposta.setStatus(StatusProposta.PENDENTE_MOTOR_FRAUDE);

		return proposta;

	}

	public Proposta doIniciarCadastroProposta() throws DAOException {

		Proposta proposta = this.propostaService.doIniciarCadastroProposta();

		return proposta;

	}

	public void doValidarImpressaoTAD(PropostaDTO propostaDTO)
			throws PropostaException, DAOException,
			DadosComplementaresException, DadosBasicosException,
			DadosResidenciaisException, ContatosException,
			DadosProfissionaisException, OutrosDocumentosException,
			ReferenciaException, DadosCartaoCalcardException {

		this.propostaService.doValidarImpressaoTAD(propostaDTO);

	}

	public void doAtualizarStatusPropostaMotorFraude() throws DAOException,
			ServiceException, IntegracaoFraudeException {

		List<RespostaAnaliseDTO> listaRespostasAnalise = this.motorFraudeService
				.doConsultarRespostaAnalise();

		List<Integer> idsPropostasAtualizadas = this.propostaService
				.doAtualizarPropostaAnaliseFraude(listaRespostasAnalise);

		this.motorFraudeService
				.doFlegarPropostasRecebidas(idsPropostasAtualizadas);

	}

	public List<Proposta> doListarPropostas(String tSessao, Date dataInicio,
			Date dataFim, Integer idProposta) throws DAOException,
			TokenSessaoInvalidoException, TokenSessaoNaoEncontradoException,
			PropostaException {

		TokenSessao tokenSessao = this.tokenService
				.doConsultarTokenSessao(tSessao);

		return this.propostaService.doListarPropostasByEstabelecimentos(
				tokenSessao.getUsuario().getEstabelecimentos(), dataInicio,
				dataFim, idProposta);

	}

	public void doAnexarDocumentos() {

	}

	public void doDescartarDocumentos(Integer idProposta)
			throws DocumentoException, ParametroGlobalNaoEncontradoException,
			DAOException, ServiceException {

		ParametroGlobal localDocumento = this.parametroService
				.doConsultar(ParametroGlobal.PARAMETRO_CAMINHO_DOCUMENTO_DIGITALIZADO);

		ParametroGlobal extencaoDocumento = this.parametroService
				.doConsultar(ParametroGlobal.PARAMETRO_FORMATO_ARQUIVO);

		this.documentoService.doDescartarDocumentos(idProposta.toString(),
				localDocumento.getValorTexto(),
				extencaoDocumento.getValorTexto());

	}
}
