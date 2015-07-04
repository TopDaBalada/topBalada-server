package br.com.calcard.calsystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.calcard.calsystem.exception.CPFException;
import br.com.calcard.calsystem.exception.CnpjException;
import br.com.calcard.calsystem.exception.EmailException;
import br.com.calcard.calsystem.exception.NomeException;

@Deprecated
public class CalsystemUtil {

	public static void doValidarCpf(String cpf) throws CPFException {

		if (cpf == null)
			throw new CPFException("CPF não informado!");

		if (cpf.length() < 11)
			throw new CPFException("CPF com menos de 11 dígitos!");

		if (cpf.equals("00000000000") || cpf.equals("11111111111")
				|| cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777")
				|| cpf.equals("88888888888") || cpf.equals("99999999999"))
			throw new CPFException("CPF inválido!");

		char dig10, dig11;

		int sm, i, r, num, peso;

		/*
		 * Calcula o 10º dígito
		 */
		sm = 0;
		peso = 10;
		for (i = 0; i < 9; i++) {
			num = (int) (cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			dig10 = '0';
		else
			dig10 = (char) (r + 48);

		/*
		 * Calcula o 11º dígito
		 */
		sm = 0;
		peso = 11;
		for (i = 0; i < 10; i++) {
			num = (int) (cpf.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso - 1;
		}

		r = 11 - (sm % 11);
		if ((r == 10) || (r == 11))
			dig11 = '0';
		else
			dig11 = (char) (r + 48);

		/*
		 * Valida se está correto
		 */
		if ((dig10 != cpf.charAt(9)) || (dig11 != cpf.charAt(10)))
			throw new CPFException("CPF inválido!");

	}

	public static String doMascararCPF(String cpf) {

		if (cpf == null)
			throw new IllegalArgumentException("CPF não informado!");

		else if (cpf.length() != 11)
			throw new IllegalArgumentException("CPF inválido!");

		StringBuilder cpfMascarado = new StringBuilder();

		cpfMascarado.append(cpf.substring(0, 3)).append("******")
				.append(cpf.substring(9, 11));

		return cpfMascarado.toString();

	}

	public static boolean isNull(String valor) {

		if (valor == null)
			return true;

		else if (valor.length() == 0)
			return true;

		else if (valor.isEmpty())
			return true;

		else if (valor.replace(" ", "").length() == 0)
			return true;

		else
			return false;

	}

	public static int doCalcularIdade(Date nascimento) {

		Calendar cn = Calendar.getInstance();
		cn.setTime(nascimento);

		Date dataAtual = new Date(System.currentTimeMillis());
		Calendar ca = Calendar.getInstance();
		ca.setTime(dataAtual);

		int idade = ca.get(Calendar.YEAR) - cn.get(Calendar.YEAR);
		if (ca.get(Calendar.MONTH) < cn.get(Calendar.MONTH)) {
			idade--;
		} else if (ca.get(Calendar.MONTH) == cn.get(Calendar.MONTH)) {
			if (ca.get(Calendar.DAY_OF_MONTH) < cn.get(Calendar.DAY_OF_MONTH))
				idade--;
		}
		return idade;
	}

	public static void doValidarNome(String nome) throws NomeException {

		if (nome == null || nome.isEmpty())
			throw new NomeException("Nome não informado!");

		else if (nome.length() > 100)
			throw new NomeException("Nome é muito longo!");

		else if (nome.split(" ").length < 2 || nome.split(" ")[1].length() < 1)
			throw new NomeException("O nome informado não possui sobrenome!");

	}

	public static void doValidarEmail(String email) throws EmailException {

		if (CalsystemUtil.isNull(email))
			throw new EmailException("E-mail não informado!");

		if (!email.contains("@") || !email.toUpperCase().contains(".COM"))
			throw new EmailException("E-mail inválido");

	}

	public static void doValidarCNPJ(String cnpj) throws CnpjException {

		if (CalsystemUtil.isNull(cnpj))
			throw new CnpjException("CNPJ não informado!");

		if (cnpj.length() != 14)
			throw new CnpjException("CNPJ inválido!");

	}

	public static String doConvertDateToString(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return dateFormat.format(date);

	}

	public static String doConvertDateToXsdDateTime(Date date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss");

		return dateFormat.format(date);

	}

	public static Date doSomarSegundos(Date data, int qtdSegundos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.SECOND, qtdSegundos);
		return cal.getTime();
	}

	public static Date doSomarMinutos(Date data, int qtdMinutos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, qtdMinutos);
		return cal.getTime();
	}

	public static Date doSomarDias(Date data, int qtdDias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, qtdDias);
		return cal.getTime();
	}

	public static Date doZerarHoras(Date data) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	public static Date doSetarUltimoInstanteDoDia(Date data) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	public static Date doToDate(String data) throws ParseException {

		DateFormat d = new SimpleDateFormat("MM/dd/yyyy");

		return d.parse(data);

	}
}
