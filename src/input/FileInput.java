/**
 * Class for TXT file read
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Cargo
 * @see ICargo
 */
package input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileInput {
	
	private static final Logger LOG = LogManager.getLogger(FileInput.class);
	
	/**
	 * read strings from file
	 * and split each string by spacebar
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<String[]> readFile(String path) throws IOException
	{
		
		BufferedReader br = null;
		
		List<String[]> result = new ArrayList<String[]>();
		
		try 
		{
			if (path.isEmpty())
			{
				throw new NullPointerException();
			}
			
			String sCurrentLine;

			// read fille to buffer from path
	        br = new BufferedReader(new FileReader(path));

	        //each string that adds to result[] is spliting by spacebar
	        while ((sCurrentLine = br.readLine()) != null) 
	        {
	            result.add(sCurrentLine.split(" "));
	        }
	        
	        br.close();
	        
	        LOG.info("File :" + path + " readed sucsessfuly");
	        
	        return result;
		} 
		catch (FileNotFoundException e) 
		{
			LOG.error("FILE NOT FOUND EXCEPTION ON readFile");
		}
		
		catch (NullPointerException e) 
		{
			LOG.error("INVALID PATH TO FILE ON readFile");
		}
		return null;
		
	}

}
