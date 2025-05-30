package basic.inheritance.abstracts.interfaces.calc;

public interface ICalc {
	
	//private int a;
	
	public static final int MAX1 = 1000;
	static final int MAX2 = 1000;
	public final int MAX3 = 1000;
	public static int MAX4 = 1000;
	int MAX5 = 1000;
	
	public abstract int add(int x, int y);
	abstract int sub(int x, int y);
	public int div(int x, int y);
	int mul(int x, int y);
	
	
	public default void test() {
		System.out.println("AAA");
	}
}
