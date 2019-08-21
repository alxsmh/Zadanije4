package tests;

import org.junit.Assert;
import org.junit.Test;

import entity.UnitList;
import factory.TrainFactory;

public class UnitListTest {

	TrainFactory fact = new TrainFactory();
	
	@Test
	public void testGetCompound() throws Exception {
		UnitList actual = new UnitList();
		UnitList expected = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		expected.addElement(fact.create("E", 5000));
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testAddElement() throws Exception {
		UnitList actual = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		
		Assert.assertNotNull(actual);
	}

	@Test
	public void testElementAt() throws Exception {
		UnitList actual = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		actual.addElement(fact.create("D", 6000));
		
		Assert.assertEquals(actual.elementAt(0),fact.create("E", 5000));
	}

	@Test
	public void testGetLast() throws Exception {
		UnitList actual = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		actual.addElement(fact.create("D", 6000));
		
		Assert.assertEquals(actual.getLast(),fact.create("D", 6000));
	}

	@Test
	public void testLength() throws Exception {
		UnitList actual = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		actual.addElement(fact.create("D", 6000));
		
		Assert.assertEquals(actual.length(), 2);
	}

	@Test
	public void testToString() throws Exception {
		UnitList actual = new UnitList();
		
		actual.addElement(fact.create("E", 5000));
		actual.addElement(fact.create("D", 6000));
		
		Assert.assertNotNull(actual.toString());
	}

}
