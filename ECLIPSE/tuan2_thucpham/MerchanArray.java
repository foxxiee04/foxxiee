package tuan2_thucpham;

public class MerchanArray {
	private Merchandise[] merchan;
	public int realElement=0;
	
	public MerchanArray() {
		super();
		this.merchan = new Merchandise[1];
	}
	
	public Merchandise[] getAllMerchan() {
		return merchan;
	}
	
	public boolean isExistingMerchanID(long numberMerchan) {
		for(int i=0;i<realElement;i++) {
			if(numberMerchan == merchan[i].getMerchanID()) return true;
		}
		return false;
	}
	
	public void addMerchan(Merchandise mer) throws Exception {
		if(!isExistingMerchanID(mer.getMerchanID())) {
			if(realElement == merchan.length) {
				Merchandise[] newArr = new Merchandise[merchan.length*2];
				for(int i=0;i<realElement;i++) {
					newArr[i]=merchan[i];
				}
				merchan=newArr;
			}
			merchan[realElement++] = mer;
		}else {
			throw new Exception("This merchandise already exist!");
		}
	}
}
