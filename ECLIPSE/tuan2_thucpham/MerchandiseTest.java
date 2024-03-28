package tuan2_thucpham;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MerchandiseTest {
	static MerchanArray merchanList; 
	static Scanner sn = new Scanner(System.in);
	static DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
	public static void main(String[] args) throws Exception {
		merchanList = new MerchanArray();
		int opt;
		try {
			do {
				opt = menu();	
				switch (opt) {
					case 1: {
						Merchandise newMer = createAMerchan();
						merchanList.addMerchan(newMer);
						break;
					}
					case 2: {
						createDefaultMerchan();
						break;
					}
					case 3: {
						displayTitle();
						displayMerchanList();
						break;
					}
					case 4:{
						System.out.println("Goodbye!");
						break;
					}
				}
			}while(opt!=4);
		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Create A Merchandise\n" + "2.Create Merchandise List\n" + "3.Print Merchandise List \n" + "4.Exit\n");
		chos = inputInt("Your choice: ");
		return chos;
	}

	public static int inputInt(String s) {
		System.out.print(s);
		return sn.nextInt();
	}

	public static String inputString(String s) {
		System.out.print(s);
		return sn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return sn.nextDouble();
	}

	public static long inputLong(String s) {
		System.out.print(s);
		return sn.nextLong();
	}
	
	public static LocalDate inputDate(String day) throws ParseException {
		System.out.print(day);
		return LocalDate.parse(day, df);
	}
	
	public static void createDefaultMerchan() throws Exception {
		Merchandise mer1 = new Merchandise(1111,"Cookie",10, LocalDate.parse("26/12/2023",df),LocalDate.parse("26/1/2024",df));
		Merchandise mer2 = new Merchandise(1112,"Milk",20, LocalDate.parse("18/8/2023",df),LocalDate.parse("25/11/2023",df));
		Merchandise mer3 = new Merchandise(1113,"Sandwich",30, LocalDate.parse("10/9/2023",df),LocalDate.parse("09/9/2023",df));
		Merchandise mer4 = new Merchandise(1114,"Juice",40, LocalDate.parse("25/5/2023",df),LocalDate.parse("25/11/2023",df));
		
		merchanList.addMerchan(mer1);
		merchanList.addMerchan(mer2);
		merchanList.addMerchan(mer3);
		merchanList.addMerchan(mer4);
	}
	
	public static Merchandise createAMerchan() throws Exception {
		Merchandise mer;
		long merID;
		String merName;
		double uPrice;
		LocalDate mFG;
		LocalDate eDate;
		
		merID = inputLong("Input your id merchandise: ");
		while(merchanList.isExistingMerchanID(merID)) {
			System.out.println("Id merchandise already exist!");
			merID = inputLong("Input again: ");
		}
		sn.nextLine();
		merName = inputString("Input merchandise name: ");
		uPrice = inputDouble("Input unit price: ");
		mFG = inputDate("Input MFG date: ");
		eDate = inputDate("Input expired date: ");
		mer = new Merchandise(merID, merName, uPrice, mFG, eDate);
		return mer;
	}
	
	public static void displayMerchan(Merchandise[] list) {
		for(int i=0;i<merchanList.realElement;i++) {
			System.out.printf("\t%-7d",i+1);
			System.out.println(list[i]);
		}
	}
	
	public static void displayMerchanList() {
		Merchandise[] allMerchan = merchanList.getAllMerchan();
		displayMerchan(allMerchan);
	}
	
	static void displayTitle() {
		String s = String.format("\t%-7s %10s %20s %15s %11s %19s %15s", "STT" ,"Merchandise ID", "Merchandise Name" , "Unit Price" , "MFG" , "Expired Day" , "Status");
		System.out.println(s);
	}
}
