package tuan4_sinhvienarr;

import java.util.Scanner;

public class TestSinhVien {
    static SinhVienArray svlist = new SinhVienArray();
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int opt, n;

        try {
            creatStuList();
            do {
                displayTitle();
                displayList();
                opt = menu();
                switch(opt) {
                    case 1:{
                    	System.out.print("Nhập số lượng sinh viên: ");
                    	n = scn.nextInt(); 
                    	for (int i = 0; i < n; i++) {
                    	    System.out.println("**Sinh viên thứ " + (i + 1) + "**");          

                            SinhVien newSV = inputSV();
                            svlist.addStu(newSV);
                        }
                        break;
                    }
                    case 2:{
                        svlist.sortIDStudent();
                        break;
                    }
                    case 3:{
                        System.out.println("Goodbye!");
                    }
                }
            } while(opt!=3);
        } catch(Exception err) {
            System.out.println(err.getMessage());
        }
    }

    // Phương thức hiển thị menu và trả về lựa chọn người dùng
    public static int menu() {
        int chos;
        System.out.println("***Menu***\n" + "1. Tạo N Sinh viên\n" + "2. Sắp xếp (ID)\n" + "3. Thoát\n");
        chos = inputInt("Lựa chọn của bạn: ");

        return chos;
    }

    // Phương thức nhập số nguyên từ người dùng
    public static int inputInt(String s) {
        System.out.print(s);
        return scn.nextInt();
    }

    // Phương thức tạo danh sách sinh viên mẫu
    public static void creatStuList() throws Exception {
        SinhVien sv1 = new SinhVien(0001, "Tran Quoc Sang", "TpHCM", "xxxxxxx");
        SinhVien sv2 = new SinhVien(0002, "Nguyen Vu Tam Nhu", "TpHCM", "xxxxxxx");
        SinhVien sv3 = new SinhVien(0004, "Duong Thanh Huyen", "TpHCM", "xxxxxxx");
        SinhVien sv4 = new SinhVien(0003, "Duong Thi My Le", "TpHCM", "xxxxxxx");

        svlist.addStu(sv1);
        svlist.addStu(sv2);
        svlist.addStu(sv3);
        svlist.addStu(sv4);
    }

    // Phương thức nhập chuỗi từ người dùng
    public static String inputString(String s) {
        System.out.println(s);
        scn.nextLine();
        return scn.nextLine();
    }

    // Phương thức nhập số nguyên dài từ người dùng
    public static long inputLong(String s) {
        System.out.println(s);
        return scn.nextLong();
    }

    // Phương thức tạo đối tượng SinhVien từ dữ liệu nhập từ người dùng
    public static SinhVien inputSV() {
        long stuID;
        String stuName, address, phone;

        stuID = inputLong("Input Student ID: ");
        while(svlist.isExisting(stuID)) {
            System.out.println("This ID already exist!");
            stuID = inputLong("Input Student ID again: ");
        }
        stuName = inputString("Input Student Name: ");
        address = inputString("Input Address: ");
        phone = inputString("Input phonenumber: ");
        SinhVien sv = new SinhVien(stuID, stuName, address, phone);
        return sv;
    }

    // Phương thức hiển thị tiêu đề danh sách sinh viên
    public static void displayTitle() {
        String s = String.format("\t%-7s\t%20s\t%20s\t%15s\t%20s","STT", "Student ID", "Student Name", "Address", "Phonenumber");
        System.out.println(s);
    }

    // Phương thức hiển thị danh sách sinh viên
    public static void displayStu(SinhVien[] list) {
        for(int i=0; i<svlist.realElement; i++) {
            System.out.printf("\t%-7d\t", i+1);
            System.out.println(list[i]);
        }
    }

    // Phương thức hiển thị toàn bộ danh sách sinh viên
    public static void displayList() {
        SinhVien[] allSV = svlist.getAllStu();
        displayStu(allSV);
    }
}
