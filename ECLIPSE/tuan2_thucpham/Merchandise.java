package tuan2_thucpham;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Merchandise {
	private long merchanID;
	private String merchanName;
	private double unitPrice;
	private LocalDate MFG;
	private LocalDate expiredDate;
	
	public long getMerchanID() {
		return merchanID;
	}
	public void setMerchanID(long merchanID) throws Exception {
		if(merchanID != 0)
			this.merchanID = merchanID;
		else {
			throw new Exception("Merchandise ID cannot be left blank!");
		}
	}
	public String getMerchanName() {
		return merchanName;
	}
	public void setMerchanName(String merchanName) throws Exception {
		if(merchanName != null)
			this.merchanName = merchanName;
		else {
			throw new Exception("Merchandise name cannot be left blank!");
		}
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) throws Exception {
		if(unitPrice>0)
			this.unitPrice = unitPrice;
		else {
			throw new Exception("Unit Price cannot be negative number!");
		}
	}
	public LocalDate getMFG() {
		return MFG;
	}
	public void setMFG(LocalDate mFG) throws Exception {
		if(mFG != null && mFG.isAfter(LocalDate.now().plusDays(3)))
			MFG = mFG;
		else {
			throw new Exception("Manufacture Date cannot be left blank!");
		}
	}
	public LocalDate getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDay(LocalDate expiredDate) throws Exception {
		if(expiredDate != null) {
			if(expiredDate.isAfter(MFG)) {
				this.expiredDate = expiredDate;
			}else {
				throw new Exception("Expired Date must be after Manufacture Date");
			}
		}else {
			throw new Exception("Expired Date cannot be left blank!");
		}
		
	}
	public Merchandise(long merchanID, String merchanName, double unitPrice, LocalDate mFG, LocalDate expiredDate) {
		super();
		this.merchanID = merchanID;
		this.merchanName = merchanName;
		this.unitPrice = unitPrice;
		this.MFG = mFG;
		this.expiredDate = expiredDate;
	}
	public Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean expired() {
		if(expiredDate.isBefore(LocalDate.now())) {
			return true;
		}else return false;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d/M/yyyy");
		String strMF = MFG.format(pattern);
		String strExpired = expiredDate.format(pattern);
		DecimalFormat formatter = new DecimalFormat("###,###,###.00");
		return String.format("%10s %20s %20s %15s %15s %15s\t",merchanID,merchanName,formatter.format(unitPrice)+" VND",strMF,strExpired,expired()?"Expired":"Still valid");
	}
}
