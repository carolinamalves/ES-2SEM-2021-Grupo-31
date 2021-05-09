package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.github.javaparser.ParseException;

import Metrics.CYCLO_method;

class CYCLO_methodTest {
	protected String file;
	protected CYCLO_method cM;
	@Test
	void testCYCLO_method() {

	}

	@Test
	void testGetMethodLineNumbers() {

	}

	@Test
	void testGetContador() throws ParseException, IOException {
		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		cM=new CYCLO_method(file);

	}
}