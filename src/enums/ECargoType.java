package enums;

public enum ECargoType {
	DIESEL_MOTOR, ELECTRIC_MOTOR, PASSANGERS, LIQUID, SOFT_CARGO;
	
	public static ECargoType getTypeOnString(String typ)
	{
		switch(typ)
		{
			case "OIL":			
			case "LIQUID":
				return LIQUID;
				
			case "PASS":
				return PASSANGERS;
			
			case "COAL":
			case "SALT":
			case "SAND":
			case "HALKA":
			case "ANIMAL":	
			case "CARS":	
			case "HABARITE":
				return SOFT_CARGO;
		}
		
		return null;
	}
}
