package tuan9_thucphamInterface;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Lớp Foods kế thừa từ lớp abstract Merchandise
public class Foods extends Merchandise {
    private LocalDate mfg;             // Ngày sản xuất
    private LocalDate expiredDate;     // Ngày hết hạn
    private String supplier;           // Nhà cung cấp
    private final double vat = 0.1;    // Thuế VAT cố định cho sản phẩm thực phẩm

    // Constructor với tham số để khởi tạo các thuộc tính của đối tượng Foods
    public Foods(String merchanID, String merchanName, int quantityInStock, double unitPrice, LocalDate mfg,
                 LocalDate expiredDate, String supplier) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        this.mfg = mfg;
        this.expiredDate = expiredDate;
        this.supplier = supplier;
    }

    // Constructor mặc định
    public Foods() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Constructor với một số tham số cơ bản
    public Foods(String merchanID, String merchanName, int quantityInStock, double unitPrice) {
        super(merchanID, merchanName, quantityInStock, unitPrice);
        // TODO Auto-generated constructor stub
    }

    // Phương thức getter cho mfg
    public LocalDate getMfg() {
        return mfg;
    }

    // Phương thức setter cho mfg
    public void setMfg(LocalDate mfg) {
        this.mfg = mfg;
    }

    // Phương thức getter cho expiredDate
    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    // Phương thức setter cho expiredDate với xử lý ngoại lệ nếu expiredDate không sau mfg
    public void setExpiredDate(LocalDate expiredDate) throws Exception {
        if(expiredDate.isAfter(mfg)) {
            this.expiredDate = expiredDate;
        } else {
            throw new Exception("Expired Date must be after Manufacture Date!");
        }
    }

    // Phương thức getter cho supplier
    public String getSupplier() {
        return supplier;
    }

    // Phương thức setter cho supplier
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    // Phương thức vatAmount() tính toán số tiền thuế VAT cho sản phẩm thực phẩm
    @Override
    public double vatAmount() {
        return vat * unitPrice;
    }

    // Phương thức rating() đánh giá sản phẩm thực phẩm dựa trên số lượng tồn kho và ngày hết hạn
    @Override
    public boolean rating() {
        return (quantityInStock > 0 && expiredDate.isAfter(LocalDate.now()));
    }

    // Phương thức toString() hiển thị thông tin định dạng của đối tượng Foods
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00 VND");
        String rating; 
        if(rating() == true) rating = "Hard to sell";
        else rating = "No rating";
        return super.toString() + String.format(" %-20s %-20s %-20s %-20s %-20s", dtf.format(mfg), dtf.format(expiredDate), supplier, df.format(vatAmount()), rating);
    }
}
