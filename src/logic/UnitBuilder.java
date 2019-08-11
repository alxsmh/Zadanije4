package logic;

import entity.UnitList;
import factory.TrainFactory;
import factory.WagonFactory;

public class UnitBuilder {

	private UnitList wLst;
	private UnitList tLst;

	private TrainFactory tFact;
	private WagonFactory wFact;
	
	private int unitCappacity;
	
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

	public UnitBuilder()
	{
		wLst = (wLst != null) ? this.wLst : new UnitList();
		tLst = (tLst != null) ? this.tLst : new UnitList();
		
		tFact = (tFact != null) ? this.tFact : new TrainFactory();
		wFact = (wFact != null) ? this.wFact : new WagonFactory();
	}
	
	public UnitBuilder(String cargoType, int cappacity, String routeType)
	{
		wLst = (wLst != null) ? this.wLst : new UnitList();
		tLst = (tLst != null) ? this.tLst : new UnitList();
		
		tFact = (tFact != null) ? this.tFact : new TrainFactory();
		wFact = (wFact != null) ? this.wFact : new WagonFactory();
		
		buildUnit(cargoType, cappacity, routeType);
	}
	
	
	
	public void buildWagons(String cargoType, int cappacity, String routeType)
	{	
		int tmpCapp = cappacity;
		this.unitCappacity += cappacity;
		
		while (tmpCapp > 0)
		{
			wLst.addElement(wFact.create(cargoType,routeType));
			
			tmpCapp -= wLst.getLast().getWeigth();
		}
	}
	
	public void buildTrain(String routeType)
	{	
		int tmpCapp = this.unitCappacity;
		
		while (tmpCapp > 0)
		{
			tLst.addElement(tFact.create(routeType, tmpCapp));
			
			tmpCapp -= tLst.getLast().getWeigth();
		}
	}
	
	public void buildUnit(String cargoType, int cappacity, String routeType)
	{
		buildWagons(cargoType, cappacity, routeType);
		
		//after building cargo consistency, we know the power we need to move cargo
		buildTrain(routeType);
	}
	
	public void buildUnit(String[] cargoType, int[] cappacity, String routeType)
	{
		//loop to combine multiple cargos
		//and multiple capacities 
		int i = 0;
		
		for (String arp : cargoType)
		{
			buildWagons(arp, cappacity[i++], routeType);
		}
		//
		//build train with various cargo
		buildTrain(routeType);
	}
}
