	package tuan5_chuyenxe;
	
	public class NgoaiThanh extends ChuyenXe{
		private String destination;
		private int travelDay;
		
		public String getDestination() {
			return destination;
		}
		public void setDestination(String noiDen) {
			this.destination = noiDen;
		}
		public int getTravelDay() {
			return travelDay;
		}
		public void setTravelDay(int soNgay) {
			this.travelDay = soNgay;
		}
		
		public NgoaiThanh(String tripCode, String driverName, String numberPlate, double revenue, String destination,
				int travelDay) {
			super(tripCode, driverName, numberPlate, revenue);
			this.destination = destination;
			this.travelDay = travelDay;
		}
		public NgoaiThanh() {
			super();
			// TODO Auto-generated constructor stub
		}
		public NgoaiThanh(String tripCode, String driverName, String numberPlate, double revenue) {
			super(tripCode, driverName, numberPlate, revenue);
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString()+String.format("%30s %20d", getDestination(),getTravelDay());
		}
	}
