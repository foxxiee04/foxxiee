package tuan7_giaodichtienvang;

import java.util.ArrayList;

public class TransactionArray {
	ArrayList<Transaction> transList;

	public TransactionArray() {
		super();
		this.transList = new ArrayList<Transaction>();
	}

	public void addTrans(Transaction trans) throws Exception {
		if(transList.contains(trans)==false) {
			transList.add(trans);
		}else {
			throw new Exception("Giao dịch này đã tồn tại!");

		}
	}
	
	public Transaction findByCode(String transCode) {
		for(Transaction trans : transList) {
			if(trans.getTransCode().equalsIgnoreCase(transCode))
				return trans;
		}
		return null;
	}
	
	public void removeTrans(Transaction trans) throws Exception {
		if(transList.contains(trans)==true) {
			transList.remove(trans);
		}else {
			throw new Exception("Giao dịch này đã tồn tại!");

		}
	}
	
	public ArrayList<Transaction> getGoldTransaction(){
		ArrayList<Transaction> gtList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans instanceof GoldTransaction) {
				gtList.add(trans);
			}
		}
		return gtList;
	}
	
	public ArrayList<Transaction> getMoneyTransaction(){
		ArrayList<Transaction> mtList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans instanceof MoneyTransaction) {
				mtList.add(trans);
			}
		}
		return mtList;
	}
	
	public ArrayList<Transaction> getUnitPrice1B(){
		ArrayList<Transaction> uPList = new ArrayList<Transaction>();
		for(Transaction trans : transList) {
			if(trans.getUnitPrice()>1000000000)
				uPList.add(trans);
		}
		return uPList;
	}
	
	public int sumQuantityMT() {
		int sum=0;
		ArrayList<Transaction> mtList = getMoneyTransaction();
		for(Transaction trans : mtList) {
			sum+=trans.getQuantity();
		}
		return sum;
	}
	
	public int sumQuantityGT() {
		int sum=0;
		ArrayList<Transaction> gtList = getGoldTransaction();
		for(Transaction trans : gtList) {
			sum+=trans.getQuantity();
		}
		return sum;
	}
	
	public double totalPriceAVG() {
		double avg=0;
		int cnt=0;
		ArrayList<Transaction> mtList = getMoneyTransaction();
		for(Transaction trans : mtList) {
			avg+=trans.totalPrice();
			cnt++;
		}
		return avg/cnt;
	}
	
	public ArrayList<Transaction> getList(){
		return transList;
	}
}
