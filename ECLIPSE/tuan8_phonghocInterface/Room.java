package tuan8_phonghocInterface;

import java.text.DecimalFormat;
import java.util.Objects;

// Lớp trừu tượng Room định nghĩa các thuộc tính và phương thức chung cho các loại phòng học
public abstract class Room {
    protected String roomCode; // Mã phòng
    protected String houseEstate; // Dự án nhà ở
    protected int numOfBulbs; // Số lượng bóng đèn
    protected double area; // Diện tích

    // Phương thức trừu tượng kiểm tra xem phòng có đạt tiêu chuẩn không
    public abstract boolean isStandard();
    
    // Constructor mặc định
    public Room() {
        super();
    }

    // Constructor với các tham số
    public Room(String roomCode, String houseEstate, int numOfBulbs, double area) {
        super();
        this.roomCode = roomCode;
        this.houseEstate = houseEstate;
        this.numOfBulbs = numOfBulbs;
        this.area = area;
    }

    // Getter và Setter cho các thuộc tính
    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getHouseEstate() {
        return houseEstate;
    }

    public void setHouseEstate(String houseEstate) {
        this.houseEstate = houseEstate;
    }

    public int getNumOfBulbs() {
        return numOfBulbs;
    }

    public void setNumOfBulbs(int numOfBulbs) {
        this.numOfBulbs = numOfBulbs;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Phương thức tính toán hashCode dựa trên mã phòng
    @Override
    public int hashCode() {
        return Objects.hash(roomCode);
    }

    // Phương thức so sánh bằng dựa trên mã phòng
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        return Objects.equals(roomCode, other.roomCode);
    }

    // Phương thức kiểm tra độ sáng của phòng
    protected boolean brightEnough() {
        if (getArea() / getNumOfBulbs() <= 10)
            return true;
        return false;
    }

    // Phương thức chuyển đối về chuỗi để hiển thị thông tin của phòng
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00 m^2");
        return String.format("%-15s %-15s %-20d %-15s", getHouseEstate(), getRoomCode(), getNumOfBulbs(), df.format(getArea()));
    }
}
