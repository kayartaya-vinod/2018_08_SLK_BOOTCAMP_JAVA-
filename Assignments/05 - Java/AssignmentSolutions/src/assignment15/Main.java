package assignment15;

public class Main {

	public static void main(String[] args) {
		Circle[] circles = { 
				new Cylinder(12.34), 
				new Cylinder(12.34, 10.0), 
				new Cylinder(12.34, 10.0, "blue") 
		};

		for (Circle c : circles) {
			System.out.println("Area = " + c.getArea());
			if (c instanceof Cylinder) {
				Cylinder cl = (Cylinder) c;
				System.out.println("Volume = " + cl.getVolume());
			}
			System.out.println();
		}
	}
}
