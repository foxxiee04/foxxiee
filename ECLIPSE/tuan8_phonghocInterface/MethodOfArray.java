package tuan8_phonghocInterface;

import java.util.ArrayList;

// Interface MethodOfArray định nghĩa các phương thức cho việc quản lý mảng phòng học
public interface MethodOfArray {
    // Phương thức thêm phòng vào mảng và xử lý ngoại lệ nếu có
    public void addRoom(Room room) throws Exception;
    
    // Phương thức tìm phòng theo mã phòng
    public Room findByCode(String roomCode);
    
    // Phương thức xóa phòng khỏi mảng và xử lý ngoại lệ nếu có
    public void removeRoom(Room room) throws Exception;
    
    // Phương thức lấy danh sách tất cả phòng
    public ArrayList<Room> getAll();
    
    // Phương thức lấy danh sách phòng đạt tiêu chuẩn
    public ArrayList<Room> getStandard();
    
    // Phương thức lấy danh sách phòng máy tính có ít nhất 60 máy
    public ArrayList<Room> getComputer60();
    
    // Phương thức sắp xếp mảng theo thứ tự tăng dần của tên dự án
    public void sortAscendingHouse();
    
    // Phương thức sắp xếp mảng theo thứ tự giảm dần của diện tích
    public void sortDescendingArea();
    
    // Phương thức sắp xếp mảng theo thứ tự tăng dần của số bóng đèn
    public void sortAscendingBulb();
    
    // Phương thức tính tổng số lượng phòng
    public int sumQuantityRoom();
}
