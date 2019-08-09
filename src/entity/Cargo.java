package entity;

import enums.ECargoType;
import enums.EMeasureUnits;

public class Cargo implements ICargo {

	private int type;
	private int units;
	private int quantity;
	

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
		this.units = this.type;
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
	}
	
	public boolean isTrain()
	{
		return ((type == ECargoType.DIESEL_MOTOR.ordinal())|((type == ECargoType.ELECTRIC_MOTOR.ordinal()))) ? true : false;
	}
	@Override
	public String toString() {
		
		return  this.getClass().getName() + 
				"[type=" + ((isTrain()) ? "Train" : ECargoType.values()[this.type].name()) + 
				", units=" + EMeasureUnits.values()[units].name() + 
				", quantity=" + ((units == EMeasureUnits.valueOf("WATT").ordinal()) ? quantity*735.5 : quantity) + 
				"]";
	}
	@Override
	public int getWeigth() {
		// TODO Auto-generated method stub
		return getQuantity();
	}
	
	
}
