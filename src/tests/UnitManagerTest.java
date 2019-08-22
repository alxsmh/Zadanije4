package tests;

import org.junit.Test;

import exceptions.ElementNotFoundException;

import org.junit.Assert;
import logic.UnitBuilder;
import logic.UnitLoadManager;
import logic.UnitManager;

public class UnitManagerTest {
	
	UnitBuilder unBuilder = new UnitBuilder();
	UnitLoadManager unLoader = new UnitLoadManager();
	UnitManager unManager = new UnitManager();
	
	@Test
	public void testCalculateCurrentLoad() throws Exception {
		unBuilder.buildUnit("cars", 124, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 1);
		
		Assert.assertEquals(unManager.calculateCurrentLoad(unBuilder.getWagonList()), 1);
		
	}

	@Test
	public void testCalculateMaxLoad() throws Exception {
		unBuilder.buildUnit("cars", 124, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 1);
		
		Assert.assertEquals(unManager.calculateMaxLoad(unBuilder.getWagonList()), 140);
	}

	@Test
	public void testCalculateEmpty() throws Exception {
		unBuilder.buildUnit("cars", 124, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 69);
		
		Assert.assertEquals(unManager.calculateEmpty(unBuilder.getWagonList()), 2);
	}

	@Test
	public void testCalculateNotEmpty() throws Exception {
		unBuilder.buildUnit("cars", 160, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 100);
		
		Assert.assertEquals(unManager.calculateNotEmpty(unBuilder.getWagonList()), 3);
	}

	@Test
	public void testFindByLoad() throws Exception {
		unBuilder.buildUnit("cars", 124, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 69);
		
		Assert.assertEquals(unManager.findByLoad(unBuilder.getWagonList(),34), 1);
	}

	@Test
	public void testFindBetweenLoad() throws Exception {
		unBuilder.buildUnit("pass", 500, "D");
		
		unLoader.loadPassangers(unBuilder.getWagonList(), 520);
		
		int pos = 0;
		
		try
		{
			pos = unManager.findBetweenLoad(unBuilder.getWagonList(),0,70);
		}
		catch (ElementNotFoundException e)
		{
			
		}
		
		Assert.assertEquals(pos, 6);
	}

	@Test
	public void testCalculateWagonsByType() throws Exception {
		String[] cargos = new String[] {"salt","oil"};
		int[] capp = new int[] {200,320};
		
		unBuilder.buildUnit(cargos, capp, "D");
		
		Assert.assertEquals(unManager.calculateWagonsByType(unBuilder.getWagonList(), "OIL"),5);
	}

	@Test
	public void testCalculateMaxLoadByType() throws Exception {
		String[] cargos = new String[] {"salt","oil"};
		int[] capp = new int[] {200,320};
		
		unBuilder.buildUnit(cargos, capp, "D");
		
		Assert.assertEquals(unManager.calculateMaxLoadByType(unBuilder.getWagonList(), "OIL"),325);
	}

	@Test
	public void testCalculateCurrentLoadByType() throws Exception {
		String[] cargos = new String[] {"salt","oil"};
		int[] capp = new int[] {200,320};
		
		unBuilder.buildUnit(cargos, capp, "D");
		
		unLoader.loadUnitByType(unBuilder.getWagonList(), "CARS", 200);
		unLoader.loadUnitByType(unBuilder.getWagonList(), "oil", 320);
		
		Assert.assertEquals(unManager.calculateCurrentLoadByType(unBuilder.getWagonList(), "salt"),200);
	}

}
