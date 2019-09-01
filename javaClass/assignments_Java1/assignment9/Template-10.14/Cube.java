/*
* Cube.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Cube extends ThreeDimensionalShape {

	public Cube(double dim1) {
		super(dim1);
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(getDim1(),2);
	}

	@Override
	public double getVolume() {
		return Math.pow(getDim1(),3);
	}

	@Override
	public String getName() {
		return "Cube";
	}

	public String toString() {
		return "width: " + getDim1();
	}

}
