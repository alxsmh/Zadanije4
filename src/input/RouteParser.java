/**
 * Class for parsing attributes from string[]
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 */
package input;

import java.util.ArrayList;
import java.util.List;

public class RouteParser {
	
	/**
	 * Extracts single {LETTER} from string[]
	 * Its a route type
	 * E - electric route
	 * D - non electric route
	 * @param input string[]
	 * @return String
	 */
	public static String getRoute(String[] input)
	{
		for (String line : input)
		{
			if((line.toUpperCase().equals("E"))|| (line.toUpperCase().equals("D")))
			{
				return line.toUpperCase();
			}
		}
		
		return null;
	}
	
	/**
	 * Extracts words from String[] as cargo names
	 * @param input string[]
	 * @return String[]
	 */
	public static String[] getCargos(String[] input)
	{				
		String result = "";
		
		for (String line: input)
		{
			//word from string
			if((line.matches("[0-9]+") == false) & (line.length()>1))
			{
				result += line.toUpperCase() + " ";
			}
		}
		
		return result.split(" ");
	}
	
	/**
	 * Extracts numbers from String[]
	 * Its weights of cargo that needed to be loaded
	 * @param input string[]
	 * @return int[]
	 */
	public static int[] getWeights(String[] input)
	{				
		List<Integer> temp = new ArrayList<Integer>();
		
		for (String line: input)
		{
			//number in string
			if((line.matches("[0-9]+") == true))
			{
				temp.add(Integer.parseInt(line));
			}
		}
		
		//parse found numbers to int[]
		return temp.stream().mapToInt(Integer::intValue).toArray();
	}

}
