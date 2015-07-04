package br.com.calcard.calsystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calintegrador.motorFraude.dto.RespostaAnaliseDTO;
import br.com.calcard.calintegrador.motorFraude.enums.StatusPropostaMotorFraude;
import br.com.calcard.calsystem.dao.PropostaDAO;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.proposta.Proposta;
import br.com.calcard.calsystem.entity.proposta.PropostaIntegracao;
import br.com.calcard.calsystem.entity.proposta.PropostaP1;
import br.com.calcard.calsystem.entity.proposta.PropostaP2;
import br.com.calcard.calsystem.enums.PropostaEnum.StatusProposta;
import br.com.calcard.calsystem.exception.proposta.ContatosException;
import br.com.calcard.calsystem.exception.proposta.DadosBasicosException;
import br.com.calcard.calsystem.exception.proposta.DadosCartaoCalcardException;
import br.com.calcard.calsystem.exception.proposta.DadosComplementaresException;
import br.com.calcard.calsystem.exception.proposta.DadosProfissionaisException;
import br.com.calcard.calsystem.exception.proposta.DadosResidenciaisException;
import br.com.calcard.calsystem.exception.proposta.OutrosDocumentosException;
import br.com.calcard.calsystem.exception.proposta.PropostaException;
import br.com.calcard.calsystem.exception.proposta.ReferenciaException;
import br.com.calcard.calsystem.util.CalsystemUtil;

