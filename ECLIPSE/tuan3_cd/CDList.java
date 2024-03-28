package tuan3_cd;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
    private CD[] cds;
    public int realElement = 0;

    public CDList() {
        super();
        this.cds = new CD[1];
    }

    // Kiểm tra xem CD có tồn tại trong danh sách không
    public boolean isExistingCD(int cdNumber) {
        for (int i = 0; i < realElement; i++)
            if (cds[i].getCdID() == cdNumber)
                return true;
        return false;
    }

    // Thêm CD vào danh sách, nếu CD đã tồn tại, ném ngoại lệ Exception
    public void addCD(CD cd) throws Exception {
        if (!isExistingCD(cd.getCdID())) {
            if (realElement == cds.length) {
                // Tăng kích thước mảng nếu cần thiết
                CD[] newCD = new CD[cds.length + 1];
                for (int i = 0; i < realElement; i++)
                    newCD[i] = cds[i];
                cds = newCD;
            }
            cds[realElement++] = cd;
        } else {
            throw new Exception("This CD already exists!");
        }
    }

    // Tính tổng giá trị của tất cả các CD trong danh sách
    public double sumPriceCD() {
        double sum = 0;
        for (int i = 0; i < realElement; i++) {
            sum += cds[i].getPrice();
        }
        return sum;
    }

    // Sắp xếp danh sách CD theo giá tiền
    public void sortPriceCD() {
        Comparator<CD> sortPrice = new Comparator<CD>() {
            @Override
            public int compare(CD thiscd, CD thatcd) {
                return thiscd.getPrice() < thatcd.getPrice() ? 1 : -1;
            }
        };
        Arrays.sort(cds, sortPrice);
    }

    // Sắp xếp danh sách CD theo tên
    public void sortNameCD() {
        Comparator<CD> sortName = (thiscd, thatcd) -> {
            return thiscd.getNameCD().compareToIgnoreCase(thatcd.getNameCD());
        };
        Arrays.sort(cds, sortName);
    }

    // Trả về danh sách tất cả các CD
    public CD[] getAllCD() {
        return cds;
    }
}
