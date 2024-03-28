// Package chứa lớp Merchandise
package tuan9_thucphamInterface;

import java.util.Objects;

// Lớp abstract Merchandise là lớp cơ sở cho các đối tượng hàng hóa
public abstract class Merchandise {
    protected String merchanID;        // Mã số của hàng hóa
    protected String merchanName;      // Tên của hàng hóa
    protected int quantityInStock;     // Số lượng tồn kho
    protected double unitPrice;         // Giá của mỗi đơn vị hàng hóa

    // Constructor có tham số để khởi tạo các thuộc tính của đối tượng Merchandise
    protected Merchandise(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
        super();
        this.merchanID = merchanID;
        this.merchanName = merchanName;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    // Constructor mặc định
    protected Merchandise() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Phương thức getter cho merchanID
    protected String getMerchanID() {
        return merchanID;
    }

    // Phương thức setter cho merchanID với xử lý ngoại lệ nếu merchanID là null
    protected void setMerchanID(String merchanID) throws Exception {
        if(merchanID != null) {
            this.merchanID = merchanID;
        } else {
            throw new Exception("Merchandise mustn't be null!");
        }
    }

    // Phương thức getter cho merchanName
    protected String getMerchanName() {
        return merchanName;
    }

    // Phương thức setter cho merchanName
    protected void setMerchanName(String merchanName) {
        this.merchanName = merchanName;
    }

    // Phương thức getter cho quantityInStock
    protected int getQuantityInStock() {
        return quantityInStock;
    }

    // Phương thức setter cho quantityInStock với xử lý ngoại lệ nếu quantityInStock âm
    protected void setQuantityInStock(int quantityInStock) throws Exception {
        if(quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        } else {
            throw new Exception("Quantity In stock must be greater than or equal to 0!");
        }
    }

    // Phương thức getter cho unitPrice
    protected double getUnitPrice() {
        return unitPrice;
    }

    // Phương thức setter cho unitPrice với xử lý ngoại lệ nếu unitPrice không dương
    protected void setUnitPrice(double unitPrice) throws Exception {
        if(unitPrice > 0) {
            this.unitPrice = unitPrice;
        } else {
            throw new Exception("Unit Price must be greater than 0!");
        }
    }

    // Phương thức trừu tượng tính thuế VAT
    public abstract double vatAmount();

    // Phương thức trừu tượng đánh giá hàng hóa
    public abstract boolean rating();

    // Phương thức hashCode sử dụng mã số hàng hóa để tính toán
    @Override
    public int hashCode() {
        return Objects.hash(merchanID);
    }

    // Phương thức equals so sánh hai đối tượng Merchandise dựa trên mã số hàng hóa
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Merchandise other = (Merchandise) obj;
        return Objects.equals(merchanID, other.merchanID);
    }

    // Phương thức toString trả về thông tin định dạng của đối tượng Merchandise
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20s", merchanID, merchanName, quantityInStock, unitPrice);
    }
}
