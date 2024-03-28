package tuan5_chuyenxe;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TestChuyenXe {
	static Scanner scn = new Scanner(System.in);
	static DanhSachChuyenXe danhSachChuyenXe = new DanhSachChuyenXe();
	
	public static void main(String[] args) throws Exception {
		try {
			int opt;
			do {
				displayTrip(danhSachChuyenXe);
				opt=menu();
				switch (opt) {
					case 1: {
						createDefault();
					break;
					}
					case 2: {
						ChuyenXe newTrip = createATrip();
						danhSachChuyenXe.addTrip(newTrip);
					break;
					}
					case 3: {
						removeATrip();
						break;
					}
					case 4: {
						updateTrip();
						break;
					}
					case 5: {
						DecimalFormat df = new DecimalFormat("#,##0.00VND");
						System.out.println("Tổng doanh thu Nội Thành: " + df.format(danhSachChuyenXe.sumRevenueNT()));
						System.out.println("Tổng doanh thu Ngoại Thành: " + df.format(danhSachChuyenXe.sumRevenueNgT()));

						break;
					}
					default:
						System.out.println("Goodbye");;
				}
			}while(opt<6);
		} catch (Exception err) {
			System.out.println(err);
		}
	}
	
	public static int menu() {
		System.out.println("****MENU****\n" + "1. Tạo Mặc Định\n" + "2. Nhập Chuyến Đi\n" + "3. Xóa Chuyến Đi\n" + "4. Cập Nhật\n" + "5. In Doanh Thu\n" + "6. Thoát\n" );
		System.out.print("Lựa chọn của bạn: ");

		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Nhập (1) để tạo Chuyến Nội Thành, (khác) để tạo Chuyến Ngoại Thành!");
		System.out.print("Lựa chọn của bạn: ");

		int chos = scn.nextInt();
		if(chos==1) {
			ChuyenXe nt1 = new NoiThanh("1111","Tran Quoc Sang", "81-XXXX", 25000000, 32, 2);
			ChuyenXe nt2 = new NoiThanh("1112","Nguyen Vu Tam Nhu", "79-XXXX", 15000000, 250, 1);
			ChuyenXe nt3 = new NoiThanh("1113","Duong Bao Trang", "81-XXXX", 5000000, 100, 5);
			ChuyenXe nt4 = new NoiThanh("1114","Duong Thanh Huyen", "26-XXXX", 10000000, 200, 2);
			danhSachChuyenXe.addTrip(nt1);
			danhSachChuyenXe.addTrip(nt2);
			danhSachChuyenXe.addTrip(nt3);
			danhSachChuyenXe.addTrip(nt4);
		}else {
			ChuyenXe ngt1 = new NgoaiThanh("1111","Tran Quoc Sang", "81-XXXX", 30000000, "An Giang", 2);
			ChuyenXe ngt2 = new NgoaiThanh("1112","Nguyen Vu Tam Nhu", "79-XXXX", 20000000, "An Giang", 2);
			ChuyenXe ngt3 = new NgoaiThanh("1113","Duong Bao Trang", "81-XXXX", 32000000, "An Giang", 2);
			ChuyenXe ngt4 = new NgoaiThanh("1114","Duong Thanh Huyen", "26-XXXX", 25000000, "An Giang", 2);
			danhSachChuyenXe.addTrip(ngt1);
			danhSachChuyenXe.addTrip(ngt2);
			danhSachChuyenXe.addTrip(ngt3);
			danhSachChuyenXe.addTrip(ngt4);
		}
	}
	
	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}
	
	public static ChuyenXe createATrip() {
		String tripCode, driverName, numPlate;
		double revenue;
		System.out.println("Nhập (1) để tạo Chuyến Nội Thành, (khác) để tạo Chuyến Ngoại Thành!");
		int chos = inputInt("Lựa chọn của bạn: ");

		scn.nextLine();
		if(chos==1) {
			double km;
			int route;
			tripCode = inputString("Nhập mã chuyến đi: ");
			while (danhSachChuyenXe.findTripCode(tripCode) != null) {
			    System.out.println("Chuyến đi này đã tồn tại!");
			    tripCode = inputString("Nhập lại mã chuyến đi: ");
			}

			driverName = inputString("Nhập tên tài xế: ");
			numPlate = inputString("Nhập biển số xe: ");
			revenue = inputDouble("Nhập doanh thu: ");
			km = inputDouble("Nhập số km đã đi: ");
			route = inputInt("Nhập số tuyến đường: ");

			ChuyenXe nt = new NoiThanh(tripCode, driverName, numPlate, revenue, km, route); 
			return nt;
		}else {
			String desti;
			int travel;
			
			tripCode = inputString("Nhập mã chuyến đi: ");
			driverName = inputString("Nhập tên tài xế: ");
			numPlate = inputString("Nhập biển số xe: ");
			revenue = inputDouble("Nhập doanh thu: ");
			scn.nextLine(); // Đọc dòng trống để xử lý vấn đề buffer
			desti = inputString("Nhập địa điểm đến: ");
			travel = inputInt("Nhập số ngày đi: ");

			ChuyenXe ngt = new NgoaiThanh(tripCode, driverName, numPlate, revenue, desti, travel);
			return ngt;
		}
	}
	
	public static void removeATrip() throws Exception {
	    System.out.println("Input TRIP CODE to remove: ");
	    String tripCode = scn.nextLine();
	    ChuyenXe rmTrip = danhSachChuyenXe.findTripCode(tripCode);
	    if (rmTrip != null) {
	        danhSachChuyenXe.removeTrip(rmTrip);
	        System.out.println("Chuyến đi có mã (" + tripCode + ") đã được xóa.");
	    } else {
	        throw new Exception("Chuyến đi có mã (" + tripCode + ") không được tìm thấy.");
	    }

	}
	
	public static void updateTrip() throws Exception {
		System.out.print("Nhập MÃ CHUYẾN ĐI cần cập nhật: ");

		String tripCode = scn.nextLine();
		ChuyenXe udTrip = danhSachChuyenXe.findTripCode(tripCode);
		if(udTrip != null) {
			if(udTrip instanceof NoiThanh) {
				int opt;
				do {
					opt=menuUpdateNT();
					switch (opt) {
					case 1: {
					    System.out.print("Nhập tên tài xế: ");
					    udTrip.setDriverName(scn.nextLine());
					    break;
					}
					case 2:{
					    System.out.print("Nhập biển số xe: ");
					    udTrip.setNumberPlate(scn.nextLine());
					    break;
					}
					case 3: {
					    System.out.print("Nhập doanh thu: ");
					    udTrip.setRevenue(scn.nextDouble());
					    scn.nextLine();
					    break;
					}
					case 4: {
					    System.out.print("Nhập số km đã đi: ");
					    ((NoiThanh)udTrip).setKmTraveled(scn.nextDouble());
					    scn.nextLine();
					    break;
					}
					case 5: {
					    System.out.print("Nhập số tuyến đường: ");
					    ((NoiThanh)udTrip).setRouteNumber(scn.nextInt());
					    scn.nextLine();
					    break;
					}
					default:{
					    System.out.println("Cập nhật thành công!");
					    break;
					}

					}
				}while(opt<6);
			}else {
				int opt;
				do {
					opt = menuUpdateNgT();
					switch (opt) {
					case 1: {
					    System.out.print("Nhập tên tài xế: ");
					    udTrip.setDriverName(scn.nextLine());
					    break;
					}
					case 2: {
					    System.out.print("Nhập biển số xe: ");
					    udTrip.setNumberPlate(scn.nextLine());
					    break;
					}
					case 3: {
					    System.out.print("Nhập doanh thu: ");
					    udTrip.setRevenue(scn.nextDouble());
					    scn.nextLine();
					    break;
					}
					case 4: {
					    System.out.print("Nhập địa điểm đến: ");
					    ((NgoaiThanh)udTrip).setDestination(scn.nextLine());
					    break;
					}
					case 5: {
					    System.out.print("Nhập số ngày đi: ");
					    ((NgoaiThanh)udTrip).setTravelDay(scn.nextInt());
					    break;
					}
					default:{
					    System.out.println("Cập nhật thành công!");
					    break;
					}

					}
				}while(opt<6);
			}
		} else {
		    throw new Exception("Chuyến đi có mã (" + tripCode + ") không được tìm thấy.");
		}
		}

		public static int menuUpdateNT() {
		    System.out.println("****MENU****\n" + "1. Tên Tài Xế\n" + "2. Biển Số Xe\n" + "3. Doanh Thu\n" + "4. Số Km Đã Đi\n" + "5. Số Tuyến Đường\n" + "6. Thoát\n" );
		    System.out.print("Lựa chọn của bạn: ");
		    int chos = scn.nextInt();
		    scn.nextLine();
		    return chos;
		}

		public static int menuUpdateNgT() {
		    System.out.println("****MENU****\n" + "1. Tên Tài Xế\n" + "2. Biển Số Xe\n" + "3. Doanh Thu\n" + "4. Địa Điểm Đến\n" + "5. Số Ngày Đi\n" + "6. Thoát\n" );
		    System.out.print("Lựa chọn của bạn: ");

		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void displayTrip(DanhSachChuyenXe danhSachChuyenXe) {
		displayTitle();
		for(ChuyenXe trip : danhSachChuyenXe.getList()) {
			if(trip instanceof NoiThanh) {
				System.out.print("\tNoiThanh");
				System.out.println(trip);
			}else {
				System.out.print("\tNgoaiThanh");
				System.out.println(trip);
			}
		}
	}
	
	public static void displayTitle() {
		String s = String.format("\t%s \t%s \t%16s \t%15s \t%16s \t%s \t%s\n","Trip Type", "Trip Code", "Driver Name", "Plate Number", "Revenue", "Km Traveled/Destination", "Route Number/Travel Day");
		System.out.printf(s);
	}
}
