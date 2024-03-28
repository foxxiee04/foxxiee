package tuan3_account;
import java.util.Scanner;

public class TestAccount {
	static AccountArray accountList;
	static Scanner sn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int opt;
		accountList = new AccountArray();
		try {
			do {
				opt = menu();
				switch(opt) {
				case 1:{
					Account newAcc = createAccount();
					accountList.add(newAcc);
					break;
				}
				case 2:{
					createDefaultAccountList();
					break;
				}
				case 3:{
					displayTitle();
					displayAccountList();
					break;
				}
				case 4:{
				    accountList.searchAccount(inputLong("Nhập số ID tài khoản để nạp tiền: ")).deposit(inputDouble("Nhập số tiền: "));
				    break;
				}
				case 5:{
				    accountList.searchAccount(inputLong("Nhập số ID tài khoản để rút tiền: ")).withdraw(inputDouble("Nhập số tiền: "), 10);
				    break;
				}
				case 6:{
				    Account senderAccount = accountList.searchAccount(inputLong("Nhập số ID tài khoản để chuyển: "));
				    Account receiverAccount = accountList.searchAccount(inputLong("Nhập số ID tài khoản nhận: "));
				    senderAccount.transfer(receiverAccount, inputDouble("Nhập số tiền: "));
				    break;
				}
				case 7:{
				    System.out.println("Tạm biệt!");
				    break;
				}

				}

			}while(opt!=7);

		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1. Tạo Tài Khoản\n" + "2. Danh Sách Tài Khoản\n" + "3. In Danh Sách Tài Khoản\n" + "4. Nạp Tiền\n" + "5. Rút Tiền\n" + "6. Chuyển Khoản\n" + "7. Thoát\n");
		chos = inputInt("Lựa chọn của bạn: ");

		return chos;
	}

	public static int inputInt(String s) {
		int numInt;
		System.out.println(s);
		numInt = sn.nextInt();
		return numInt;
	}

	public static String inputString(String s) {
		String str;
		System.out.println(s);
		str = sn.nextLine();
		return str;
	}

	public static double inputDouble(String s) {
		double numDouble;
		System.out.println(s);
		numDouble = sn.nextFloat();
		return numDouble;
	}

	public static long inputLong(String s) {
		long numDouble;
		System.out.println(s);
		numDouble = sn.nextLong();
		return numDouble;
	}

	public static Account createAccount() throws Exception {
		Account acc;
		long accountNumber;
		String name;
		double balance;
		accountNumber = inputLong("Nhập số ID tài khoản của bạn: ");
		while(accountList.isExistingAccNumber(accountNumber)) {
		    System.out.println("ID tài khoản đã tồn tại!");
		    accountNumber = inputLong("Nhập lại: ");
		}
		name = inputString("Nhập tên tài khoản: ");
		balance = inputDouble("Nhập số tiền gửi ban đầu: ");

		acc = new Account(accountNumber,name,balance);
		return acc;
	}

	public static void createDefaultAccountList() throws Exception {
		Account Acc1 = new Account(0001,"Tran Quoc Sang", 0);
		Account Acc2 = new Account(0002,"Nguyen Vu Tam Nhu", 55);
		Account Acc3 = new Account(0003,"Duong Thanh Huyen", 115);
		Account Acc4 = new Account(0004,"Duong Thi My Le", 200);
		accountList.add(Acc1);
		accountList.add(Acc2);
		accountList.add(Acc3);
		accountList.add(Acc4);
	}

	public static void displayAccount(Account[] list) {
		for(int i=0; i < accountList.realElement;i++) {
			System.out.printf("\t%-7d",i+1);
			System.out.println(list[i]);
		}	
	}
	
	public static void displayAccountList() {
		Account [] allAccount = accountList.getAllAccount();
		displayAccount(allAccount);
	}
	
	static void displayTitle() {
		String s = String.format("\t%-7s %20s %20s %15s", "STT" ,"ID account", "Name" , "Balance");
		System.out.println(s);
	}
}
