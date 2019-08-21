package tests;

import org.junit.Test;

import entity.Cargo;
import factory.TrainFactory;

import org.junit.Assert;

public class TrainFactoryTest {

	@Test
	public void testCreate() throws Exception {
		TrainFactory fact = new TrainFactory();
		Cargo a = (Cargo) fact.create("D", 7500);
		
		Assert.assertTrue(a.isTrain());
	}

}
