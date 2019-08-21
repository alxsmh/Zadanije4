package tests;

import org.junit.Assert;
import org.junit.Test;

import entity.Cargo;
import factory.WagonFactory;

public class WagonFactoryTest {

	@Test
	public void testCreate() throws Exception {
		WagonFactory fact = new WagonFactory();
		Cargo a = (Cargo) fact.create("Oil","D");
		
		Assert.assertTrue(!a.isTrain());
	}

}
