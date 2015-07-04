package br.com.calcard.calsystem.util;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class CustomObjectMapper extends AbstractHttpMessageConverter<Object> {

	@Override
	protected Object readInternal(Class<? extends Object> arg0,
			HttpInputMessage arg1) throws IOException,
			HttpMessageNotReadableException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void writeInternal(Object arg0, HttpOutputMessage arg1)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub

	}

}
