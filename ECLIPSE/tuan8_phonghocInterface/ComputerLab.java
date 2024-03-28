package tuan8_phonghocInterface;

// Lớp ComputerLab kế thừa từ lớp Room
public class ComputerLab extends Room {
    private int numCPU; // Số lượng CPU trong phòng máy tính

    // Constructor với tham số
    public ComputerLab(String roomCode, String houseEstate, int numOfBulbs, double area, int numCPU) {
        // Gọi constructor của lớp cha (Room) bằng cách sử dụng super
        super(roomCode, houseEstate, numOfBulbs, area);
        this.numCPU = numCPU; // Khởi tạo thuộc tính numCPU
    }

    // Constructor mặc định
    public ComputerLab() {
        super(); // Gọi constructor mặc định của lớp cha (Room)
    }

    // Constructor với các tham số trừ số lượng CPU
    public ComputerLab(String roomCode, String houseEstate, int numOfBulbs, double area) {
        super(roomCode, houseEstate, numOfBulbs, area); // Gọi constructor của lớp cha (Room)
    }

    // Phương thức lấy giá trị cho numCPU
    public int getNumCPU() {
        return numCPU;
    }

    // Phương thức thiết lập giá trị cho numCPU
    public void setNumCPU(int numCPU) {
        this.numCPU = numCPU;
    }

    // Phương thức kiểm tra xem số lượng máy tính có đủ không dựa trên diện tích và số lượng CPU
    public boolean computerEnough() {
        // Kiểm tra nếu tỉ lệ diện tích chia cho số lượng CPU nhỏ hơn hoặc bằng 1.5
        if ((getArea() / getNumCPU()) <= 1.5)
            return true;
        return false;
    }

    // Ghi đè phương thức isStandard từ lớp cha
    @Override
    public boolean isStandard() {
        // Kiểm tra nếu cả hai điều kiện computerEnough và brightEnough đều đúng
        if (computerEnough() && brightEnough())
            return true;
        return false;
    }

    // Ghi đè phương thức toString từ lớp cha
    @Override
    public String toString() {
        String standard;
        // Xác định tình trạng tiêu chuẩn dựa trên phương thức isStandard
        if (isStandard())
            standard = "Đạt tiêu chuẩn";
        else
            standard = "Không đạt tiêu chuẩn";

        // Gọi phương thức toString của lớp cha (Room) và thêm thông tin numCPU và standard
        return super.toString() + String.format(" %-25d %-20s", getNumCPU(), standard);
    }
}
