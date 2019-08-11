package entity;

import enums.ECargoType;
import enums.EMeasureUnits;

public class Cargo implements ICargo {

	private int type;
	private int units;
	private int quantity;
	private int current;

	public void load(int cargo)
	{
		//we can't load more than quantity
		this.current += (this.current + cargo < this.quantity+1) ? cargo : this.quantity;
	}
	
	public void unload(int cargo)
	{
		//we can't unload more than current
		this.current -= (this.current - cargo > -1) ? cargo : 0;
	}
	
	public int getType() {
		return type;
	}
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
	public void setUnits() {
		this.units = EMeasureUnits.values()[ ECargoType.values()[this.type].ordinal()].ordinal();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cargo(String type, int quantity) {

		this.setType(ECargoType.valueOf(type.toUpperCase()));
		
		this.setUnits();
		
		this.quantity = quantity;
		this.setCurrent(0);
	}
	
	public boolean isTrain()
	{
		return ((type == ECargoType.DIESEL_MOTOR.ordinal())|((type == ECargoType.ELECTRIC_MOTOR.ordinal()))) ? true : false;
	}
	@Override
	public String toString() {
		
		return  this.getClass().getName() + 
				"[type=" + getStringType() + 
				", units=" + EMeasureUnits.values()[units].name() + 
				", quantity=" + ((units == EMeasureUnits.valueOf("WATT").ordinal()) ? quantity*735.5 : quantity) + 
				"]";
	}
	@Override
	public int getWeigth() {
		// TODO Auto-generated method stub
		return getQuantity();
	}
	
	public String getStringType()
	{
		return  ((isTrain()) ? "Train" : ECargoType.values()[this.type].name());
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@Override
	public int getCurrentLoad() {
		// TODO Auto-generated method stub
		return getCurrent();
	}
	
	
}
