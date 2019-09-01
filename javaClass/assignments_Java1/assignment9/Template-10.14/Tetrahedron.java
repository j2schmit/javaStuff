/*
* Tetrahedron.java
*/

/**
 *
 * @author Jeremy Schmitt
 */

public class Tetrahedron extends ThreeDimensionalShape {

	private double dim2;
	private double dim3;

	public Tetrahedron(double dim1, double dim2, double dim3) {
		super(dim1);
		this.dim2 = dim2;
		this.dim3 = dim3;
	}

	public double getDim2() {
		return dim2;
	}

	public double getDim3() {
		return dim3;
	}

	@Override
	public double getArea() {
		return 4* getDim1() * dim2 / 2;
	}

	@Override
	public double getVolume() {
		return getArea() * dim3 / 12;
	}

	@Override
	public String getName() {
		return "Tetrahedron";
	}

	public String toString() {
		return "base width: " + getDim1() + ", base height: " + getDim2() + ", height: " + getDim3();
		
	}

}
