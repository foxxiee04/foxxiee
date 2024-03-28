package tuan3_account;
public class AccountArray {
	private Account[] accounts; 
	public int realElement = 0; 


	public AccountArray() {
		super();
		this.accounts = new Account[1]; // Khởi tạo mảng tài khoản ban đầu với kích thước 1
	}

	// Phương thức trả về toàn bộ mảng tài khoản
	public Account[] getAllAccount() {
		return accounts;
	}

	// Phương thức tìm kiếm và trả về tài khoản trong mảng dựa trên số tài khoản
	public Account searchAccount(long accountNumber) {
		for (int i = 0; i < realElement; i++) {
			if (accounts[i].getNumOfAcc() == accountNumber)
				return accounts[i];
		}
		return null; 
	}

	// Phương thức để thêm một tài khoản mới vào mảng
	public void add(Account acc) throws Exception {
		if (!isExistingAccNumber(acc.getNumOfAcc())) { // Kiểm tra xem số tài khoản đã tồn tại trong mảng chưa
			if (realElement == accounts.length) { // Nếu mảng đầy, tăng kích thước của mảng lên gấp đôi
				Account[] newArr = new Account[accounts.length * 2];
				for (int i = 0; i < realElement; i++) {
					newArr[i] = accounts[i];
				}
				accounts = newArr;
			}
			accounts[realElement++] = acc; // Thêm tài khoản mới vào mảng và tăng số lượng tài khoản
		} else {
			throw new Exception("Tài khoản này đã tồn tại!"); 
		}
	}

	// Phương thức kiểm tra xem một số tài khoản đã tồn tại trong mảng hay chưa
	public boolean isExistingAccNumber(long accountNumber) {
		for (int i = 0; i < realElement; i++) {
			if (accountNumber == accounts[i].getNumOfAcc())
				return true; 
		}
		return false;	
	}
}
