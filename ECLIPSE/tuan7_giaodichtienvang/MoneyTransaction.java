package tuan7_giaodichtienvang;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class MoneyTransaction extends Transaction{
	private double exchangeRate;
	private int moneyType;
	
	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public int getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(int moneyType) {
		this.moneyType = moneyType;
	}

	public MoneyTransaction(String transCode, LocalDate transDate, double unitPrice, int quantity, double exchangeRate,
			int moneyType) {
		super(transCode, transDate, unitPrice, quantity);
		this.exchangeRate = exchangeRate;
		this.moneyType = moneyType;
	}

	public MoneyTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoneyTransaction(String transCode, LocalDate transDate, double unitPrice, int quantity) {
		super(transCode, transDate, unitPrice, quantity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double totalPrice() {
		if(getMoneyType()==1)
			return getUnitPrice()*getQuantity();
		else
			return getUnitPrice()*getQuantity()*getExchangeRate();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String money = null;
		switch(moneyType) {
			case 1:{
				money = "VND";
				break;
			}
			case 2:{
				money = "USD";
				break;
			}
			case 3:{
				money = "EURO";
				break;
			}
		}
		return super.toString()+String.format(" %-25s | %-20s | %-15s |", df.format(totalPrice()), getExchangeRate(), money);
	}
}
