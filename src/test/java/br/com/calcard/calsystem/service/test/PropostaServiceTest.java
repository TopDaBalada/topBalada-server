package br.com.calcard.calsystem.service.test;

public class PropostaServiceTest {

	// private PropostaService propostaService;
	//
	// private PropostaP1DAO propostaP1DAO;
	//
	// private PropostaDAO propostaDAO;
	//
	// @Before
	// public void setUp() throws Exception {
	//
	// this.propostaDAO = Mockito.spy(new PropostaDAO());
	//
	// this.propostaP1DAO = Mockito.spy(new PropostaP1DAO());
	//
	// this.propostaService = Mockito.spy(new PropostaService(
	// this.propostaP1DAO, this.propostaDAO));
	//
	// }
	//
	// @Test
	// public void deveCadastrarNovaProposta() throws ParseException,
	// PropostaException, ServiceException, DAOException,
	// PropostaNaoEncontrada, PropostaP1NaoAprovada,
	// PropostaCadastradaException {
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	// String dateInString = "31/08/1982";
	//
	// PropostaDTO propostaDTO = new PropostaDTO();
	//
	// propostaDTO.setIdP1(1);
	//
	// propostaDTO.setIdEstabelecimento(1);
	//
	// propostaDTO.setIdUsuario(1);
	//
	// // Dados Básicos
	// DadosBasicosDTO dadosBasicos = new DadosBasicosDTO();
	// dadosBasicos.setCpf("01496209001");
	// dadosBasicos.setDataNascimento(sdf.parse(dateInString));
	// dadosBasicos.setNome("Cliente Teste");
	// dadosBasicos.setSexo(SexoEnum.M);
	// propostaDTO.setDadosBasicos(dadosBasicos);
	//
	// // Dados Complementares
	// DadosComplementaresDTO dadosComplementares = new
	// DadosComplementaresDTO();
	// dadosComplementares.setEstadoCivil(EstadoCivilEnum.SOLTEIRO);
	// dadosComplementares.setGrauInstrucao(GrauInstrucaoEnum.POS_GRADUCAO);
	// dadosComplementares.setNascionalidade(NacionalidadeEnum.BRASILEIRO);
	// dadosComplementares.setNaturalidade("Porto Alegre");
	// dadosComplementares.setNomeMae("Mae Cliente Teste");
	// dadosComplementares.setNomePai("Pai Cliente Teste");
	// dadosComplementares.setNumeroDependentes(0);
	// dadosComplementares.setUf(UFEnum.RS);
	// propostaDTO.setDadosComplementares(dadosComplementares);
	//
	// // Contatos
	// ContatoDTO contato = new ContatoDTO();
	// contato.seteMail("clienteTeste@teste.com.br");
	//
	// List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
	//
	// telefones.add(new TelefoneDTO(DDDEnum.DDD_51, 99887766, null,
	// TipoTelefoneEnum.CELULAR));
	//
	// telefones.add(new TelefoneDTO(DDDEnum.DDD_51, 33556677, null,
	// TipoTelefoneEnum.RESIDENCIAL));
	//
	// propostaDTO.setContatos(contato);
	//
	// // Dados Profissionais
	// DadosProfissionaisDTO dadosProfissionais = new DadosProfissionaisDTO();
	// dadosProfissionais.setNaturezaOcupacao(NaturezaOcupacaoEnum.AUTONOMO);
	// dadosProfissionais.setProfissao(ProfissaoEnum.ADMINISTRADOR);
	// dadosProfissionais.setSalario(1000);
	// propostaDTO.setDadosProfissionais(dadosProfissionais);
	//
	// // Dados Residenciais
	// DadosResidenciaisDTO dadosResidenciais = new DadosResidenciaisDTO();
	// dadosResidenciais.setAnosResidencia(1);
	// dadosResidenciais.setMesesResidencia(0);
	// dadosResidenciais.setTipoResidencia(TipoResidenciaEnum.PROPRIA);
	// dadosResidenciais.setEndereco(new EnderecoDTO("91240080",
	// TipoLogradouroEnum.RUA, "Rua de Teste", 200, null,
	// "Bairro de Teste", "Cidade de Teste", UFEnum.RS));
	// propostaDTO.setDadosResidenciais(dadosResidenciais);
	//
	// PropostaP1 propostaP1Mock = new PropostaP1();
	// propostaP1Mock.setCpf(propostaDTO.getDadosBasicos().getCpf());
	// propostaP1Mock.setDataNascimento(propostaDTO.getDadosBasicos()
	// .getDataNascimento());
	// propostaP1Mock.setEstabelecimento(EstabelecimentoFactory.factory());
	// propostaP1Mock.setId(1);
	// propostaP1Mock.setNome("Cliente Teste");
	// propostaP1Mock.setSexo(SexoEnum.M);
	// propostaP1Mock.setStatus(StatusPropostaP1Enum.APROVADO);
	// propostaP1Mock.setUsuario(UsuarioFactory.factory());
	//
	// Mockito.doReturn(propostaP1Mock).when(this.propostaService)
	// .doConsultarPropostaP1(Mockito.anyInt());
	//
	// Proposta propostaMock = new Proposta();
	// propostaMock.setContatos(null);
	// propostaMock.setDadosComplementares(null);
	// propostaMock.setDadosP1(null);
	// propostaMock.setDadosProfissionais(null);
	// propostaMock.setDadosResidenciais(null);
	// propostaMock.setDataAtualizacao(null);
	// propostaMock.setDataRegistro(null);
	// propostaMock.setId(null);
	// propostaMock.setOutrosDocumentos(null);
	// propostaMock.setStatus(null);
	//
	// Mockito.doReturn(toBeReturned)
	//
	// Proposta proposta = this.propostaService.doCadastrarP2(propostaDTO);
	//
	// Assert.assertEquals(StatusPropostaP2Enum.APROVADO, proposta.getStatus());
	//
	// }
}
