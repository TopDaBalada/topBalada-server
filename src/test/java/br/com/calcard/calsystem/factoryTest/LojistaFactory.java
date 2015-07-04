package br.com.calcard.calsystem.factoryTest;

import java.util.Date;

import br.com.calcard.calsystem.entity.Lojista;

public class LojistaFactory {

	public static Lojista facotory() {

		Lojista lojista = new Lojista();

		lojista.setCodigo("TESTE");
		lojista.setDataAtualizacao(new Date());
		lojista.setDataRegistro(new Date());
		lojista.setDescricao("Lojista de Teste");
		lojista.setId(1);

		return lojista;

	}

}
