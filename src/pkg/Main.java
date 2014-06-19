package pkg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r = 5;
		double height = 2;
		double inc = 3;
		Circle c = new Circle(r, height, inc);
		int t = 3;
		convertTrajectoriestoDensity(t);
		double[] bounds = { 15, 15, 15 };
		double[] v = { 0, 0, 0, 0, 0, 0 };
		Electron e = new Electron(bounds);
	}

	private static void convertTrajectoriestoDensity(int t) {
		// TODO Complete Later
	}
}
