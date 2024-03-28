package tuan7_giaodichtienvang;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Transaction {
	protected String transCode;
	protected LocalDate transDate;
	protected double unitPrice;
	protected int quantity;
	protected String getTransCode() {
		return transCode;
	}
	protected void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	protected LocalDate getTransDate() {
		return transDate;
	}
	protected void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}
	protected double getUnitPrice() {
		return unitPrice;
	}
	protected void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	protected int getQuantity() {
		return quantity;
	}
	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	protected Transaction(String transCode, LocalDate transDate, double unitPrice, int quantity) {
		super();
		this.transCode = transCode;
		this.transDate = transDate;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	protected Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public abstract double totalPrice();
	@Override
	public int hashCode() {
		return Objects.hash(transCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(transCode, other.transCode);
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return String.format(" | %-16s | %-16s | %-25s | %-15d | ", getTransCode(),dtf.format(getTransDate()), df.format(getUnitPrice()), getQuantity());
	}
	
}
