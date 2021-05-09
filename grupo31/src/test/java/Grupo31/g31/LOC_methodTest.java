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
	public void testGetTotal() throws ParseException, IOException {
		file="C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasml\\compiler\\SourceCodeParser.java";
		lM=new LOC_method(file);
		assertEquals(a,lM.getList());
		assertNotNull(lM.getList());
	}



}
