package br.com.calcard.calsystem.service.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:dispatcher-servlet.xml" })
public class UsuarioServiceImplTest {

	// @InjectMocks
	// @Autowired
	// private UsuarioService usuarioService;
	//
	// @Mock
	// private UsuarioDAO usuarioDAOImpl;
	//
	// @Before
	// public void setup() throws LoginInvalidoException {
	// MockitoAnnotations.initMocks(this);
	// }
	//
	// @Test(expected = LoginInvalidoException.class)
	// public void deveRetornarLoginInvalido() throws LoginInvalidoException {
	// usuarioService.doAutenticarUsuario(null, null);
	// }
	//
	// @Test
	// public void deveRetornarUsuarioConsultado() throws LoginInvalidoException
	// {
	//
	// Usuario usuarioTeste = new Usuario().create();
	//
	// Mockito.when(
	// usuarioDAOImpl.doGetUsuarioByLoginESenha(
	// usuarioTeste.getLogin(), usuarioTeste.getSenha()))
	// .thenReturn(usuarioTeste);
	//
	// Usuario usuario = usuarioService.doAutenticarUsuario(
	// usuarioTeste.getLogin(), usuarioTeste.getSenha());
	//
	// Assert.assertEquals(usuarioTeste, usuario);
	//
	// }
}
