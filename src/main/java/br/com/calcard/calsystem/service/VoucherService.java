package br.com.calcard.calsystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dao.VoucherDAO;
import br.com.calcard.calsystem.entity.Conta;
import br.com.calcard.calsystem.entity.Estabelecimento;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.entity.Usuario;
import br.com.calcard.calsystem.entity.Voucher;
import br.com.calcard.calsystem.exception.CPFInvalidoException;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.usuario.UsuarioNaoEncontradoException;
import br.com.calcard.calsystem.exception.voucher.VoucherDisponivelException;
import br.com.calcard.calsystem.exception.voucher.VoucherEContaDiferentesException;
import br.com.calcard.calsystem.exception.voucher.VoucherEEstabelecimentoDiferentesException;
import br.com.calcard.calsystem.exception.voucher.VoucherEmUtilizacaoException;
import br.com.calcard.calsystem.exception.voucher.VoucherEmitidoException;
import br.com.calcard.calsystem.exception.voucher.VoucherExpiradoException;
import br.com.calcard.calsystem.exception.voucher.VoucherNaoEncontradoException;
import br.com.calcard.calsystem.exception.voucher.VoucherStatusException;
import br.com.calcard.calsystem.exception.voucher.VoucherUtilizadoException;
import br.com.calcard.calsystem.util.CPFUtil;

/**
 * Classe respons�vel por encapsular todos os Servi�os relacionadas ao
 * {@link Voucher}
 * 
 * @author Gustavo Porto
 * @category Servi�o
 *
 */
@Service
public class VoucherService {

	private VoucherDAO voucherDAO;

	private Map<String, ParametroGlobal> parametros;

	private ParametroService parametroService;

	@Autowired
	public VoucherService(VoucherDAO voucherDAO,
			ParametroService parametroService) {
		this.voucherDAO = voucherDAO;
		this.parametroService = parametroService;
	}

	/**
	 * Servi�o respons�vel por validar o processo de impress�o de um Voucher
	 * 
	 * @param codigoVoucher
	 *            C�digo do {@link Voucher} a ser impresso
	 * @param idUsuario
	 *            Id do {@link Usuario} que solicitou a impress�o do
	 *            {@link Voucher}
	 * @return {@link Voucher} {@link Voucher} impresso.
	 * @throws VoucherNaoEncontradoException
	 * @throws VoucherStatusException
	 * @throws VoucherExpiradoException
	 * @throws VoucherUtilizadoException
	 * @throws VoucherEmUtilizacaoException
	 * @throws VoucherEmitidoException
	 * @throws VoucherDisponivelException
	 * @throws UsuarioNaoEncontradoException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doImprimir(Voucher voucher, Usuario usuario, String senha)
			throws VoucherStatusException, DAOException {

		if (voucher == null)
			throw new IllegalArgumentException("Voucher n�o informado!");

		else if (usuario == null)
			throw new IllegalArgumentException("Usuario n�o informado!");

		if (voucher.getStatus().equals(Voucher.STATUS_DISPONIVEL)) {

			if (senha == null)
				throw new IllegalArgumentException("Senha n�o informada!");

			voucher.setStatus(Voucher.STATUS_EMITIDO);

			voucher.setSenha(senha);

			this.voucherDAO.doAtualizar(voucher);

		} else
			throw new VoucherStatusException();

		return voucher;
	}

	/**
	 * M�todo respons�vel por identificar o Status do {@link Voucher} e retornar
	 * uma exce��o relacionada
	 * 
	 * @param voucher
	 *            {@link Voucher}
	 * @throws VoucherStatusException
	 * @throws VoucherUtilizadoException
	 * @throws VoucherDisponivelException
	 * @throws VoucherEmUtilizacaoException
	 * @throws VoucherExpiradoException
	 * @throws VoucherEmitidoException
	 */
	public void doValidarStatus(Voucher voucher) throws VoucherStatusException,
			VoucherUtilizadoException, VoucherDisponivelException,
			VoucherEmUtilizacaoException, VoucherExpiradoException,
			VoucherEmitidoException {

		switch (voucher.getStatus()) {
		case Voucher.STATUS_DISPONIVEL:
			throw new VoucherDisponivelException();
		case Voucher.STATUS_EM_UTILIZACAO:
			throw new VoucherEmUtilizacaoException();
		case Voucher.STATUS_EXPIRADO:
			throw new VoucherExpiradoException();
		case Voucher.STATUS_EMITIDO:
			throw new VoucherEmitidoException();
		case Voucher.STATUS_UTILIZADO:
			throw new VoucherUtilizadoException();
		default:
			throw new VoucherStatusException();

		}

	}

