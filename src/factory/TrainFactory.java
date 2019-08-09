package factory;
import entity.ICargo;
import entity.Cargo;

public class TrainFactory {

	
	public ICargo create(String routeType, int cappacity)
	{
		switch(routeType)
		{
		case "E":
			return  new WZ_Payong_7200();
			
		case "D":
			return (cappacity < 6001) ? new RVR_EZK_6000() : new TUR_TVKMGZ_12000() ;
			
		default: 
			return null;
		}
	}
	
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
