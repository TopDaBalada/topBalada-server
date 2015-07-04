package br.com.calcard.calsystem.factoryTest;

import java.util.Date;

import br.com.topBalada.entity.Usuario;

public class UsuarioFactory {

	public static Usuario factory() {

		Usuario usuario = new Usuario();

		usuario.setCpf("12345678901");
		usuario.setDataAtualizacao(new Date());
		usuario.setDataRegistro(new Date());
		usuario.setEstabelecimentos(null);
		usuario.setId(1);
		usuario.setLogin("teste");
		usuario.setNome("Usuario de Teste");
		usuario.setPerfil(null);
		usuario.setSenha("12345");

		return usuario;

	}
}
