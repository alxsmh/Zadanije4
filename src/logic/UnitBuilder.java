/**
 * Class for building unit
 * @author Shamshur Aliaksandr
 * @version 1.0
 * @since 10.08.2019
 * @see Cargo
 * @see ICargo
 * @see UnitList
 * @see UnitBuilder
 * @see LoadManager
 * @see RouteParser
 */
package logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.UnitList;
import factory.TrainFactory;
import factory.WagonFactory;

public class UnitBuilder {

	private static final Logger LOG = LogManager.getLogger(UnitBuilder.class);
	
	private UnitList wLst;
	private UnitList tLst;

	private TrainFactory tFact;
	private WagonFactory wFact;
	
	private int unitCappacity;
	
	public UnitBuilder()
	{
		wLst = (wLst != null) ? this.wLst : new UnitList();
		tLst = (tLst != null) ? this.tLst : new UnitList();
		
		tFact = (tFact != null) ? this.tFact : new TrainFactory();
		wFact = (wFact != null) ? this.wFact : new WagonFactory();

		LOG.info("no param constructor call");
	}
	
	public UnitBuilder(String cargoType, int cappacity, String routeType)
	{
		wLst = (wLst != null) ? this.wLst : new UnitList();
		tLst = (tLst != null) ? this.tLst : new UnitList();
		
		tFact = (tFact != null) ? this.tFact : new TrainFactory();
		wFact = (wFact != null) ? this.wFact : new WagonFactory();
		
		buildUnit(cargoType, cappacity, routeType);
		LOG.info("param constructor call");
	}
	
	public UnitBuilder(String cargoType[], int cappacity[], String routeType)
	{
		wLst = (wLst != null) ? this.wLst : new UnitList();
		tLst = (tLst != null) ? this.tLst : new UnitList();
		
		tFact = (tFact != null) ? this.tFact : new TrainFactory();
		wFact = (wFact != null) ? this.wFact : new WagonFactory();
		
		buildUnit(cargoType, cappacity, routeType);
		
		LOG.info("array param constructor call");
	}
	
	public UnitList getWagonList() {
		return wLst;
	}

	public void setWagonList(UnitList wLst) {
		this.wLst = wLst;
	}

	
	public UnitList getTrainList() {
		return tLst;
	}

	public void setTrainList(UnitList tLst) {
		this.tLst = tLst;
	}
	
	/**
	 * Builds single, one type Wagons list
	 * @param cargoType String
	 * @param cappacity	int
	 * @param routeType	String
	 */
	public void buildWagons(String cargoType, int cappacity, String routeType)
	{	
		int tmpCapp = cappacity;
		
		while (tmpCapp > 0)
		{
			// wagon factory call
			//if wagon was not created: nullPointerException
			try
			{
				wLst.addElement(wFact.create(cargoType,routeType));
				
				int weight = wLst.getLast().getWeigth();
				
				//for checking of ordered load
				//gets created wagon max load
				//and decreases ordered capacity on that
				tmpCapp -= weight;
				this.unitCappacity += weight;
			}
			catch(NullPointerException e)
			{
				tmpCapp = -1;
				LOG.error("Wrong cargo name or type");
			}			
		}
		
		LOG.info("builded wagons");
	}
	
	/**
	 * Build train according to route type
	 * And wList capacity
	 * @param routeType
	 */
	public void buildTrain(String routeType)
	{	
		int tmpCapp = this.unitCappacity;
		
		while (tmpCapp > 0)
		{
			tLst.addElement(tFact.create(routeType, tmpCapp));
			
			tmpCapp -= tLst.getLast().getWeigth();
		}
		
		LOG.info("builded trains");
	}
	
	/**
	 * Build single unit
	 * @param cargoType cargo name
	 * @param cappacity
	 * @param routeType	type of railroad route
	 */
	public void buildUnit(String cargoType, int cappacity, String routeType)
	{
		buildWagons(cargoType, cappacity, routeType);
		
		//after building cargo consistency, we know the power we need to move cargo
		buildTrain(routeType);
		
		LOG.info("unit builded  trains:wagons");
	}
	
	/**
	 * Build multiple wagons to wList
	 * @param cargoType cargo names
	 * @param cappacity capacity array according to cargo names
	 * @param routeType	type of railroad route 
	 */
	public void buildUnit(String[] cargoType, int[] cappacity, String routeType)
	{
		//loop to combine multiple cargos
		//and multiple capacities 
		int i = 0;
		try {
			for (String arp : cargoType)
			{
				buildWagons(arp, cappacity[i++], routeType);
			}
		}
		//inputed cargoType or cappacity has invalid length
		catch(ArrayIndexOutOfBoundsException e)
		{
			LOG.error(e);
			return;
		}
		//
		//build train with various cargo
		buildTrain(routeType);
		
		LOG.info("unit with arrays builded  trains:wagons");
	}

	@Override
	public String toString() {
		return "UnitBuilder [tLst=" + tLst + "\nwLst=" + wLst + ", ~~ unitCappacity=" + unitCappacity + "]";
	}
	
	
}
