/**
 * Class for loadind unit with cargo
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see UnitList
 * @see UnitManager
 */
package logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.ICargo;
import entity.UnitList;
import enums.ECargoType;

public class UnitLoadManager {
	
	private static final Logger LOG = LogManager.getLogger(UnitLoadManager.class);
	
	private UnitManager unMang;
	
	public UnitLoadManager()
	{
		unMang = (unMang == null) ? new UnitManager():unMang;
		LOG.info("no param constructor call");
	}
	
	/**
	 * Load UnitList items according to items type
	 * @param unit to load
	 * @param cargoType1	cargo name
	 * @param cappacity	quantity to load
	 */
	public void loadUnitByType(UnitList unit, String cargoType1, int cappacity)
	{
		String cargoType = ECargoType.getTypeOnString(cargoType1).name();
		
		//check if possible  to load capacity to UnitList
		if(cappacity - (unMang.calculateMaxLoadByType(unit, cargoType) 
				- unMang.calculateCurrentLoadByType(unit,cargoType)) > 0)
		{
			//Impossible to overload
			LOG.error("Impossible to overload, max possible load is "
			+ unMang.calculateMaxLoadByType(unit, cargoType));
		}
		else
		{
			//foreach ICargo in UnitList
			//Get its load and add a part of cappacity
			//that could fit in
			for (ICargo item: unit.getCompound())
			{   								
				if (item.getStringType().equals(cargoType))
				{
					int canLoad = item.getWeigth() - item.getCurrentLoad();
					
					item.load(cappacity);
					
					cappacity -= canLoad;
					
					if (cappacity < 0)
					{
						LOG.info("unit loaded by " + cargoType1);
						return;
					}				
				}			
			}
		}
	}
	
	/**
	 * Load UnitList items according to items type
	 * @param unit
	 * @param cargoType
	 * @param cappacity
	 */
	public void loadUnitByType(UnitList unit, String[] cargoType, int[] cappacity)
	{
		int i = 0;
		
		for(String item: cargoType)
		{
			loadUnitByType(unit, item, cappacity[i++]);
		}
		
		LOG.info("array unit load");
		
	}
	
	/**
	 * Unload UnitList items according to items type
	 * @param unit to unload
	 * @param cargoType1	cargo name
	 * @param cappacity	quantity to unload
	 */
	public void unloadUnitByType(UnitList unit, String cargoType, int cappacity)
	{
		//check if possible  to unload capacity from UnitList
		if((unMang.calculateCurrentLoadByType(unit,cargoType)) - cappacity < 0)
		{
			//Impossible to get more than loaded
			LOG.error("Impossible to get more than loaded. Current load: " 
			+ unMang.calculateCurrentLoadByType(unit, cargoType));
		}
		else
		{
			//foreach ICargo in UnitList
			//Get its load and unloads a part of cappacity
			//that could be unloaded
			for (ICargo item: unit.getCompound())
			{  				
				if (item.getStringType().equals(cargoType))
				{
					int canUnload = item.getCurrentLoad();
					
					item.unload((cappacity > canUnload) ? canUnload:cappacity);
					
					cappacity -= canUnload;
					
					if (cappacity < 0)
					{
						LOG.info("array unit load by type");
						return;
					}
				}
			}
		}
	}

	/**
	 * Load passangers to UnitList
	 * @param unit
	 * @param passangersCountto load
	 */
	public void loadPassangers(UnitList unit, int passangersCount)
	{
		loadUnitByType(unit, ECargoType.valueOf("PASSANGERS").name(), passangersCount);
	}
	
	/**
	 * Unload passangers to UnitList
	 * @param unit
	 * @param passangersCount to unload
	 */
	public void unloadPassangers(UnitList unit, int passangersCount)
	{
		unloadUnitByType(unit, ECargoType.valueOf("PASSANGERS").name(), passangersCount);
	}
	
}
