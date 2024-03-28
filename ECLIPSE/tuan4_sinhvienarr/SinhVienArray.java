package tuan4_sinhvienarr;

import java.util.Arrays;
import java.util.Comparator;

public class SinhVienArray {
	private SinhVien[] svs;
	public int realElement=0;
	
	public SinhVienArray() {
		super();
		this.svs = new SinhVien[1];
	}
	
	public boolean isExisting(long numOfStu) {
		for(int i=0;i<realElement;i++) {
			if(numOfStu == svs[i].getStudentID())
				return true;
		}
		return false;
	}
	
	public void addStu(SinhVien sv) throws Exception {
		if(!isExisting(sv.getStudentID())) {
			if(realElement == svs.length) {
				SinhVien[] newArr = new SinhVien[svs.length+1];
				for(int i=0;i<realElement;i++)
					newArr[i] = svs[i];
				svs = newArr;
			}
			svs[realElement++]=sv;
		}else {
			throw new Exception("This id already exist!");
		}
	}
	
	public void sortIDStudent() {
		Comparator<SinhVien>sortID = new Comparator<SinhVien>() {
			
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getStudentID()<o2.getStudentID()?-1:1;
			}
		};
		Arrays.sort(svs,sortID);
	}
	
	public SinhVien[] getAllStu() {
		return svs;
	}
}