	/**
	 * Servi�o respons�vel por listar todos os {@link Voucher}s existentes para
	 * um CPF.
	 * 
	 * @param cpf
	 * @return List<{@link Voucher}> Lista com os {@link Voucher}s encontrados.
	 * @throws CPFInvalidoException
	 * @throws VoucherNaoEncontradoException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public List<Voucher> doListarByCpf(String cpf) throws CPFInvalidoException,
			VoucherNaoEncontradoException, DAOException {

		if (cpf == null)
			throw new IllegalArgumentException("CPF n�o informada!");

		CPFUtil.doValidarCpf(cpf);

		List<Voucher> vouchers = this.voucherDAO.doListarByCpf(cpf);

		if (vouchers == null)
			throw new VoucherNaoEncontradoException();

		return vouchers;

	}

	/**
	 * Servi�o respons�vel por iniciar a utiliza��o de um {@link Voucher} em um
	 * compra.
	 * 
	 * @param voucher
	 *            {@link Voucher} original
	 * @return {@link Voucher} {@link Voucher} atualizado para compra
	 * @throws VoucherStatusException
	 * @throws VoucherNaoEncontradoException
	 * @throws VoucherECpfDiferentesException
	 * @throws ParametroGlobalNaoEncontradoException
	 * @throws VoucherEEstabelecimentoDiferentesException
	 * @throws VoucherEContaDiferentesException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doUtilizar(Voucher voucher, Conta conta,
			Estabelecimento estabelecimento) throws VoucherStatusException,
			VoucherNaoEncontradoException,
			ParametroGlobalNaoEncontradoException,
			VoucherEEstabelecimentoDiferentesException,
			VoucherEContaDiferentesException, DAOException, ServiceException {

		this.doCarregarParametros();

		if (voucher == null)
			throw new IllegalArgumentException("Voucher n�o informado");

		if (conta == null)
			throw new IllegalArgumentException("Conta n�o informado");

		if (parametros.get(
				ParametroGlobal.PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO)
				.getValorBooleano()) {

			if (estabelecimento == null)
				throw new IllegalArgumentException(
						"Estabelecimento n�o informado");

			else if (!estabelecimento.getCnpj().equals(
					voucher.getEstabelecimento().getCnpj()))
				throw new VoucherEEstabelecimentoDiferentesException();

		}

		if (!conta.getCpf().equals(voucher.getConta().getCpf()))
			throw new VoucherEContaDiferentesException();

		if (voucher.getStatus().equals(Voucher.STATUS_EMITIDO)) {

			voucher.setStatus(Voucher.STATUS_EM_UTILIZACAO);

			this.voucherDAO.doAtualizar(voucher);

			return voucher;

		} else
			throw new VoucherStatusException();

	}

	public void doCarregarParametros()
			throws ParametroGlobalNaoEncontradoException, DAOException,
			ServiceException {

		parametros = parametroService
				.doListarParametrosByNome(ParametroGlobal.PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO);

	}

	/**
	 * Servi�o respons�vel por consultar um {@link Voucher} pelo seu ID
	 * 
	 * @param idVoucher
	 *            ID do {@link Voucher} a ser consultado
	 * @return {@link Voucher}
	 * @throws VoucherNaoEncontradoException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doConsultarById(Integer idVoucher)
			throws VoucherNaoEncontradoException, DAOException {

		if (idVoucher == null)
			throw new IllegalArgumentException("Id do Voucher n�o informado!");

		Voucher voucher = voucherDAO.doProcurar(idVoucher);

		if (voucher == null)
			throw new VoucherNaoEncontradoException();

		return voucher;
	}

	/**
	 * Servi�o respons�vel por finalizar a utiliza��o de um {@link Voucher} em
	 * um compra.
	 * 
	 * @param voucher
	 *            {@link Voucher}
	 * @return {@link Voucher} {@link Voucher} confirmado e atualizado como
	 *         Utilizado.
	 * @throws VoucherStatusException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doConfirmarUtilizacao(Voucher voucher)
			throws VoucherStatusException, DAOException {

		if (voucher == null)
			throw new IllegalArgumentException("Voucher n�o informado");

		if (voucher.getStatus().equals(Voucher.STATUS_EM_UTILIZACAO)) {

			voucher.setStatus(Voucher.STATUS_UTILIZADO);

			this.voucherDAO.doAtualizar(voucher);

			return voucher;

		} else
			throw new VoucherStatusException();

	}

	/**
	 * Servi�o respons�vel por abortar a utiliza��o de um {@link Voucher}. Nos
	 * casos em que por algum problema o processo n�o p�de ser conclu�do
	 * 
	 * @param voucher
	 *            {@link Voucher} � ser abortado
	 * @return {@link Voucher} {@link Voucher} atualizado para o Status de
	 *         Emitido permitindo a sua utiliza��o novamente
	 * @throws VoucherStatusException
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doCancelarUtilizacao(Voucher voucher)
			throws VoucherStatusException, DAOException {

		if (voucher == null)
			throw new IllegalArgumentException("Voucher n�o informado");

		if (voucher.getStatus().equals(Voucher.STATUS_EM_UTILIZACAO)) {

			voucher.setStatus(Voucher.STATUS_EMITIDO);

			this.voucherDAO.doAtualizar(voucher);

			return voucher;

		} else
			throw new VoucherStatusException();

	}

	public Voucher doConsultarByCodigo(String codigoVoucher)
			throws VoucherNaoEncontradoException, DAOException {

		if (codigoVoucher == null)
			throw new IllegalArgumentException(
					"C�digo do Voucher n�o informado");

		Voucher voucher = voucherDAO.doConsultarByCodigo(codigoVoucher);

		if (voucher == null)
			throw new VoucherNaoEncontradoException();

		return voucher;

	}

}
