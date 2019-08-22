/**
 * Enum for possible cargo types handling
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 */
package enums;

public enum ECargoType {
	DIESEL_MOTOR, ELECTRIC_MOTOR, PASSANGERS, LIQUID, SOFT_CARGO;
	
	/**
	 * Get ECargoType element according to inputed cargo NAME
	 * @param typ
	 * @return ECargoType
	 */
	public static ECargoType getTypeOnString(String typ)
	{
		switch(typ.toUpperCase())
		{
			case "DIESEL_MOTOR":
			case "DIESEL_ENGINE":
				return DIESEL_MOTOR;
				
			case "ELECTRIC_MOTOR":
			case "ELECTRIC_ENGINE":
				return ELECTRIC_MOTOR;
				
			case "OIL":			
			case "LIQUID":
				return LIQUID;
				
			case "PASS":
			case "PASSANGER":
			case "PASSANGERS":
				return PASSANGERS;
			
			case "COAL":
			case "SALT":
			case "SAND":
			case "HALKA":
			case "ANIMAL":	
			case "CARS":	
			case "HABARITE":
			case "SOFT_CARGO":
				return SOFT_CARGO;
		}
		
		return null;
	}
}
