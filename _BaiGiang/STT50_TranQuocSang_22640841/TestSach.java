package QLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSach {
	static Scanner scn = new Scanner(System.in);
	static MangSach danhSachSach = new MangSach();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	static DecimalFormat df = new DecimalFormat("#,##0.00VND");
	public static void main(String[] args) throws Exception {
		int luaChon;
		do {
			hienThiDanhSachSach(danhSachSach);
			luaChon = menu();
			switch (luaChon) {
				case 1: {
					taoMacDinh();
					break;
				}
				case 2: {
					Sach sachMoi = taoSachMoi();
					danhSachSach.themSach(sachMoi);
					break;
				}
				case 3: {
					xoaSach();
					break;
				}
				case 4: {
					capNhatSach();
					break;
				}
				case 5: {
					System.out.println("Đơn giá trung bình Sách Tham Khảo: " + df.format(danhSachSach.giaTrungBinhSachThamKhao()));
					break;
				}
				case 6: {
					System.out.println("Tổng giá Sách Giáo Khoa: " + df.format(danhSachSach.tongGiaSachGiaoKhoa()));
					System.out.println("Tổng giá Sách Tham Khảo: " + df.format(danhSachSach.tongGiaSachThamKhao()));
					break;
				}
				case 7: {
					hienThiSachTheoNhaXuatBan();
					break;
				}
				default:
					System.out.println("Tạm biệt");;
			}
		} while (luaChon < 8);
	}

	public static int menu() {
		System.out.println("****MENU****\n" + "1. Tạo Sách Mặc Định\n" + "2. Nhập Sách Mới\n" + "3. Xóa Sách\n" + "4. Cập Nhật\n" + "5. In Đơn Giá Trung Bình Sách Tham Khảo\n" + "6. In Tổng Giá\n" + "7. In Sách Theo Nhà Xuất Bản\n" + "8. Thoát\n");
		System.out.print("Lựa chọn của bạn: ");
		int chon = scn.nextInt();
		scn.nextLine();
		return chon;
	}

	public static void taoMacDinh() throws Exception {
		System.out.println("Nhập (1) để tạo Sách Giáo Khoa, (khác) để tạo Sách Tham Khảo!");
		System.out.print("Lựa chọn của bạn: ");
		int chon = scn.nextInt();
		scn.nextLine();
		if(chon == 1) {
			Sach gk1 = new SachGiaoKhoa("1111", LocalDate.parse("9/9/2023",dtf), 20000, 100, "Kim Đồng", true);
			Sach gk2 = new SachGiaoKhoa("1112", LocalDate.parse("10/10/2023",dtf), 25000, 150, "Lao Động", true);
			Sach gk3 = new SachGiaoKhoa("1113", LocalDate.parse("11/11/2023",dtf), 14000, 80, "Trẻ", false);
			Sach gk4 = new SachGiaoKhoa("1114", LocalDate.parse("12/12/2023",dtf), 18000, 50, "Hội Nhà Văn", false);
			danhSachSach.themSach(gk1);
			danhSachSach.themSach(gk2);
			danhSachSach.themSach(gk3);
			danhSachSach.themSach(gk4);
		} else {
			Sach tk1 = new SachThamKhao("2221", LocalDate.parse("9/9/2023",dtf), 30000, 100, "Kim Đồng", 0.1);
			Sach tk2 = new SachThamKhao("2222", LocalDate.parse("10/10/2023",dtf), 20000, 150, "Lao Động", 0.08);
			Sach tk3 = new SachThamKhao("2223", LocalDate.parse("11/11/2023",dtf), 18000, 70, "Trẻ", 0.15);
			Sach tk4 = new SachThamKhao("2224", LocalDate.parse("12/12/2023",dtf), 25000, 200, "Hội Nhà Văn", 0.06);
			danhSachSach.themSach(tk1);
			danhSachSach.themSach(tk2);
			danhSachSach.themSach(tk3);
			danhSachSach.themSach(tk4);
		}
	}

	public static boolean nhapGiaTriBoolean(String thongBao) {
		System.out.print(thongBao);
		return scn.nextBoolean();
	}

	public static String nhapGiaTriChuoi(String thongBao) {
		System.out.print(thongBao);
		return scn.nextLine();
	}

	public static double nhapGiaTriDouble(String thongBao) {
		System.out.print(thongBao);
		return scn.nextDouble();
	}

	public static long nhapGiaTriLong(String thongBao) {
		System.out.print(thongBao);
		return scn.nextLong();
	}
	
	public static LocalDate nhapNgay(String ngay) {
		System.out.print(ngay);
		return LocalDate.parse(scn.nextLine(), dtf);
	}
	
	public static Sach taoSachMoi() {
		String maSach, nhaXuatBan;
		double donGia;
		long soLuong;
		LocalDate ngayNhap;
		
		System.out.println("Nhập (1) để tạo Sách Giáo Khoa, (khác) để tạo Sách Tham Khảo!");
		System.out.print("Lựa chọn của bạn: ");
		int chon = scn.nextInt();
		scn.nextLine();
		if(chon == 1) {
			boolean tinhTrang;
			
				maSach = nhapGiaTriChuoi("Nhập mã sách: ");
				while(danhSachSach.timSachTheoMa(maSach) != null) {
					System.out.println("Sách này đã tồn tại trong danh sách!");
					maSach = nhapGiaTriChuoi("Nhập mã sách lại: ");
				}
				ngayNhap = nhapNgay("Nhập ngày nhập: ");
				donGia = nhapGiaTriDouble("Nhập đơn giá: ");
				soLuong = nhapGiaTriLong("Nhập số lượng: ");
				scn.nextLine();
				nhaXuatBan = nhapGiaTriChuoi("Nhập nhà xuất bản: ");
				tinhTrang = nhapGiaTriBoolean("Nhập tình trạng(true/false): ");
				Sach gk = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, tinhTrang);
				return gk;
		} else {
			double thue;
			
				maSach = nhapGiaTriChuoi("Nhập mã sách: ");
				while(danhSachSach.timSachTheoMa(maSach) != null) {
					System.out.println("Sách này đã tồn tại trong danh sách!");
					maSach = nhapGiaTriChuoi("Nhập mã sách lại: ");
				}
				ngayNhap = nhapNgay("Nhập ngày nhập: ");
				donGia = nhapGiaTriDouble("Nhập đơn giá: ");
				soLuong = nhapGiaTriLong("Nhập số lượng: ");
				scn.nextLine();
				nhaXuatBan = nhapGiaTriChuoi("Nhập nhà xuất bản: ");
				thue = nhapGiaTriDouble("Nhập thuế: ");
				Sach tk = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXuatBan, thue);
				return tk;
		}
	}



