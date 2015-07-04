package br.com.calcard.calsystem.service.test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml",
//		"classpath:dispatcher-servlet.xml" })
public class VoucherServiceTest {

	// private VoucherService voucherService;
	//
	// private VoucherDAO voucherDAO;
	//
	// private ParametroGlobalDAO parametroGlobalDAO;
	//
	// private ParametroService parametroService;
	//
	// @Before
	// public void setUp() throws Exception {
	//
	// voucherDAO = Mockito.spy(new VoucherDAO());
	//
	// parametroGlobalDAO = Mockito.spy(new ParametroGlobalDAO());
	//
	// parametroService = Mockito
	// .spy(new ParametroService(parametroGlobalDAO));
	//
	// voucherService = Mockito.spy(new VoucherService(voucherDAO,
	// parametroService));
	// }
	//
	// /*
	// * Testes do Método doListarByCpf()
	// */
	// @Test(expected = IllegalArgumentException.class)
	// public void doListarByCpfDeveRetornarIllegalArgumentException()
	// throws VoucherNaoEncontradoException, CPFInvalidoException {
	// voucherService.doListarByCpf(null);
	// }
	//
	// @Test(expected = CPFInvalidoException.class)
	// public void doListarByCpfDeveRetornarCPFInvalidoException()
	// throws VoucherNaoEncontradoException, CPFInvalidoException {
	//
	// String cpf = "35658448507";
	//
	// voucherService.doListarByCpf(cpf);
	//
	// }
	//
	// @Test(expected = VoucherNaoEncontradoException.class)
	// public void doListarByCpfDeveRetornarVoucherNaoEncontradoException()
	// throws VoucherNaoEncontradoException, CPFInvalidoException {
	//
	// String cpf = "18805816809";
	//
	// Mockito.doReturn(null).when(voucherDAO).doListarByCpf(cpf);
	//
	// voucherService.doListarByCpf(cpf);
	//
	// }
	//
	// @Test
	// public void doListarByCpfDeveRetornarVouchersConsultados()
	// throws VoucherNaoEncontradoException, CPFInvalidoException {
	//
	// String cpf = "18805816809";
	//
	// List<Voucher> vouchersMock = new Voucher().createList(2);
	//
	// for (Voucher v : vouchersMock)
	// v.getConta().setCpf(cpf);
	//
	// Mockito.doReturn(vouchersMock).when(voucherDAO).doListarByCpf(cpf);
	//
	// List<Voucher> vouchers = voucherService.doListarByCpf(cpf);
	//
	// for (Voucher v : vouchers)
	// Assert.assertEquals(v.getConta().getCpf(), cpf);
	//
	// }
	//
	// /*
	// * Testes do Método doUtilizar()
	// */
	// @Test(expected = IllegalArgumentException.class)
	// public void doUtilizarDeveRetornarIllegalArgumentException()
	// throws VoucherStatusException, VoucherNaoEncontradoException,
	// ParametroGlobalNaoEncontradoException,
	// VoucherEEstabelecimentoDiferentesException,
	// VoucherEContaDiferentesException {
	//
	// this.voucherService.doUtilizar(null, null, null);
	//
	// }
	//
	// @Test(expected = VoucherStatusException.class)
	// public void doUtilizarDeveRetornarVoucherStatusException()
	// throws VoucherStatusException, VoucherNaoEncontradoException,
	// ParametroGlobalNaoEncontradoException,
	// VoucherEEstabelecimentoDiferentesException,
	// VoucherEContaDiferentesException {
	//
	// Voucher voucherMock = new Voucher().create();
	// voucherMock.setStatus(Voucher.STATUS_UTILIZADO);
	//
	// Map<String, ParametroGlobal> parametroGlobalMock = new HashMap<String,
	// ParametroGlobal>();
	//
	// ParametroGlobal parametroGlobalVoucherValidaEstabelecimentoMock = new
	// ParametroGlobal()
	// .create();
	// parametroGlobalVoucherValidaEstabelecimentoMock
	// .setNome(ParametroGlobal.NOME_PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO);
	// parametroGlobalVoucherValidaEstabelecimentoMock.setValorBooleano(false);
	//
	// parametroGlobalMock.put(
	// ParametroGlobal.NOME_PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO,
	// parametroGlobalVoucherValidaEstabelecimentoMock);
	//
	// this.voucherService.doUtilizar(voucherMock, null, null);
	//
	// }
	//
	// @Test
	// public void doUtilizarDeveAtualizarStatusVoucherParaEmUtilizacao()
	// throws VoucherStatusException, VoucherNaoEncontradoException,
	// ParametroGlobalNaoEncontradoException,
	// VoucherEEstabelecimentoDiferentesException,
	// VoucherEContaDiferentesException {
	//
	// Voucher voucherMock = new Voucher().create();
	//
	// Voucher voucherTest = (Voucher) voucherMock.clone();
	// voucherTest.setStatus(Voucher.STATUS_EM_UTILIZACAO);
	//
	// voucherMock.setStatus(Voucher.STATUS_EMITIDO);
	//
	// Mockito.doReturn(null).when(voucherDAO)
	// .doAtualizar(Mockito.any(Voucher.class));
	//
	// Map<String, ParametroGlobal> parametroGlobalMock = new HashMap<String,
	// ParametroGlobal>();
	//
	// ParametroGlobal parametroGlobalVoucherValidaEstabelecimentoMock = new
	// ParametroGlobal()
	// .create();
	// parametroGlobalVoucherValidaEstabelecimentoMock
	// .setNome(ParametroGlobal.NOME_PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO);
	// parametroGlobalVoucherValidaEstabelecimentoMock.setValorBooleano(false);
	//
	// parametroGlobalMock.put(
	// ParametroGlobal.NOME_PARAMETRO_VOUCHER_VALIDA_ESTABELECIMENTO,
	// parametroGlobalVoucherValidaEstabelecimentoMock);
	//
	// Mockito.doReturn(parametroGlobalMock).when(parametroService)
	// .doListarParametrosByNome(Mockito.anyString());
	//
	// voucherMock = this.voucherService.doUtilizar(voucherMock,
	// voucherMock.getConta(), null);
	//
	// Assert.assertEquals(voucherTest, voucherMock);
	//
	// }
	//
	// /*
	// * Testes do Método doImprimir()
	// */
	// @Test(expected = IllegalArgumentException.class)
	// public void doImprimirDeveRetornarIllegalArgumentException()
	// throws VoucherStatusException {
	//
	// this.voucherService.doImprimir(null, null, null);
	//
	// }
	//
	// @Test(expected = VoucherStatusException.class)
	// public void doImprimirDeveRetornarVoucherStatusException()
	// throws VoucherStatusException {
	//
	// String senha = "1234";
	//
	// Usuario usuario = new Usuario().create();
	//
	// Voucher voucherMock = new Voucher().create();
	//
	// voucherMock.setStatus(Voucher.STATUS_UTILIZADO);
	//
	// voucherMock = voucherService.doImprimir(voucherMock, usuario, senha);
	//
	// }
	//
	// @Test
	// public void
	// doImprimirDeveRetornarVoucherParaImpressaoDeUmVoucherDisponivel()
	// throws CloneNotSupportedException, VoucherNaoEncontradoException,
	// VoucherDisponivelException, VoucherEmitidoException,
	// VoucherEmUtilizacaoException, VoucherUtilizadoException,
	// VoucherExpiradoException, VoucherStatusException,
	// UsuarioNaoEncontradoException, ServiceException {
	//
	// String senha = "1234";
	//
	// Usuario usuario = new Usuario().create();
	//
	// Voucher voucherMock = new Voucher().create();
	//
	// Voucher voucherEsperado = (Voucher) voucherMock.clone();
	// voucherEsperado.setStatus(Voucher.STATUS_EMITIDO);
	// voucherEsperado.setSenha("1234");
	//
	// voucherMock.setStatus(Voucher.STATUS_DISPONIVEL);
	// voucherMock.setSenha(null);
	//
	// Mockito.doReturn(null).when(voucherDAO)
	// .doAtualizar(Mockito.any(Voucher.class));
	//
	// voucherMock = this.voucherService.doImprimir(voucherMock, usuario,
	// senha);
	//
	// Assert.assertEquals(voucherEsperado, voucherMock);
	//
	// }
	//
	// /*
	// * Testes do Método doConfirmarUtilizacao()
	// */
	// @Test(expected = IllegalArgumentException.class)
	// public void doConfirmarUtilizacaoDeveRetornarIllegalArgumentException()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// this.voucherService.doConfirmarUtilizacao(null);
	//
	// }
	//
	// @Test(expected = VoucherStatusException.class)
	// public void doConfirmarUtilizacaoDeveRetornarVoucherStatusException()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// Voucher voucherMock = new Voucher().create();
	// voucherMock.setStatus(Voucher.STATUS_UTILIZADO);
	//
	// this.voucherService.doConfirmarUtilizacao(voucherMock);
	//
	// }
	//
	// @Test
	// public void
	// doConfirmarUtilizacaoDeveAtualizarStatusVoucherParaEmUtilizacao()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// Voucher voucherMock = new Voucher().create();
	//
	// Voucher voucherTest = (Voucher) voucherMock.clone();
	// voucherTest.setStatus(Voucher.STATUS_UTILIZADO);
	//
	// voucherMock.setStatus(Voucher.STATUS_EM_UTILIZACAO);
	//
	// Mockito.doReturn(null).when(voucherDAO)
	// .doAtualizar(Mockito.any(Voucher.class));
	//
	// voucherMock = this.voucherService.doConfirmarUtilizacao(voucherMock);
	//
	// Assert.assertEquals(voucherTest, voucherMock);
	//
	// }
	//
	// /*
	// * Testes do Método doCancelarUtilizacao()
	// */
	// @Test(expected = IllegalArgumentException.class)
	// public void doCancelarUtilizacaoDeveRetornarIllegalArgumentException()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// this.voucherService.doCancelarUtilizacao(null);
	//
	// }
	//
	// @Test(expected = VoucherStatusException.class)
	// public void doCancelarUtilizacaoDeveRetornarVoucherStatusException()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// Voucher voucherMock = new Voucher().create();
	// voucherMock.setStatus(Voucher.STATUS_UTILIZADO);
	//
	// this.voucherService.doCancelarUtilizacao(voucherMock);
	//
	// }
	//
	// @Test
	// public void
	// doCancelarUtilizacaoDeveAtualizarStatusVoucherParaEmUtilizacao()
	// throws VoucherStatusException, VoucherNaoEncontradoException {
	//
	// Voucher voucherMock = new Voucher().create();
	//
	// Voucher voucherTest = (Voucher) voucherMock.clone();
	// voucherTest.setStatus(Voucher.STATUS_EMITIDO);
	//
	// voucherMock.setStatus(Voucher.STATUS_EM_UTILIZACAO);
	//
	// Mockito.doReturn(null).when(voucherDAO)
	// .doAtualizar(Mockito.any(Voucher.class));
	//
	// voucherMock = this.voucherService.doCancelarUtilizacao(voucherMock);
	//
	// Assert.assertEquals(voucherTest, voucherMock);
	//
	// }

}
