package tuan8_giaodichdat;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class LandTransaction extends Transaction{
	private String landType;
	private final double rate = 1.5;
	
	public String getLandType() {
		return landType;
	}

	public void setLandType(String landType) throws Exception {
		if(landType.matches("[a-cA-C]"))	
			this.landType = landType.toUpperCase();
		else
		    throw new Exception("Loại đất không hợp lệ. Phải là 'A', 'B' hoặc 'C' (không phân biệt chữ hoa chữ thường)!");

	}

	public LandTransaction(String transCode, LocalDate transDate, double unitPrice, double area, String landType) {
		super(transCode, transDate, unitPrice, area);
		this.landType = landType;
	}

	public LandTransaction(String landType) {
		super();
		this.landType = landType;
	}

	public LandTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPrice() {
		if (getLandType().equalsIgnoreCase("A")) {
            return getArea() * getUnitPrice() * rate;
        } else if (getLandType().equalsIgnoreCase("B") || getLandType().equalsIgnoreCase("C")) {
            return getArea() * getUnitPrice();
        } else {
            return -1;
        }
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return super.toString() + String.format("%25s %25s", df.format(totalPrice()), landType);
	}
}
