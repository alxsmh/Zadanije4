package entity;

public interface ICargo {
	
	
	public boolean isTrain();
	
	public int getWeigth();
	
	public String getStringType();
	
	public void load(int cargoNums);
	
	public void unload(int cargoNums);
	
	public int getCurrentLoad();

}
