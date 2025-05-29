package basic.inheritance.abstracts;

public class Main {

	public static void main(String[] args) {
		ACalc calc = new RealRealCalc();
		int result = calc.add(10, 20);
		System.out.println("result = " + result);
		
		calc.div(10, 2);
	}

}
