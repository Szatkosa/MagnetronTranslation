package pkg;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Electron> electrons = new ArrayList<Electron>();
	public static ElectricField Ef = new ElectricField();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] vp = new double[6];
		double electronDensity = 0.01;
		double E0 = 0;
		double Br = 0;
		double Bz = 0;
		double stepR = 0;
		double stepZ = 0;
		double time = 0;
		double v = 0;
		double[] pos = new double[3], velocity = new double[3];
		vp = equationOfMotionPICManyElectrons(electronDensity, false, E0, Br,
				Bz, stepR, stepZ, time, pos, velocity);
	}

	private static double[] equationOfMotionPICManyElectrons(
			double electronDensity, boolean wave, double e0, double br,
			double bz, double stepR, double stepZ, double time, double[] pos,
			double[] velocity) {
		// TODO Auto-generated method stub
		final double K = -1.75881E11;
		double[] vp = new double[6];

		double R = Math.sqrt(Math.pow(pos[0], 2) + Math.pow(pos[1], 2));

		double Rpos = gridPos(R, stepR, 1000);
		double Zpos = gridPos(pos[3], stepZ, 1000);

		double BZ = Bz(Zpos, Rpos);
		double BR = Br(Zpos, Rpos);

		double sizeE = Main.electrons.size();
		double ne = electronDensity(gridPos(pos[2], 0.001, sizeE),
				gridPos(R, 0.001, sizeE));

		double E = Main.Ef.recalculate(pos[2], time, e0, wave, BR, ne);

		vp[0] = velocity[0];
		vp[1] = K * (velocity[1] * BZ - velocity[2] * BR * pos[1] / R);
		vp[3] = K * (velocity[2] * BR * pos[0] / R - velocity[0] * BZ);
		vp[4] = velocity[2];
		vp[5] = K
				* (E + velocity[0] * BR * pos[1] / R - velocity[1] * BR
						* pos[0] / R);
		return vp;
	}

	private static double[] equationOfMotionPIC(double electronDensity,
			double e0, double br, double bz, double stepR, double stepZ,
			double time, double[] pos, double[] velocity) {
		// TODO Auto-generated method stub
		final double K = -1.75881E11;
		double[] vp = new double[6];

		double R = Math.sqrt(Math.pow(pos[0], 2) + Math.pow(pos[1], 2));

		double Rpos = gridPos(R, stepR, 1000);
		double Zpos = gridPos(pos[3], stepZ, 1000);

		double BZ = Bz(Zpos, Rpos);
		double BR = Br(Zpos, Rpos);

		double sizeE = Main.electrons.size();
		double ne = electronDensity(gridPos(pos[2], 0.001, sizeE),
				gridPos(R, 0.001, sizeE));

		double E = Main.Ef.recalculate(pos[2], time, e0, true, BR, ne);

		vp[0] = velocity[0];
		vp[1] = K * (velocity[1] * BZ - velocity[2] * BR * pos[1] / R);
		vp[2] = velocity[1];
		vp[3] = K * (velocity[2] * BR * pos[0] / R - velocity[0] * BZ);
		vp[4] = velocity[2];
		vp[5] = K
				* (E + velocity[0] * BR * pos[1] / R - velocity[1] * BR
						* pos[0] / R);
		return vp;
	}

	private static int gridPos(double value, double step, double maxSize) {
		// TODO Auto-generated method stub
		int pos = (int) Math.floor(value / step);
		if (pos <= 0 || pos > maxSize)
			pos = 1;
		return pos;
	}

	private static void convertTrajectoriestoDensity(int t) {
		// TODO Complete Later
	}

	private static void createOrderedElectronDensity(double N, double[] bounds) {
		Main.electrons.clear();
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				double R = bounds[0] / (N + 1);
				double[] pos = { R, 0, Electron.ELECTRON_STARTING_HEIGHT };
				double[] velocity = { 0, 0, 0 };
				Main.electrons.add(new Electron(pos, velocity, bounds));
			}
		}
	}

	private static void createElectronDensity(double N, double[] bounds) {
		Main.electrons.clear();
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				double R = bounds[0] * Math.random();
				double[] pos = { R, 0, Electron.ELECTRON_STARTING_HEIGHT };
				double[] velocity = { 0, 0, 0 };
				Main.electrons.add(new Electron(pos, velocity, bounds));
			}
		}
	}
}
