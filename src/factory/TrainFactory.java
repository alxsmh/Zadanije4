/**
 * Class for train factory
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Cargo
 * @see ICargo
 */
package factory;
import entity.ICargo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.Cargo;

public class TrainFactory {

	private static final Logger LOG = LogManager.getLogger(TrainFactory.class);
	
	/**
	 * Create Train according to railroad route type and asking power
	 * @param routeType	railroad route type
	 * @param cappacity power
	 * @return ICargo
	 */
	public ICargo create(String routeType, int cappacity)
	{
		LOG.info("Customer entered the Train factory");
		
		switch(routeType)
		{
		case "E":
			return  new WZ_Payong_7200();
			
		case "D":
			return (cappacity < 6001) ? new RVR_EZK_6000() : new TUR_TVKMGZ_12000() ;
			
		default: 
			LOG.warn("No train were created!");
			return null;
		}
	}
	
	/*
	 * Classes that train factory can produce
	 */
	
	public class WZ_Payong_7200 extends Cargo
	{
	
		public WZ_Payong_7200() 
		{
				super("ELECTRIC_MOTOR", 7200);
				// TODO Auto-generated constructor stub
		}
	}
	
	public class RVR_EZK_6000 extends Cargo
	{
	
		public RVR_EZK_6000() 
		{
				super("DIESEL_MOTOR", 6000);
				// TODO Auto-generated constructor stub
		}
	}
	
	public class TUR_TVKMGZ_12000 extends Cargo
	{
	
		public TUR_TVKMGZ_12000() 
		{
				super("DIESEL_MOTOR", 12000);
				// TODO Auto-generated constructor stub
		}
	}
}
