package input;

import java.util.ArrayList;
import java.util.List;

public class RouteParser {
	
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
	
	public static String[] getCargos(String[] input)
	{				
		String result = "";
		
		for (String line: input)
		{
			if((line.matches("[0-9]+") == false) & (line.length()>1))
			{
				result += line.toUpperCase() + " ";
			}
		}
		
		return result.split(" ");
	}
	
	public static int[] getWeights(String[] input)
	{				
		List<Integer> temp = new ArrayList<Integer>();
		
		for (String line: input)
		{
			if((line.matches("[0-9]+") == true))
			{
				temp.add(Integer.parseInt(line));
			}
		}
		
		return temp.stream().mapToInt(Integer::intValue).toArray();
	}

}
