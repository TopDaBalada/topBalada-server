package br.com.calcard.calsystem.service;

import java.util.ArrayList;
import java.util.List;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calsystem.dto.EnderecoDTO;
import br.com.calcard.calsystem.dto.RGDTO;
import br.com.calcard.calsystem.dto.TelefoneDTO;
import br.com.calcard.calsystem.dto.proposta.DadosComplementaresDTO;
import br.com.calcard.calsystem.dto.proposta.DadosProfissionaisDTO;
import br.com.calcard.calsystem.dto.proposta.DadosResidenciaisDTO;
import br.com.calcard.calsystem.dto.proposta.OutrosDocumentosDTO;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.dto.proposta.ReferenciaDTO;
import br.com.calcard.calsystem.entity.proposta.Endereco;
import br.com.calcard.calsystem.entity.proposta.Proposta;
import br.com.calcard.calsystem.entity.proposta.PropostaDadosProfissionais;
import br.com.calcard.calsystem.entity.proposta.PropostaDadosResidenciais;
import br.com.calcard.calsystem.entity.proposta.PropostaOutrosDocumentos;
import br.com.calcard.calsystem.entity.proposta.PropostaP2;
import br.com.calcard.calsystem.entity.proposta.PropostaReferencia;
import br.com.calcard.calsystem.entity.proposta.Telefone;
import br.com.calcard.calsystem.enums.PropostaEnum.FaturaPorEmailEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.StatusProposta;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoDocumentoEnum;
import br.com.calcard.calsystem.enums.PropostaEnum.TipoTelefoneEnum;
import br.com.calcard.calsystem.exception.CnpjException;
import br.com.calcard.calsystem.exception.EmailException;
import br.com.calcard.calsystem.exception.NomeException;
import br.com.calcard.calsystem.exception.TelefoneException;
import br.com.calcard.calsystem.exception.proposta.ContatosException;
import br.com.calcard.calsystem.exception.proposta.DadosBasicosException;
import br.com.calcard.calsystem.exception.proposta.DadosCartaoCalcardException;
import br.com.calcard.calsystem.exception.proposta.DadosComplementaresException;
import br.com.calcard.calsystem.exception.proposta.DadosProfissionaisException;
import br.com.calcard.calsystem.exception.proposta.DadosResidenciaisException;
import br.com.calcard.calsystem.exception.proposta.OutrosDocumentosException;
import br.com.calcard.calsystem.exception.proposta.PropostaException;
import br.com.calcard.calsystem.exception.proposta.RGException;
import br.com.calcard.calsystem.exception.proposta.ReferenciaException;
import br.com.calcard.calsystem.rn.EnderecoException;
import br.com.calcard.calsystem.util.CalsystemUtil;

public class ValidadorPropostaP2 {

	public ValidadorPropostaP2() {

	}

	public PropostaP2 doValidarProposta(PropostaDTO propostaDTO,
			Proposta proposta) throws PropostaException, DAOException,
			DadosComplementaresException, DadosBasicosException,
			DadosResidenciaisException, ContatosException,
			DadosProfissionaisException, OutrosDocumentosException,
			ReferenciaException, DadosCartaoCalcardException {

		PropostaP2 propostaP2 = new PropostaP2();
		PropostaDadosProfissionais dadosProfissionais;
		PropostaDadosResidenciais dadosResidenciais;
		PropostaOutrosDocumentos outrosDocumentos;

		List<PropostaReferencia> referencias = null;

		if (proposta == null)
			throw new PropostaException("Proposta não informada!");

		if (proposta.getPropostaP2() != null)
			throw new PropostaException("Proposta já utilizada!");

		if (!proposta.getStatus().equals(StatusProposta.APROVADO_P1))
			throw new PropostaException("Proposta P1 não está aprovada!");

		if (proposta.getPropostaP1() == null)
			throw new PropostaException("Proposta P1 não cadastrado!");

		if (propostaDTO == null)
			throw new PropostaException("Proposta não informada!");

		// Dados Complementares
		propostaP2 = this.doCarregarDadosComplementares(propostaDTO
				.getDadosComplementares());

		// Outros Documentos
		outrosDocumentos = this.doCarregarOutrosDocumentos(propostaDTO
				.getOutrosDocumentos());

		outrosDocumentos.setPropostaP2(propostaP2);

		propostaP2.setOutrosDocumentos(outrosDocumentos);

		// Dados Residencias
		dadosResidenciais = this.doCarregarDadosResidenciais(propostaDTO
				.getDadosResidenciais());

		dadosResidenciais.setPropostaP2(propostaP2);

		propostaP2.setDadosResidenciais(dadosResidenciais);

		// Dados Profissionais
		dadosProfissionais = this.doCarregarDadosProfissionais(propostaDTO
				.getDadosProfissionais());

		dadosProfissionais.setPropostaP2(propostaP2);

		propostaP2.setDadosProfissionais(dadosProfissionais);

		// Referencias
		referencias = this.doCarregarReferencias(propostaDTO.getReferencias());

		for (PropostaReferencia referencia : referencias)
			referencia.setPropostaP2(propostaP2);

		propostaP2.setReferencias(referencias);

		return propostaP2;

	}

