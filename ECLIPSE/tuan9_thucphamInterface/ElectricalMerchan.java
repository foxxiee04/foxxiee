package tuan9_thucphamInterface;

import java.text.DecimalFormat;

// Lớp ElectricalMerchan kế thừa từ lớp abstract Merchandise
public class ElectricalMerchan extends Merchandise {
    private int warrantyMonths;     // Số tháng bảo hành
    private double wattage;         // Công suất của sản phẩm điện tử
    private final double vat = 0.1;  // Thuế VAT cố định cho sản phẩm điện tử

    // Constructor với tham số để khởi tạo các thuộc tính của đối tượng ElectricalMerchan
    public ElectricalMerchan(String merchanID, String merchanName, int quantityInStock, double unitPrice,
                             int warrantyMonths, double wattage) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        this.warrantyMonths = warrantyMonths;
        this.wattage = wattage;
    }

    // Constructor mặc định
    public ElectricalMerchan() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Constructor với một số tham số cơ bản
    public ElectricalMerchan(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        // TODO Auto-generated constructor stub
    }

    // Phương thức getter cho warrantyMonths
    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    // Phương thức setter cho warrantyMonths với xử lý ngoại lệ nếu warrantyMonths âm
    public void setWarrantyMonths(int warrantyMonths) throws Exception {
        if(warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        } else {
            throw new Exception("Warranty Months must be greater than or equal to 0!");
        }
    }

    // Phương thức getter cho wattage
    public double getWattage() {
        return wattage;
    }

    // Phương thức setter cho wattage với xử lý ngoại lệ nếu wattage không dương
    public void setWattage(double wattage) throws Exception {
        if(wattage > 0) {
            this.wattage = wattage;
        } else {
            throw new Exception("Wattage must be greater than 0!");
        }
    }

    // Phương thức vatAmount() tính toán số tiền thuế VAT cho sản phẩm điện tử
    @Override
    public double vatAmount() {
        return vat * unitPrice;
    }

    // Phương thức rating() đánh giá sản phẩm điện tử dựa trên số lượng tồn kho
    @Override
    public boolean rating() {
        return (quantityInStock < 3);
    }

    // Phương thức toString() hiển thị thông tin định dạng của đối tượng ElectricalMerchan
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
        String rating;
        if(rating()) rating = "Sellable";
        else rating = "No rating";
        return super.toString() + String.format(" %-20s %-20s %-20s %-20s", warrantyMonths, wattage, df.format(vatAmount()), rating);
    }
}
