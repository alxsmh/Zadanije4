package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import enums.ECargoType;

import org.junit.Assert;
import input.FileInput;
import input.RouteParser;
import logic.UnitBuilder;
import logic.UnitLoadManager;
import logic.UnitManager;

public class UnitLoadManagerTest {

	UnitLoadManager ulManager = new UnitLoadManager();
	UnitManager unM = new UnitManager();
	
	@Test
	public void testLoadUnitByTypeUnitListStringInt() throws Exception {	

		
			String routeType = "E";
			String cargoTypes = "oil";			
			int quantitys = 164;
			
			UnitBuilder a = new UnitBuilder(cargoTypes,quantitys,routeType);
			
			ulManager.loadUnitByType(a.getWagonList(), ECargoType.getTypeOnString(cargoTypes).name(), quantitys);
		
		Assert.assertEquals(unM.calculateCurrentLoad(a.getWagonList()), 164);
	}

	@Test
	public void testLoadUnitByTypeUnitListStringArrayIntArray() throws Exception {
		List<String[]> arp = new ArrayList<String[]>();
		List<UnitBuilder> result = new ArrayList<UnitBuilder>();
		
		try 
		{
			arp = FileInput.readFile("W:\\inputFile.txt");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String[] line : arp)
		{
			String routeType = RouteParser.getRoute(line);
			String[] cargoTypes = RouteParser.getCargos(line);			
			int[] quantitys = RouteParser.getWeights(line);
			
			UnitBuilder a = new UnitBuilder(cargoTypes,quantitys,routeType);
			
			ulManager.loadUnitByType(a.getWagonList(), cargoTypes, quantitys);

			result.add(a);
		}
		
		Assert.assertEquals(unM.calculateCurrentLoad(result.get(0).getWagonList()), 504);
	}

	@Test
	public void testUnloadUnitByType() throws Exception {
		String routeType = "E";
		String cargoTypes = "oil";			
		int quantitys = 164;
		
		UnitBuilder a = new UnitBuilder(cargoTypes,quantitys,routeType);
		
		ulManager.loadUnitByType(a.getWagonList(), ECargoType.getTypeOnString(cargoTypes).name(), quantitys);
	
		ulManager.unloadUnitByType(a.getWagonList(), ECargoType.getTypeOnString(cargoTypes).name(), 50);
		
		Assert.assertEquals(unM.calculateCurrentLoad(a.getWagonList()), 114);
	}


}
