/**
 * Class for wagon factory
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Cargo
 * @see ICargo
 */
package factory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.Cargo;
import entity.ICargo;

public class WagonFactory {

	private static final Logger LOG = LogManager.getLogger(WagonFactory.class);
	
	/**
	 * Create wagon according to cargoName and railroad route type
	 * @param cargoName	cargo name that needed to transport
	 * @param routeType	railroad route type
	 * @return
	 */
	public ICargo create(String cargoName, String routeType)
	{
		LOG.info("Customer entered the Wagon factory");
		switch (cargoName.toUpperCase())
		{
		case "OIL":
			return new LiquidWagon_Type65(); 
			
		case "LIQUID":
			return new LiquidWagon_Type58(); 
		//If railroad route type is E construct electrical passenger wagon	
		case "PASS":
			return ((routeType.startsWith("E")) ? new PassangerWagon_Type105() : new PassangerWagon_Type76());
		
		case "COAL":
		case "SALT":
		case "SAND":
		case "HALKA":
			return  new StandartCargoWagon_Type45();
			
		case "ANIMAL":
			return new AnimalCargoWagon_Type26();
			
		case "CARS":
			return new CarWagon_Type35();
			
		case "HABARITE":
			return new PlatformWagon_Type80();
			
		default:
			LOG.warn("No wagons were created!");
			return null;
		}
	}
	
	/*
	 * Wagons factory can produce
	 */
	public class LiquidWagon_Type65 extends Cargo{

		public LiquidWagon_Type65() {
			super("liquid", 65);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class LiquidWagon_Type58 extends Cargo{

		public LiquidWagon_Type58() {
			super("liquid", 58);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class PassangerWagon_Type105 extends Cargo{

		public PassangerWagon_Type105() {
			super("passangers", 105);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class PassangerWagon_Type76 extends Cargo{

		public PassangerWagon_Type76() {
			super("passangers", 76);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class StandartCargoWagon_Type45 extends Cargo{

		public StandartCargoWagon_Type45() {
			super("soft_cargo", 45);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class AnimalCargoWagon_Type26 extends Cargo{

		public AnimalCargoWagon_Type26() {
			super("soft_cargo", 26);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class CarWagon_Type35 extends Cargo{

		public CarWagon_Type35() {
			super("soft_cargo", 35);
			// TODO Auto-generated constructor stub
		}

	}
	
	public class PlatformWagon_Type80 extends Cargo{

		public PlatformWagon_Type80() {
			super("soft_cargo", 80);
			// TODO Auto-generated constructor stub
		}

	}
}
