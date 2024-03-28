package tuan3_cd;

import java.util.Scanner;

public class TestCD {
    static CDList cdList;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int opt;
        cdList = new CDList();
        try {
            do {
                opt = menu();
                switch (opt) {
                    case 1: {
                        CD newCD = createACD();
                        cdList.addCD(newCD);
                        break;
                    }
                    case 2: {
                        createCDDefault();
                        break;
                    }
                    case 3: {
                        displayTitle();
                        displayAllCD();
                        break;
                    }
                    case 4: {
                        System.out.println("Số lượng CD: " + cdList.realElement);
                        break;
                    }
                    case 5: {
                        System.out.println("Tổng tiền của CD: " + cdList.sumPriceCD());
                        break;
                    }
                    case 6: {
                        cdList.sortPriceCD();
                        break;
                    }
                    case 7: {
                        cdList.sortNameCD();
                        break;
                    }
                    case 8: {
                        System.out.println("Goodbye!");
                        break;
                    }
                }
            } while (opt != 8);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    // Hiển thị menu và trả về lựa chọn của người dùng
    public static int menu() {
        int chos;
        System.out.println("***Menu***\n" + "1. Tạo CD\n" + "2. Tạo Danh Sách CD\n" + "3. In Danh Sách CD\n"
                + "4. Số lượng CD\n" + "5. Tổng chi phí của CDs\n" + "6. Sắp xếp (Giá)\n" + "7. Sắp xếp (Tên)\n" + "8. Thoát\n");
        chos = inputInt("Lựa chọn của bạn: ");

        return chos;
    }

    // Nhận giá trị nguyên từ người dùng
    public static int inputInt(String s) {
        System.out.println(s);
        return scn.nextInt();
    }

    // Tạo danh sách CD mẫu và thêm vào CDList
    public static void createCDDefault() throws Exception {
        CD cd1 = new CD(1111, "DQ", "AQS", 5, 200);
        CD cd2 = new CD(1112, "CQ", "BQS", 10, 150);
        CD cd3 = new CD(1113, "BQ", "CQS", 15, 700);
        CD cd4 = new CD(1114, "AQ", "DQS", 25, 500);
        cdList.addCD(cd1);
        cdList.addCD(cd2);
        cdList.addCD(cd3);
        cdList.addCD(cd4);
    }

    // Nhập chuỗi từ người dùng
    public static String inputString(String s) {
        System.out.println(s);
        scn.nextLine(); // Đọc dòng trống để xóa bộ đệm trước khi nhập chuỗi
        return scn.nextLine();
    }

    // Nhận giá trị số thực từ người dùng
    public static double inputDouble(String s) {
        System.out.println(s);
        return scn.nextDouble();
    }

    // Nhận giá trị số nguyên dài từ người dùng
    public static long inputLong(String s) {
        System.out.println(s);
        return scn.nextLong();
    }

    // Tạo một đối tượng CD mới từ thông tin nhập vào từ người dùng
    public static CD createACD() throws Exception {
        int cdCode, numSongs;
        String cdName, singName;
        double cdPrice;

        cdCode = inputInt("Nhập mã CD: ");
        while (cdList.isExistingCD(cdCode)) {
            System.out.println("CD này đã tồn tại!");
            cdCode = inputInt("Nhập lại mã CD: ");
        }
        cdName = inputString("Nhập tên CD: ");
        singName = inputString("Nhập tên ca sĩ: ");
        numSongs = inputInt("Nhập số bài hát: ");
        cdPrice = inputDouble("Nhập giá CD: ");

        CD cd = new CD(cdCode, cdName, singName, numSongs, cdPrice);
        return cd;
    }

    // Hiển thị danh sách CD
    public static void displayCD(CD[] list) {
        for (int i = 0; i < cdList.realElement; i++) {
            System.out.printf("%d", i + 1);
            System.out.println(list[i]);
        }
    }

    // Hiển thị tất cả các CD trong CDList
    public static void displayAllCD() {
        CD[] allCD = cdList.getAllCD();
        displayCD(allCD);
    }

    // Hiển thị tiêu đề của bảng CD
    public static void displayTitle() {
        String s = String.format("%s %17s %19s %15s %20s %15s", "STT", "CD ID", "CD Name", "Singer Name",
                "Number of Songs", "CD Price");
        System.out.println(s);
    }
}
