/*
* Sphere.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Sphere extends ThreeDimensionalShape {

	public Sphere(double dim1) {
		super(dim1);
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(getDim1(),2);
	}

	@Override
	public double getVolume() {
		return (4/3) * Math.PI * Math.pow(getDim1(),3);
	}

	@Override
	public String getName() {
		return "Sphere";
	}

	public String toString() {
		return "width: " + getDim1();
	}

}
