package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import logic.UnitBuilder;
import logic.UnitLoadManager;


public class UnitInput {
	
	public static List<UnitBuilder> buildUnitsFromFile(String path)
	{
		List<String[]> arp = new ArrayList<String[]>();
		
		List<UnitBuilder> result = new ArrayList<UnitBuilder>();
		
		try 
		{
			arp = FileInput.readFile(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		UnitLoadManager ust = new UnitLoadManager();
		
		for (String[] line : arp)
		{
			//get characteristics from filename path
			String routeType = RouteParser.getRoute(line);
			String[] cargoTypes = RouteParser.getCargos(line);			
			int[] quantitys = RouteParser.getWeights(line);
			
			//build train from factory (has empty load)
			UnitBuilder a = new UnitBuilder(cargoTypes,quantitys,routeType);
			
			//ShowUnit.printUnit(a.getWagonList());
			
			//load builded train from file
			ust.loadUnitByType(a.getWagonList(), cargoTypes, quantitys);
			
			//ShowUnit.printBuildedUnit(a);
			//add
			result.add(a);
			//result.add(new UnitBuilder(cargoTypes,quantitys,routeType));
		}
		
		return result;
	}
}
