package br.com.calcard.calsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calintegrador.motorFraude.dto.AddressDTO;
import br.com.calcard.calintegrador.motorFraude.dto.BillingDataDTO;
import br.com.calcard.calintegrador.motorFraude.dto.ClearSaleDTO;
import br.com.calcard.calintegrador.motorFraude.dto.EmploymentDTO;
import br.com.calcard.calintegrador.motorFraude.dto.GenericDTO;
import br.com.calcard.calintegrador.motorFraude.dto.IssuerDTO;
import br.com.calcard.calintegrador.motorFraude.dto.OrderDTO;
import br.com.calcard.calintegrador.motorFraude.dto.PersonalReferenceDTO;
import br.com.calcard.calintegrador.motorFraude.dto.PhoneDTO;
import br.com.calcard.calintegrador.motorFraude.dto.RespostaAnaliseDTO;
import br.com.calcard.calintegrador.motorFraude.exception.IntegracaoFraudeException;
import br.com.calcard.calintegrador.motorFraude.service.MotorFraudeIntegradorServiceFacade;
import br.com.calcard.calsystem.entity.proposta.Proposta;
import br.com.calcard.calsystem.util.CalsystemUtil;

@Service
public class MotorFraudeService {

	private MotorFraudeIntegradorServiceFacade motorFraudeIntegradorServiceFacade;

	@Autowired
	public MotorFraudeService(
			MotorFraudeIntegradorServiceFacade motorFraudeServiceFacade) {
		this.motorFraudeIntegradorServiceFacade = motorFraudeServiceFacade;
	}

	public List<RespostaAnaliseDTO> doConsultarRespostaAnalise()
			throws IntegracaoFraudeException, DAOException {

		return this.motorFraudeIntegradorServiceFacade
				.doConsultarRespostaAnalise();

	}

