package tuan9_thucphamInterface;

import java.util.ArrayList;

public interface MethodOfArray {
	
	public void addMerchan(Merchandise merchan) throws Exception;
	
	public Merchandise findByCode(String merchanID) throws Exception;
	
	public void removeMerchan(Merchandise merchan) throws Exception;
	
	public ArrayList<Merchandise> getFoods();
	
	public ArrayList<Merchandise> getElectrical();
	
	public ArrayList<Merchandise> getCeramic();
}
