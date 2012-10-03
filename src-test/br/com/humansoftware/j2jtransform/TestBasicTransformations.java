package br.com.humansoftware.j2jtransform;


import java.io.IOException;
import java.io.InputStream;

import javax.xml.xquery.XQException;

import org.junit.Before;
import org.junit.Test;

public class TestBasicTransformations {
	Json2JsonTransformation jsonTransformation;

	@Before
	public void setUp() throws Exception {
		InputStream query = this.getClass().getResourceAsStream("/query.json");
		jsonTransformation = new Json2JsonTransformation(query);
	}

	@Test
	public void testBasic1() throws XQException, IOException,
			Json2JsonTransformationException {
		jsonTransformation.connect();
		
		InputStream originData1 = this.getClass().getResourceAsStream(
				"/origin_data.json");
		System.out.println("Transformation result 1 = "
				+ jsonTransformation.transform(originData1));
		InputStream originData2 = this.getClass().getResourceAsStream(
				"/origin_data2.json");
		System.out.println("Transformation result 2 = "
				+ jsonTransformation.transform(originData2));

		jsonTransformation.disconnect();
	}

}
