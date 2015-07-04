package br.com.calcard.calsystem.ws;

public class IDsExcecao {

	/***********************************************************************/
	/************************ ERROS GEN�RICOS (999) ************************/
	/***********************************************************************/

	// N�o foi poss�vel processar sua solicita��o!
	public static final Integer ERRO_SISTEMA = 999999;

	// CPF inv�lido ou n�o informado
	public static final Integer ERRO_CPF_INVALIDO = 999001;

	// Parametro Global n�o encontrado
	public static final Integer ERRO_SISTEMA_PARAMETRO_GLOBAL_NAO_ENCONTRADO = 999002;

	/***********************************************************************/
	/*********************** ERROS DE VOUCHER (100) ************************/
	/***********************************************************************/

	// O Voucher informado j� foi utilizado!
	public static final Integer ERRO_VOUCHER_UTILIZADO = 100001;

	// O Voucher informado expirou!
	public static final Integer ERRO_VOUCHER_EXPIRADO = 100002;

	// Voucher n�o encontrado!
	public static final Integer ERRO_VOUCHER_NAO_ENCONTRADO = 100003;

	// Voucher inv�lido ou n�o informado
	public static final Integer ERRO_VOUCHER_INVALIDO = 100004;

	// O Voucher informado possui um status inv�lido, contactar a TI Calcard
	public static final Integer ERRO_VOUCHER_STATUS_INVALIDO = 100005;

	// O Voucher informado ainda n�o foi emitido
	public static final Integer ERRO_VOUCHER_NAO_EMITIDO = 100006;

	// O Voucher n�o foi emitido por este Estabelecimento
	public static final Integer ERRO_VOUCHER_ESTABELECIMENT_DIFERENTES = 100007;

	// O Voucher n�o foi emitido para esta Conta
	public static final Integer ERRO_VOUCHER_CONTA_DIFERENTES = 100008;

	/***********************************************************************/
	/*********************** ERROS DE LOJISTA (150) ***********************/
	/***********************************************************************/

	public static final Integer ERRO_LOJISTA_NAO_ENCONTRADO = 150000;

	/***********************************************************************/
	/*********************** ERROS DE USUARIO (200) ************************/
	/***********************************************************************/

	// Usuario n�o encontrado!
	public static final Integer ERRO_USUARIO_NAO_ENCONTRADO = 200001;

	// Usuario inv�lido ou n�o informado
	public static final Integer ERRO_USUARIO_INVALIDO = 200002;

	/***********************************************************************/
	/*********************** ERROS DE TOKEN (300) **************************/
	/***********************************************************************/

	// Token de Login inv�lido
	public static final Integer ERRO_TOKEN_LOGIN_INVALIDO = 300001;

	// Token de Sessao inv�lido
	public static final Integer ERRO_TOKEN_SESSAO_INVALIDO = 300002;

	// Token de Transacao inv�lido
	public static final Integer ERRO_TOKEN_TRANSACAO_INVALIDO = 300003;

	// Token de Login n�o encontrado
	public static final Integer ERRO_TOKEN_LOGIN_NAO_ENCONTRADO = 300004;

	// Token de Login informado j� foi utilizado
	public static final Integer ERRO_TOKEN_LOGIN_UTILIZADO = 300005;

	// Token de Login informado est� expirado
	public static final Integer ERRO_TOKEN_LOGIN_EXPIRADO = 300006;

	// Token de Sess�o n�o encontrado
	public static final Integer ERRO_TOKEN_SESSAO_NAO_ENCONTRADO = 300007;

	/***********************************************************************/
	/*********************** ERROS DE CONTA (400) **************************/
	/***********************************************************************/

	// Conta n�o encontrada
	public static final Integer ERRO_CONTA_NAO_ENCONTRADA = 400001;

	/***********************************************************************/
	/******************* ERROS DE ESTABELECIMENTO (500) ********************/
	/***********************************************************************/

	// Estabelecimento inv�lido ou n�o informado
	public static final Integer ERRO_ESTABELECIMENTO_INVALIDO = 500001;