public static void hienThiSachTheoNhaXuatBan() {
	System.out.print("Nhập TÊN NHÀ XUẤT BẢN để hiển thị: ");
	String tenNhaXuatBan = scn.nextLine();
	ArrayList<Sach> danhSachSachNhaXuatBan = danhSachSach.timSachTheoNhaXuatBan(tenNhaXuatBan);
	System.out.println("Danh sách sách của nhà xuất bản " + tenNhaXuatBan);
	hienThiTieuDe();
	for(Sach sach : danhSachSachNhaXuatBan) {
		if(sach instanceof SachGiaoKhoa) {
			System.out.print("\tSách Giáo Khoa ");
			System.out.println(sach);
		} else {
			System.out.print("\tSách Tham Khảo ");
			System.out.println(sach);
		}
	}
	System.out.println("\n");
}

public static void xoaSach() throws Exception {
	System.out.print("Nhập MÃ SÁCH để xóa: ");
	String maSach = scn.nextLine();
	Sach sachCanXoa = danhSachSach.timSachTheoMa(maSach);
    if (sachCanXoa != null) {
    	String cauHoi = nhapGiaTriChuoi("Bạn có muốn xóa sách với mã " + maSach + "(y hoặc n): ");
    	if(cauHoi.equalsIgnoreCase("Y")) {
    		danhSachSach.xoaSach(sachCanXoa);
	        System.out.println("Sách với mã sách (" + maSach + ") đã được xóa.");
    	} else {
    		System.out.println("Xóa sách với mã sách (" + maSach + ") thất bại.");
    	}
    } else {
        throw new Exception("Không tìm thấy sách với mã sách (" + maSach + ").");
    }
}

