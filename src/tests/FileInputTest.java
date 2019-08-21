package tests;

import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import input.FileInput;

public class FileInputTest {

	@Test
	public void testReadFile() throws Exception {
		List<String[]> actual = FileInput.readFile("W:\\inputFile.txt");
		
		String[] expected = new String[] {"e", "coal", "438", "oil", "66"};
		
		Assert.assertArrayEquals(expected, actual.get(0));
	}

}
