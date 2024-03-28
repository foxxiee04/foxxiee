package tuan8_phonghocInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Lớp RoomList thực hiện Interface MethodOfArray và quản lý danh sách các phòng học
public class RoomList implements MethodOfArray {
    private ArrayList<Room> roomList; // Danh sách các phòng học

    // Constructor mặc định, khởi tạo danh sách
    public RoomList() {
        super();
        this.roomList = new ArrayList<Room>();
    }
    
    // Phương thức tìm phòng theo mã phòng
    public Room findByCode(String roomCode) {
        for(Room room : roomList) {
            if(room.getRoomCode().equalsIgnoreCase(roomCode))
                return room;
        }
        return null;  
    }
    
    // Phương thức thêm phòng vào danh sách và xử lý ngoại lệ nếu có
    public void addRoom(Room room) throws Exception {
        if(!roomList.contains(room))
            roomList.add(room);
        else
            throw new Exception("This room already exists!");
    }
    
    // Phương thức xóa phòng khỏi danh sách và xử lý ngoại lệ nếu có
    public void removeRoom(Room room) throws Exception {
        if(roomList.contains(room))
            roomList.remove(room);
        else
            throw new Exception("This room not found!");
    }
    
    // Phương thức lấy danh sách tất cả phòng
    public ArrayList<Room> getAll(){
        return roomList;
    }
    
    // Phương thức lấy danh sách phòng đạt tiêu chuẩn
    public ArrayList<Room> getStandard(){
        ArrayList<Room> standardList = new ArrayList<Room>();
        for(Room room : roomList) {
            if(room.isStandard())
                standardList.add(room);
        }
        return standardList;
    }
    
    // Phương thức lấy danh sách phòng máy tính có ít nhất 60 máy
    public ArrayList<Room> getComputer60(){
        ArrayList<Room> labList = new ArrayList<Room>();
        for(Room room : roomList) {
            if(room instanceof ComputerLab && ((ComputerLab)room).getNumCPU() == 60)
                labList.add(room);
        }
        return labList;
    }
    
    // Phương thức sắp xếp danh sách theo thứ tự tăng dần của tên dự án
    public void sortAscendingHouse(){
        Collections.sort(roomList, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getHouseEstate().compareToIgnoreCase(o2.getHouseEstate());
            }
        });
    }
    
    // Phương thức sắp xếp danh sách theo thứ tự giảm dần của diện tích
    public void sortDescendingArea() {
        Collections.sort(roomList, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return Double.compare(o2.getArea(), o1.getArea());
            }
        });
    }
    
    // Phương thức sắp xếp danh sách theo thứ tự tăng dần của số bóng đèn
    public void sortAscendingBulb() {
        Collections.sort(roomList, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return Integer.compare(o1.getNumOfBulbs(), o2.getNumOfBulbs());
            }
        });
    }
    
    // Phương thức tính tổng số lượng phòng
    public int sumQuantityRoom() {
        return roomList.size();
    }
}
