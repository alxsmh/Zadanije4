/**
 * Launcher for Task4 functions
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 */

package controller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import input.UnitInput;
import logic.UnitBuilder;
import view.ShowUnit;

public class Controller {

	private static final Logger LOG = LogManager.getLogger(Controller.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//open file, read the data and generate unit 
		List<UnitBuilder> inputedUnits = UnitInput.buildUnitsFromFile("W:\\inputFile.txt");		
		
		//print genereted unit to console
		ShowUnit.printBuildedUnit(inputedUnits.get(0));
		
		LOG.info("Program worked sucsessfuly ");
	}

}
