package br.com.calcard.calsystem.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {

		Date dataAtual = DateUtil.doZerarHoras(new Date());

		Date dataAmanha = DateUtil.doSomarDias(dataAtual, 1);

		System.out.println(dataAtual + " - " + dataAmanha);

	}

	@Deprecated
	public static Date doSomarSegundos(Date data, int qtdSegundos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.SECOND, qtdSegundos);
		return cal.getTime();
	}

	@Deprecated
	public static Date doSomarMinutos(Date data, int qtdMinutos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, qtdMinutos);
		return cal.getTime();
	}

	@Deprecated
	public static Date doSomarDias(Date data, int qtdDias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, qtdDias);
		return cal.getTime();
	}

	@Deprecated
	public static Date doZerarHoras(Date data) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	@Deprecated
	public static Date doToDate(String data) throws ParseException {

		DateFormat d = new SimpleDateFormat("MM/dd/yyyy");

		return d.parse(data);

	}

}
