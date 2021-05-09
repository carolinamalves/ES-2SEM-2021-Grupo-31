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
	void testGetContador() throws ParseException, IOException {
		file=("C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasm\\compiler\\SourceCodeParser.java");
		cM=new CYCLO_method(file);
		
		assertEquals(15,cM.getContador().size());
		assertNotNull(cM.getContador().size());
	}

}
