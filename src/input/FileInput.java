package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInput {
	
	public static List<String[]> readFile(String path) throws IOException
	{
		
		BufferedReader br = null;
		
		List<String[]> result = new ArrayList<String[]>();
		
		try 
		{
			String sCurrentLine;

	        br = new BufferedReader(new FileReader(path));

	        while ((sCurrentLine = br.readLine()) != null) 
	        {
	            result.add(sCurrentLine.split(" "));
	        }
	        
	        br.close();
	        
	        return result;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
