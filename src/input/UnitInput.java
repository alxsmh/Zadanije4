/**
 * Class for reading file and building the unit from extracted params
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Cargo
 * @see ICargo
 * @see UnitBuilder
 * @see LoadManager
 * @see RouteParser
 */
package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import logic.UnitBuilder;
import logic.UnitLoadManager;


public class UnitInput {
	private static final Logger LOG = LogManager.getLogger(UnitInput.class);
	
	/**
	 * Built Units according to strings in inputed file
	 * @param path string to file
	 * @return List<UnitBuilder>
	 */
	public static List<UnitBuilder> buildUnitsFromFile(String path)
	{
		List<String[]> arp = new ArrayList<String[]>();
		
		List<UnitBuilder> result = new ArrayList<UnitBuilder>();
		
		// file read
		try 
		{
			arp = FileInput.readFile(path);
		} 
		catch (IOException e) 
		{
			LOG.error(e);
			return null;
		}
		
		//for loading cargos
		UnitLoadManager ust = new UnitLoadManager();
		
		//each string of file
		for (String[] line : arp)
		{
			//get characteristics from filename path
			String routeType = RouteParser.getRoute(line);
			String[] cargoTypes = RouteParser.getCargos(line);			
			int[] quantitys = RouteParser.getWeights(line);
			
			//build train from factory (has empty load)
			UnitBuilder a = new UnitBuilder(cargoTypes,quantitys,routeType);	
			
			//load builded train from file
			ust.loadUnitByType(a.getWagonList(), cargoTypes, quantitys);
			
			//add
			result.add(a);
		}
		
		LOG.info("Unit input done sucsessfuly");
		return result;
	}
}