	// Estabelecimento n�o encontrado
	public static final Integer ERRO_ESTABELECIMENTO_NAO_ENCONTRADO = 500002;

	// O c�digo do Estabelecimento � inv�lido ou n�o foi informado
	public static final Integer ERRO_ESTABELECIMENTO_CODIGO_INVALIDO = 500003;

	// O CNPJ do Estabelecimento � inv�lido ou n�o foi informado
	public static final Integer ERRO_ESTABELECIMENTO_CNPJ_INVALIDO = 500004;

	// J� existe um estabelecimento com o C�digo informado
	public static final Integer ERRO_ESTABELECIMENTO_CODIGO_DUPLICADO = 500005;

	// Estabelecimento inv�lido
	public static final Integer ERRO_ESTABELECIMENTO_ID_INVALIDO = 500006;

	// J� existe um Estabelecimento cadastrado com este CNPJ!
	public static final Integer ERRO_ESTABELECIMENTO_CNPJ_EXISTENTE = 500007;

	/***********************************************************************/
	/********************** ERROS DE PERIF�RICO (600) **********************/
	/***********************************************************************/

	// O c�digo do Perif�rico � inv�lido ou n�o foi informado!
	public static final Integer ERRO_PERIFERICO_CODIGO_INVALIDO = 600001;

	// Perif�ico n�o encontrado
	public static final Integer ERRO_PERIFERICO_NAO_ENCONTRADO = 600002;

	// Perif�rico inv�lido
	public static final Integer ERRO_PERIFERICO_INVALIDO = 600003;

	/***********************************************************************/
	/************************ ERROS DE LOGIN (700) *************************/
	/***********************************************************************/

	// Login inv�lido
	public static final Integer ERRO_LOGIN_INVALIDO = 700001;

	/***********************************************************************/
	/************************ ERROS DE PERFIL (800) ************************/
	/***********************************************************************/

	// Perfil inv�lido
	public static final Integer ERRO_PERFIL_INVALIDO = 800001;

	/***********************************************************************/
	/*********************** ERROS DE PROPOSTA (900) ***********************/
	/***********************************************************************/

	// Nome da Proposta inv�lido
	public static final Integer ERRO_PROPOSTA_NOME_INVALIDO = 900001;

	// CPF da Proposta inv�lido
	public static final Integer ERRO_PROPOSTA_CPF_INVALIDO = 900002;

	// Sexo da Proposta inv�lido
	public static final Integer ERRO_PROPOSTA_SEXO_INVALIDO = 900003;

	// Data de nascimento da Proposta inv�lida!
	public static final Integer ERRO_PROPOSTA_DATA_NASCIMENTO_INVALIDA = 900004;

	// O Usu�rio informado n�o possui permiss�o para cadastrar propostas para o
	// Estabelecimento
	public static final Integer ERRO_PROPOSTA_USUARIO_SEM_PERMISSAO_ESTABELECIMENTO = 900005;

	// Os dados b�sicos da Proposta s�o inv�lidos ou n�o foram informados!
	public static final Integer ERRO_PROPOSTA_DADOS_BASICOS_INVALIDOS = 900006;

	// Proposta n�o encontrada!
	public static final Integer ERRO_PROPOSTA_NAO_ENCONTRADA = 900007;

	// Proposta P1 n�o est� aprovada!
	public static final Integer ERRO_PROPOSTA_P1_NAO_APROVADA = 900008;

	public static final Integer ERRO_PROPOSTA_DADOS_COMPLEMENTARES_INVALIDOS = 900009;

	public static final Integer ERRO_PROPOSTA_OUTROS_DOCUMENTOS_INVALIDOS = 900010;

	public static final Integer ERRO_PROPOSTA_DADOS_RESIDENCIAIS_INVALIDOS = 900011;

	public static final Integer ERRO_PROPOSTA_CONTATOS_INVALIDOS = 900012;

	public static final Integer ERRO_PROPOSTA_REFERENCIAS_INVALIDAS = 900013;

	public static final Integer ERRO_PROPOSTA_DADOS_PROFISSIONAIS_INVALIDOS = 900014;

}
