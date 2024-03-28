package tuan8_giaodichdat;

import java.util.ArrayList;

public class TransactionArray {
	ArrayList<Transaction> transList;

	public TransactionArray() {
		super();
		this.transList = new ArrayList<Transaction>();
	}
	
	public Transaction findByCode(String transCode) {
		for(Transaction trans : transList) {
			if(trans.getTransCode().equalsIgnoreCase(transCode))
				return trans;
		}
		return null;
	}
	
	public void addTrans(Transaction trans) throws Exception {
		if(transList.contains(trans)==false)
			transList.add(trans);
		else
		    throw new Exception("Giao dịch này đã tồn tại!");

	}
	
	public void removeTrans(Transaction trans) throws Exception {
		if(transList.contains(trans)==true)
			transList.remove(trans);
		else throw new Exception("This trans not found!");
	}
	
	public ArrayList<Transaction> getLandTrans(){
		ArrayList<Transaction> landList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans instanceof LandTransaction)
				landList.add(trans);
		}
		return landList;
	}
	
	public ArrayList<Transaction> getHouseTrans(){
		ArrayList<Transaction> houseList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans instanceof HouseTransaction)
				houseList.add(trans);
		}
		return houseList;
	}
	
	public double avgLandTrans() {
		double sum=0;
		int cnt=0;
		ArrayList<Transaction> landType = getLandTrans();
		for(Transaction trans : landType) {
			sum+=trans.totalPrice();
			cnt++;
		}
		return sum / cnt;
	}
	
	public ArrayList<Transaction> getTransByDate(){
		ArrayList<Transaction> dateList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans.getTransDate().getMonthValue() == 9 && trans.getTransDate().getYear() == 2013)
				dateList.add(trans);
		}
		return dateList;
	}
	
	public int getQuantityLT(){
		ArrayList<Transaction> landType = getLandTrans();
		return landType.size();
	}
	
	public int getQuantityHT(){
		ArrayList<Transaction> landType = getHouseTrans();
		return landType.size();
	}
	
	public ArrayList<Transaction> getAll(){
		return transList;
	}
}
