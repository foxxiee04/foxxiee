package tuan8_giaodichdat;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class HouseTransaction extends Transaction{
	private int houseType;
	private String address;
	private final double percent = 0.9;
	
	public int getHouseType() {
		return houseType;
	}
	
	public void setHouseType(int houseType) throws Exception {
		if(houseType ==1 || houseType==2)
			this.houseType = houseType;
		else
		    throw new Exception("Loại nhà không hợp lệ. Phải là 1 hoặc 2!");

	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public HouseTransaction(int houseType, String address) {
		super();
		this.houseType = houseType;
		this.address = address;
	}

	public HouseTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HouseTransaction(String transCode, LocalDate transDate, double unitPrice, double area, int houseType,
			String address) {
		super(transCode, transDate, unitPrice, area);
		this.houseType = houseType;
		this.address = address;
	}

	@Override
	public double totalPrice() {
		if(houseType == 1) return area * unitPrice;
		if(houseType == 2) return area * unitPrice * percent;
		return 0;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String type = null;
		if(houseType == 1) type="High-end";
		if(houseType == 2) type="Regular";
		return super.toString() + String.format("%25s %25s %20s", df.format(totalPrice()), type, address);
	}
	
}
