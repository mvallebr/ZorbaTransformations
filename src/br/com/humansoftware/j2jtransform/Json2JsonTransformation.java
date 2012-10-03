package br.com.humansoftware.j2jtransform;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.zorbaxquery.api.xqj.ZorbaXQDataSource;

public class Json2JsonTransformation {
	private XQDataSource xqs;
	private String transformation;
	private XQConnection conn;
	private XQPreparedExpression expression;

	public Json2JsonTransformation(String transformation) {
		// System.loadLibrary("zorba_api");
		xqs = new ZorbaXQDataSource();
		this.transformation = transformation;
	}

	public Json2JsonTransformation(InputStream Transformation) throws IOException {
		this(readFile(Transformation));
	}

	public void connect() throws XQException, Json2JsonTransformationException {
		if (conn != null)
			throw new Json2JsonTransformationException(
					"Already connected, please disconnect first");

		conn = xqs.getConnection();
	}

	public void disconnect() throws XQException {
		if (conn != null)
			conn.close(); // Closing connection to the Database.
		conn = null;
	}

	public String transform(String origin) throws XQException, IOException,
			Json2JsonTransformationException {
		if (conn == null)
			throw new Json2JsonTransformationException(
					"Not connected, please connect first");
		expression = conn.prepareExpression(transformation);
		StringBuffer buffer = new StringBuffer();
		expression.bindString(new QName("inputdoc"), origin, null);
		XQResultSequence res = expression.executeQuery();
		while (res.next())
			buffer.append(res.getItemAsString(null));
		return buffer.toString();
	}

	public String transform(InputStream origin) throws XQException,
			IOException, Json2JsonTransformationException {
		return transform(readFile(origin));
	}

	public static String readFile(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		StringBuilder fileData = new StringBuilder();
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			fileData.append(buf, 0, numRead);
		}
		reader.close();
		return fileData.toString();
	}

}
