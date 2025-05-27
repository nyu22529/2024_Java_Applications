package basic.inheritance.dynimicbinding;

public class ShapeMain {

	public static void main(String[] args) {
		
		Shape s = new Shape();
		s.draw();
		
		Circle circle = new Circle();
		circle.draw();
		
		Line line = new Line();
		line.draw();
		
		Rect rect = new Rect();
		rect.draw();
		
	}

}
