package tuan3_cd;

import java.text.DecimalFormat;

public class CD {
	private int cdID;
	private String nameCD;
	private String nameSinger;
	private int numOfSong;
	private double price;
	public int getCdID() {
		return cdID;
	}
	public void setCdID(int cdID) {
		this.cdID = cdID;
	}
	public String getNameCD() {
		return nameCD;
	}
	public void setNameCD(String nameCD) {
		this.nameCD = nameCD;
	}
	public String getNameSinger() {
		return nameSinger;
	}
	public void setNameSinger(String nameSinger) {
		this.nameSinger = nameSinger;
	}
	public int getNumOfSong() {
		return numOfSong;
	}
	public void setNumOfSong(int numOfSong) throws Exception {
		if(numOfSong>0)
			this.numOfSong = numOfSong;
		else 
			throw new Exception("The Number Of Song cannot be a negative number!");
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) throws Exception {
		if(price>0) {
			this.price = price;
		}else {
			throw new Exception("The CD Price cannot be a negative number!");
		}	
	}
	public CD(int cdID, String nameCD, String nameSinger, int numOfSong, double price) {
		super();
		this.cdID = cdID;
		this.nameCD = nameCD;
		this.nameSinger = nameSinger;
		this.numOfSong = numOfSong;
		this.price = price;
	}
	public CD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String str = String.format("%20d %19s %15s %20d %15s",cdID, nameCD, nameSinger, numOfSong, df.format(price));
		return str;
	}
}