	private PropostaOutrosDocumentos doCarregarOutrosDocumentos(
			OutrosDocumentosDTO outrosDocumentosDTO)
			throws OutrosDocumentosException {

		PropostaOutrosDocumentos outrosDocumentos = new PropostaOutrosDocumentos();

		this.doValidarOutrosDocumentos(outrosDocumentosDTO);

		outrosDocumentos.setDataEmissao(outrosDocumentosDTO.getRg()
				.getDataEmissao());

		outrosDocumentos.setNumero(outrosDocumentosDTO.getRg().getNumero());

		outrosDocumentos.setOrgaoEmissor(outrosDocumentosDTO.getRg()
				.getOrgaoEmissorEnum());

		outrosDocumentos.setUf(outrosDocumentosDTO.getRg().getUf());

		outrosDocumentos.setTipoDocumento(TipoDocumentoEnum.RG);

		return outrosDocumentos;

	}

	private List<PropostaReferencia> doCarregarReferencias(
			List<ReferenciaDTO> referenciasDTO) throws ReferenciaException {

		List<PropostaReferencia> referencias = new ArrayList<PropostaReferencia>();

		this.doValidarReferencias(referenciasDTO);

		for (ReferenciaDTO referencia : referenciasDTO) {

			PropostaReferencia dadosReferencia = new PropostaReferencia();
			dadosReferencia.setNome(referencia.getNome());
			dadosReferencia.setGrauParentesco(referencia
					.getGrauParentescoEnum());

			dadosReferencia.setTelefone(new Telefone(referencia.getTelefone()
					.getDddEnum(), referencia.getTelefone().getNumero(),
					referencia.getTelefone().getRamal(),
					TipoTelefoneEnum.REFERENCIA));

			referencias.add(dadosReferencia);

		}

		return referencias;

	}

	private PropostaDadosResidenciais doCarregarDadosResidenciais(
			DadosResidenciaisDTO dadosResidenciaisDTO)
			throws DadosResidenciaisException {

		PropostaDadosResidenciais dadosResidenciais = new PropostaDadosResidenciais();

		this.doValidarDadosResidenciais(dadosResidenciaisDTO);

		dadosResidenciais.setAnosResidencia(dadosResidenciaisDTO
				.getAnosResidencia());

		dadosResidenciais.setMesesResidencia(dadosResidenciaisDTO
				.getMesesResidencia());

		dadosResidenciais.setTipoResidencia(dadosResidenciaisDTO
				.getTipoResidenciaEnum());

		dadosResidenciais.setTelefone(new Telefone(dadosResidenciaisDTO
				.getTelefoneResidencial().getDddEnum(), dadosResidenciaisDTO
				.getTelefoneResidencial().getNumero(), dadosResidenciaisDTO
				.getTelefoneResidencial().getRamal(),
				TipoTelefoneEnum.RESIDENCIAL));

		dadosResidenciais.setEndereco(this
				.doCarregarEnderecoResidencial(dadosResidenciaisDTO
						.getEndereco()));

		return dadosResidenciais;
	}

	private Endereco doCarregarEnderecoResidencial(EnderecoDTO enderecoDTO) {

		Endereco endereco = new Endereco();

		endereco.setBairro(enderecoDTO.getBairro());

		endereco.setCep(enderecoDTO.getCep());

		endereco.setCidade(enderecoDTO.getCidade());

		endereco.setComplemento(enderecoDTO.getComplemento());

		endereco.setLogradouro(enderecoDTO.getLogradouro());

		endereco.setNumero(enderecoDTO.getNumero());

		endereco.setUf(enderecoDTO.getUf());

		return endereco;

	}

