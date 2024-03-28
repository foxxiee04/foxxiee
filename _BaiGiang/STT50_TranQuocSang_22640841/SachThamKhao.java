package QLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachThamKhao extends Sach{
	private double thue;
	
	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}
	
	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, long soLuong, String nhaXuatBan,
			double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, long soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double tinhTongGia() {
		return getSoLuong()*getDonGia()+thue;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		return super.toString()+String.format("%15s %20s", getThue(), df.format(tinhTongGia()));
	}
}
