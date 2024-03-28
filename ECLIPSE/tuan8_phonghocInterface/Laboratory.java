package tuan8_phonghocInterface;

// Lớp Laboratory kế thừa từ lớp Room
public class Laboratory extends Room {
    private boolean sink; // Biến kiểm tra có bồn rửa hay không

    // Constructor mặc định
    public Laboratory() {
        super(); // Gọi constructor mặc định của lớp cha (Room)
    }

    // Constructor với các tham số trừ biến sink
    public Laboratory(String roomCode, String houseEstate, int numOfBulbs, double area) {
        super(roomCode, houseEstate, numOfBulbs, area); // Gọi constructor của lớp cha (Room)
    }

    // Constructor với tất cả các tham số bao gồm biến sink
    public Laboratory(String roomCode, String houseEstate, int numOfBulbs, double area, boolean sink) {
        super(roomCode, houseEstate, numOfBulbs, area); // Gọi constructor của lớp cha (Room)
        this.sink = sink; // Khởi tạo giá trị cho biến sink
    }

    // Phương thức kiểm tra có bồn rửa hay không
    public boolean isSink() {
        return sink;
    }

    // Phương thức thiết lập giá trị cho biến sink
    public void setSink(boolean sink) {
        this.sink = sink;
    }

    // Ghi đè phương thức isStandard từ lớp cha
    @Override
    public boolean isStandard() {
        // Kiểm tra nếu có bồn rửa và đủ sáng
        if (isSink() && brightEnough())
            return true;
        return false;
    }

    // Ghi đè phương thức toString từ lớp cha
    @Override
    public String toString() {
        String isSinkStatus, standardStatus;
        // Xác định tình trạng có bồn rửa hay không
        if (isSink())
            isSinkStatus = "Có bồn rửa";
        else
            isSinkStatus = "Không có bồn rửa";

        // Xác định tình trạng tiêu chuẩn dựa trên phương thức isStandard
        if (isStandard())
            standardStatus = "Đạt tiêu chuẩn";
        else
            standardStatus = "Không đạt tiêu chuẩn";

        // Gọi phương thức toString của lớp cha (Room) và thêm thông tin về bồn rửa và tiêu chuẩn
        return super.toString() + String.format(" %-25s %-20s", isSinkStatus, standardStatus);
    }
}
