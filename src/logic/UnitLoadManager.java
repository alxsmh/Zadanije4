package logic;

import entity.ICargo;
import entity.UnitList;
import enums.ECargoType;

public class UnitLoadManager {
	
	private UnitManager unMang;
	
	public UnitLoadManager()
	{
		unMang = (unMang == null) ? new UnitManager():unMang;
	}
	
	public void loadUnitByType(UnitList unit, String cargoType, int cappacity)
	{
		if(cappacity - (unMang.calculateMaxLoadByType(unit, cargoType) - unMang.calculateCurrentLoadByType(unit,cargoType)) > 0)
		{
			//Impossible to overload
			System.out.print(unMang.calculateMaxLoadByType(unit, cargoType));
		}
		else
		{
			for (ICargo item: unit.getCompound())
			{   								
				if (item.getStringType().equals(cargoType))
				{
					int canLoad = item.getWeigth() - item.getCurrentLoad();
					
					item.load(cappacity);
					
					cappacity -= canLoad;
					
					if (cappacity < 0)
					{
						return;
					}				
				}			
			}
		}
	}
	
	public void loadUnitByType(UnitList unit, String[] cargoType, int[] cappacity)
	{
		int i = 0;
		
		for(String item: cargoType)
		{
			loadUnitByType(unit, ECargoType.getTypeOnString(item).name(), cappacity[i++]);
		}
		
	}
	
	public void unloadUnitByType(UnitList unit, String cargoType, int cappacity)
	{
		if((unMang.calculateCurrentLoadByType(unit,cargoType)) - cappacity < 0)
		{
			//Impossible to get more than loaded
			
		}
		else
		{
			for (ICargo item: unit.getCompound())
			{  				
				if (item.getStringType().equals(cargoType))
				{
					int canUnload = item.getCurrentLoad();
					
					item.unload((cappacity > canUnload) ? canUnload:cappacity);
					
					cappacity -= canUnload;
					
					if (cappacity < 0)
					{
						return;
					}
				}
			}
		}
	}

	public void loadPassangers(UnitList unit, int passangersCount)
	{
		loadUnitByType(unit, ECargoType.valueOf("PASSANGERS").name(), passangersCount);
	}
	
	public void unloadPassangers(UnitList unit, int passangersCount)
	{
		unloadUnitByType(unit, ECargoType.valueOf("PASSANGERS").name(), passangersCount);
	}
	
}
