package tests;

import org.junit.Test;
import org.junit.Assert;

import enums.ECargoType;

public class ECargoTypeTest {

	@Test
	public void testGetTypeOnString() throws Exception {
		String expected = "LIQUID";
		
		Assert.assertEquals(expected, ECargoType.getTypeOnString("Oil").name());
	}

}
