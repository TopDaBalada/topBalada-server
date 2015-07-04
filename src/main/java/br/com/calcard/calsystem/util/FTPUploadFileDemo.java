package br.com.calcard.calsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUploadFileDemo {

	public static void main(String[] args) {
		
		String server = "186.202.67.144";
		int port = 21;
		String user = "calcard";
		String pass = "pg@calcard2015";

		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// APPROACH #1: uploads first file using an InputStream
			File firstLocalFile = new File("C:/teste.txt");

			String firstRemoteFile = "/SMS/ENVIO/Projects.zip";
			InputStream inputStream = new FileInputStream(firstLocalFile);

			System.out.println("Start uploading first file");
			boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
			inputStream.close();
			if (done) {
				System.out.println("The first file is uploaded successfully.");
			}

			// // APPROACH #2: uploads second file using an OutputStream
			// File secondLocalFile = new File("E:/Test/Report.doc");
			// String secondRemoteFile = "test/Report.doc";
			// inputStream = new FileInputStream(secondLocalFile);
			//
			// System.out.println("Start uploading second file");
			// OutputStream outputStream = ftpClient
			// .storeFileStream(secondRemoteFile);
			// byte[] bytesIn = new byte[4096];
			// int read = 0;
			//
			// while ((read = inputStream.read(bytesIn)) != -1) {
			// outputStream.write(bytesIn, 0, read);
			// }
			// inputStream.close();
			// outputStream.close();
			//
			// boolean completed = ftpClient.completePendingCommand();
			// if (completed) {
			// System.out.println("The second file is uploaded successfully.");
			// }

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
