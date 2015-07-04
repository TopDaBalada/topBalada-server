package br.com.calcard.calsystem.service;

import br.com.calcard.calframework.exception.CPFException;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.exception.NomeException;
import br.com.calcard.calframework.util.CalsystemUtil;
import br.com.calcard.calsystem.dto.proposta.DadosBasicosDTO;
import br.com.calcard.calsystem.dto.proposta.PropostaDTO;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.proposta.PropostaP1;
import br.com.calcard.calsystem.exception.proposta.DadosBasicosException;
import br.com.calcard.calsystem.exception.proposta.PropostaException;

public class ValidadorPropostaP1 {

	public PropostaP1 doValidarProposta(PropostaDTO propostaDTO,
			Usuario usuario, Estabelecimento estabelecimento)
			throws PropostaException, DAOException, DadosBasicosException {

		PropostaP1 propostaP1;

		if (propostaDTO == null)
			throw new PropostaException("PropostaDTO n�o informada!");

		propostaP1 = this.doCarregarPropostaP1(propostaDTO.getDadosBasicos(),
				usuario, estabelecimento);

		return propostaP1;

	}

	private PropostaP1 doCarregarPropostaP1(DadosBasicosDTO dadosBasicosDTO,
			Usuario usuario, Estabelecimento estabelecimento)
			throws PropostaException, DadosBasicosException {

		if (dadosBasicosDTO == null)
			throw new PropostaException("Dados P1 n�o informados!");

		if (usuario == null)
			throw new PropostaException("Usu�rio n�o informado!");

		if (estabelecimento == null)
			throw new PropostaException("Estabelecimeento n�o informado!");

		this.doValidarDadosP1(dadosBasicosDTO);

		PropostaP1 propostaP1 = new PropostaP1();

		propostaP1.setCpf(dadosBasicosDTO.getCpf());

		propostaP1.setDataNascimento(dadosBasicosDTO.getDataNascimento());

		propostaP1.setNome(dadosBasicosDTO.getNome());

		propostaP1.setSexo(dadosBasicosDTO.getSexoEnum());

		propostaP1.setUsuario(usuario);

		propostaP1.setEstabelecimento(estabelecimento);

		return propostaP1;

	}

	private void doValidarDadosP1(DadosBasicosDTO dadosP1)
			throws DadosBasicosException {

		if (dadosP1 == null)
			throw new DadosBasicosException("Proposta n�o informada!");

		if (dadosP1.getDataNascimento() == null)
			throw new DadosBasicosException("Data de nascimento n�o informada!");

		if (CalsystemUtil.doCalcularIdade(dadosP1.getDataNascimento()) < 18)
			throw new DadosBasicosException(
					"Proposta n�o pode ser registrada para uma pessoa menor de 18 anos!");

		if (dadosP1.getSexo() == null)
			throw new DadosBasicosException("Sexo n�o informado!");

		try {
			CalsystemUtil.doValidarNome(dadosP1.getNome());
		} catch (NomeException e) {
			throw new DadosBasicosException("Nome in�lido!", e);
		}

		try {
			CalsystemUtil.doValidarCpf(dadosP1.getCpf());
		} catch (CPFException e) {
			throw new DadosBasicosException("CPF inv�lido!", e);
		}

	}

}
