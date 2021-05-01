package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.github.javaparser.ParseException;

class LOC_methodTest {
	protected String file;
	protected LOC_method lM;
	@Test
	void testLOC_method() {
	
	}

	@Test
	void testGetMethodLineNumbers() {
		
	}

	@Test
	void testGetTotal() throws ParseException, IOException {
		file="C:\\Users\\admin\\Desktop\\jasml\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		lM=new LOC_method(file);
		assertEquals(0,lM.getTotal());
	}



}
