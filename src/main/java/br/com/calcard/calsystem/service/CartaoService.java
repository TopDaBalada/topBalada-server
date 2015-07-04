package br.com.calcard.calsystem.service;

import java.util.Random;

public abstract class CartaoService {

	public String doGerarSenha() {
		return String.format("%04d", new Random().nextInt(9999));
	}

}
