package tuan1_quanlisinhvien;
public class SinhVien 
{

	private int maSinhVien;
	private String hoTen;
	private float diemLT;
	private float diemTH;

	// Constructors


	public SinhVien(int maSinhVien, String hoTen, float diemLT, float diemTH) {
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
	public int getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(int maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	// Tính điểm trung bình
	public float tinhDiemTrungBinh() {
		return (diemLT + diemTH) / 2;
	}

	// Phương thức toString
	@Override
	public String toString() {
		return String.format("%-10d %-30s %5.2f %5.2f %5.2f", maSinhVien, hoTen, diemLT, diemTH, tinhDiemTrungBinh());
	}
}
