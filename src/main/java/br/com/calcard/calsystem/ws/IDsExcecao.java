package br.com.calcard.calsystem.ws;

public class IDsExcecao {

	/***********************************************************************/
	/************************ ERROS GENÉRICOS (999) ************************/
	/***********************************************************************/

	// Não foi possível processar sua solicitação!
	public static final Integer ERRO_SISTEMA = 999999;

	// CPF inválido ou não informado
	public static final Integer ERRO_CPF_INVALIDO = 999001;

	// Parametro Global não encontrado
	public static final Integer ERRO_SISTEMA_PARAMETRO_GLOBAL_NAO_ENCONTRADO = 999002;

	/***********************************************************************/
	/*********************** ERROS DE VOUCHER (100) ************************/
	/***********************************************************************/

	// O Voucher informado já foi utilizado!
	public static final Integer ERRO_VOUCHER_UTILIZADO = 100001;

	// O Voucher informado expirou!
	public static final Integer ERRO_VOUCHER_EXPIRADO = 100002;

	// Voucher não encontrado!
	public static final Integer ERRO_VOUCHER_NAO_ENCONTRADO = 100003;

	// Voucher inválido ou não informado
	public static final Integer ERRO_VOUCHER_INVALIDO = 100004;

	// O Voucher informado possui um status inválido, contactar a TI Calcard
	public static final Integer ERRO_VOUCHER_STATUS_INVALIDO = 100005;

	// O Voucher informado ainda não foi emitido
	public static final Integer ERRO_VOUCHER_NAO_EMITIDO = 100006;

	// O Voucher não foi emitido por este Estabelecimento
	public static final Integer ERRO_VOUCHER_ESTABELECIMENT_DIFERENTES = 100007;

	// O Voucher não foi emitido para esta Conta
	public static final Integer ERRO_VOUCHER_CONTA_DIFERENTES = 100008;

	/***********************************************************************/
	/*********************** ERROS DE LOJISTA (150) ***********************/
	/***********************************************************************/

	public static final Integer ERRO_LOJISTA_NAO_ENCONTRADO = 150000;

	/***********************************************************************/
	/*********************** ERROS DE USUARIO (200) ************************/
	/***********************************************************************/

	// Usuario não encontrado!
	public static final Integer ERRO_USUARIO_NAO_ENCONTRADO = 200001;

	// Usuario inválido ou não informado
	public static final Integer ERRO_USUARIO_INVALIDO = 200002;

	/***********************************************************************/
	/*********************** ERROS DE TOKEN (300) **************************/
	/***********************************************************************/

	// Token de Login inválido
	public static final Integer ERRO_TOKEN_LOGIN_INVALIDO = 300001;

	// Token de Sessao inválido
	public static final Integer ERRO_TOKEN_SESSAO_INVALIDO = 300002;

	// Token de Transacao inválido
	public static final Integer ERRO_TOKEN_TRANSACAO_INVALIDO = 300003;

	// Token de Login não encontrado
	public static final Integer ERRO_TOKEN_LOGIN_NAO_ENCONTRADO = 300004;

	// Token de Login informado já foi utilizado
	public static final Integer ERRO_TOKEN_LOGIN_UTILIZADO = 300005;

	// Token de Login informado está expirado
	public static final Integer ERRO_TOKEN_LOGIN_EXPIRADO = 300006;

	// Token de Sessão não encontrado
	public static final Integer ERRO_TOKEN_SESSAO_NAO_ENCONTRADO = 300007;

	/***********************************************************************/
	/*********************** ERROS DE CONTA (400) **************************/
	/***********************************************************************/

	// Conta não encontrada
	public static final Integer ERRO_CONTA_NAO_ENCONTRADA = 400001;

	/***********************************************************************/
	/******************* ERROS DE ESTABELECIMENTO (500) ********************/
	/***********************************************************************/

	// Estabelecimento inválido ou não informado
	public static final Integer ERRO_ESTABELECIMENTO_INVALIDO = 500001;

