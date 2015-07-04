package br.com.calcard.calsystem.util;

import java.security.KeyPair;

public class Criptografia {

	public static void main(String args[]) {

		FileKeyTool fileKeyTool = new FileKeyTool();

		// GERA NOVO ARQUIVO E NOVA CHAVE
		KeyPair keyPair = null;// fileKeyTool.gerarArquivos();

		// LE CHEVE DO ARQUIVO EXISTENTE
		// KeyPair keyPair = fileKeyTool.carregarKeyPair();

		KeyTool keyTool = new KeyTool(keyPair);

		// CRIPTOGRAFA USANDO A CHAVE CARREGADA DO ARQUIVO
		String msnCripto = keyTool.criptografar(keyTool.getKeyPair()
				.getPublic(), "gustavo porto da silva");

		// String chavePublicStr = new StringBuilder()
		// .append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvM6OhxrPkAuQcKkOvfUMk1+VJi4HMtN1ZhMle\n")
		// .append("HGjoRvcTIn4R3BNALrOgiq3RsLKvrgVTNw0H5+WOJBu8Ju1E/Hl1sC09eJkRsuCGAFilTYm1ABg1\n")
		// .append("MW080jTmJ9phycUIxi3C2TM4NmnUEyhIGKwJKm1dYqQnmlaf/HLF+PYq9QIDAQAB")
		// .toString();
		//
		// String msnCripto = keyTool.criptografar(
		// keyTool.stringToKey(chavePublicStr), "gustavo porto da silva");

		String msnOriginal = keyTool.descriptografar(keyTool.getKeyPair()
				.getPrivate(), msnCripto);

		System.out.println("============== CHAVE PUBLICA =================");
		System.out.println(keyTool.keyToString(keyPair.getPublic()));
		System.out
				.println("=======================================================");
		System.out
				.println("============== MENSAGEM CRIPTOGRAFADA =================");
		System.out.println(msnCripto);
		System.out
				.println("=======================================================");

		System.out
				.println("============== MENSAGEM ORIGINAL =================");
		System.out.println(msnOriginal);
		System.out
				.println("=======================================================");

	}
}
