/*
* Square.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Square extends TwoDimensionalShape {

	public Square(double dim1) {
		super(dim1);
	}

	@Override
	public double getArea() {
		return Math.pow(getDim1(),2);
	}

	@Override
	public String getName() {
		return "Square";
	}

	public String toString() {
		return "width: " + getDim1();
	}

}
