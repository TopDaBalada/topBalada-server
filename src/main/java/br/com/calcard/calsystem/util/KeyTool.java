package br.com.calcard.calsystem.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class KeyTool {

	private KeyPair keyPair = null;
	private Cipher cipher = null;
	private KeyPairGenerator keyPairGenerator = null;
	private KeyFactory keyFactory = null;

	public KeyTool(KeyPair keyPair) {
		init();
		this.keyPair = keyPair;
	}

	public KeyTool() {
		init();
	}

	private void init() {
		try {
			// Security.addProvider(new BouncyCastleProvider());
			// cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding", "BC");
			cipher = Cipher.getInstance("RSA");
			// keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024, new SecureRandom());
			// keyFactory = KeyFactory.getInstance("RSA", "BC");
			keyFactory = KeyFactory.getInstance("RSA");

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		KeyTool en = new KeyTool();
		en.DistributePubKey();

		//en.critografarComCheve();

	}

	public void DistributePubKey() {

		gerarChave();

		String pubKeyStr = keyToString(keyPair.getPublic());

		String privKeyStr = keyToString(keyPair.getPrivate());

		System.out.println("++++++++++ public key +++++++++");
		System.out.println(pubKeyStr);
		System.out.println("++++++++++++++++++++++++++");

		System.out.println("++++++++++ private key +++++++++");
		System.out.println(privKeyStr);
		System.out.println("++++++++++++++++++++++++++");

		Key pubKey2 = stringToKey(pubKeyStr);

		Key privKey2 = stringToKey(privKeyStr);

		String cipherText = criptografar(pubKey2, "gustavo");

		System.out.println("++++++++ mensagem criptografada +++++++++++");
		System.out.println(cipherText);
		System.out.println("++++++++++++++++++++++++++++++");

		String mensagem = descriptografar(privKey2, cipherText);

		// System.out.println("cripto : " + new Gson().toJson(cipherText));

		System.out.println("plain : " + mensagem);

	}

	public KeyPair gerarChave() {
		keyPair = keyPairGenerator.generateKeyPair();
		return keyPair;
	}

	public String keyToString(Key key) {

		byte[] publicKeyBytes = key.getEncoded();

		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(publicKeyBytes);

	}

	public Key stringToKey(String key) {

		try {
			// Convert PublicKeyString to Byte Stream
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] sigBytes2 = decoder.decodeBuffer(key);

			// Convert the public key bytes into a PublicKey object
			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes2);

			return keyFactory.generatePublic(x509KeySpec);

		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String criptografar(Key key, String mensagem) {

		// encryption step
		try {

			BASE64Encoder enconder = new BASE64Encoder();

			cipher.init(Cipher.ENCRYPT_MODE, key, new SecureRandom());
			// cipher.init(Cipher.ENCRYPT_MODE, key);

			return enconder.encode(cipher.doFinal(mensagem.getBytes()));

		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		return null;
		// System.out.println("cipher: " + Utils.toHex(cipherText));

	}

	public String descriptografar(Key key, String mensagem) {

		// decryption step
		try {

			BASE64Decoder decoder = new BASE64Decoder();
			byte[] m = decoder.decodeBuffer(mensagem);

			cipher.init(Cipher.DECRYPT_MODE, key);

			byte[] plainText = null;

			return new String(cipher.doFinal(m));

		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

	public KeyFactory getKeyFactory() {
		return keyFactory;
	}

	public KeyPair getKeyPair() {
		return keyPair;
	}

	public Cipher getCipher() {
		return cipher;
	}

	public KeyPairGenerator getKeyPairGenerator() {
		return keyPairGenerator;
	}

}