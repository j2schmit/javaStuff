/*
* Circle.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Circle extends TwoDimensionalShape {

	public Circle(double dim1) {
		super(dim1);
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(getDim1(),2);
	}

	@Override
	public String getName() {
		return "Circle";
	}

	public String toString() {
		return "radius: " + getDim1();
	}

}
