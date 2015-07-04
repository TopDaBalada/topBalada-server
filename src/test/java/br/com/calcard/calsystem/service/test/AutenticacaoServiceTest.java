package br.com.calcard.calsystem.service.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:dispatcher-servlet.xml" })
public class AutenticacaoServiceTest {

	// @Before
	// public void setUp() throws Exception {
	// }
	//
	// @Test(expected = ParametroInvalidoException.class)
	// public void deveRetornarParametroInvalido()
	// throws ParametroInvalidoException, LoginInvalidoException {
	//
	// AutenticacaoService autenticacaoService = new AutenticacaoService(null);
	//
	// autenticacaoService.doAutenticarUsuario(null, null);
	//
	// }
	//
	// @Test
	// public void deveRetornarUsuarioConsultado()
	// throws ParametroInvalidoException, LoginInvalidoException {
	//
	// Usuario usuarioTeste = new Usuario().create();
	//
	// UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
	//
	// Mockito.when(
	// usuarioDAO.doGetUsuarioByLoginESenha(Mockito.anyString(),
	// Mockito.anyString())).thenReturn(usuarioTeste);
	//
	// AutenticacaoService autenticacaoService = new AutenticacaoService(
	// usuarioDAO);
	//
	// Usuario usuario = autenticacaoService.doAutenticarUsuario("teste",
	// "teste");
	//
	// Assert.assertEquals(usuarioTeste, usuario);
	//
	// }
	//
	// @Test(expected = LoginInvalidoException.class)
	// public void deveRetornarLoginInvalido() throws
	// ParametroInvalidoException,
	// LoginInvalidoException {
	//
	// UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
	//
	// Mockito.when(
	// usuarioDAO.doGetUsuarioByLoginESenha(Mockito.anyString(),
	// Mockito.anyString())).thenReturn(null);
	//
	// AutenticacaoService autenticacaoService = new AutenticacaoService(
	// usuarioDAO);
	//
	// autenticacaoService.doAutenticarUsuario("teste", "teste");
	//
	// }

}
