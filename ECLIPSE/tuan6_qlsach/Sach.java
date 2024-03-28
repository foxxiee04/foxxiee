package tuan6_qlsach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Sach {
	protected String bookCode;
	protected LocalDate entryDate;
	protected double unitPrice;
	protected long quantity;
	protected String publisher;
	
	protected String getBookCode() {
		return bookCode;
	}
	protected void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	protected LocalDate getEntryDate() {
		return entryDate;
	}
	protected void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	protected double getUnitPrice() {
		return unitPrice;
	}
	protected void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	protected long getQuantity() {
		return quantity;
	}
	protected void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	protected String getPublisher() {
		return publisher;
	}
	protected void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	protected Sach(String bookCode, LocalDate entryDate, double unitPrice, long quantity, String publisher) {
		super();
		this.bookCode = bookCode;
		this.entryDate = entryDate;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.publisher = publisher;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(bookCode, other.bookCode);
	}
	public abstract double totalPrice();
	@Override
	public String toString() {
		DecimalFormat nf = new DecimalFormat("#,##0.00VND");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
		return String.format(" %15s %20s %20s %15s %20s ", getBookCode(), getEntryDate().format(df) , nf.format(getUnitPrice()), getQuantity(), getPublisher());
	}
}
