package tuan7_giaodichtienvang;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestTransaction {
	static TransactionArray transList = new TransactionArray();
	static Scanner scn = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy"); 
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");

	public static void main(String[] args) {
		try {
			int opt;
			do{
				displayTrans(transList);
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
					    System.out.println("Tổng Số Tiền Trung Bình Các Giao Dịch: " + df.format(transList.totalPriceAVG()));
					    break;
					}
					case 4: {
					    System.out.println("Tổng Số Lượng Giao Dịch Vàng: " + transList.sumQuantityGT());
					    System.out.println("Tổng Số Lượng Giao Dịch Tiền: " + transList.sumQuantityMT());
					    break;
					
					}
					case 5: {
						displayUnitPrice1B();
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
	    System.out.println("****MENU****\n" + "1. Tạo Mặc Định\n" + "2. Nhập Một Giao Dịch\n" + "3. In Tổng Giá Trị Trung Bình\n" + "4. In Tổng Số Lượng\n" + "5. In Các Giao Dịch (Giá Bán Đơn Vị >1 tỷ)\n" + "6. Thoát\n");
	    int chos = inputInt("Lựa chọn của bạn: ");
	    scn.nextLine();
	    return chos;
	}


	public static void createDefault() throws Exception {
		System.out.println("Nhập (1) để tạo Giao Dịch Vàng, (khác) để tạo Giao Dịch Tiền!");
		int chos = inputInt("Lựa chọn của bạn: ");

		scn.nextLine();
		if(chos==1) {
			Transaction trans1 = new GoldTransaction("1111", LocalDate.parse("9/9/2023",dtf), 2000000000, 100, "9999");
			Transaction trans2 = new GoldTransaction("1112", LocalDate.parse("10/10/2023",dtf), 25000000, 200, "24K");
			Transaction trans3 = new GoldTransaction("1113", LocalDate.parse("11/11/2023",dtf), 10000000, 90, "white gold");
			Transaction trans4 = new GoldTransaction("1114", LocalDate.parse("21/12/2023",dtf), 23000000, 500, "rose gold");
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}else {
			Transaction trans1 = new MoneyTransaction("2221", LocalDate.parse("19/9/2023",dtf), 30000000, 200, 1, 1);
			Transaction trans2 = new MoneyTransaction("2222", LocalDate.parse("29/9/2023",dtf), 35000000, 150, 25.283, 2);
			Transaction trans3 = new MoneyTransaction("2223", LocalDate.parse("18/9/2023",dtf), 2000000000, 300, 25.282, 2);
			Transaction trans4 = new MoneyTransaction("2224", LocalDate.parse("7/9/2023",dtf), 1500000000, 100, 24.345, 3);
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

	public static Transaction inputTrans() {
		String transCode;
		LocalDate entryDate;
		double uPrice;
		int quantity;
		System.out.println("Nhập (1) để tạo giao dịch Vàng, (bất kỳ) để tạo giao dịch Tiền!");
		int chos = inputInt("Lựa chọn của bạn: ");
		scn.nextLine();
		if (chos == 1) {
		    String goldType;

		    transCode = inputString("Nhập mã giao dịch: ");
		    while (transList.findByCode(transCode) != null) {
		        System.out.println("Mã này đã tồn tại!");
		        transCode = inputString("Nhập lại mã giao dịch: ");
		    }
		    entryDate = inputDate("Nhập ngày giao dịch: ");
		    uPrice = inputDouble("Nhập giá trị đơn vị: ");
		    quantity = inputInt("Nhập số lượng: ");
		    scn.nextLine();
		    goldType = inputString("Nhập loại vàng: ");

			
			Transaction trans = new GoldTransaction(transCode, entryDate, uPrice, quantity, goldType);
			return trans;
		}else {
			int moneyType;
			double exRate;
			
			transCode = inputString("Nhập mã giao dịch: ");
			while (transList.findByCode(transCode) != null) {
			    System.out.println("Mã này đã tồn tại!");
			    transCode = inputString("Nhập lại mã giao dịch: ");
			}
			entryDate = inputDate("Nhập ngày giao dịch: ");
			uPrice = inputDouble("Nhập giá trị đơn vị: ");
			quantity = inputInt("Nhập số lượng: ");
			scn.nextLine();
			moneyType = inputInt("Nhập loại tiền (1 hoặc 2 hoặc 3): ");
			exRate = inputDouble("Nhập tỷ giá hối đoái: ");

			
			Transaction trans = new MoneyTransaction(transCode, entryDate, uPrice, quantity, exRate, moneyType);
			return trans;
		}
	}
	
	public static void displayTrans(TransactionArray transList) {
		displayTitle();
		for(Transaction trans : transList.getList()) {
			if(trans instanceof GoldTransaction) {
				System.out.print("Gold Transaction ");
				System.out.println(trans);
			}else {
				System.out.print("Money Transaction");
				System.out.println(trans);
			}
		}
	}
	
	public static void displayUnitPrice1B() {
		System.out.println("\n***Danh sách giao dịch với giá trị đơn vị trên 1 tỷ đồng***");

		displayTitle();
		for(Transaction trans : transList.getUnitPrice1B()) {
			if(trans instanceof GoldTransaction) {
				System.out.print("Gold Transaction ");
				System.out.println(trans);
			}else {
				System.out.print("Money Transaction");
				System.out.println(trans);
			}
		}
	}

	public static void displayTitle() {
		String s = String.format("%-15s  | %-15s | %-15s | %-25s | %-15s |  %-25s | %-20s | %-15s |\n","Transaction Type", "Transaction Code", "Transaction Date", "Unit Price", "Quantity", "Total Price",  "Gold Type/Exchange Rate", "Money Type");
		System.out.printf(s);
	}
}
