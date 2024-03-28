package tuan1_hinhchunhat;
import java.util.Scanner;
public class TestHCN 
{
	private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opt;
        do {
            opt = menu();
            switch (opt) {
                case 1: {
                    xuatTieuDeCot();
                    nhapCung();
                    break;
                }
                case 2: {
                    HinhChuNhat cn1 = nhapMemHCN();
                    xuatTieuDeCot();
                    System.out.println(cn1);
                    break;
                }
                case 3: {
                    System.out.println("Thoát");
                    break;
                }
            }
        } while (opt != 3);
        // Đóng Scanner sau khi chương trình kết thúc
        sc.close();
    }

	static void xuatTieuDeCot()
	{
		String s = String.format("%10s %10s %10s %10s", "Chiều dài", "Chiều rộng", "Chu vi", "Diện tích");
		System.out.println(s);
	}
	public static int nhapSoNguyen(String str)
	{
		int x=0;
		System.out.println(str);
		x = sc.nextInt();
		return x;
	}
	public static HinhChuNhat nhapMemHCN()
	{
		int d, r;
		d = nhapSoNguyen("Nhập chiều dài: ");
		r = nhapSoNguyen("Nhập chiều rộng: ");
		HinhChuNhat cn = new HinhChuNhat(d,r);
		return cn;
	}
	public static void nhapCung()
	{
		HinhChuNhat cn1 = new HinhChuNhat();
		cn1.setChieuDai(5);
		cn1.setChieuRong(3);
		HinhChuNhat cn2 = new HinhChuNhat (10, 8);
		System.out.println(cn1);
		System.out.println(cn2);
	}
	public static int menu ()
	{
		int chon;
		System.out.println("MENU\n" + "1. Nhập cứng\n" +"2. Nhập mềm\n" +"3. Thoát\n");
		chon = nhapSoNguyen("Mời bạn nhập: ");
		return chon;
	}
}