@Service
// @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PropostaService {

	private PropostaDAO propostaDAO;

	@Autowired
	public PropostaService(PropostaDAO propostaDAO) {
		this.propostaDAO = propostaDAO;
	}

	public Proposta doIniciarCadastroProposta() throws DAOException {

		Proposta proposta = new Proposta();
		proposta.setStatus(StatusProposta.INICIADO);

		return this.propostaDAO.doRegistrar(proposta);

	}

	public Proposta doCadastrarPropostaP1(PropostaDTO propostaDTO,
			Usuario usuario, Estabelecimento estabelecimento)
			throws PropostaException, DAOException, DadosBasicosException {

		Proposta proposta = new Proposta();
		PropostaP1 propostaP1 = new PropostaP1();

		ValidadorPropostaP1 validadorPropostaP1 = new ValidadorPropostaP1();

		if (propostaDTO == null)
			throw new PropostaException("PropostaDTO não informada!");

		proposta = this.doConsultarProposta(propostaDTO.getNumeroProposta());

		if (proposta.getPropostaP1() != null)
			throw new PropostaException("Proposta já utilizada!");

		if (!proposta.getStatus().equals(StatusProposta.INICIADO))
			throw new PropostaException("Status da Proposta inválido!");

		propostaP1 = validadorPropostaP1.doValidarProposta(propostaDTO,
				usuario, estabelecimento);

		propostaP1.setProposta(proposta);

		proposta.setPropostaP1(propostaP1);

		proposta.setStatus(StatusProposta.REGISTRADO_P1);

		return this.propostaDAO.doAtualizar(proposta);

	}

	public Proposta doCadastrarPropostaP2(PropostaDTO propostaDTO)
			throws PropostaException, DAOException,
			DadosComplementaresException, DadosBasicosException,
			DadosResidenciaisException, ContatosException,
			DadosProfissionaisException, OutrosDocumentosException,
			ReferenciaException, DadosCartaoCalcardException {

		Proposta proposta = new Proposta();
		PropostaP2 propostaP2;

		ValidadorPropostaP2 validadorPropostaP2 = new ValidadorPropostaP2();

		if (propostaDTO == null)
			throw new PropostaException("Proposta não informada!");

		proposta = this.doConsultarProposta(propostaDTO.getNumeroProposta());

		propostaP2 = validadorPropostaP2.doValidarProposta(propostaDTO,
				proposta);

		propostaP2.setProposta(proposta);

		proposta.setPropostaP2(propostaP2);

		// proposta.setStatus(StatusProposta.PENDENTE);

		return this.propostaDAO.doAtualizar(proposta);

	}

	public Proposta doConsultarProposta(Integer id) throws PropostaException,
			DAOException {

		if (id == null)
			throw new PropostaException("ID da Proposta não informado!");

		Proposta proposta = this.propostaDAO.doProcurar(id);

		if (proposta == null)
			throw new PropostaException(
					new StringBuilder()
							.append("Nenhuma Proposta encontrada para o ID informado! ID: ")
							.append(id).toString());

		return proposta;
	}

	public void doValidarImpressaoTAD(PropostaDTO propostaDTO)
			throws PropostaException, DAOException,
			DadosComplementaresException, DadosBasicosException,
			DadosResidenciaisException, ContatosException,
			DadosProfissionaisException, OutrosDocumentosException,
			ReferenciaException, DadosCartaoCalcardException {

		ValidadorPropostaP2 validadorPropostaP2 = new ValidadorPropostaP2();

		validadorPropostaP2.doValidarProposta(propostaDTO,
				this.doConsultarProposta(propostaDTO.getNumeroProposta()));

	}

	public void doVincularIntegracao(Proposta proposta, Integer idIntegracao)
			throws ServiceException {

		if (proposta == null)
			throw new ServiceException("Proposta não informada!");

		if (proposta.getPropostaIntegracao() == null)
			proposta.setPropostaIntegracao(new ArrayList<PropostaIntegracao>());

		proposta.getPropostaIntegracao().add(
				new PropostaIntegracao(proposta, idIntegracao));

	}

	public List<Integer> doAtualizarPropostaAnaliseFraude(
			List<RespostaAnaliseDTO> listaRespostasAnalise)
			throws DAOException, ServiceException {

		String listaStatusAprovaProposta[] = {
				StatusPropostaMotorFraude.APROVACAO_AUTOMATICA.getCodigo(),
				StatusPropostaMotorFraude.APROVACAO_MANUAL.getCodigo() };

		String listaStatusReprovaProposta[] = {
				StatusPropostaMotorFraude.CANCELADO_PELO_CLIENTE.getCodigo(),
				StatusPropostaMotorFraude.FRAUDE_CONFIRMADA.getCodigo(),
				StatusPropostaMotorFraude.REPROVACAO_AUTOMATICA.getCodigo(),
				StatusPropostaMotorFraude.REPROVACAO_POR_POLITICA.getCodigo(),
				StatusPropostaMotorFraude.REPROVADO_SEM_SUSPEITA.getCodigo(),
				StatusPropostaMotorFraude.SUSPENSAO_MANUAL.getCodigo() };

		List<Integer> IdsPropostasAtualizadas = new ArrayList<Integer>();

		for (RespostaAnaliseDTO respostaAnaliseProposta : listaRespostasAnalise) {

			Proposta proposta = this.propostaDAO
					.doProcurar(respostaAnaliseProposta.getIdProposta());

			if (proposta != null) {

				if (Arrays.asList(listaStatusAprovaProposta).contains(
						respostaAnaliseProposta.getStatus())) {

					proposta.setStatus(StatusProposta.APROVADO_MOTOR_FRAUDE);

					proposta.setScoreFraude(respostaAnaliseProposta.getScore());

					this.doVincularIntegracao(proposta,
							respostaAnaliseProposta.getIdIntegracao());

					IdsPropostasAtualizadas.add(proposta.getId());

				} else if (Arrays.asList(listaStatusReprovaProposta).contains(
						respostaAnaliseProposta.getStatus())) {

					proposta.setStatus(StatusProposta.REPROVADO_MOTOR_FRAUDE);

					proposta.setScoreFraude(respostaAnaliseProposta.getScore());

					this.doVincularIntegracao(proposta,
							respostaAnaliseProposta.getIdIntegracao());

					IdsPropostasAtualizadas.add(proposta.getId());

				}

				this.propostaDAO.doAtualizar(proposta);

				// if (propostaStatusDTO.getStatus().equals(
				// StatusPropostaMotorFraude.ANALISE_MANUAL.getCodigo())) {
				//
				// } else if (propostaStatusDTO.getStatus().equals(
				// StatusPropostaMotorFraude.ERRO.getCodigo())) {
				//
				// } else if (propostaStatusDTO.getStatus().equals(
				// StatusPropostaMotorFraude.NOVO.getCodigo())) {
				// }

			}

		}

		return IdsPropostasAtualizadas;

	}

	public List<Proposta> doListarPropostasByEstabelecimentos(
			List<Estabelecimento> estabelecimentos, Date dataInicio,
			Date dataFim, Integer idProposta) throws DAOException,
			PropostaException {

		if (dataInicio != null && dataFim == null)
			throw new PropostaException("Data fim deve ser informada!");

		if (dataFim != null && dataInicio == null)
			throw new PropostaException("Data inicio deve ser informada!");

		if (dataInicio == null && idProposta == null)
			dataInicio = new Date();

		if (dataFim == null && idProposta == null)
			dataFim = CalsystemUtil.doSomarDias(dataInicio, 1);

		if (dataInicio != null)
			dataInicio = CalsystemUtil.doZerarHoras(dataInicio);

		if (dataFim != null)
			dataFim = CalsystemUtil.doSetarUltimoInstanteDoDia(dataFim);

		if (dataInicio != null && dataFim != null) {

			if (dataInicio.after(dataFim))
				throw new PropostaException(
						"Data inicial não pode ser maior que a data final!");

			if (CalsystemUtil.doSomarDias(dataInicio, 31).before(dataFim))
				throw new PropostaException(
						"Período de consulta não pode ser superior a 31 dias!");

		}

		return this.propostaDAO.doListarByEstabelecimentos(estabelecimentos,
				dataInicio, dataFim, idProposta);

	}
}
