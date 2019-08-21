package tests;

import org.junit.Assert;
import org.junit.Test;

import entity.UnitList;
import logic.UnitBuilder;
import factory.TrainFactory;
import factory.WagonFactory;

public class UnitBuilderTest {

	WagonFactory wFact = new WagonFactory();
	TrainFactory tFact = new TrainFactory();
	
	@Test
	public void testGetWagonList() throws Exception {
		UnitBuilder a = new UnitBuilder();
		UnitList wagons = new UnitList();
		
		for (int i = 0; i < 3; i++)
		{
			wagons.addElement(wFact.create("PASSANGERS", "E"));
		}
		
		a.setWagonList(wagons);
		
		Assert.assertEquals(wagons, a.getWagonList());
		
	}

	@Test
	public void testSetWagonList() throws Exception {
		UnitBuilder a = new UnitBuilder();
		UnitList wagons = new UnitList();
		
		for (int i = 0; i < 3; i++)
		{
			wagons.addElement(wFact.create("PASSANGERS", "E"));
		}
		
		a.setWagonList(wagons);
		
		Assert.assertEquals(wagons, a.getWagonList());
	}

	@Test
	public void testGetTrainList() throws Exception {
		UnitBuilder a = new UnitBuilder();
		UnitList trains = new UnitList();
		
		
		for (int i = 0; i < 2; i++)
		{
			trains.addElement(tFact.create("e",5800));
		}
		
		a.setTrainList(trains);
		
		Assert.assertEquals(trains, a.getTrainList());
	}

	@Test
	public void testSetTrainList() throws Exception {
		UnitBuilder a = new UnitBuilder();
		UnitList trains = new UnitList();
		
		for (int i = 0; i < 2; i++)
		{
			trains.addElement(tFact.create("e",5800));
		}
		
		a.setTrainList(trains);
		
		Assert.assertEquals(trains, a.getTrainList());
	}

	@Test
	public void testBuildWagons() throws Exception {
		UnitBuilder a = new UnitBuilder();
		UnitList expected = new UnitList();
		
		a.buildWagons("OIL", 120, "D");
			
		for (int i = 0; i < 2; i++)
		{
			expected.addElement(wFact.create("OIL","D"));
		}
		
		Assert.assertEquals(expected, a.getWagonList() );
	}

	@Test
	public void testToString() throws Exception {
		UnitBuilder a = new UnitBuilder();
		
		a.buildWagons("oil", 120, "D");
			
		Assert.assertNotNull(a.toString());
	}

}
