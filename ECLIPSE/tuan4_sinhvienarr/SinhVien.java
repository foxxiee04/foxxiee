package tuan4_sinhvienarr;

public class SinhVien {
	private long studentID;
	private String studentName;
	private String address;
	private String phoneNum;
	
	public long getStudentID() {
		return studentID;
	}
	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public SinhVien(long studentID, String studentName, String address, String phoneNum) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.address = address;
		this.phoneNum = phoneNum;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String str= String.format("%20d %23s %18s %20s",getStudentID(),getStudentName(),getAddress(),getPhoneNum());
		return str;
	}
	
}