	public Integer doEnviarProposta(Proposta proposta)
			throws IntegracaoFraudeException, DAOException {

		try {

			// Order
			OrderDTO order = new OrderDTO();

			order.setEmissor(new IssuerDTO());

			order.setBillingData(new BillingDataDTO());

			order.getBillingData().setDadosGenericos(
					new ArrayList<GenericDTO>());

			// dados basicos

			order.setIdProposta(proposta.getId());

			order.setDataProposta(CalsystemUtil
					.doConvertDateToXsdDateTime(proposta.getDataRegistro()));

			order.getEmissor().setEstabelecimento(
					proposta.getPropostaP1().getEstabelecimento().getId());

			order.getEmissor().setPromotor(
					proposta.getPropostaP1().getUsuario().getLogin());

			order.getBillingData().setCpf(proposta.getPropostaP1().getCpf());

			order.getBillingData().setDataNascimento(
					CalsystemUtil.doConvertDateToXsdDateTime(proposta
							.getPropostaP1().getDataNascimento()));

			order.getBillingData().setNome(proposta.getPropostaP1().getNome());

			order.getBillingData().setSexo(
					proposta.getPropostaP1().getSexo().getCodigo());

			// dados complementares

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("Naturalidade", proposta
							.getPropostaP2().getNaturalidade()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("NaturalidadeUF", proposta
							.getPropostaP2().getUf().name()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("Nacionalidade", proposta
							.getPropostaP2().getNacionalidade().name()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("TP_ESTADO_CIVIL", proposta
							.getPropostaP2().getEstadoCivil().name()));

			// grau de instrucao
			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("ESCOLARIDADE", proposta
							.getPropostaP2().getGrauInstrucao().name()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("NumeroDependentes", proposta
							.getPropostaP2().getNumeroDependentes()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("NomePai", proposta.getPropostaP2()
							.getNomePai()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("NM_MAE", proposta.getPropostaP2()
							.getNomeMae()));

			// Outros Documentos

			order.getBillingData().setRg(
					proposta.getPropostaP2().getOutrosDocumentos().getNumero());

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("DT_EMISSAO_RG", CalsystemUtil
							.doConvertDateToXsdDateTime((proposta
									.getPropostaP2().getOutrosDocumentos()
									.getDataEmissao()))));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("UF_RG", proposta.getPropostaP2()
							.getOutrosDocumentos().getUf().name()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("NM_ORGAO_EMISSOR", proposta
							.getPropostaP2().getOutrosDocumentos()
							.getOrgaoEmissor().name()));

			// Contatos

			order.setEmail(proposta.getPropostaP2().getEmail());

			// Order >> BillingData >> Phones

			order.getBillingData().setTelefones(new ArrayList<PhoneDTO>());

			// generics.add(new GenericDTO("TIPOTELEFONE",
			// "DadosProfissionais"));

			// telefone Residencial
			PhoneDTO telefoneResidencial = new PhoneDTO();

			telefoneResidencial.setDdd(proposta.getPropostaP2()
					.getDadosResidenciais().getTelefone().getDdd().getId());

			telefoneResidencial.setNumero(proposta.getPropostaP2()
					.getDadosResidenciais().getTelefone().getNumero());

			order.getBillingData().getTelefones().add(telefoneResidencial);

			// telefone celular
			PhoneDTO telefoneCelular = new PhoneDTO();

			telefoneCelular.setDdd(proposta.getPropostaP2().getCelular()
					.getDdd().getId());

			telefoneCelular.setNumero(proposta.getPropostaP2().getCelular()
					.getNumero());

			order.getBillingData().getTelefones().add(telefoneCelular);

			// telefone comercial
			PhoneDTO telefoneComercial = new PhoneDTO();

			telefoneComercial.setDdd(proposta.getPropostaP2()
					.getDadosProfissionais().getTelefone().getDdd().getId());

			telefoneComercial.setNumero(proposta.getPropostaP2()
					.getDadosProfissionais().getTelefone().getNumero());

			telefoneComercial.setRamal(proposta.getPropostaP2()
					.getDadosProfissionais().getTelefone().getRamal());

			order.getBillingData().getTelefones().add(telefoneComercial);

			// Dados residencias

			// Order >> BillingData >> Address

			order.getBillingData().setEndereco(new AddressDTO());

			order.getBillingData()
					.getEndereco()
					.setCep(proposta.getPropostaP2().getDadosResidenciais()
							.getEndereco().getCep());

			order.getBillingData()
					.getEndereco()
					.setRua(proposta.getPropostaP2().getDadosResidenciais()
							.getEndereco().getLogradouro());

			order.getBillingData()
					.getEndereco()
					.setNumero(
							proposta.getPropostaP2().getDadosResidenciais()
									.getEndereco().getNumero());

			order.getBillingData()
					.getEndereco()
					.setComplemento(
							proposta.getPropostaP2().getDadosResidenciais()
									.getEndereco().getComplemento());

			order.getBillingData()
					.getEndereco()
					.setBairro(
							proposta.getPropostaP2().getDadosResidenciais()
									.getEndereco().getBairro());

			order.getBillingData()
					.getEndereco()
					.setCidade(
							proposta.getPropostaP2().getDadosResidenciais()
									.getEndereco().getCidade());

			order.getBillingData()
					.getEndereco()
					.setEstado(
							proposta.getPropostaP2().getDadosResidenciais()
									.getEndereco().getUf().name());

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("TempoResidencialAnos", proposta
							.getPropostaP2().getDadosResidenciais()
							.getAnosResidencia()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("TempoResidencialMeses", proposta
							.getPropostaP2().getDadosResidenciais()
							.getMesesResidencia()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("TipoResidencia", proposta
							.getPropostaP2().getDadosResidenciais()
							.getTipoResidencia().name()));

			// dados profissionais

			// Order >> BillingDate >> Employment

			order.getBillingData().setDadosProfissionais(new EmploymentDTO());

			order.getBillingData()
					.getDadosProfissionais()
					.setNaturezaOcupacao(
							proposta.getPropostaP2().getDadosProfissionais()
									.getNaturezaOcupacao().name());

			order.getBillingData()
					.getDadosProfissionais()
					.setProfissao(
							proposta.getPropostaP2().getDadosProfissionais()
									.getProfissao().name());

			order.getBillingData()
					.getDadosProfissionais()
					.setDataAdmissao(
							proposta.getPropostaP2().getDadosProfissionais()
									.getDataAdmissao());

			order.getBillingData()
					.getDadosProfissionais()
					.setNomeEmpresa(
							proposta.getPropostaP2().getDadosProfissionais()
									.getNomeEmpresa());

			order.getBillingData()
					.getDadosProfissionais()
					.setCnpj(
							proposta.getPropostaP2().getDadosProfissionais()
									.getCnpj());

			// Order >> BillingDate >> Employment >> Address
			order.getBillingData().getDadosProfissionais()
					.setEndereco(new AddressDTO());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setCep(proposta.getPropostaP2().getDadosProfissionais()
							.getEndereco().getCep());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setRua(proposta.getPropostaP2().getDadosProfissionais()
							.getEndereco().getLogradouro());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setNumero(
							proposta.getPropostaP2().getDadosProfissionais()
									.getEndereco().getNumero());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setComplemento(
							proposta.getPropostaP2().getDadosProfissionais()
									.getEndereco().getComplemento());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setBairro(
							proposta.getPropostaP2().getDadosProfissionais()
									.getEndereco().getBairro());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setCidade(
							proposta.getPropostaP2().getDadosProfissionais()
									.getEndereco().getCidade());

			order.getBillingData()
					.getDadosProfissionais()
					.getEndereco()
					.setEstado(
							proposta.getPropostaP2().getDadosProfissionais()
									.getEndereco().getUf().name());

			order.getBillingData()
					.getDadosProfissionais()
					.setSalario(
							proposta.getPropostaP2().getDadosProfissionais()
									.getSalario());

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("RendaNaoComprovada", proposta
							.getPropostaP2().getDadosProfissionais()
							.getOutrasRendas()));

			order.getBillingData()
					.getDadosGenericos()
					.add(new GenericDTO("OrigemOutrasRendas", proposta
							.getPropostaP2().getDadosProfissionais()
							.getOrigemOutrasRendas()));

			// Cartao Calcard

			order.getEmissor().setGenerics(new ArrayList<GenericDTO>());

			/*
			 * order.getEmissor().getGenerics() .add(new
			 * GenericDTO("NomeEmbossado", ""));
			 */

			order.getEmissor()
					.getGenerics()
					.add(new GenericDTO("DiaVencimentoFatura", proposta
							.getPropostaP2().getVencimentoFatura().getId()));

			order.getEmissor()
					.getGenerics()
					.add(new GenericDTO("TipoCorrespondencia", proposta
							.getPropostaP2().getEnderecoCorrespondencia()
							.name()));

			// Referencias Pessoais

			// Order >> BillingData >> PersonalReferences
			order.getBillingData().setReferenciasPessoais(
					new ArrayList<PersonalReferenceDTO>());

			PersonalReferenceDTO referencia1 = new PersonalReferenceDTO();

			referencia1.setNome(proposta.getPropostaP2().getReferencias()
					.get(0).getNome());
			referencia1.setGrauParentesco(proposta.getPropostaP2()
					.getReferencias().get(0).getGrauParentesco().name());

			referencia1.setDdd(proposta.getPropostaP2().getReferencias().get(0)
					.getTelefone().getDdd().getId());

			referencia1.setTelefone(proposta.getPropostaP2().getReferencias()
					.get(0).getTelefone().getNumero());

			referencia1.setRamal(proposta.getPropostaP2().getReferencias()
					.get(0).getTelefone().getRamal());

			order.getBillingData().getReferenciasPessoais().add(referencia1);

			PersonalReferenceDTO referencia2 = new PersonalReferenceDTO();

			referencia2.setNome(proposta.getPropostaP2().getReferencias()
					.get(1).getNome());

			referencia2.setGrauParentesco(proposta.getPropostaP2()
					.getReferencias().get(1).getGrauParentesco().name());
			referencia2.setDdd(proposta.getPropostaP2().getReferencias().get(1)
					.getTelefone().getDdd().getId());

			referencia2.setTelefone(proposta.getPropostaP2().getReferencias()
					.get(1).getTelefone().getNumero());

			referencia2.setRamal(proposta.getPropostaP2().getReferencias()
					.get(1).getTelefone().getRamal());

			order.getBillingData().getReferenciasPessoais().add(referencia2);

			ClearSaleDTO clearSaleDTO = new ClearSaleDTO();

			clearSaleDTO.getOrders().add(order);

			return this.motorFraudeIntegradorServiceFacade
					.doEnviarProposta(clearSaleDTO);

		} catch (IntegracaoFraudeException e) {
			throw new IntegracaoFraudeException(
					"Não foi possível enviar a Proposta para o motor de fraude",
					e);
		}

	}

	public Map<Integer, Integer> doFlegarPropostasRecebidas(
			List<Integer> idsPropostas) throws IntegracaoFraudeException,
			DAOException {

		return this.motorFraudeIntegradorServiceFacade
				.doFlegarPropostasRecebidas(idsPropostas);

	}

}
