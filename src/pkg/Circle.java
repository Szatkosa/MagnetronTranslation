package pkg;

//Hello!

public class Circle {
	private double rad, inc, height;
	
	public Circle(double r, double height, double inc) {
		// TODO Auto-generated constructor stub
		this.setRad(r);
		this.setInc(inc);
		this.setHeight(height);
	}

	/**
	 * @return the rad
	 */
	public double getRad() {
		return rad;
	}

	/**
	 * @param rad the rad to set
	 */
	public void setRad(double rad) {
		this.rad = rad;
	}

	/**
	 * @return the inc
	 */
	public double getInc() {
		return inc;
	}

	/**
	 * @param inc the inc to set
	 */
	public void setInc(double inc) {
		this.inc = inc;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}}
