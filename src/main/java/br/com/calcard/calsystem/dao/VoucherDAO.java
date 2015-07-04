package br.com.calcard.calsystem.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.calcard.calframework.dao.CalsystemDAO;
import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.entity.Conta;
import br.com.calcard.calsystem.entity.Voucher;
import br.com.calcard.calsystem.util.DateUtil;
import br.com.calcard.calsystem.util.Parametro;

@Repository
public class VoucherDAO extends CalsystemDAO<Voucher> {

	/**
	 * M�todo respons�vel por listar todos os {@link Voucher}s existentes
	 * cadastrados para um CPF.
	 * 
	 * @param cpf
	 *            CPF da {@link Conta} vinculada ao {@link Voucher}
	 * @return List<{@link Voucher}>
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public List<Voucher> doListarByCpf(String cpf) throws DAOException {

		if (cpf == null)
			throw new IllegalArgumentException("CPF n�o informado!");

		return (List<Voucher>) super.doGetResultList(
				Voucher.NQ_SELECT_VOUCHERS_BY_CPF, new Parametro()
						.doAddParametro("cpf", cpf).getParametros());

	}

	/**
	 * M�todo respons�vel por listar todos os {@link Voucher}s vencidos.
	 * 
	 * @return List<{@link Voucher}>
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public List<Voucher> doListarVencidos() throws DAOException {

		return (List<Voucher>) super.doGetResultList(
				Voucher.NQ_SELECT_VOUCHERS_VENCIDOS,
				new Parametro()
						.doAddParametro("hoje",
								DateUtil.doZerarHoras(new Date()))
						.doAddParametro("status1", Voucher.STATUS_DISPONIVEL)
						.doAddParametro("status2", Voucher.STATUS_EMITIDO)
						.getParametros());

	}

	/**
	 * M�todo respons�vel por consultar um {@link Voucher} pelo seu c�digo
	 * 
	 * @param codigoVoucher
	 *            C�digo identificador do {@link Voucher} que se quuer
	 *            consultar.
	 * @return {@link Voucher}
	 * @throws ServiceException
	 * @throws DAOException
	 */
	public Voucher doConsultarByCodigo(String codigoVoucher)
			throws DAOException {

		if (codigoVoucher == null)
			throw new IllegalArgumentException(
					"C�digo do Voucher n�o informado!");

		return super.doGetSingleResult(Voucher.NQ_SELECT_VOUCHER_BY_CODIGO,
				new Parametro().doAddParametro("codigo", codigoVoucher)
						.getParametros());
	}

	@Override
	public Class<Voucher> doGetClass() {
		return Voucher.class;
	}
}
