package tuan5_chuyenxe;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe{
	private double kmTraveled;
	private int routeNumber;
	
	public double getKmTraveled() {
		return kmTraveled;
	}
	public void setKmTraveled(double kmTraveled) {
		this.kmTraveled = kmTraveled;
	}
	public int getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(int soTuyen) {
		this.routeNumber = soTuyen;
	}
	public NoiThanh(String tripCode, String driverName, String numberPlate, double revenue, double kmTraveled, int routeNumber) {
		super(tripCode, driverName, numberPlate, revenue);
		this.kmTraveled = kmTraveled;
		this.routeNumber = routeNumber;
	}
	public NoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoiThanh(String tripCode, String driverName, String numberPlate, double revenue) {
		super(tripCode, driverName, numberPlate, revenue);
		// TODO Auto-generated constructor stub
	}
	
	 @Override
	public String toString() {
		DecimalFormat kmf = new DecimalFormat("#,##0.00km");
		String KmTraveled = kmf.format(kmTraveled);
		return super.toString()+String.format("%30s %20d",KmTraveled,getRouteNumber());
	}
}
