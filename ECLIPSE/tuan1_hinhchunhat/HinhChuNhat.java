package tuan1_hinhchunhat;
public class HinhChuNhat 
{
	public int chieuDai, chieuRong;//field
	public HinhChuNhat ()
	{
		super();
	}
	public HinhChuNhat (int chieuDai, int chieuRong)
	{
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	public int getChieuDai()
	{
		return chieuDai;
	}
	public void setChieuDai(int cDai)
	{
		this.chieuDai = cDai;
	}
	public int getChieuRong()
	{
		return chieuRong;
	}
	public void setChieuRong(int cRong)
	{
		this.chieuRong = cRong;
	}
	//Hàm tính diện tích
	public long tinhDienTich()
	{
		long dt = 0;
		dt = (this.getChieuDai()* getChieuRong());
		return dt;
	}
	//Hàm tính chu vi
	public long tinhChuVi()
	{
		long cv = 0;
		cv = (this.getChieuDai()+ getChieuRong())*2;
		return cv;
	}
	@Override
	//Hàm hiển thị chu vi, diện tích
	public String toString ()
	{
		String str = String.format("%10d %10d %10d %10d", getChieuDai(), getChieuRong(), tinhChuVi(), tinhDienTich());
		return str;
	}
}