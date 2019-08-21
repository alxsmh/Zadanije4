package logic;

import java.util.Collections;

import entity.ICargo;
import entity.UnitList;

public class UnitManager {
	
	/**
	 * Calculate current load of UnitList
	 * @param a
	 * @return int current load
	 */
	public int calculateCurrentLoad(UnitList a)
	{
		int result = 0;
		int listLen = a.length();
		
		while (--listLen > -1)
		{
			result += a.getCompound().get(listLen).getCurrentLoad();
		}
		
		return result;
	}
	
	/**
	 * Calculate max possible load of UnitList
	 * @param a
	 * @return int max possible load
	 */
	public int calculateMaxLoad(UnitList a)
	{
		int result = 0;
		int listLen = a.length();
		
		while (--listLen > -1)
		{
			result += a.getCompound().get(listLen).getWeigth();
		}
		
		return result;
	}
	
	/**
	 * Calculate number of empty wagons
	 * @param a
	 * @return
	 */
	public int calculateEmpty(UnitList a)
	{
		int result = 0;
		int listLen = a.length();
		
		while (--listLen > -1)
		{
			result += (a.getCompound().get(listLen).getCurrentLoad() > 0 ) ? 0 : 1;
		}
		
		return result;
	}
	
	/**
	 * Calculate number of not empty wagons
	 * @param a
	 * @return
	 */
	public int calculateNotEmpty(UnitList a)
	{
		return a.length() - calculateEmpty(a);
	}
	
	/**
	 * Sort UnitList by current load ASC
	 * @param a
	 * @return
	 */
	public UnitList sortAscByCurrentLoad(UnitList a)
	{
		int size = a.length();
		
		
		//outbound array
		for (int i = 0; i < size; i++)
		{
			//inbound array
			for (int j = 0; j < i; j++) 
			{
				//ascending sort
				if (a.elementAt(i).getCurrentLoad() < a.elementAt(j).getCurrentLoad() ) 
				{
					Collections.swap(a.getCompound(), i, j);
				}
			}
		}
		
		return a;
	}
	
	/**
	 * Return pos of founded wagon by inputed load
	 * @param a
	 * @param load
	 * @return
	 */
	public int findByLoad(UnitList a, int load)
	{
		int pos = -1;
		
		int last = a.length()-1;
		int first = 0;
		
		//search
		while (first <= last)
		{
			//pick mid position
			int center = (first + last) / 2;
			int curr = a.elementAt(center).getCurrentLoad();
			
			if (curr == load)
			{
				return center;
			}
			
			if (curr > load)
			{
				last = center - 1;
			}
			else
			{
				first = center + 1;
			}
		}
		
		return pos;
	}
	
	/**
	 * Return pos of founded wagon by inputed load thresholds
	 * @param a
	 * @param load
	 * @return
	 */
	public int findBetweenLoad(UnitList a, int firstThreshold, int lastThreshold)
	{
		int pos = -1;
		
		int last = a.length()-1;
		int first = 0;
		
		//search
		while (first <= last)
		{
			//pick mid position
			int center = (first + last) / 2;
			
			int curr = a.elementAt(center).getCurrentLoad();
			
			if ((curr > firstThreshold) & (curr < lastThreshold))
			{
				return center;
			}
			
			if (curr > lastThreshold)
			{
				last = center - 1;
			}
			else
			{
				first = center + 1;
			}
		}
		
		return pos;
	}
	
	/**
	 * Calculate wagonns in UnitList by Type
	 * @param list
	 * @param type
	 * @return
	 */
	public int calculateWagonsByType(UnitList list, String type)
	{
		int count = 0;
		
		for (ICargo tmp : list.getCompound())
		{
			if(tmp.getStringType().equals(type))
			{
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Calculate max load in UnitList in wagons by type
	 * @param list
	 * @param type
	 * @return
	 */
	public int calculateMaxLoadByType(UnitList list, String type)
	{
		int load = 0;
		
		for (ICargo tmp : list.getCompound())
		{
			if(tmp.getStringType().equals(type))
			{
				load += tmp.getWeigth();
			}
		}
		
		return load;
	}
	
	/**
	 * Calculate current load in UnitList in wagons by type
	 * @param list
	 * @param type
	 * @return
	 */
	public int calculateCurrentLoadByType(UnitList list, String type)
	{
		int load = 0;
		
		for (ICargo tmp : list.getCompound())
		{
			if(tmp.getStringType().equals(type))
			{
				load += tmp.getCurrentLoad();
			}
		}
		
		return load;
	}
	
	
}
