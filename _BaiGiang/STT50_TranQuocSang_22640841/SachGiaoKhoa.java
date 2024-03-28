package QLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class SachGiaoKhoa extends Sach{
	private boolean tinhTrang;
	private final double giamGia = 0.5f;
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, long soLuong, String nhaXuatBan,
			boolean tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}
	public SachGiaoKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, long soLuong, String nhaXuatBan) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double tinhTongGia() {
		if(isTinhTrang())
			return getSoLuong()*getDonGia();
		else 
			return getSoLuong()*getDonGia()*giamGia;
	}
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String tinhTrangSach = isTinhTrang()?"Mới":"Cũ";
		return super.toString()+String.format("%15s %20s", tinhTrangSach, df.format(tinhTongGia()));
	}
	
}
