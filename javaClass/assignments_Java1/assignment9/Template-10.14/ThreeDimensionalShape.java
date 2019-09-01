/*
* ThreeDimensionalShape.java
*/

/**
 *
 * @author Jeremy Schmitt
 */


public abstract class ThreeDimensionalShape extends Shape {

	private double dim1;

	public ThreeDimensionalShape(double dim1) {
		this.dim1 = dim1;
	}

	public double getDim1() {
		return dim1;
	}

	public abstract double getArea();

	public abstract double getVolume();

}
