package pkg;

public class Electron {
	private static int[] DEFAULT_V = { 0, 0, 0, 0, 0, 0 };
	@SuppressWarnings("unused")
	private static int AVG_NUM_COLLISIONS = 18;
	private static double COLLISION_PROBABILITY = 1E-4;

	private int[] v;
	private int[] bounds;
	private boolean done;
	private int t;
	private int countCollision;

	public Electron(int[] v, int[] bounds) {
		// TODO Auto-generated constructor stub
		this.setV(v);
		this.setBounds(bounds);
		this.setDone(false);
		this.setT(0);
		this.countCollision = 0;
		boolean collided = this.isCollided();
	}

	/*
	 * Runs test, checks random collision to determine if electron has collided
	 */
	private boolean isCollided() {
		// DONE Auto-generated method stub
		return (Math.random() < COLLISION_PROBABILITY);
	}

	public Electron(int[] bounds2) {
		// TODO Auto-generated constructor stub
		this.setV(DEFAULT_V);
		this.setBounds(bounds2);
	}

	/**
	 * @return the v
	 */
	public int[] getV() {
		return v;
	}

	/**
	 * @param v
	 *            the v to set
	 */
	public void setV(int[] v) {
		this.v = v;
	}

	/**
	 * @return the bounds
	 */
	public int[] getBounds() {
		return bounds;
	}

	/**
	 * @param bounds
	 *            the bounds to set
	 * 
	 *            Also checks if bounds array is valid (positive and nonzero)
	 */
	public void setBounds(int[] bounds) {
		boolean valid = true;
		for (int i = 0; i < 3; i++)
			valid = (bounds[i] >= 0);

		if (valid)
			this.bounds = bounds;
	}

	/**
	 * @return the t
	 */
	public int getT() {
		return t;
	}

	/**
	 * @param t
	 *            the t to set
	 */
	public void setT(int t) {
		this.t = t;
	}

	/**
	 * @return the countCollision
	 */
	public int getCountCollision() {
		return countCollision;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done
	 *            the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}
}
