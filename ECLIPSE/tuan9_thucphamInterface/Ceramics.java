package tuan9_thucphamInterface;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Lớp Ceramics kế thừa từ lớp abstract Merchandise
public class Ceramics extends Merchandise {
    private String supplierCera;        // Nhà cung cấp của sản phẩm gốm
    private LocalDate entryDate;        // Ngày nhập hàng
    private final double vat = 0.1;     // Thuế VAT cố định cho sản phẩm gốm

    // Constructor với tham số để khởi tạo các thuộc tính của đối tượng Ceramics
    public Ceramics(String merchanID, String merchanName, int quantityInStock, double unitPrice, String mfgCera,
                    LocalDate entryDate) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        this.supplierCera = mfgCera;
        this.entryDate = entryDate;
    }

    // Constructor mặc định
    public Ceramics() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Constructor với một số tham số cơ bản
    public Ceramics(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        // TODO Auto-generated constructor stub
    }

    // Phương thức getter cho supplierCera
    public String getMfgCera() {
        return supplierCera;
    }

    // Phương thức setter cho supplierCera
    public void setMfgCera(String mfgCera) {
        this.supplierCera = mfgCera;
    }

    // Phương thức getter cho entryDate
    public LocalDate getEntryDate() {
        return entryDate;
    }

    // Phương thức setter cho entryDate
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    // Phương thức rating() đánh giá sản phẩm gốm dựa trên số lượng tồn kho và ngày nhập hàng
    @Override
    public boolean rating() {
        return (quantityInStock > 50 && entryDate.isBefore(LocalDate.now().minusDays(10)));
    }

    // Phương thức vatAmount() tính toán số tiền thuế VAT cho sản phẩm gốm
    @Override
    public double vatAmount() {
        return vat * unitPrice;
    }

    // Phương thức toString() hiển thị thông tin định dạng của đối tượng Ceramics
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
        String rating;
        if(rating()) rating = "Slow-selling";
        else rating ="No rating";
        return super.toString() + String.format(" %-20s %-20s %-20s %-20s", supplierCera, dtf.format(entryDate), df.format(vatAmount()), rating);
    }
}
