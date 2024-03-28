package tuan8_giaodichdat;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TestTransacion {
	static TransactionArray transList = new TransactionArray();
	static Scanner scn = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	public static void main(String[] args) {
		try {
			int opt;
			do{
				displayList(transList);
				opt=menu();
				switch(opt) {
					case 1: {
						createDefault();
						break;
					}
					case 2: {
						Transaction trans = inputTrans();
						transList.addTrans(trans);
						break;
					}
					case 3: {
					    System.out.println("Tổng giao dịch Trung bình Đất: " + df.format(transList.avgLandTrans()));
					    break;
					}
					case 4: {
					    System.out.println("Tổng Số lượng Giao dịch Đất: " + transList.getQuantityLT());
					    System.out.println("Tổng Số lượng Giao dịch Nhà: " + transList.getQuantityHT());
					    break;
					}

					case 5: {
						displayListDate(transList);
						break;
					}
					default : {
						System.out.println("Goodbye!");
					}
				}
			}while(opt<6);

		}catch(Exception err) {
			System.out.println(err);
		}
	}
	
	public static int menu() {
		System.out.println("****MENU****\n" + "1.Tạo Mặc định\n" + "2.Nhập Giao dịch\n" + "3.In Giá trị trung bình Tổng\n" + "4.In Tổng Số lượng\n" + "5.In Giao dịch (9/2013)\n" + "6.Thoát\n");
		int chos = inputInt("Lựa chọn của bạn: ");

		scn.nextLine();
		return chos;
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Nhập (1) để tạo giao dịch Vàng, (bất kỳ) để tạo giao dịch Tiền!");
		int chos = inputInt("Lựa chọn của bạn: ");

		scn.nextLine();
		if(chos == 1) {
			Transaction trans1 = new LandTransaction("1111", LocalDate.parse("29/9/2013",dtf), 600000000, 500, "A"); 
			Transaction trans2 = new LandTransaction("1112", LocalDate.parse("11/1/2013",dtf), 100000000, 200, "B");
			Transaction trans3 = new LandTransaction("1113", LocalDate.parse("1/11/2013",dtf), 300000000, 100, "B");
			Transaction trans4 = new LandTransaction("1114", LocalDate.parse("12/12/2013",dtf), 200000000, 700, "C");
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}else {
			Transaction trans1 = new HouseTransaction("2221", LocalDate.parse("10/1/2023",dtf), 200000000, 100, 1, "566 NTS");
			Transaction trans2 = new HouseTransaction("2222", LocalDate.parse("16/9/2013",dtf), 500000000, 200, 2, "566 NTS");
			Transaction trans3 = new HouseTransaction("2223", LocalDate.parse("11/9/2013",dtf), 400000000, 400, 2, "566 NTS");
			Transaction trans4 = new HouseTransaction("2224", LocalDate.parse("1/12/2023",dtf), 800000000, 1000, 1, "566 NTS");
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}
	}
	
	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}

	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static LocalDate inputDate(String day) {
		System.out.print(day);
		return LocalDate.parse(day, dtf);
	}
	
	public static Transaction inputTrans() throws Exception {
		String transCode;
		LocalDate entryDate;
		double uPrice, area;

		System.out.println("Nhập (1) để tạo giao dịch Đất, (bất kỳ) để tạo giao dịch Nhà!");
		int chos = inputInt("Lựa chọn của bạn: ");
		scn.nextLine();
		if(chos == 1) {
		    String landType;

		    transCode = inputString("Nhập mã giao dịch: ");
		    while(transList.findByCode(transCode)!=null) {
		        System.out.println("Mã này đã tồn tại!");
		        transCode = inputString("Nhập lại mã giao dịch: ");
		    }
		    entryDate = inputDate("Nhập ngày giao dịch: ");
		    uPrice = inputDouble("Nhập giá trị đơn vị: ");
		    area = inputDouble("Nhập diện tích: ");
		    scn.nextLine();
		    landType = inputString("Nhập loại đất: ");
		
			
			Transaction trans = new LandTransaction(transCode, entryDate, uPrice, area, landType);
			return trans;
		}else {
			int houseType; 
			String address;
			
			transCode = inputString("Nhập mã giao dịch: ");
			while (transList.findByCode(transCode) != null) {
			    System.out.println("Mã này đã tồn tại!");
			    transCode = inputString("Nhập lại mã giao dịch: ");
			}
			entryDate = inputDate("Nhập ngày giao dịch: ");
			uPrice = inputDouble("Nhập giá trị đơn vị: ");
			area = inputDouble("Nhập diện tích: ");
			scn.nextLine();
			houseType = inputInt("Nhập 1 (Cao cấp) hoặc 2 (Thường): ");
			address = inputString("Nhập địa chỉ: ");


			Transaction trans = new HouseTransaction(transCode, entryDate, uPrice, area, houseType, address);
			return trans;
		}
	}
	
	public static void displayTitle() {
		String s = String.format("%s %20s %20s %20s %20s  %23s %25s %20s","Transaction Type", "Transaction Code", "Transaction Date", "Unit Price", "Area", "Total Price",  "Land Type/House Type", "House Address");
		System.out.println(s);
	}
	
	public static void displayList(TransactionArray transList) {
		displayTitle();
		for(Transaction trans : transList.getAll()) {
			if(trans instanceof LandTransaction) {
				System.out.print("LandTransaction ");
				System.out.println(trans);
			}else {
				System.out.print("HouseTransaction");
				System.out.println(trans);
			}
		}
	}
	
	public static void displayListDate(TransactionArray transList) {
		System.out.println("***List Date 9/2013***");
		displayTitle();
		for(Transaction trans : transList.getTransByDate()) {
			if(trans instanceof LandTransaction) {
				System.out.print("LandTransaction ");
				System.out.println(trans);
			}else {
				System.out.print("HouseTransaction");
				System.out.println(trans);
			}
		}
		System.out.println("\n");
	};
}
