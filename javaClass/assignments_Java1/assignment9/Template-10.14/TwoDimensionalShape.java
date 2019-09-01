/*
* TwoDimensionalShape.java
*/

/**
 *
 * @author Jeremy Schmitt
 */


public abstract class TwoDimensionalShape extends Shape {

	private double dim1;

	public TwoDimensionalShape(double dim1) {
		this.dim1 = dim1;
	}

	public double getDim1() {
		return dim1;
	}
	
	public abstract double getArea();

}
