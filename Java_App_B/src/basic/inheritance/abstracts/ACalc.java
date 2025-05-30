package basic.inheritance.abstracts;

public abstract class ACalc {
	private int a;
	
	public static final int MAX = 1000;
	int abc = 5;
	
	public abstract int add(int x, int y); // 추상 메소드
	public abstract int sub(int x, int y); // 추상 메소드
	public abstract int mul(int x, int y); // 추상 메소드
	public abstract int div(int x, int y); // 추상 메소드
	
	public void test() {
		System.out.println("AAA");
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
