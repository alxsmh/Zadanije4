package entity;

import java.util.ArrayList;
import java.util.List;

public class UnitList {
	
	private List<ICargo> compound;
	
	public UnitList()
	{				
		setCompound(new ArrayList<ICargo>());
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
	
	public void addElement(ICargo el) 
	{
		this.compound.add(el);
	}
	
	public ICargo elementAt(int index) 
	{
		return this.compound.get(index);
	}
	
	public ICargo getLast()
	{
		return this.compound.get(length()-1);
	}
	
	public int length()
	{
		return this.compound.size();
	}

	@Override
	public String toString() {

		return "UnitList [" + compound.toString() + ", length=" + length()+ "]";
	}
	
}
