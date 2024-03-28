package tuan6_qlsach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachThamKhao extends Sach{
	private double tax;
	
	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public SachThamKhao(String bookCode, LocalDate entryDate, double unitPrice, long quantity, String publisher,
			double tax) {
		super(bookCode, entryDate, unitPrice, quantity, publisher);
		this.tax = tax;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String bookCode, LocalDate entryDate, double unitPrice, long quantity, String publisher) {
		super(bookCode, entryDate, unitPrice, quantity, publisher);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPrice() {
		return getQuantity()*getUnitPrice()+tax;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		return super.toString()+String.format("%15s %20s", getTax(), df.format(totalPrice()));
	}
}
