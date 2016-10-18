package it.govpay.web.rs.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;

public class InputStreamDataSource implements DataSource {

	private String name;
	private String contentType;
	private byte[] bytes;

	public InputStreamDataSource(String name, String contentType, InputStream inputStream) throws IOException {
		int read;			
		this.name = name;
		this.contentType = contentType;

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		byte[] buff = new byte[256];			
		while ((read = inputStream.read(buff)) != -1) {
			baos.write(buff, 0, read);
		}
		baos.flush();
		baos.close();
		this.bytes = baos.toByteArray();
	}
	public InputStreamDataSource(String name, String contentType, byte[] b) throws IOException {
		this.name = name;
		this.contentType = contentType;
		this.bytes = b;
	}

	@Override
	public String getContentType() {
		return this.contentType;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(this.bytes);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(bytes);
		return baos;
	}

}
