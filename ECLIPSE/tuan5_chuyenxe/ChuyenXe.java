package tuan5_chuyenxe;

import java.text.DecimalFormat;

public class ChuyenXe {
	protected String tripCode;
	protected String driverName;
	protected String numberPlate;
	protected double revenue;

	public String getNumberPlate() {
		return numberPlate;
	}
	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	protected String getTripCode() {
		return tripCode;
	}
	protected void setTripCode(String tripCode) {
		this.tripCode = tripCode;
	}
	protected String getDriverName() {
		return driverName;
	}
	protected void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	protected double getRevenue() {
		return revenue;
	}
	protected void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	protected ChuyenXe(String tripCode, String driverName, String numberPlate, double revenue) {
		super();
		this.tripCode = tripCode;
		this.driverName = driverName;
		this.numberPlate = numberPlate;
		this.revenue = revenue;
	}
	protected ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenXe other = (ChuyenXe) obj;
		return tripCode.equals(other.tripCode);
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String Revenue = df.format(revenue);
		return String.format("\t%s %27s %22s %24s", getTripCode(), getDriverName(),getNumberPlate() , Revenue);
	}
}
