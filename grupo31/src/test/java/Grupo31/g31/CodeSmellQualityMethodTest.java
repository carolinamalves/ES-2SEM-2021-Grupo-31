package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import Rules.CodeSmellQualityMethod;

class CodeSmellQualityMethodTest {
	protected File file1;
	protected File file2;
	protected CodeSmellQualityMethod cM=new CodeSmellQualityMethod();
	@Test
	void testCompareValues() throws IOException 
	{
		file1=new File("C:\\Users\\carol\\Desktop\\src_metrics.xlsx");
		file2=new File("C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\Code_Smells.xlsx");
		cM.compareValues(file1.toString(), file2.toString());
		assertEquals(5,cM.FN);
		assertNotNull(cM.FN);
		
	}

}
