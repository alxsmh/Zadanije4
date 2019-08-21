package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import input.FileInput;
import input.RouteParser;

public class RouteParserTest {

	@Test
	public void testGetRoute() throws Exception {
		List<String[]> actual = FileInput.readFile("W:\\inputFile.txt");
		
		String expected = "E";
		
		Assert.assertEquals(expected, RouteParser.getRoute(actual.get(0)));
	}

	@Test
	public void testGetCargos() throws Exception {
		List<String[]> actual = FileInput.readFile("W:\\inputFile.txt");
		
		String[] expected = new String[]  {"COAL", "OIL"};
		
		Assert.assertArrayEquals(expected, RouteParser.getCargos(actual.get(0)));
	}

	@Test
	public void testGetWeights() throws Exception {
		List<String[]> actual = FileInput.readFile("W:\\inputFile.txt");
		
		int[] expected = new int[]  {438, 66};
		
		Assert.assertArrayEquals(expected, RouteParser.getWeights(actual.get(0)));
	}

}
