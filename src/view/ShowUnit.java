/**
 * Class for outputing 
 * UnitList and UnitBuilder
 * classes to console
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see UnitList
 * @see UnitBuilder
 */
package view;

import entity.UnitList;
import logic.UnitBuilder;

public class ShowUnit {
	
	/**
	 * Output UnitBuilder to console
	 * @param a UnitBuilder
	 */
	public static void printBuildedUnit(UnitBuilder a)
	{
		System.out.print(a.toString());
	}
	
	/**
	 * Output printUnit to console
	 * @param a printUnit
	 */
	public static void printUnit(UnitList a)
	{
		System.out.print(a.toString());
	}

}
