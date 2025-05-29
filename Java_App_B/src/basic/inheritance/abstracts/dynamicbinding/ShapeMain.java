package basic.inheritance.abstracts.dynamicbinding;

public class ShapeMain {

	public static void main(String[] args) {
		
		Shape s;
		
		s = new Circle();
		s.draw();
		
		s = new Line();
		s.draw();
		
		s = new Rect();
		s.draw();
	}

}
