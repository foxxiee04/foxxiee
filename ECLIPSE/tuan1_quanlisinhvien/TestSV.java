package tuan1_quanlisinhvien;

import java.util.Scanner;

public class TestSV 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo sinh viên sv1 (thông tin của bạn)
        SinhVien sv1 = new SinhVien(22640841, "Trần Quốc Sáng", 8.5f, 7.5f);

        // Tạo sinh viên sv2 (thông tin người bạn thân nhất của bạn)
        SinhVien sv2 = new SinhVien(22640840, "Nguyễn Vũ Tâm Như", 7.0f, 6.5f);


        SinhVien sv3 = new SinhVien();
        System.out.println("Nhập thông tin cho sinh viên");
        System.out.print("Mã sinh viên: ");
        sv3.setMaSinhVien(scanner.nextInt());
        scanner.nextLine(); // Đọc dòng trống
        System.out.print("Họ tên: ");
        sv3.setHoTen(scanner.nextLine());
        System.out.print("Điểm LT: ");
        sv3.setDiemLT(scanner.nextFloat());
        System.out.print("Điểm TH: ");
        sv3.setDiemTH(scanner.nextFloat());

        // In bảng danh sách sinh viên
        System.out.println("\nDanh sách sinh viên: ");
        System.out.println("MSSV      Họ và tên                      Điểm LT Điểm TH Điểm TB");
        System.out.println("-------------------------------------------------------------");
        // Tạo sinh viên sv3 (sử dụng constructor mặc định)
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);

        scanner.close();
    } 
}