	private PropostaDadosProfissionais doCarregarDadosProfissionais(
			DadosProfissionaisDTO dadosProfissionaisDTO)
			throws DadosProfissionaisException {

		PropostaDadosProfissionais dadosProfissionais = new PropostaDadosProfissionais();

		this.doValidarDadosProfissionais(dadosProfissionaisDTO);

		dadosProfissionais.setCnpj(dadosProfissionaisDTO.getCnpj());

		dadosProfissionais.setDataAdmissao(dadosProfissionaisDTO
				.getDataAdmissao());

		dadosProfissionais.setNaturezaOcupacao(dadosProfissionaisDTO
				.getNaturezaOcupacaoEnum());

		dadosProfissionais.setNomeEmpresa(dadosProfissionaisDTO
				.getNomeEmpresa());

		dadosProfissionais.setOrigemOutrasRendas(dadosProfissionaisDTO
				.getOrigemOutrasRendas());

		dadosProfissionais.setOutrasRendas(dadosProfissionaisDTO
				.getOutrasRendas());

		dadosProfissionais.setSalario(dadosProfissionaisDTO.getSalario());

		dadosProfissionais.setProfissao(dadosProfissionaisDTO
				.getProfissaoEnum());

		dadosProfissionais.setEndereco(this
				.doCarregarEnderecoProfissional(dadosProfissionaisDTO
						.getEndereco()));

		if (dadosProfissionaisDTO.getTelefoneComercial() != null) {

			dadosProfissionais.setTelefone(new Telefone(dadosProfissionaisDTO
					.getTelefoneComercial().getDddEnum(), dadosProfissionaisDTO
					.getTelefoneComercial().getNumero(), dadosProfissionaisDTO
					.getTelefoneComercial().getRamal(),
					TipoTelefoneEnum.COMERCIAL));

		}

		return dadosProfissionais;

	}

	private Endereco doCarregarEnderecoProfissional(EnderecoDTO enderecoDTO) {

		Endereco endereco = new Endereco();

		endereco.setBairro(enderecoDTO.getBairro());

		endereco.setCep(enderecoDTO.getCep());

		endereco.setCidade(enderecoDTO.getCidade());

		endereco.setComplemento(enderecoDTO.getComplemento());

		endereco.setLogradouro(enderecoDTO.getLogradouro());

		endereco.setNumero(enderecoDTO.getNumero());

		endereco.setUf(enderecoDTO.getUf());

		return endereco;

	}

	private PropostaP2 doCarregarDadosComplementares(
			DadosComplementaresDTO dadosComplementaresDTO)
			throws DadosComplementaresException {

		PropostaP2 propostaP2 = new PropostaP2();

		this.doValidarDadosComplementares(dadosComplementaresDTO);

		propostaP2.setVencimentoFatura(dadosComplementaresDTO
				.getVencimentoFaturaEnum());

		propostaP2
				.setFaturaPorEmail(dadosComplementaresDTO.getFaturaPorEmail());

		propostaP2.setEnderecoCorrespondencia(dadosComplementaresDTO
				.getEnderecoCorrespondenciaEnum());

		propostaP2.setEmail(dadosComplementaresDTO.geteMail());

		propostaP2.setEstadoCivil(dadosComplementaresDTO.getEstadoCivilEnum());

		propostaP2.setGrauInstrucao(dadosComplementaresDTO
				.getGrauInstrucaoEnum());

		propostaP2.setNacionalidade(dadosComplementaresDTO
				.getNacionalidadeEnum());

		propostaP2.setNaturalidade(dadosComplementaresDTO.getNaturalidade());

		propostaP2.setNomeMae(dadosComplementaresDTO.getNomeMae());

		propostaP2.setNomePai(dadosComplementaresDTO.getNomePai());

		propostaP2.setNumeroDependentes(dadosComplementaresDTO
				.getNumeroDependentes());

		propostaP2.setCelular(new Telefone(dadosComplementaresDTO
				.getTelefoneCelular().getDddEnum(), dadosComplementaresDTO
				.getTelefoneCelular().getNumero(), dadosComplementaresDTO
				.getTelefoneCelular().getRamal(), TipoTelefoneEnum.CELULAR));

		propostaP2.setUf(dadosComplementaresDTO.getUf());

		return propostaP2;

	}

	private void doValidarReferencias(List<ReferenciaDTO> referencias)
			throws ReferenciaException {

		if (referencias == null || referencias.size() < 2)
			throw new ReferenciaException(
					"Quantidade de referencias mínimas não informadas!");

		for (ReferenciaDTO referencia : referencias) {

			if (referencia.getGrauParentescoEnum() == null)
				throw new ReferenciaException(
						"Grau de parentesco não informado!");

			try {
				this.doValidarTelefone(referencia.getTelefone());
			} catch (TelefoneException e) {
				throw new ReferenciaException("Telefone inválido!", e);
			}

			try {
				CalsystemUtil.doValidarNome(referencia.getNome());
			} catch (NomeException e) {
				throw new ReferenciaException("Nome inválido!", e);
			}

		}

	}

