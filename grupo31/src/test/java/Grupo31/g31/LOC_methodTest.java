package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.github.javaparser.ParseException;

import Metrics.LOC_method;

class LOC_methodTest {
	protected String file;
	protected LOC_method lM;
	protected ArrayList<Integer> a;
	@Test
	void testLOC_method() {

	}

	@Test
	void testGetMethodLineNumbers() {

	}

	@Test
	public void testGetTotal() throws ParseException, IOException {
		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		lM=new LOC_method(file);
		assertEquals(a,lM.getList());
	}
}