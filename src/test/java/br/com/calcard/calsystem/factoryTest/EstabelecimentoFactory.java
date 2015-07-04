package br.com.calcard.calsystem.factoryTest;

import java.util.Date;

import br.com.calcard.calsystem.entity.Enum.StatusEstabelecimentoEnum;
import br.com.calcard.calsystem.entity.Estabelecimento;

public class EstabelecimentoFactory {

	public static Estabelecimento factory() {

		Estabelecimento estabelecimento = new Estabelecimento();

		estabelecimento.setCnpj("12345678901234");
		estabelecimento.setCodigo("1");
		estabelecimento.setDataAtualizacao(new Date());
		estabelecimento.setDataRegistro(new Date());
		estabelecimento.setId(1);
		estabelecimento.setLojista(LojistaFactory.facotory());
		estabelecimento.setStatus(StatusEstabelecimentoEnum.ATIVO);
		estabelecimento.setUsuarios(null);

		return estabelecimento;

	}

}
