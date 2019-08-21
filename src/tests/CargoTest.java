package tests;
import entity.Cargo;
import org.junit.Test;
import org.junit.Assert;

public class CargoTest {

	
	
	@Test
	public void testSetQuantity() throws Exception {
		Cargo a = new Cargo("Coal",50);
		a.setQuantity(65);
		
		int expected = 65;
		
		Assert.assertEquals(expected, a.getQuantity());
		
	}

	@Test
	public void testIsTrain() throws Exception {
		Cargo a = new Cargo("Diesel_Engine",2000);
		
		Assert.assertTrue(a.isTrain());
	}

	@Test
	public void testToString() throws Exception {
		Cargo a = new Cargo("Animal",25);
		
		Assert.assertNotNull(a.toString());
	}

	@Test
	public void testGetWeigth() throws Exception {
		Cargo a = new Cargo("Coal",65);
		
		int expected = 65;
		
		Assert.assertEquals(expected, a.getWeigth());
	}

	@Test
	public void testGetStringType() throws Exception {
		Cargo a = new Cargo("Diesel_Engine",6500);
		
		String expected = "Train";
		
		Assert.assertEquals(expected, a.getStringType());
	}

	@Test
	public void testGetCurrentLoad() throws Exception {
		Cargo a = new Cargo("Coal",65);
		
		a.load(10);
		
		int expected = 10;
		
		Assert.assertEquals(expected, a.getCurrentLoad());
	}

}