public static void capNhatSach() throws Exception {
	System.out.print("Nhập MÃ SÁCH để cập nhật: ");
	String maSach = scn.nextLine();
	Sach sachCanCapNhat = danhSachSach.timSachTheoMa(maSach);
	if(sachCanCapNhat != null) {
		String nhaXuatBan;
		double donGia;
		long soLuong;
		LocalDate ngayNhap;
		if(sachCanCapNhat instanceof SachGiaoKhoa) {
			int luaChon;
			do {
				luaChon = menuCapNhatSachGK();
				switch (luaChon) {
					case 1:{
						ngayNhap = nhapNgay("Nhập ngày nhập: ");
						sachCanCapNhat.setNgayNhap(ngayNhap);
						break;
					}
					case 2: {
						donGia = nhapGiaTriDouble("Nhập đơn giá: ");
						sachCanCapNhat.setDonGia(donGia);
						scn.nextLine();
						break;
					}
					case 3: {
						soLuong = nhapGiaTriLong("Nhập số lượng: ");
						sachCanCapNhat.setSoLuong(soLuong);
						scn.nextLine();
						break;
					}
					case 4: {
						nhaXuatBan = nhapGiaTriChuoi("Nhập nhà xuất bản: ");
						sachCanCapNhat.setNhaXuatBan(nhaXuatBan);
						break;
					}
					case 5: {
						boolean tinhTrang = nhapGiaTriBoolean("Nhập tình trạng(true/false): ");
						((SachGiaoKhoa)sachCanCapNhat).setTinhTrang(tinhTrang);
						break;
					}
					default:{
						System.out.println("Cập nhật thành công!");
						break;
					}	
				}
				
			} while (luaChon < 6);
		} else {
			int luaChon;
			do {
				luaChon = menuCapNhatSachTK();
				switch (luaChon) {
					case 1:{
						ngayNhap = nhapNgay("Nhập ngày nhập: ");
						sachCanCapNhat.setNgayNhap(ngayNhap);
						break;
					}
					case 2: {
						donGia = nhapGiaTriDouble("Nhập đơn giá: ");
						sachCanCapNhat.setDonGia(donGia);
						scn.nextLine();
						break;
					}
					case 3: {
						soLuong = nhapGiaTriLong("Nhập số lượng: ");
						sachCanCapNhat.setSoLuong(soLuong);
						scn.nextLine();
						break;
					}
					case 4: {
						nhaXuatBan = nhapGiaTriChuoi("Nhập nhà xuất bản: ");
						sachCanCapNhat.setNhaXuatBan(nhaXuatBan);
						break;
					}
					case 5: {
						double thue = nhapGiaTriDouble("Nhập thuế: ");
						((SachThamKhao)sachCanCapNhat).setThue(thue);
						break;
					}
					default:{
						System.out.println("Cập nhật thành công!");
						break;
					}
				}
			} while (luaChon < 6);
		}
	} else {
		throw new Exception("Không tìm thấy sách với mã sách (" + maSach + ").");
	}
}

public static int menuCapNhatSachGK() {
	System.out.println("****MENU****\n" + "1. Ngày Nhập\n" + "2. Đơn Giá\n" + "3. Số Lượng\n" + "4. Nhà Xuất Bản\n" + "5. Tình Trạng\n" + "6. Thoát\n");
	System.out.print("Lựa chọn của bạn: ");
	int chon = scn.nextInt();
	scn.nextLine();
	return chon;
}

public static int menuCapNhatSachTK() {
	System.out.println("****MENU****\n" + "1. Ngày Nhập\n" + "2. Đơn Giá\n" + "3. Số Lượng\n" + "4. Nhà Xuất Bản\n" + "5. Thuế\n" + "6. Thoát\n");
	System.out.print("Lựa chọn của bạn: ");
	int chon = scn.nextInt();
	scn.nextLine();
	return chon;
}

public static void hienThiDanhSachSach(MangSach danhSachSach) {
	hienThiTieuDe();
	for(Sach sach : danhSachSach.layDanhSachSach()) {
		if(sach instanceof SachGiaoKhoa) {
			System.out.print("\tSách Giáo Khoa ");
			System.out.println(sach);
		} else {
			System.out.print("\tSách Tham Khảo ");
			System.out.println(sach);
		}
	}
}

public static void hienThiTieuDe() {
	String tieuDe = String.format("\t%s \t%15s \t%12s \t%17s \t%9s \t%14s \t%14s \t%19s\n","Loại Sách", "Mã Sách", "Ngày Nhập", "Đơn Giá", "Số Lượng", "Nhà Xuất Bản", "Tình Trạng/Thuế", "Tổng Giá");
	System.out.printf(tieuDe);
}

}
