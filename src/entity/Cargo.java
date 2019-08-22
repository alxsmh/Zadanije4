/**
 * Cargo entity. It's a ELEMENT of railroad unit
 * train or cargo wagon
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 */
package entity;

import enums.ECargoType;
import enums.EMeasureUnits;

public class Cargo implements ICargo {

	private int type;
	private int units;
	private int quantity;
	private int current;

	/**
	 * Constructor. Returns created element
	 * @param type	cargo type
	 * @param quantity max weight that cargo can hold
	 * @see ECargoType
	 */
	public Cargo(String type, int quantity) {

		//this.setType(ECargoType.valueOf(type.toUpperCase()));
		this.setType(ECargoType.getTypeOnString(type));
		
		this.setUnits();
		
		this.quantity = quantity;
		this.setCurrent(0);
	}
	
	/**
	 * Loads element on inputed value
	 * @param cargo value to load
	 * @see ICargo
	 */
	public void load(int cargo)
	{
		//we can't load more than quantity
		this.current += (this.current + cargo < this.quantity+1) ? cargo : this.quantity - this.current;
	}
	
	/**
	 * Unloads element on inputed value
	 * @param cargo value to unload
	 * @see ICargo
	 */
	public void unload(int cargo)
	{
		//we can't unload more than current
		this.current -= (this.current - cargo > -1) ? cargo : 0;
	}
	
	public int getType() {
		return type;
	}
	
	/**
	 * Set type according to ECargoType
	 * @param type
	 * @see ECargoType
	 */
	public void setType(ECargoType type) {
		switch(type)
		{
		case DIESEL_MOTOR:
		case ELECTRIC_MOTOR:
		case PASSANGERS: 
		case LIQUID:
		case SOFT_CARGO:
			this.type = type.ordinal();
			break;
			
		default:
			this.type = -1;
			break;
		}
	}
	public int getUnits() {
		return units;
	}
	/**
	 * Set units according to cargo type order in ECargoType
	 * @see ECargoType
	 * @see EMeasureUnits
	 */
	public void setUnits() {
		this.units = EMeasureUnits.values()[ ECargoType.values()[this.type].ordinal()].ordinal();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Calculates is current element a train
	 * Element is train if it has motor or engine
	 * @see ECargoType
	 */
	public boolean isTrain()
	{
		return ((type == ECargoType.DIESEL_MOTOR.ordinal())|((type == ECargoType.ELECTRIC_MOTOR.ordinal()))) ? true : false;
	}
	@Override
	public String toString() {
		
		return  this.getClass().getName() + 
				"\n[type=" + getStringType() + 
				", units=" + EMeasureUnits.values()[units].name() + 
				", quantity=" + ((units == EMeasureUnits.valueOf("WATT").ordinal()) ? quantity*735.5 : quantity) + 
				", current=" + current +
				"]";
	}
	/**
	 * Get maximum load element can hold
	 * @see ICargo
	 */
	@Override
	public int getWeigth() {
		// TODO Auto-generated method stub
		return getQuantity();
	}
	
	/**
	 * Return type of element
	 */
	public String getStringType()
	{
		return  ((isTrain()) ? "Train" : ECargoType.values()[this.type].name());
	}

	private int getCurrent() {
		return current;
	}

	private void setCurrent(int current) {
		this.current = current;
	}

	/**
	 * Return current element load
	 * @see ICargo
	 */
	@Override
	public int getCurrentLoad() {
		// TODO Auto-generated method stub
		return getCurrent();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + current;
		result = prime * result + quantity;
		result = prime * result + type;
		result = prime * result + units;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (current != other.current)
			return false;
		if (quantity != other.quantity)
			return false;
		if (type != other.type)
			return false;
		if (units != other.units)
			return false;
		return true;
	}
	
}
