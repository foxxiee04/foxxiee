package tuan8_phonghocInterface;

// Lớp LectureHalls kế thừa từ lớp Room
public class LectureHalls extends Room {
    private boolean projector; // Biến kiểm tra có máy chiếu hay không

    // Constructor với tất cả các tham số bao gồm biến projector
    public LectureHalls(String roomCode, String houseEstate, int numOfBulbs, double area, boolean projector) {
        super(roomCode, houseEstate, numOfBulbs, area); // Gọi constructor của lớp cha (Room)
        this.projector = projector; // Khởi tạo giá trị cho biến projector
    }

    // Constructor mặc định
    public LectureHalls() {
        super(); // Gọi constructor mặc định của lớp cha (Room)
    }

    // Constructor với các tham số trừ biến projector
    public LectureHalls(String roomCode, String houseEstate, int numOfBulbs, double area) {
        super(roomCode, houseEstate, numOfBulbs, area); // Gọi constructor của lớp cha (Room)
    }

    // Phương thức kiểm tra có máy chiếu hay không
    public boolean isProjector() {
        return projector;
    }

    // Phương thức thiết lập giá trị cho biến projector
    public void setProjector(boolean projector) {
        this.projector = projector;
    }

    // Ghi đè phương thức isStandard từ lớp cha
    @Override
    public boolean isStandard() {
        // Kiểm tra nếu có máy chiếu và đủ sáng
        if (isProjector() && brightEnough())
            return true;
        return false;
    }

    // Ghi đè phương thức toString từ lớp cha
    @Override
    public String toString() {
        String isProjectorStatus, standardStatus;
        // Xác định tình trạng có máy chiếu hay không
        if (isProjector())
            isProjectorStatus = "Có máy chiếu";
        else
            isProjectorStatus = "Không có máy chiếu";

        // Xác định tình trạng tiêu chuẩn dựa trên phương thức isStandard
        if (isStandard())
            standardStatus = "Đạt tiêu chuẩn";
        else
            standardStatus = "Không đạt tiêu chuẩn";

        // Gọi phương thức toString của lớp cha (Room) và thêm thông tin về máy chiếu và tiêu chuẩn
        return super.toString() + String.format(" %-25s %-20s", isProjectorStatus, standardStatus);
    }
}
