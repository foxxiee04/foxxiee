package tuan6_qlsach;

import java.util.ArrayList;

public class BookArray {
	ArrayList<Sach> bookList;

	public BookArray() {
		super();
		// Khởi tạo danh sách sách
		this.bookList = new ArrayList<Sach>();
	}

	// Thêm sách vào danh sách, kiểm tra trùng lặp
	public void addBook(Sach book) throws Exception { 
		if(bookList.contains(book) == false)
			bookList.add(book);
		else 
			throw new Exception("Sách này đã tồn tại!");
	}

	// Tìm sách theo mã sách
	public Sach findBookByCode(String bookCode) {
		for(Sach book : bookList) {
			if(book.getBookCode().equalsIgnoreCase(bookCode))
				return book;
		}
		return null;
	}
	
	// Tìm sách theo nhà xuất bản
	public ArrayList<Sach> findBookByPublisher(String publisher) {
		ArrayList<Sach> pubBook = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book.getPublisher().equalsIgnoreCase(publisher))
				pubBook.add(book);
		}
		return pubBook;
	}
	
	// Xóa sách khỏi danh sách, kiểm tra tồn tại
	public void removeBook(Sach book) throws Exception {
		if(bookList.contains(book) == true)
			bookList.remove(book);
		else 
			throw new Exception("Không tìm thấy sách!");
	}

	// Lấy danh sách sách tham khảo
	public ArrayList<Sach> getThamKhao(){
		ArrayList<Sach> tkList = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book instanceof SachThamKhao)
				tkList.add(book);
		}
		return tkList;
	}

	// Lấy danh sách sách giáo khoa
	public ArrayList<Sach> getGiaoKhoa(){
		ArrayList<Sach> gkList = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book instanceof SachGiaoKhoa)
				gkList.add(book);
		}
		return gkList;
	}

	// Tính trung bình giá unit của sách tham khảo
	public double unitPriceAVG() {
		ArrayList<Sach> tkList = getThamKhao();
		double avg=0;
		int cnt=0;
		for(Sach book : tkList) {
			avg += book.getUnitPrice();
			cnt++;
		}
		return avg/cnt;
	}
	
	// Tính tổng giá của sách giáo khoa
	public double sumTotalPriceGK() {
		ArrayList<Sach> gkList = getGiaoKhoa();
		double sum=0;
		for(Sach book : gkList) {
			sum += book.totalPrice();
		}
		return sum;
	}
	
	// Tính tổng giá của sách tham khảo
	public double sumTotalPriceTK() {
		ArrayList<Sach> tkList = getThamKhao();
		double sum=0;
		for(Sach book : tkList) {
			sum += book.totalPrice();
		}
		return sum;
	}
	
	// Lấy danh sách sách
	public ArrayList<Sach> getList() {
		return bookList;
	}
}
