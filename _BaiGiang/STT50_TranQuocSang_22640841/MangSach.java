package QLySach;

import java.util.ArrayList;

public class MangSach {
	ArrayList<Sach> danhSachSach;

	public MangSach() {
		super();
		this.danhSachSach = new ArrayList<Sach>();
	}

	public void themSach(Sach sach) throws Exception { 
		if(danhSachSach.contains(sach) == false)
			danhSachSach.add(sach);
		else 
			throw new Exception("Sách này đã tồn tại trong danh sách!");
	}

	public Sach timSachTheoMa(String maSach) {
		for(Sach sach : danhSachSach) {
			if(sach.getMaSach().equalsIgnoreCase(maSach))
				return sach;
		}
		return null;
	}
	
	public ArrayList<Sach> timSachTheoNhaXuatBan(String nhaXuatBan) {
		ArrayList<Sach> sachTheoNhaXuatBan = new ArrayList<Sach>();
		for(Sach sach : danhSachSach) {
			if(sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan))
				sachTheoNhaXuatBan.add(sach);
		}
		return sachTheoNhaXuatBan;
	}
	
	public void xoaSach(Sach sach) throws Exception {
		if(danhSachSach.contains(sach) == true)
			danhSachSach.remove(sach);
		else 
			throw new Exception("Không tìm thấy sách này trong danh sách!");
	}

	public ArrayList<Sach> getDanhSachSachThamKhao(){
		ArrayList<Sach> danhSachSachThamKhao = new ArrayList<Sach>();
		for(Sach sach : danhSachSach) {
			if(sach instanceof SachThamKhao)
				danhSachSachThamKhao.add(sach);
		}
		return danhSachSachThamKhao;
	}

	public ArrayList<Sach> getDanhSachSachGiaoKhoa(){
		ArrayList<Sach> danhSachSachGiaoKhoa = new ArrayList<Sach>();
		for(Sach sach : danhSachSach) {
			if(sach instanceof SachGiaoKhoa)
				danhSachSachGiaoKhoa.add(sach);
		}
		return danhSachSachGiaoKhoa;
	}

	public double giaTrungBinhSachThamKhao() {
		ArrayList<Sach> danhSachSachThamKhao = getDanhSachSachThamKhao();
		double tongGia = 0;
		int soLuongSachThamKhao = danhSachSachThamKhao.size();
		if(soLuongSachThamKhao > 0) {
			for(Sach sach : danhSachSachThamKhao) {
				tongGia += sach.getDonGia();
			}
			return tongGia / soLuongSachThamKhao;
		}
		return 0;
	}
	
	public double tongGiaSachGiaoKhoa() {
		ArrayList<Sach> danhSachSachGiaoKhoa = getDanhSachSachGiaoKhoa();
		double tongGia = 0;
		for(Sach sach : danhSachSachGiaoKhoa) {
			tongGia += sach.tinhTongGia();
		}
		return tongGia;
	}
	
	public double tongGiaSachThamKhao() {
		ArrayList<Sach> danhSachSachThamKhao = getDanhSachSachThamKhao();
		double tongGia = 0;
		for(Sach sach : danhSachSachThamKhao) {
			tongGia += sach.tinhTongGia();
		}
		return tongGia;
	}
	
	public ArrayList<Sach> layDanhSachSach() {
		return danhSachSach;
	}
}
