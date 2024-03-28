package tuan6_qlsach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBook {
	static Scanner scn = new Scanner(System.in);
	static BookArray bookList = new BookArray();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	static DecimalFormat df = new DecimalFormat("#,##0.00VND");
	public static void main(String[] args) throws Exception {
		int opt;
		do {
			displayBook(bookList);
			opt=menu();
			switch (opt) {
			case 1: {
				createDefault();
				break;
			}
			case 2: {
				Sach newBook = createABook();
				bookList.addBook(newBook);
				break;
			}
			case 3: {
				removeABook();
				break;
			}
			case 4: {
				updateBook();
				break;
			}
			case 5: {
				System.out.println("Giá Trung Bình Tham Khảo: " + df.format(bookList.unitPriceAVG()));
				break;
			}
			case 6: {
				System.out.println("Tổng Giá Trị Giao Khảo: " + df.format(bookList.sumTotalPriceGK()));
				System.out.println("Tổng Giá Trị Tham Khảo: " + df.format(bookList.sumTotalPriceTK()));
			}

			case 7: {
				displayXPublisher();
				break;
			}
			default:
				System.out.println("Goodbye");;
			}
		}while(opt<8);
	}

	// Hiển thị menu và trả về lựa chọn người dùng
	public static int menu() {
		System.out.println("****MENU****\n" + "1. Tạo danh sách mặc định\n" + "2. Nhập thông tin sách\n" + "3. Xóa sách\n" + "4. Cập nhật\n"
				+ "5. In giá trung bình đơn vị\n" + "6. In Tổng giá\n" + "7. In sách của nhà xuất bản X\n" + "8. Thoát\n");
		System.out.print("Lựa chọn của bạn: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}

	public static void createDefault() throws Exception {
		System.out.println("Nhập (1) để tạo Sách Giáo Khoa, (khác) để tạo Sách Tham Khảo!");
		System.out.print("Lựa chọn của bạn: ");
		int chos = scn.nextInt();
		scn.nextLine();
		if(chos==1) {
			Sach gk1 = new SachGiaoKhoa("1111", LocalDate.parse("12/11/2023",dtf), 20000, 100, "Nhan Van", true);
			Sach gk2 = new SachGiaoKhoa("1112", LocalDate.parse("05/10/2023",dtf), 25000, 150, "Nhan Van", true);
			Sach gk3 = new SachGiaoKhoa("1113", LocalDate.parse("1/11/2023",dtf), 14000, 80, "Kim Dong", false);
			Sach gk4 = new SachGiaoKhoa("1114", LocalDate.parse("02/12/2023",dtf), 18000, 50, "Hoi Nha Van", false);
			bookList.addBook(gk1);
			bookList.addBook(gk2);
			bookList.addBook(gk3);
			bookList.addBook(gk4);
		}else {
			Sach tk1 = new SachThamKhao("2221", LocalDate.parse("07/9/2023",dtf), 30000, 100, "Tre", 0.1);
			Sach tk2 = new SachThamKhao("2222", LocalDate.parse("15/10/2023",dtf), 20000, 150, "Lao Dong", 0.08);
			Sach tk3 = new SachThamKhao("2223", LocalDate.parse("13/11/2023",dtf), 18000, 70, "Tre", 0.15);
			Sach tk4 = new SachThamKhao("2224", LocalDate.parse("12/12/2023",dtf), 25000, 200, "Lao Dong", 0.06);
			bookList.addBook(tk1);
			bookList.addBook(tk2);
			bookList.addBook(tk3);
			bookList.addBook(tk4);
		}
	}

	public static boolean inputBoolean(String s) {
		System.out.print(s);
		return scn.nextBoolean();
	}

	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}

	public static long inputLong(String s) {
		System.out.print(s);
		return scn.nextLong();
	}

	public static LocalDate inputDate(String day) {
		System.out.print(day);
		return LocalDate.parse(day, dtf);
	}

	public static Sach createABook() {
		String bookCode, publisher;;
		double uPrice;
		long quantity;
		LocalDate entryDate;

		System.out.println("Nhập (1) để tạo Sách Giáo Khoa, (khác) để tạo Sách Tham Khảo!");
		System.out.print("Lựa chọn của bạn: ");
		int chos = scn.nextInt();
		scn.nextLine();
		if (chos == 1) {
			boolean condition;

			bookCode = inputString("Nhập mã sách: ");
			while (bookList.findBookByCode(bookCode) != null) {
				System.out.println("Sách này đã tồn tại!");
				bookCode = inputString("Nhập lại mã sách: ");
			}
			entryDate = inputDate("Nhập ngày nhập sách: ");
			uPrice = inputDouble("Nhập giá bán đơn vị: ");
			quantity = inputLong("Nhập số lượng: ");
			scn.nextLine();
			publisher = inputString("Nhập nhà xuất bản: ");
			condition = inputBoolean("Nhập tình trạng (true/false): ");


			Sach gk = new SachGiaoKhoa(bookCode, entryDate, uPrice, quantity, publisher, condition);
			return gk;
		}else {
			double tax;

			bookCode = inputString("Nhập mã sách: ");
			while (bookList.findBookByCode(bookCode) != null) {
				System.out.println("Sách này đã tồn tại!");
				bookCode = inputString("Nhập lại mã sách: ");
			}
			entryDate = inputDate("Nhập ngày nhập sách: ");
			uPrice = inputDouble("Nhập giá bán đơn vị: ");
			quantity = inputLong("Nhập số lượng: ");
			scn.nextLine();
			publisher = inputString("Nhập nhà xuất bản: ");
			tax = inputDouble("Nhập thuế: ");
			Sach tk = new SachThamKhao(bookCode, entryDate, uPrice, quantity, publisher, tax);
			return tk;
		}
	}

	public static void displayXPublisher() {
		System.out.print("Nhập TÊN NHÀ XUẤT BẢN để hiển thị: ");

		String publisherName = scn.nextLine();
		ArrayList<Sach> pubBook = bookList.findBookByPublisher(publisherName);
		System.out.println("List " + publisherName + " books");
		displayTitle();
		for(Sach book : pubBook) {
			if(book instanceof SachGiaoKhoa) {
				System.out.print("\tSach Giao Khoa ");
				System.out.println(book);
			}else {
				System.out.print("\tSach Tham Khao ");
				System.out.println(book);
			}
		}
		System.out.println("\n");
	}

	public static void removeABook() throws Exception {
		System.out.print("Nhập MÃ SÁCH để xóa: ");
		String bookCode = scn.nextLine();
		Sach rmBook = bookList.findBookByCode(bookCode);
		if (rmBook != null) {
			String ques = inputString("Bạn có muốn xóa sách với mã " + bookCode + "(y hoặc n): ");
			if (ques.equalsIgnoreCase("Y")) {
				bookList.removeBook(rmBook);
				System.out.println("Sách với mã sách (" + bookCode + ") đã được xóa.");
			} else {
				System.out.println("Xóa sách với mã sách (" + bookCode + ") thất bại.");
			}
		} else {
			throw new Exception("Sách với mã sách (" + bookCode + ") không được tìm thấy.");
		}

	}

	public static void updateBook() throws Exception {
		System.out.print("Nhập MÃ SÁCH để cập nhật: ");

		String bookCode = scn.nextLine();
		Sach udBook = bookList.findBookByCode(bookCode);
		if(udBook != null) {
			String publisher;
			double uPrice;
			long quantity;
			LocalDate entryDate;
			if(udBook instanceof SachGiaoKhoa) {
				int opt;
				do {
					opt=menuUpdateGK();
					switch (opt) {
					case 1: {
						entryDate = inputDate("Nhập ngày nhập sách: ");
						udBook.setEntryDate(entryDate);
						break;
					}
					case 2: {
						uPrice = inputDouble("Nhập giá bán đơn vị: ");
						udBook.setUnitPrice(uPrice);
						scn.nextLine();
						break;
					}
					case 3: {
						quantity = inputLong("Nhập số lượng: ");
						udBook.setQuantity(quantity);
						scn.nextLine();
						break;
					}
					case 4: {
						publisher = inputString("Nhập nhà xuất bản: ");
						udBook.setPublisher(publisher);
						break;
					}
					case 5: {
						boolean condition = inputBoolean("Nhập tình trạng (true/false): ");
						((SachGiaoKhoa)udBook).setCondition(condition);
						break;
					}
					default:{
						System.out.println("Cập nhật thành công!");
						break;


					}	
					}

				}while(opt<7);
			}else {
				int opt;
				do {
					opt = menuUpdateTK();
					switch (opt) {
					case 1: {
						entryDate = inputDate("Nhập ngày nhập sách: ");
						udBook.setEntryDate(entryDate);
						break;
					}
					case 2: {
						uPrice = inputDouble("Nhập giá bán đơn vị: ");
						udBook.setUnitPrice(uPrice);
						scn.nextLine();
						break;
					}
					case 3: {
						quantity = inputLong("Nhập số lượng: ");
						udBook.setQuantity(quantity);
						scn.nextLine();
						break;
					}
					case 4: {
						publisher = inputString("Nhập nhà xuất bản: ");
						udBook.setPublisher(publisher);
						break;
					}
					case 5: {
						double tax = inputDouble("Nhập thuế: ");
						((SachThamKhao)udBook).setTax(tax);
						break;
					}
					default: {
						System.out.println("Cập nhật thành công!");
						break;
					}
					}
				} while (opt < 6);
			}
		} else {
			throw new Exception("Sách với mã sách (" + bookCode + ") không được tìm thấy.");
		}

	}

	public static int menuUpdateGK() {
		System.out.println("****MENU****\n" + "1. Ngày Nhập Sách\n" + "2. Giá Bán Đơn Vị\n" + "3. Số Lượng\n" + "4. Nhà Xuất Bản\n" + "5. Tình Trạng\n" + "6. Thoát\n");
		System.out.print("Lựa chọn của bạn: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}

	public static int menuUpdateTK() {
		System.out.println("****MENU****\n" + "1. Ngày Nhập Sách\n" + "2. Giá Bán Đơn Vị\n" + "3. Số Lượng\n" + "4. Nhà Xuất Bản\n" + "5. Thuế\n" + "6. Thoát\n");
		System.out.print("Lựa chọn của bạn: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}


	public static void displayBook(BookArray bookList) {
		displayTitle();
		for(Sach book : bookList.getList()) {
			if(book instanceof SachGiaoKhoa) {
				System.out.print("\tSach Giao Khoa ");
				System.out.println(book);
			}else {
				System.out.print("\tSach Tham Khao ");
				System.out.println(book);
			}
		}
	}

	public static void displayTitle() {
		String s = String.format("\t%s \t%15s \t%12s \t%17s \t%9s \t%14s \t%14s \t%19s\n","Book Type", "Book Code", "Entry Date", "Unit Price", "Quantity", "Publisher", "Condition/Tax", "Total Price");
		System.out.printf(s);
	}
}