	private void doValidarOutrosDocumentos(
			OutrosDocumentosDTO outrosDocumentosDTO)
			throws OutrosDocumentosException {

		if (outrosDocumentosDTO == null)
			throw new OutrosDocumentosException(
					"Outros documentos não informados!");

		if (outrosDocumentosDTO.getRg() == null)
			throw new OutrosDocumentosException("RG não informado!");

		try {
			this.doValidarRG(outrosDocumentosDTO.getRg());
		} catch (RGException e) {
			throw new OutrosDocumentosException("RG inválido", e);
		}

	}

	private void doValidarRG(RGDTO rg) throws RGException {

		if (rg == null)
			throw new RGException("RG não informado!");

		else if (rg.getDataEmissao() == null)
			throw new RGException("Data de emissão não informada!");

		else if (rg.getNumero() == null)
			throw new RGException("Número não informado!");

		else if (rg.getOrgaoEmissorEnum() == null)
			throw new RGException("Orgão emissor não informado!");

		else if (rg.getUf() == null)
			throw new RGException("UF não informada!");

	}

	private void doValidarDadosProfissionais(
			DadosProfissionaisDTO dadosProfissionaisDTO)
			throws DadosProfissionaisException {

		if (dadosProfissionaisDTO == null)
			throw new DadosProfissionaisException(
					"Dados profissionais não informados!");

		if (!CalsystemUtil.isNull(dadosProfissionaisDTO.getCnpj())) {

			try {
				CalsystemUtil.doValidarCNPJ(dadosProfissionaisDTO.getCnpj());
			} catch (CnpjException e) {
				throw new DadosProfissionaisException("CNPJ inválido!", e);
			}

		}

		if (dadosProfissionaisDTO.getDataAdmissao() == null)
			throw new DadosProfissionaisException(
					"Data de Admissão não informada!");

		if (dadosProfissionaisDTO.getNaturezaOcupacaoEnum() == null)
			throw new DadosProfissionaisException(
					"Natureza da ocupação não informada!");

		if (dadosProfissionaisDTO.getProfissaoEnum() == null)
			throw new DadosProfissionaisException("Profissão não informada!");

		if (dadosProfissionaisDTO.getSalario() == null)
			throw new DadosProfissionaisException("Salário não informado!");

		if (dadosProfissionaisDTO.getSalario() < 0)
			throw new DadosProfissionaisException("Salário inválido!");

		// if (Arrays.asList(
		// new String[] { NaturezaOcupacaoEnum.EMPREGADO.name(),
		// NaturezaOcupacaoEnum.FUNCIONARIO_PUBLICO.name() })
		// .contains(
		// this.propostaDTO.getDadosProfissionais()
		// .getNaturezaOcupacaoEnum().name())) {

		if (dadosProfissionaisDTO.getEndereco() != null) {

			try {
				this.doValidarEndereco(dadosProfissionaisDTO.getEndereco());
			} catch (EnderecoException e) {
				throw new DadosProfissionaisException(
						"Endereço profissional inválido!", e);
			}
		}

		if (dadosProfissionaisDTO.getTelefoneComercial() != null) {

			try {
				this.doValidarTelefone(dadosProfissionaisDTO
						.getTelefoneComercial());
			} catch (TelefoneException e) {
				throw new DadosProfissionaisException(
						"Telefone comercial inválido!", e);
			}
		}

	}

	private void doValidarTelefone(TelefoneDTO telefoneDTO)
			throws TelefoneException {

		if (telefoneDTO == null)
			throw new TelefoneException("Telefone não informado!");

		if (telefoneDTO.getDddEnum() == null)
			throw new TelefoneException("DDD do telefone não informado!");

		if (telefoneDTO.getNumero() == null)
			throw new TelefoneException("Número do telefone não informado!");

	}

