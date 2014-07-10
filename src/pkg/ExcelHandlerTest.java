package pkg;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelHandlerTest {

	@Test
	public void testGetCellValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testSGetCellValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAlphaNumeric() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLetter() {
		for (int i = 0; i < 25; i++){
			assertTrue("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i)==ExcelHandler.getLetter(i));
		}
	}

}
