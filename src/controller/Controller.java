package controller;
import java.util.List;

import input.UnitInput;
import logic.UnitBuilder;
import view.ShowUnit;

public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<UnitBuilder> inputedUnits = UnitInput.buildUnitsFromFile("W:\\inputFile.txt");		
		
		ShowUnit.printBuildedUnit(inputedUnits.get(0));
		
		
	}

}
