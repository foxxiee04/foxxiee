package tuan9_thucphamInterface;

import java.util.ArrayList;

// Lớp MerchanArray triển khai giao diện MethodOfArray
public class MerchanArray implements MethodOfArray {
    private ArrayList<Merchandise> merchanList;  // Danh sách sản phẩm

    // Constructor khởi tạo danh sách sản phẩm
    public MerchanArray() {
        super();
        this.merchanList = new ArrayList<Merchandise>();
    }

    // Phương thức thêm sản phẩm vào danh sách
    @Override
    public void addMerchan(Merchandise merchan) throws Exception {
        if (!merchanList.contains(merchan))
            merchanList.add(merchan);
        else
            throw new Exception("This merchandise already exists!");
    }

    // Phương thức tìm sản phẩm theo mã số
    @Override
    public Merchandise findByCode(String merchanID) throws Exception {
        for (Merchandise merchan : merchanList)
            if (merchanID.equalsIgnoreCase(merchan.getMerchanID()))
                return merchan;
        return null;
    }

    // Phương thức xóa sản phẩm khỏi danh sách
    @Override
    public void removeMerchan(Merchandise merchan) throws Exception {
        if (merchanList.contains(merchan))
            merchanList.remove(merchan);
        else
            throw new Exception("This merchandise not found!");
    }

    // Phương thức lấy danh sách sản phẩm thực phẩm
    @Override
    public ArrayList<Merchandise> getFoods() {
        ArrayList<Merchandise> foodList = new ArrayList<Merchandise>();
        for (Merchandise mer : merchanList) {
            if (mer instanceof Foods)
                foodList.add(mer);
        }
        return foodList;
    }

    // Phương thức lấy danh sách sản phẩm điện tử
    @Override
    public ArrayList<Merchandise> getElectrical() {
        ArrayList<Merchandise> electricList = new ArrayList<Merchandise>();
        for (Merchandise mer : merchanList) {
            if (mer instanceof ElectricalMerchan)
                electricList.add(mer);
        }
        return electricList;
    }

    // Phương thức lấy danh sách sản phẩm gốm
    @Override
    public ArrayList<Merchandise> getCeramic() {
        ArrayList<Merchandise> ceraList = new ArrayList<Merchandise>();
        for (Merchandise mer : merchanList) {
            if (mer instanceof Ceramics)
                ceraList.add(mer);
        }
        return ceraList;
    }
}
