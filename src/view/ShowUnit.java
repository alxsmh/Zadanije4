package view;

import entity.UnitList;
import logic.UnitBuilder;

public class ShowUnit {
	
	public static void printBuildedUnit(UnitBuilder a)
	{
		System.out.print(a.toString());
	}
	
	public static void printUnit(UnitList a)
	{
		System.out.print(a.toString());
	}

}
