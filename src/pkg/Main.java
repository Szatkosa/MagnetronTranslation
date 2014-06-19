package pkg;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Electron> electrons = new ArrayList<Electron>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double z = 0;
		double time = 0;
		double E0 = 0;
		boolean wave = true;
		double Bmag = 0;
		double ne = 0;
		ElectricField ef = new ElectricField(z,time,E0,wave,Bmag,ne);
		ElectricField ef2 = new ElectricField();
		ef2.recalculate(z,time,E0,wave,Bmag,ne);
		ef2.recalculate();
	}

	private static void convertTrajectoriestoDensity(int t) {
		// TODO Complete Later
	}
	
	private static void createOrderedElectronDensity(double N, double[] bounds){		
		for (int i = 0; i<N; i++){
			for (int k = 0; k < N; k++){
				double R = bounds[0]/(N+1);
				double[] pos = {R,0,Electron.ELECTRON_STARTING_HEIGHT};
				double[] velocity = {0,0,0};
				Main.electrons.add(new Electron(pos, velocity, bounds));
			}
		}
	}
}