	private void doValidarDadosResidenciais(
			DadosResidenciaisDTO dadosResidenciais)
			throws DadosResidenciaisException {

		if (dadosResidenciais == null)
			throw new DadosResidenciaisException(
					"Dados residenciais não informados!");

		if (dadosResidenciais.getAnosResidencia() == null)
			throw new DadosResidenciaisException(
					"Tempo (anos) de Residencia não informado!");

		if (dadosResidenciais.getMesesResidencia() == null)
			throw new DadosResidenciaisException(
					"Tempo (meses) de Residencia não informado!");

		if (dadosResidenciais.getMesesResidencia() > 11)
			throw new DadosResidenciaisException(
					"Tempo (meses) de Residencia inválido! > 11");

		if (dadosResidenciais.getTipoResidenciaEnum() == null)
			throw new DadosResidenciaisException(
					"Tipo de residência não informada!");

		try {
			this.doValidarTelefone(dadosResidenciais.getTelefoneResidencial());
		} catch (TelefoneException e) {
			throw new DadosResidenciaisException("Telefone inválido!", e);
		}

		try {
			this.doValidarEndereco(dadosResidenciais.getEndereco());
		} catch (EnderecoException e) {
			throw new DadosResidenciaisException(
					"Endereço residencial inválido!", e);
		}

	}

	private void doValidarEndereco(EnderecoDTO endereco)
			throws EnderecoException {

		if (endereco == null)
			throw new EnderecoException("Endereço não informado!");

		if (CalsystemUtil.isNull(endereco.getBairro()))
			throw new EnderecoException("Bairro não informado!");

		if (CalsystemUtil.isNull(endereco.getCep()))
			throw new EnderecoException("Cep não informado!");

		if (endereco.getCep().replace(" ", "").length() != 8)
			throw new EnderecoException("Cep inválido!");

		if (CalsystemUtil.isNull(endereco.getCidade()))
			throw new EnderecoException("Cidade não informado!");

		if (CalsystemUtil.isNull(endereco.getLogradouro()))
			throw new EnderecoException("Logradouro não informado!");

		if (endereco.getNumero() == null)
			throw new EnderecoException("Número não informado!");

		if (endereco.getUf() == null)
			throw new EnderecoException(
					"UF do Endereço residencial não informado!");

	}

	private void doValidarDadosComplementares(
			DadosComplementaresDTO dadosComplementaresDTO)
			throws DadosComplementaresException {

		if (dadosComplementaresDTO == null)
			throw new DadosComplementaresException(
					"Dados Complementares não informados!");

		if (dadosComplementaresDTO.getEnderecoCorrespondenciaEnum() == null)
			throw new DadosComplementaresException(
					"Endereço de correspondência não informado!");

		if (dadosComplementaresDTO.getVencimentoFaturaEnum() == null)
			throw new DadosComplementaresException(
					"Vencimento da fatura não informado!");

		if (dadosComplementaresDTO.getEstadoCivil() == null)
			throw new DadosComplementaresException(
					"Estado civil não informado!");

		if (dadosComplementaresDTO.getGrauInstrucaoEnum() == null)
			throw new DadosComplementaresException(
					"Grau de instrução não informado!");

		if (dadosComplementaresDTO.getNacionalidadeEnum() == null)
			throw new DadosComplementaresException(
					"Nacionalidade não informada!");

		if (CalsystemUtil.isNull(dadosComplementaresDTO.getNaturalidade()))
			throw new DadosComplementaresException(
					"Naturalidade não informada!");

		if (CalsystemUtil.isNull(dadosComplementaresDTO.getNomeMae()))
			throw new DadosComplementaresException("Nome da mãe não informado!");

		try {
			CalsystemUtil.doValidarNome(dadosComplementaresDTO.getNomeMae());
		} catch (NomeException e) {
			throw new DadosComplementaresException("Nome da mãe inválido!", e);
		}

		if (!CalsystemUtil.isNull(dadosComplementaresDTO.geteMail())) {
			try {
				CalsystemUtil.doValidarEmail(dadosComplementaresDTO.geteMail());
			} catch (EmailException e) {
				throw new DadosComplementaresException("E-mail inválido!", e);
			}
		}

		if (dadosComplementaresDTO.getFaturaPorEmail().equals(
				FaturaPorEmailEnum.SIM)
				&& CalsystemUtil.isNull(dadosComplementaresDTO.geteMail())) {
			throw new DadosComplementaresException(
					"E-mail não informado para o recebimento da fatura!");
		}

		if (dadosComplementaresDTO.getUf() == null)
			throw new DadosComplementaresException(
					"UF dos dados complementares não informadab!");

		if (!CalsystemUtil.isNull(dadosComplementaresDTO.getNomePai())) {
			try {
				CalsystemUtil
						.doValidarNome(dadosComplementaresDTO.getNomePai());
			} catch (NomeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
