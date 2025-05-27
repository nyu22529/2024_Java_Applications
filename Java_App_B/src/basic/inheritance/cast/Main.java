package basic.inheritance.cast;

public class Main {

	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A();
		
		B b1 = new B();
		B b2 = new B();
		
		a1 = a2;
		b1 = b2;
		
		a1 = b1; // up cast
	}

}
