package pkg;

public class Electron {
	private static final double[] DEFALUT_POS = { 0, 0, 0 };
	private static final double[] DEFAULT_VELOCITY = { 0, 0, 0 };
	@SuppressWarnings("unused")
	private static int AVG_NUM_COLLISIONS = 18;
	private static double COLLISION_PROBABILITY = 1E-4;

	private double[] pos;
	private double[] velocity;
	private double[] bounds;
	private boolean done;
	private double t;
	private int countCollision;

	public Electron(double[] pos, double[] velocity, double[] bounds) {
		// TODO Auto-generated constructor stub
		this.setPos(pos);
		this.setVelocity(velocity);
		this.setBounds(bounds);
		this.setDone(false);
		this.setT(0);
		this.countCollision = 0;
		boolean collided = this.isCollided();
	}

	public Electron(double[] bounds2) {
		// TODO Auto-generated constructor stub
		this.setPos(DEFALUT_POS);
		this.setVelocity(DEFAULT_VELOCITY);
		double d = 5;
	}

	/*
	 * Runs test, checks random collision to determine if electron has collided
	 */
	private boolean isCollided() {
		// DONE Auto-generated method stub
		return (Math.random() < COLLISION_PROBABILITY);
	}

	
	private boolean outOfBounds() {
		double r = Math.sqrt(Math.pow(this.pos[0], 2)
				+ Math.pow(this.pos[1], 2));
		return ((r >= this.bounds[0]) || (this.pos[2] >= this.bounds[2]) || (this.pos[2] < this.bounds[2]));
	}
	
	private void rk4Step(double f, double dt){
		double t0 = this.t;
        double ux0 = this.pos[0];
        double tf = t0 + dt;

        double f0 = fnx(t0,ux0);

        double u1 = ux0 + dt*f0/2.0;
        double f1 = fnx(tf/2.0,u1);

        double u2 = ux0 + dt*f1/2.0;
        double f2 = fnx(tf/2.0,u2);
        
        double u3 = ux0 + dt*f2;
        double f3 = fnx(tf,u3);

        this.pos[0] = ux0 + dt*(f0 + 2.0*f1 + 2.0*f2 + f3)/6.0;
        
        
        double uy0 = this.pos[0];

        f0 = fny(t0,uy0);

        u1 = uy0 + dt*f0/2.0;
        f1 = fny(tf/2.0,u1);

        u2 = uy0 + dt*f1/2.0;
        f2 = fny(tf/2.0,u2);
        
        u3 = uy0 + dt*f2;
        f3 = fny(tf,u3);

        this.pos[1] = uy0 + dt*(f0 + 2.0*f1 + 2.0*f2 + f3)/6.0;
        
        
        double uz0 = this.pos[0];

        f0 = fnz(t0,uz0);

        u1 = uz0 + dt*f0/2.0;
        f1 = fnz(tf/2.0,u1);

        u2 = uz0 + dt*f1/2.0;
        f2 = fnz(tf/2.0,u2);
        
        u3 = uz0 + dt*f2;
        f3 = fnz(tf,u3);

        this.pos[1] = uz0 + dt*(f0 + 2.0*f1 + 2.0*f2 + f3)/6.0;
        
        this.t += dt;
	}

	/**
	 * @return the bounds
	 */
	public double[] getBounds() {
		return bounds;
	}

	/**
	 * @param bounds2
	 *            the bounds to set
	 * 
	 *            Also checks if bounds array is valid (positive and nonzero)
	 */
	public void setBounds(double[] bounds2) {
		boolean valid = true;
		for (int i = 0; i < 3; i++)
			valid = (bounds2[i] >= 0);

		if (valid)
			this.bounds = bounds2;
	}

	/**
	 * @return the t
	 */
	public double getT() {
		return t;
	}

	/**
	 * @param t
	 *            the t to set
	 */
	public void setT(double t) {
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

	/**
	 * @return the pos
	 */
	public double[] getPos() {
		return pos;
	}

	/**
	 * @param pos
	 *            the pos to set
	 */
	public void setPos(double[] pos) {
		this.pos = pos;
	}

	/**
	 * @return the velocity
	 */
	public double[] getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity
	 *            the velocity to set
	 */
	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}
}
