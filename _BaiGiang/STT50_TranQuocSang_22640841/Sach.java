package QLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Sach {
	protected String maSach;
	protected LocalDate ngayNhap;
	protected double donGia;
	protected long soLuong;
	protected String nhaXuatBan;
	
	protected String getMaSach() {
		return maSach;
	}
	protected void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	protected LocalDate getNgayNhap() {
		return ngayNhap;
	}
	protected void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	protected double getDonGia() {
		return donGia;
	}
	protected void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	protected long getSoLuong() {
		return soLuong;
	}
	protected void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	protected String getNhaXuatBan() {
		return nhaXuatBan;
	}
	protected void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	protected Sach(String maSach, LocalDate ngayNhap, double donGia, long soLuong, String nhaXuatBan) {
		super();
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
	public abstract double tinhTongGia();
	@Override
	public String toString() {
		DecimalFormat nf = new DecimalFormat("#,##0.00VND");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
		return String.format(" %15s %20s %20s %15s %20s ", getMaSach(), getNgayNhap().format(df) , nf.format(getDonGia()), getSoLuong(), getNhaXuatBan());
	}
}
