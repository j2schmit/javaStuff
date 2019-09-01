/*
* Triangle.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Triangle extends TwoDimensionalShape {

	private double dim2;

	public Triangle(double dim1, double dim2) {
		super(dim1);
		this.dim2 = dim2;
	}

	public double getDim2() {
		return dim2;
	}

	@Override
	public double getArea() {
		return getDim1() * dim2 / 2;
	}

	@Override
	public String getName() {
		return "Triangle";
	}

	public String toString() {
		return "base width: " + getDim1() + ", height: " + getDim2();
		
	}

}
