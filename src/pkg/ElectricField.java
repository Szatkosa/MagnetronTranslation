package pkg;

public class ElectricField {

	private static final double DEFAULT_Z = 0;
	private static final double DEFAULT_TIME = 0;
	private static final double DEFAULT_E0 = 0;
	private static final boolean DEFAULT_WAVE = false;
	private static final double DEFAULT_BMAG = 0;
	private static final double DEFAULT_NE = 0;

	private static final double RS = 2.5E-3;
	private static final double Q = 1.602E-19;
	private static final double EPSILON_0 = 8.854E-12;
	private static final double K = 2 * Math.PI / (0.005);
	private double z;
	private double time;
	private double e0;
	private boolean wave;
	private double bmag;
	private double ne;
	private double r;
	private double omegape;
	private double omegace;
	private double omegauh;

	public ElectricField(double z, double time, double e0, boolean wave,
			double bmag, double ne) {
		// TODO Auto-generated constructor stub
		this.recalculate(z, time, e0, wave, bmag, ne);
	}

	public ElectricField() {
		// TODO Auto-generated constructor stub
		this.recalculate(DEFAULT_Z, DEFAULT_TIME, DEFAULT_E0, DEFAULT_WAVE,
				DEFAULT_BMAG, DEFAULT_NE);
	}

	public void recalculate(double z, double time, double e0, boolean wave,
			double bmag, double ne) {
		// TODO Auto-generated method stub
		this.z = z;
		this.time = time;
		this.e0 = e0;
		this.wave = wave;
		this.bmag = bmag;
		this.ne = ne;
		this.recalculate();
	}

	public double recalculate() {
		// TODO Auto-generated method stub
		this.r = z - 0.03;
		this.omegape = Math.sqrt((Math.pow(ElectricField.Q, 2)) * this.ne
				/ (this.EPSILON_0));
		this.omegace = (ElectricField.Q * this.bmag / Electron.ELECTRON_MASS);
		this.omegauh = Math.sqrt(Math.pow(omegape, 2) + Math.pow(omegace, 2));
		double ef = (Double) null;

		if (r > ElectricField.RS) {
			if (this.wave) {
				ef = -71.42857142
						+ this.e0
						* Math.sin(ElectricField.K * this.z - this.omegauh
								* time);
			} else {
				ef = -71.42857142 + this.e0;
			}
		} else {
			ef = -5.983571430E5 + 4.786285714E8 * (r) - 9.572571429E10
					* Math.pow(r, 2);
		}

		return ef;
	}

}
