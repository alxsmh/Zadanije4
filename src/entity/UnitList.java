package entity;

import java.util.ArrayList;
import java.util.List;

public class UnitList {
	
	private List<ICargo> compound;

	public List<ICargo> getCompound() {
		return compound;
	}

	private void setCompound(List<ICargo> compound) {
		this.compound = compound;
	}

	public UnitList()
	{				
		setCompound(new ArrayList<ICargo>());
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
