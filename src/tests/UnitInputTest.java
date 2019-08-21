package tests;

import org.junit.Test;
import input.UnitInput;
import org.junit.Assert;

public class UnitInputTest {

	@Test
	public void testBuildUnitsFromFile() throws Exception {
		
		Assert.assertNotNull(UnitInput.buildUnitsFromFile("W:\\inputFile.txt").get(0).getTrainList().toString());
	}

}
