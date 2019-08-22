/**
 * Class for ICargo elements list service
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see ICargo
 */
package entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UnitList {
	
	private static final Logger LOG = LogManager.getLogger(UnitList.class);
	
	/**
	 * List of ICargo to handle
	 */
	private List<ICargo> compound;
	
	/**
	 * Creates compound
	 */
	public UnitList()
	{				
		setCompound(new ArrayList<ICargo>());
		LOG.info("New UnitList is Created");
	}
	
	@Override
	public int hashCode() {
		final int prime = 2;
		int result = 1;
		int size = this.length();
		
		while(--size > 0)
		{
			result += compound.get(size).getWeigth();
		}
		
		result = prime * result;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		
		UnitList other = (UnitList) obj;
		
		if (this.compound == null) 
		{
			if (other.getCompound() != null)
			{
				return false;
			}
		} 
		else if  (other.length() != this.length())
		{
			return false;
		}
		
		return true;
	}

	public List<ICargo> getCompound() {
		return compound;
	}

	private void setCompound(List<ICargo> compound) {
		this.compound = compound;
	}
	
	/**
	 * Appends compound with ICargo element
	 * @param el inputing ICargo
	 */
	public void addElement(ICargo el) 
	{
		this.compound.add(el);
		LOG.info("Element Added To list" + compound.getClass());
	}
	
	/**
	 * Pick up ICargo from list by index
	 * @param index
	 */
	public ICargo elementAt(int index) 
	{
		return this.compound.get(index);
	}
	
	/**
	 * Get last ICargo from compound
	 * @return ICargo
	 */
	public ICargo getLast()
	{
		return this.compound.get(length()-1);
	}
	
	/**
	 * Return size of compound
	 * @return int
	 */
	public int length()
	{
		return this.compound.size();
	}

	@Override
	public String toString() {

		return "UnitList [" + compound.toString() + ", length=" + length()+ "]";
	}
	
}
