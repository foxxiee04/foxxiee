package tuan6_qlsach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachGiaoKhoa extends Sach{
	private boolean condition;
	private final double discount=0.5f;
	public boolean isCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
	public SachGiaoKhoa(String bookCode, LocalDate entryDate, double unitPrice, long quantity, String publisher,
			boolean condition) {
		super(bookCode, entryDate, unitPrice, quantity, publisher);
		this.condition = condition;
	}
	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachGiaoKhoa(String bookCode, LocalDate entryDate, double unitPrice, long quantity, String publisher) {
		super(bookCode, entryDate, unitPrice, quantity, publisher);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double totalPrice() {
		if(isCondition())
			return getQuantity()*getUnitPrice();
		else 
			return getQuantity()*getUnitPrice()*discount;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String cdt = isCondition()?"new":"old";
		return super.toString()+String.format("%15s %20s", cdt, df.format(totalPrice()));
	}
	
}
