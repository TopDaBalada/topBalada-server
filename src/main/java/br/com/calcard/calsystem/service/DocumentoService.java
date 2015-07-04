package br.com.calcard.calsystem.service;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.calframework.exception.DAOException;
import br.com.calcard.calframework.service.ServiceException;
import br.com.calcard.calsystem.dto.DocumentoDTO;
import br.com.calcard.calsystem.entity.ParametroGlobal;
import br.com.calcard.calsystem.exception.ParametroGlobalNaoEncontradoException;
import br.com.calcard.calsystem.exception.documento.DocumentoException;
import br.com.calcard.calsystem.util.ListagemArquivosFilter;

@Service
// @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DocumentoService {

	private ParametroService parametroService;

	@Autowired
	public DocumentoService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	public DocumentoDTO doGerarMiniaturas(String numProposta)
			throws ServiceException, DAOException,
			ParametroGlobalNaoEncontradoException, DocumentoException {

		if (numProposta == null)
			throw new ServiceException("ID da proposta não informado!");

		DocumentoDTO newDoc = new DocumentoDTO();

		newDoc.setCaminhoDocumento(parametroService.doConsultar(
				ParametroGlobal.PARAMETRO_CAMINHO_DOCUMENTO_DIGITALIZADO)
				.getValorTexto());

		newDoc.setNomeDocumento(numProposta);

		newDoc.setProporcaoThm(parametroService
				.doConsultar(ParametroGlobal.PARAMETRO_PROPORCAO_THUMB)
				.getValorNumero().doubleValue());

		newDoc.setFormatoDocumento(parametroService.doConsultar(
				ParametroGlobal.PARAMETRO_FORMATO_ARQUIVO).getValorTexto());

		File[] listaArquivos = doListarArquivosRede(
				newDoc.getCaminhoDocumento(), newDoc.getNomeDocumento(),
				newDoc.getFormatoDocumento());

		List<String> lista = new ArrayList<String>();

		for (int i = 0; i < listaArquivos.length; i++)
			lista.add(doCriarThm(listaArquivos[i].getName().toString(), newDoc));

		newDoc.setListaBase64(lista);

		return newDoc;

	}

	private File[] doListarArquivosRede(String localArquivo,
			String nomeArquivo, String extensaoArquivo)
			throws DocumentoException {

		File file = new File(localArquivo + nomeArquivo + extensaoArquivo);

		if (file.exists()) {

			File base = new File(localArquivo);

			ListagemArquivosFilter filtrarArquivos = new ListagemArquivosFilter();
			filtrarArquivos.setFiltro(nomeArquivo);

			return base.listFiles(filtrarArquivos);

		} else {
			throw new DocumentoException(
					"Não foram localizados documentos na rede.");
		}
	}

	private BufferedImage scale(BufferedImage source, double ratio) {
		int w = (int) (source.getWidth() * ratio);
		int h = (int) (source.getHeight() * ratio);
		BufferedImage bi = getCompatibleImage(w, h);
		Graphics2D g2d = bi.createGraphics();
		double xScale = (double) w / source.getWidth();
		double yScale = (double) h / source.getHeight();
		AffineTransform at = AffineTransform.getScaleInstance(xScale, yScale);
		g2d.drawRenderedImage(source, at);
		g2d.dispose();
		return bi;
	}

	private BufferedImage getCompatibleImage(int w, int h) {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		BufferedImage image = gc.createCompatibleImage(w, h);
		return image;
	}

	private String doCriarThm(String nome, DocumentoDTO newDoc)
			throws DocumentoException {

		try {

			BufferedImage img = ImageIO.read(new File(newDoc
					.getCaminhoDocumento() + nome));

			String base = doConverterBase64(
					scale(img, newDoc.getProporcaoThm()),
					newDoc.getFormatoDocumento(), newDoc);

			return base;

		} catch (IOException e) {
			throw new DocumentoException("Não foi possível criar miniatura.", e);
		}
	}

	private String doConverterBase64(BufferedImage image, String type,
			DocumentoDTO newDoc) throws DocumentoException {

		try {

			type = newDoc.getFormatoDocumento().replace(".", "");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(image, type, out);
			byte[] bytes = out.toByteArray();

			String base64bytes = org.apache.commons.codec.binary.Base64
					.encodeBase64String(bytes);

			String base = "data:image/" + type + ";base64,";
			base = base + base64bytes;

			newDoc.setCorpo(base);

			return newDoc.getCorpo();

		} catch (IOException e) {
			throw new DocumentoException(
					"Não foi possível converter a miniatura em Base64.", e);
		}

	}

	public void doDescartarDocumentos(String idProposta,
			String localDocumentos, String extensaoDocumentos)
			throws DocumentoException {

		for (File arquivo : Arrays.asList(this.doListarArquivosRede(
				localDocumentos, idProposta, extensaoDocumentos)))
			arquivo.delete();

	}

}
