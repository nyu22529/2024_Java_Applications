package classes;

public class Address {
	private String sigu; // 시구 정보
	private String detail; // 상세 주소
	public Address(String sigu, String detail) {
		super();
		this.sigu = sigu;
		this.detail = detail;
	}
	public String getSigu() {
		return sigu;
	}
	public void setSigu(String sigu) {
		this.sigu = sigu;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "Address [sigu=" + sigu + ", detail=" + detail + "]";
	}
}