	// Estabelecimento não encontrado
	public static final Integer ERRO_ESTABELECIMENTO_NAO_ENCONTRADO = 500002;

	// O código do Estabelecimento é inválido ou não foi informado
	public static final Integer ERRO_ESTABELECIMENTO_CODIGO_INVALIDO = 500003;

	// O CNPJ do Estabelecimento é inválido ou não foi informado
	public static final Integer ERRO_ESTABELECIMENTO_CNPJ_INVALIDO = 500004;

	// Já existe um estabelecimento com o Código informado
	public static final Integer ERRO_ESTABELECIMENTO_CODIGO_DUPLICADO = 500005;

	// Estabelecimento inválido
	public static final Integer ERRO_ESTABELECIMENTO_ID_INVALIDO = 500006;

	// Já existe um Estabelecimento cadastrado com este CNPJ!
	public static final Integer ERRO_ESTABELECIMENTO_CNPJ_EXISTENTE = 500007;

	/***********************************************************************/
	/********************** ERROS DE PERIFÉRICO (600) **********************/
	/***********************************************************************/

	// O código do Periférico é inválido ou não foi informado!
	public static final Integer ERRO_PERIFERICO_CODIGO_INVALIDO = 600001;

	// Periféico não encontrado
	public static final Integer ERRO_PERIFERICO_NAO_ENCONTRADO = 600002;

	// Periférico inválido
	public static final Integer ERRO_PERIFERICO_INVALIDO = 600003;

	/***********************************************************************/
	/************************ ERROS DE LOGIN (700) *************************/
	/***********************************************************************/

	// Login inválido
	public static final Integer ERRO_LOGIN_INVALIDO = 700001;

	/***********************************************************************/
	/************************ ERROS DE PERFIL (800) ************************/
	/***********************************************************************/

	// Perfil inválido
	public static final Integer ERRO_PERFIL_INVALIDO = 800001;

	/***********************************************************************/
	/*********************** ERROS DE PROPOSTA (900) ***********************/
	/***********************************************************************/

	// Nome da Proposta inválido
	public static final Integer ERRO_PROPOSTA_NOME_INVALIDO = 900001;

	// CPF da Proposta inválido
	public static final Integer ERRO_PROPOSTA_CPF_INVALIDO = 900002;

	// Sexo da Proposta inválido
	public static final Integer ERRO_PROPOSTA_SEXO_INVALIDO = 900003;

	// Data de nascimento da Proposta inválida!
	public static final Integer ERRO_PROPOSTA_DATA_NASCIMENTO_INVALIDA = 900004;

	// O Usuário informado não possui permissão para cadastrar propostas para o
	// Estabelecimento
	public static final Integer ERRO_PROPOSTA_USUARIO_SEM_PERMISSAO_ESTABELECIMENTO = 900005;

	// Os dados básicos da Proposta são inválidos ou não foram informados!
	public static final Integer ERRO_PROPOSTA_DADOS_BASICOS_INVALIDOS = 900006;

	// Proposta não encontrada!
	public static final Integer ERRO_PROPOSTA_NAO_ENCONTRADA = 900007;

	// Proposta P1 não está aprovada!
	public static final Integer ERRO_PROPOSTA_P1_NAO_APROVADA = 900008;

	public static final Integer ERRO_PROPOSTA_DADOS_COMPLEMENTARES_INVALIDOS = 900009;

	public static final Integer ERRO_PROPOSTA_OUTROS_DOCUMENTOS_INVALIDOS = 900010;

	public static final Integer ERRO_PROPOSTA_DADOS_RESIDENCIAIS_INVALIDOS = 900011;

	public static final Integer ERRO_PROPOSTA_CONTATOS_INVALIDOS = 900012;

	public static final Integer ERRO_PROPOSTA_REFERENCIAS_INVALIDAS = 900013;

	public static final Integer ERRO_PROPOSTA_DADOS_PROFISSIONAIS_INVALIDOS = 900014;

}
