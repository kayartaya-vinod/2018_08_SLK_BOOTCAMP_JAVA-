package assignment17;

public class Main {

	public static void main(String[] args) {
		
		Shape[] shapes = {
			new Circle(),
			new Circle(12.34),
			new Circle(34.56, "red", false),
			new Rectangle(),
			new Rectangle(12.34, 45.67),
			new Rectangle(23.45, 67.89, "blue", true),
			new Square(),
			new Square(45.67),
			new Square(12.34, "yellow", false),
			new Square(13.24, "magenta", true),
		};
		
		for(Shape sh: shapes) {
			System.out.println(sh);
			if(sh instanceof Rectangle) { // Rectangle or Square
				Rectangle r = (Rectangle) sh;
				System.out.println("Area      = " + r.getArea());
				System.out.println("Perimeter = " + r.getPerimeter());
			}
			else if(sh instanceof Circle) {
				Circle c = (Circle) sh;
				System.out.println("Area      = " + c.getArea());
				System.out.println("Perimeter = " + c.getPerimeter());
			}
			System.out.println();
		}
		
	}
}
